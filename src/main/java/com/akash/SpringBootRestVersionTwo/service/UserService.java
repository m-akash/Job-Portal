package com.akash.SpringBootRestVersionTwo.service;


import com.akash.SpringBootRestVersionTwo.model.User;
import com.akash.SpringBootRestVersionTwo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User SaveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
