package com.practise.register.service_impl;

import com.practise.register.dto.*;
import com.practise.register.exception.DataIntegrityViolationException;
import com.practise.register.exception.EmailExistException;
import com.practise.register.exception.UserNotLoggedIn;
import com.practise.register.model.Authentication;
import com.practise.register.model.ModifyUser;
import com.practise.register.model.TempUser;
import com.practise.register.model.User;
import com.practise.register.repo.AuthenticationRepo;
import com.practise.register.repo.ModifyUserRepo;
import com.practise.register.repo.TempUserRepo;
import com.practise.register.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private ModifyUserRepo modifyUserRepo;

    @Autowired
    private AuthenticationRepo authenticationRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private int getUserID;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public ResponseEntity<Object> loginUser(LoginRequest loginRequest)
    {
        // create response object
        ResponseDto responseDto = new ResponseDto();

        // set custom find by email
        Optional<User> user = userRepo.customFindByEmail(loginRequest.getEmail());
        Authentication authenticationId = authenticationRepo.findById(1).get();

        boolean decodePassword = passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword());

        if(user.get().getEmail().equals(loginRequest.getEmail()) && decodePassword)
        {
            responseDto.setResponseMessage("Successful");
            responseDto.setResponseStatus(true);
            authenticationId.setAuthenticated(true);
            authenticationId.setUser(user.get());
            authenticationRepo.save(authenticationId);

            logger.info("User successfully login in");
        }
        else
        {
            responseDto.setResponseMessage("Email or password is incorrect");
            responseDto.setResponseStatus(false);

            logger.error("Email or password is incorrect");
        }

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> logout()
    {
        Authentication auth = authenticationRepo.findById(1).get();
        ResponseDto responseDto = new ResponseDto();

        try
        {
            auth.setAuthenticated(false);
            authenticationRepo.save(auth);
            responseDto.setResponseMessage("User has been successfully logged in");
            responseDto.setResponseStatus(true);
            logger.info("User successfully logged out");
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            responseDto.setResponseStatus(false);
        }

        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);

    }

    @Override
    public ResponseEntity<Object> createTempUserDTO(TempUserRequest requestTempUser) {

        ResponseDto responseDto=new ResponseDto();
        TempUser tempUser = null;

        // check if user is authenticated or not
        if(!authenticationRepo.is_authentication())
        {
            logger.error("User has not been logged in");
            throw new UserNotLoggedIn();
        }

        // check email is unique or not
        if(tempUserRepo.checkEmailExist(requestTempUser.getEmail()) == 1 || userRepo.checkEmailExist(requestTempUser.getEmail()) == 1)
        {
            logger.error("Email was not unique.");
            throw new EmailExistException("Email has already exists. Email should be unique");
        }

        // check phone number is unique or not
        else if(tempUserRepo.checkPhoneNumberExist(requestTempUser.getPhoneNumber()) == 1 || userRepo.checkPhoneNumberExist(requestTempUser.getPhoneNumber()) == 1)
        {
            responseDto.setResponseMessage("Phone number already exists");
            responseDto.setResponseStatus(false);
            logger.error("Phone number was not unique.");
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
                tempUser.setPassword(passwordEncoder.encode(requestTempUser.getPassword()));
                tempUser.setIsApproved("false");
                tempUser.setCreatedBy("abisehk");

                // save to database
                tempUserRepo.save(tempUser);
                responseDto.setResponseMessage("Registration Success, Waiting for Approval");
                responseDto.setResponseStatus(true);
                logger.info("User has been created.");

            }
            catch (Exception e)
            {
                responseDto.setResponseMessage("Unable to process your request");
                responseDto.setResponseStatus(false);
                logger.error(e.getMessage());
            }
        }
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // map temp user response variables to temp user varibale
    @Override
    public ResponseEntity<TempUserResponse> getAllTempUserDTO()
    {
        List<TempUserDto> tempUserDtos =  tempUserRepo.findAll()
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

        return dto;
    }

    // get user using native query
    @Override
    public ResponseEntity<TempUserResponse> getTempUser(int id)
    {
        Optional<TempUser> getUser=null;

        try
        {
            getUser = tempUserRepo.customFindById(id);
            logger.info("List Temp User " + getUser);
        }
        catch (Exception exp)
        {
            logger.error(exp.getMessage());
        }


        return new ResponseEntity(getUser, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<UserResponse> listUser()
    {
        List<UserDTO> userDTOS = userRepo.findAll()
                                            .stream()
                                            .map(this:: userDataIntoDTO)
                                            .collect(Collectors.toList());

        logger.info("List " + userDTOS);
        UserResponse userResponse = new UserResponse();
        userResponse.setGetAllUser(userDTOS);
        return new ResponseEntity<>(userResponse, HttpStatus.ACCEPTED);
    }

    private UserDTO userDataIntoDTO(User user)
    {
        // create instance of user dto class
        UserDTO userDTO = new UserDTO();

        // set values in dto from user
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setPan(user.getPan());

        return userDTO;
    }

    // get user id
    @Override
    public ResponseEntity<UserResponse> getUserByID(int id)
    {
        User user;
        try
        {
            user = userRepo.customFindById(id);
            logger.info("Found user " + user);

        }
        catch (Exception exp)
        {
            logger.error(exp.getMessage());
            return new ResponseEntity(exp.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(user, HttpStatus.ACCEPTED);

    }


    // Approve the temp user and save to user table
    @Override
    public ResponseEntity<Object> saveUser(int id, String userName)
    {

        User user = new User();
        ResponseDto responseDto = new ResponseDto();
        userName = "bishek";

        // check user is authenticated or not
        if(!authenticationRepo.is_authentication())
        {
            logger.error("User has not been logged in");
            throw new UserNotLoggedIn();
        }

        //TODO use hibernate query instead of predefine query
        Optional<TempUser> getTempUser = tempUserRepo.customFindById(id);

        //TODO check both checker and maker
        if(getTempUser.get().getCreatedBy().equals(userName))
        {
            responseDto.setResponseMessage("Could not approved because the checker and maker are same");
            responseDto.setResponseStatus(false);
            logger.error("Checker and maker were same while approving");
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

            logger.info("Temp User has been successfully saved in user database.");

        }
        catch (Exception e)
        {
            logger.error("Duplicate key has been found.");
            throw new DataIntegrityViolationException();
        }

        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @Override
    public List<TempUser> getAllTempUser()
    {
        return (List<TempUser>) tempUserRepo.findAll();

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
    public ResponseEntity<Object> modifyUser(ModifyUserRequest modifyUserRequest, int id)
    {

        ModifyUser modifyUser = new ModifyUser();
        ResponseDto responseDto = new ResponseDto();
        User user = userRepo.customFindById(id);

        try
        {
            modifyUser.setUserName(modifyUserRequest.getUserName());
            modifyUser.setEmail(modifyUserRequest.getEmail());
            modifyUser.setPhoneNumber(modifyUserRequest.getPhoneNumber());
            modifyUser.setPan(modifyUserRequest.getPan());
            modifyUser.setUser(user);
            modifyUser.setIsApproved("false");

            responseDto.setResponseMessage("Approved the modification of the user.");
            responseDto.setResponseStatus(true);

            modifyUserRepo.save(modifyUser);
        }
        catch (Exception exp)
        {
            logger.error(exp.getMessage());
            responseDto.setResponseMessage(exp.getMessage());
            responseDto.setResponseStatus(false);
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ModifyUserResponse> getModifyUser()
    {

        List<UserDTO> userDTOS = modifyUserRepo.findAll()
                .stream()
                .map(this:: modifyDataIntoDTO)
                .collect(Collectors.toList());

        ModifyUserResponse  modifyUserResponse = new ModifyUserResponse();
        modifyUserResponse.setListModifyUser(userDTOS);

        return new ResponseEntity<>(modifyUserResponse,HttpStatus.OK);
    }

    private UserDTO modifyDataIntoDTO(ModifyUser modifyUser)
    {
        // create instance of user dto class
        UserDTO user =  new UserDTO();

        // set values in dto from user
        user.setId(modifyUser.getId());
        user.setUserName(modifyUser.getUserName());
        user.setPan(modifyUser.getPan());
        user.setPhoneNumber(modifyUser.getPhoneNumber());
        user.setEmail(modifyUser.getEmail());

        return user;
    }

    @Override
    public ResponseEntity<Object> modifyUserByID(int id)
    {
        return new ResponseEntity<>("CHeck", HttpStatus.OK);
    }




}
