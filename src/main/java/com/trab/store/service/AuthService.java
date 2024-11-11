package com.trab.store.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.trab.store.dto.SignUpDTO;
import com.trab.store.exception.UserAlreadyExistsException;
import com.trab.store.model.User;
import com.trab.store.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return user;
    }

    public UserDetails signUp(SignUpDTO data) throws UserAlreadyExistsException {
        if (userRepository.findByEmail(data.email()) != null) {
            throw new UserAlreadyExistsException("Email already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.email(), encryptedPassword, data.role());
        return userRepository.save(newUser);
    }

}
