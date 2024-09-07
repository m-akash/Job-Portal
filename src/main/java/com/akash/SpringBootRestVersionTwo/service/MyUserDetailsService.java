package com.akash.SpringBootRestVersionTwo.service;


import com.akash.SpringBootRestVersionTwo.model.User;
import com.akash.SpringBootRestVersionTwo.model.UserDetailsImplementation;
import com.akash.SpringBootRestVersionTwo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username);

       if(user == null){
           System.out.println("User 404");
           throw new UsernameNotFoundException("User 404");
       }

       return new UserDetailsImplementation(user);
    }
}
