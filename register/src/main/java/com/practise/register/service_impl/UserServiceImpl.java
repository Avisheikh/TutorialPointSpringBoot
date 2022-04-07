package com.practise.register.service_impl;

import com.practise.register.dto.*;
import com.practise.register.exception.DataIntegrityViolationException;
import com.practise.register.exception.EmailExistException;
import com.practise.register.model.TempUser;
import com.practise.register.model.User;
import com.practise.register.repo.TempUserRepo;
import com.practise.register.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements com.practise.register.service.UserService
{

    @Autowired
    private TempUserRepo tempUserRepo;

    @Autowired
    private UserRepo userRepo;

    private int getUserID;


    @Override
    public ResponseEntity<TempUserResponse> getTempUser(int id)
    {
        Optional<TempUser> getUser = tempUserRepo.customFindById(id);

        return new ResponseEntity(getUser, HttpStatus.ACCEPTED);
    }

    @Override
    public List<TempUser> getAllTempUser()
    {
        return (List<TempUser>) tempUserRepo.findAll();

    }

    @Override
    public ResponseEntity<TempUserResponse> getAllTempUserDTO()
    {
        List<TempUserDto> tempUserDtos =  tempUserRepo
                .findAll()
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());

        TempUserResponse tempUserResponse = new TempUserResponse();
        tempUserResponse.setListTempUser(tempUserDtos);
        return new ResponseEntity(tempUserResponse, HttpStatus.ACCEPTED);
    }

    // create convertDataIntoDTO() method that returns UserLocationDTO
    private TempUserDto convertDataIntoDTO(TempUser tempUser)
    {
        // create instance of our temp user dto class
        TempUserDto dto = new TempUserDto();

        //set values in dto from temp user
        dto.setUserId(tempUser.getId());
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

        if(tempUserRepo.checkEmailExist(requestTempUser.getEmail()) == 1 || userRepo.checkEmailExist(requestTempUser.getEmail()) == 1)
        {
            throw new EmailExistException("Email has already exists. Email should be unique");
        }

        else if(tempUserRepo.checkPhoneNumberExist(requestTempUser.getPhoneNumber()) == 1 || userRepo.checkPhoneNumberExist(requestTempUser.getPhoneNumber()) == 1)
        {
            responseDto.setResponseMessage("Phone number already exists");
            responseDto.setResponseStatus(false);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }

        else
        {
            try {

                // created temp user class object
                //TODO check using phone number and email if it is already exit or not
                tempUser = new TempUser();

                // setting the value
                tempUser.setUserName(requestTempUser.getUserName());
                tempUser.setEmail(requestTempUser.getEmail());
                tempUser.setPhoneNumber(requestTempUser.getPhoneNumber());
                tempUser.setPan(requestTempUser.getPan());
                tempUser.setPassword(requestTempUser.getPassword());
                tempUser.setIsApproved("false");
                tempUser.setCreatedBy("abisehk");

                // save to database
                tempUserRepo.save(tempUser);
                responseDto.setResponseMessage("Registration Success, Waiting for Approval");
                responseDto.setResponseStatus(true);

            }
            catch (Exception e)
            {
                responseDto.setResponseMessage("Unable to process your request");
                responseDto.setResponseStatus(false);
            }
        }
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> saveUser(int id, String userName)
    {

        User user = new User();
        ResponseDto responseDto = new ResponseDto();
        userName = "bishek";

        System.out.println(id);

        //TODO use hibernate query instead of predefine query
        Optional<TempUser> getTempUser = tempUserRepo.customFindById(id);

        //TODO check both checker and maker
        if(getTempUser.get().getCreatedBy().equals(userName))
        {
            responseDto.setResponseMessage("Could not approved because the checker and maker are same");
            responseDto.setResponseStatus(false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }

        try
        {

            user.setUserName(getTempUser.get().getUserName());
            user.setPassword(getTempUser.get().getPassword());
            user.setEmail(getTempUser.get().getEmail());
            user.setPan(getTempUser.get().getPan());
            user.setPhoneNumber(getTempUser.get().getPhoneNumber());
            user.setIsApproved("true");
            user.setCreatedDate(getTempUser.get().getCreatedDate());
            user.setTempUser(getTempUser.get());
            user.setCreatedBy(userName);

            // TODO add approved true when data save in user on temp table
            userRepo.save(user);

            getTempUser.get().setIsApproved("true");
            tempUserRepo.save(getTempUser.get());

            responseDto.setResponseMessage("User has been approved successfully.");
            responseDto.setResponseStatus(true);

        }
        catch (Exception e)
        {
            throw new DataIntegrityViolationException();
        }


        return new ResponseEntity<>(responseDto,HttpStatus.OK);

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

    @Override
    public ResponseEntity<Object> loginUser(LoginRequest loginRequest)
    {
        // create response object
        ResponseDto responseDto = new ResponseDto();

        // set custom find by email
        Optional<User> user = userRepo.customFindByEmail(loginRequest.getEmail());
        System.out.println(user.get().getEmail());
        System.out.println(loginRequest.getEmail());
        System.out.println((user.get().getEmail()).equals(loginRequest.getEmail()));
        System.out.println(user.get().getPassword() == loginRequest.getPassword());

        if(user.get().getEmail().equals(loginRequest.getEmail()) && user.get().getPassword().equals(loginRequest.getPassword()))
        {
            responseDto.setResponseMessage("Successful");
            responseDto.setResponseStatus(true);

        }
        else
        {
            responseDto.setResponseMessage("Email or password is incorrect");
            responseDto.setResponseStatus(false);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
