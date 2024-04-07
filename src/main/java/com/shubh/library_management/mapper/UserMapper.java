package com.shubh.library_management.mapper;

import com.shubh.library_management.dto.UserDTO;
import com.shubh.library_management.entity.User;

public class UserMapper {
    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO(
            user.getUserId(),
            user.getUserName(),
            user.getUserEmail()
        );

        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO){
        User user = new User(
            userDTO.getUserId(),
            userDTO.getUserName(),
            userDTO.getUserEmail()
        );

        return user;
    }
}
