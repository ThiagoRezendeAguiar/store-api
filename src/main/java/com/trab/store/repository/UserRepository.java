package com.trab.store.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trab.store.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    public User findByEmail(String email);
}
