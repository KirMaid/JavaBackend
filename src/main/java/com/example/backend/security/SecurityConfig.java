package com.example.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig{
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder){
        List<UserDetails> usersList = new ArrayList<>();
        usersList.add(new User("lavash", encoder.encode("password"),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))));

        usersList.add(new User("admin", encoder.encode("password"),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))));

        return new InMemoryUserDetailsManager(usersList);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeRequests()
                .antMatchers("/design","/orders").hasRole("USER")
                .antMatchers("/","/**").permitAll()
                .antMatchers(HttpMethod.POST, "/admin/**")
                .access("hasRole('ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/design")
                .and()
                .logout()
                .and()
                .build();
    }



//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepo) {
//        return username -> {
//            com.example.backend.entities.User user = userRepo.findByUsername(username);
//            if (user != null) return user;
//            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
//        };
//    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        var userDetailsService =
                new InMemoryUserDetailsManager();

        var user = User.withUsername("user")
                .password("password")
                .authorities("USER_ROLE")
                .build();

        userDetailsService.createUser(user);

        return userDetailsService;
    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        List<UserDetails> usersList = new ArrayList<>();
//        usersList.add(new User(
//                "buzz", encoder.encode("password"),
//                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//        usersList.add(new User(
//                "woody", encoder.encode("password"),
//                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//        return new InMemoryUserDetailsManager(usersList);
//    }


}
