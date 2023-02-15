package com.shopping.auth.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
    public int userId;
    public String userName;
    public String userSurname;
    public String email;
    public String password;
    public int basketId;
}
