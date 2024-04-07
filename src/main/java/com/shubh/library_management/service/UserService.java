package com.shubh.library_management.service;

import java.util.List;

import com.shubh.library_management.dto.UserDTO;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);
}
