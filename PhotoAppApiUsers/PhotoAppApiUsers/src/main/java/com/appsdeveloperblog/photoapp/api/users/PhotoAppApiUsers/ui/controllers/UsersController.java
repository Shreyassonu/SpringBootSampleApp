package com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.ui.controllers;

import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.data.UserEntity;
import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.model.CreateUserRequest;
import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.service.UserService;
import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.shared.UserDto;
import jakarta.validation.Valid;
import org.hibernate.cfg.Environment;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
//    @Autowired
//    private Environment env;
    @Autowired
    UserService userService;
    @GetMapping("/status/check")
    public String status()
    {
        return "Working";
    }
    @PostMapping("/create")
    public ResponseEntity createUser(@Valid @RequestBody CreateUserRequest createUserRequest)
    {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto =modelMapper.map(createUserRequest, UserDto.class);
        userService.createUser(userDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
