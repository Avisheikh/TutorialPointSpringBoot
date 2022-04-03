package com.example.BeanNDependencyInjection.Service;

import com.example.BeanNDependencyInjection.DTO.UserLocationDTO;
import com.example.BeanNDependencyInjection.Entity.User;
import com.example.BeanNDependencyInjection.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService
{
//
//    @Autowired
//    private UserRepo userRepo;
//
//
//    public List<UserLocationDTO> getAllUsersLocation()
//    {
//        return userRepo.findAll()
//                .stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());
//    }
//
//    private UserLocationDTO convertEntityToDto(User user)
//    {
//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//
//        userLocationDTO.setUserID(user.getId());
//        userLocationDTO.setEmail(user.getEmail());
//        userLocationDTO.setPlace(user.getLocation().getPlace());
//        userLocationDTO.setLongtitude(user.getLocation().getLongtitude());
//        return userLocationDTO;
//    }


}
