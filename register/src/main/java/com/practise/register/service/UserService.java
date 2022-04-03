package com.practise.register.service;


import com.practise.register.dto.TempUserDTO;
import com.practise.register.dto.TempUserRequest;
import com.practise.register.model.TempUser;
import com.practise.register.model.User;
import com.practise.register.repo.TempUserRepo;
import com.practise.register.repo.UserRepo;
import com.practise.register.serviceInterface.UserServiceInterface;
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
        TempUser tempUser = null;
        try {
            // created temp user class object
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


        } catch (Exception e) {
            System.out.println(e);
        }

        return new ResponseEntity<>(requestTempUser, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> saveUser(int id)
    {

        User user = new User();

        //how to use sql query

        System.out.println(id);

        // get data by id
        Optional<TempUser> getTempUser = tempUserRepo.findById(id);

        user.setUserName(getTempUser.get().getUserName());
        user.setPassword(getTempUser.get().getPassword());
        user.setEmail(getTempUser.get().getEmail());
        user.setPan(getTempUser.get().getPan());
        user.setPhoneNumber(getTempUser.get().getPhoneNumber());
        user.setIsApproved(getTempUser.get().getIsApproved());
        user.setCreatedDate(getTempUser.get().getCreatedDate());
        user.setTempUser(getTempUser.get());
        
        userRepo.save(user);

        return new ResponseEntity<>("User Has Been Approved",HttpStatus.OK);

    }


}
