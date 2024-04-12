package com.shubh.library_management.service;

import java.util.List;

import com.shubh.library_management.dto.UserDTO;
import com.shubh.library_management.entity.User;

public interface UserService {
    List<UserDTO> getAllUsers();

    User getUserById(Long userId);

    UserDTO createUser(UserDTO userDTO);
}
