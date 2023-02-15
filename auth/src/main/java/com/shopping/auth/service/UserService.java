package com.shopping.auth.service;

import com.shopping.auth.entity.User;
import com.shopping.auth.mapper.UserMapper;
import com.shopping.auth.repository.UserRepository;
import com.shopping.auth.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserResponse addUser(String userName, String userSurname, String email, String password,int basketId){
        UserResponse userResponse = new UserResponse();
        User user = new User();
        user.setUserName(userName);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setBasketId(basketId);
        user = userRepository.save(user);
        userResponse.user = userMapper.toDto(user);
        return userResponse;
    }

    public UserResponse loginUser(String email,String password){
        UserResponse userResponse = new UserResponse();
        User user = userRepository.findByEmail(email);
        if (!user.getPassword().equals(password)){
            return null;
        }
        userResponse.user = userMapper.toDto(user);
        return userResponse;
    }

    public UserResponse findUserById(int userId){
        UserResponse response = new UserResponse();
        response.user= userMapper.toDto(userRepository.findByUserId(userId));
        return response;
    }
}
