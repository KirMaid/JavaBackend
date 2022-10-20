package com.example.backend.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserRepositoryUserDetailsService implements UserDetailsService{
//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepo) {
//        return username -> {
//            User user = userRepo.findByUsername(username);
//            if (user != null) return user;
//            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
//        };
//    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
