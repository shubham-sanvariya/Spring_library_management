package com.shubh.library_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shubh.library_management.dto.UserDTO;
import com.shubh.library_management.entity.User;
import com.shubh.library_management.mapper.UserMapper;
import com.shubh.library_management.repository.UserRepository;

@Service
public class UserServiceimpl implements UserService{

    private UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
        .map((user) -> UserMapper.mapToUserDTO(user)).toList();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }
    
    public UserDTO createUser(UserDTO userDTO){
        User user = UserMapper.mapToUser(userDTO);
        userRepository.save(user);
        return UserMapper.mapToUserDTO(user);
    }
}
