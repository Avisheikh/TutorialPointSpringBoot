package com.practise.register.service;

import com.practise.register.dto.TempUserDTO;
import com.practise.register.dto.TempUserRequest;
import com.practise.register.exception.DataIntegrityViolationException;
import com.practise.register.exception.EmailExistException;
import com.practise.register.model.ResponseDto;
import com.practise.register.model.TempUser;
import com.practise.register.model.User;
import com.practise.register.repo.TempUserRepo;
import com.practise.register.repo.UserRepo;
import com.practise.register.serviceInterface.UserServiceInterface;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface
{

    @Autowired
    private TempUserRepo tempUserRepo;

    @Autowired
    private UserRepo userRepo;

    private int getUserID;


    @Override
    public List<TempUser> getAllTempUser()
    {
        return (List<TempUser>) tempUserRepo.findAll();

    }

    @Override
    public List<TempUserDTO> getAllTempUserDTO()
    {
        return ((List<TempUser>) tempUserRepo
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }

    // create convertDataIntoDTO() method that returns UserLocationDTO
    private TempUserDTO convertDataIntoDTO(TempUser tempUser)
    {
        // create instance of our temp user dto class
        TempUserDTO dto = new TempUserDTO();

        //set values in dto from temp user
        dto.setUserName(tempUser.getUserName());
        dto.setEmail(tempUser.getEmail());
        dto.setPhoneNumber(tempUser.getPhoneNumber());
        dto.setPan(tempUser.getPan());
        dto.setPassword(tempUser.getPassword());

        return dto;
    }

    @Override
    public ResponseEntity<Object> createTempUserDTO(TempUserRequest requestTempUser) {

        ResponseDto responseDto=new ResponseDto();
        TempUser tempUser = null;

        if(tempUserRepo.checkEmailExist(requestTempUser.getEmail()) == 1)
        {
//                responseDto.setResponseMessage("Email already exists");
//                responseDto.setResponseStatus(false);
//                return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

            throw new EmailExistException("Username has already exists. Username should be unique");

        }
        try {

            // created temp user class object
            //TODO check using phone number and email if it is already exit or not


            if(tempUserRepo.checkPasswordExist(requestTempUser.getPassword()) == 1)
            {
                responseDto.setResponseMessage("Password already exists");
                responseDto.setResponseStatus(false);
                return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
            }

            else
            {
                tempUser = new TempUser();

                // setting the value
                tempUser.setUserName(requestTempUser.getUserName());
                tempUser.setEmail(requestTempUser.getEmail());
                tempUser.setPhoneNumber(requestTempUser.getPhoneNumber());
                tempUser.setPan(requestTempUser.getPan());
                tempUser.setPassword(requestTempUser.getPassword());
                tempUser.setIsApproved("false");

                // save to database
                tempUserRepo.save(tempUser);
                responseDto.setResponseMessage("Registration Success, Waiting for Approval");
                responseDto.setResponseStatus(true);
            }
        }
        catch (Exception e)
        {
            responseDto.setResponseMessage("Unable to process your request");
            responseDto.setResponseStatus(false);
            System.out.println(e);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> saveUser(int id, String userName)
    {

        User user = new User();
        userName = "abishek";

        //TODO use hibernate query instead of predefine query
        //TODO check both checker and maker
        //TODO add approved true when data save in user on temp table

        try
        {
            Optional<TempUser> getTempUser = tempUserRepo.findById(id);

            user.setUserName(getTempUser.get().getUserName());
            user.setPassword(getTempUser.get().getPassword());
            user.setEmail(getTempUser.get().getEmail());
            user.setPan(getTempUser.get().getPan());
            user.setPhoneNumber(getTempUser.get().getPhoneNumber());
            user.setIsApproved("true");
            user.setCreatedDate(getTempUser.get().getCreatedDate());
            user.setTempUser(getTempUser.get());
            user.setCreatedBy(userName);

            userRepo.save(user);



        }
        catch (Exception e)
        {
            throw new DataIntegrityViolationException();
        }


        return new ResponseEntity<>("User Has Been Approved",HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Object> updateTempUser(int id, TempUserRequest tempUserRequest)
    {

        TempUser getTempUser = null;

        this.getUserID = id;

        try
        {
            getTempUser = new TempUser();

            getTempUser.setUserName(tempUserRequest.getUserName());
            getTempUser.setEmail(tempUserRequest.getEmail());
            getTempUser.setPhoneNumber(tempUserRequest.getPhoneNumber());
            getTempUser.setPan(tempUserRequest.getPan());
            getTempUser.setPassword(tempUserRequest.getPassword());

            tempUserRepo.save(getTempUser);
        }

        catch (Exception e)
        {
            System.out.println(e);
        }

        return new ResponseEntity<>("Need to approve by the user",HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Object> updateUser(int tempUserId, String userName)
    {
        userName = "abishek";

        System.out.println(this.getUserID);

        try
        {
               Optional<TempUser> getTempUser = tempUserRepo.findById(tempUserId);
               Optional<User> getUser = userRepo.findById(this.getUserID);

            System.out.println(getUser.get().getUserName());

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return  new ResponseEntity<>("Saved", HttpStatus.OK);

    }

}
