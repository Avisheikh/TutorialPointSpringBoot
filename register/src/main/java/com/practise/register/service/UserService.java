package com.practise.register.service;


import com.practise.register.model.TempUser;
import com.practise.register.repo.TempUserRepo;
import com.practise.register.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface
{

    @Autowired
    private TempUserRepo tempUserRepo;

    @Override
    public ResponseEntity<Object> createTempUser(TempUser requestTempUser)
    {
        try
        {
            // created temp user class object
            TempUser tempUser = new TempUser();


            // setting the value
            tempUser.setUserName(requestTempUser.getUserName());
            tempUser.setEmail(requestTempUser.getEmail());
            tempUser.setPhoneNumber(requestTempUser.getPhoneNumber());
            tempUser.setPan(requestTempUser.getPan());
            tempUser.setPassword(requestTempUser.getPassword());
            tempUser.setCreatedDate(requestTempUser.getCreatedDate());
            tempUser.setIsApproved("false");
            tempUser.setCreatedDate(requestTempUser.getCreatedDate());

            // save to database
            tempUserRepo.save(tempUser);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return new ResponseEntity<>("Temp User Create Successfully.", HttpStatus.CREATED);

    }


}
