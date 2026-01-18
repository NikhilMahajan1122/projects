package com.auth.controller;

import com.auth.modal.User;
import com.auth.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user,@RequestParam Set<String> authorities){
       log.info("Inside add User controller");
        try{
            userService.createUser(user, authorities);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created SuccessFully");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error Creating User! ");
        }
    }

}
