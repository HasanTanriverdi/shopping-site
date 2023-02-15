package com.shopping.auth.controller;

import com.shopping.auth.response.UserResponse;
import com.shopping.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/register/{userName}/{userSurname}/{email}/{password}/{basketId}")
    public UserResponse register(@PathVariable(value = "userName")String userName,
                                 @PathVariable(value = "userSurname")String userSurname,
                                 @PathVariable(value = "email")String email,
                                 @PathVariable(value = "password")String password,
                                 @PathVariable(value = "basketId")Integer basketId){
        UserResponse userResponse = userService.addUser(userName,userSurname,email,password,basketId);
        return userResponse;
    }
    @GetMapping("/login/{email}/{password}")
    public UserResponse login(@PathVariable(value = "email")String email,
                              @PathVariable(value = "password")String password){
        UserResponse userResponse =userService.loginUser(email, password);
        return userResponse;
    }

    @GetMapping("/find/{userId}")
    public UserResponse findUserById (@PathVariable (value = "userId")int userId){
        return userService.findUserById(userId);
    }
}
