package com.auth.service;

import com.auth.dao.AuthoritiesRepository;
import com.auth.dao.UserRepository;
import com.auth.modal.Authority;
import com.auth.modal.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private AuthoritiesRepository authoritiesRepository;
    private PasswordEncoder passwordEncoder;

    public void createUser(User user, Set<String> authorityNames){
        if(userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("User Already Exists..");
        }
        //encrypt the password
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Set<Authority> authorities = new HashSet<>();
        authorities = authorityNames.stream().map(name -> authoritiesRepository.findByAuthority(name)
                .orElseThrow(() -> new NoSuchElementException("Authority not found!"))).collect(Collectors.toSet());
        user.setAuthorities(authorities);

        userRepository.save(user);
    }


}
