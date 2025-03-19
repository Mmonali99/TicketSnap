package com.ticketsnap.service;

import com.ticketsnap.exceptions.NoUserFound;
import com.ticketsnap.models.User;
import com.ticketsnap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(NoUserFound::new);
    }

    public User registerUser(String name, String email, String password, String roles) {
        return authService.registerUser(name, email, password, roles);
    }
}
