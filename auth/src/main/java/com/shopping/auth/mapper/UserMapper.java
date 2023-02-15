package com.shopping.auth.mapper;

import com.shopping.auth.dto.UserDto;
import com.shopping.auth.entity.User;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.salesforce.atrium")
@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityMapper<UserDto, User>{
}
