package com.shubh.library_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubh.library_management.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
