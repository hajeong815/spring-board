package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.user;

public interface userRepository extends JpaRepository<user, String>{

}
