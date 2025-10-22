package com.example.aguela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aguela.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}