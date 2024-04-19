package com.appsdeveloperblog.mobileappws.ui.controller;

import com.appsdeveloperblog.mobileappws.model.request.UserRequestModel;
import com.appsdeveloperblog.mobileappws.model.response.UserRest;
import com.appsdeveloperblog.mobileappws.service.UserService;
import com.appsdeveloperblog.mobileappws.serviceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {
    Map<String,UserRest> users;
    @Autowired
    UserService userService;
    @GetMapping(path = "/{userId}",produces =
            {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> getUsers(@PathVariable String userId,@RequestParam(value = "page",defaultValue = "1") int page,
                                            @RequestParam(value = "limit",defaultValue = "10")int limit)
    {
        String firstName= null;
    //
        //

        int firstname=firstName.length();


       if(users.containsKey(userId)) {
           return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
       }else{
           return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
       }
    }
    @PostMapping( consumes =
            {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity <UserRest>createUser(@Valid @RequestBody UserRequestModel userDetails)
    {

        UserRest returnValue =userService.CreateUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue,HttpStatus.CREATED);
    }
    @PutMapping(path = "/{userId}",
            consumes =
            {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces =  {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public UserRest updateUser(@PathVariable String userId,@RequestBody UserRequestModel userDetails)
    {
       UserRest storedDetails = users.get(userId);
       storedDetails.setFirstName(userDetails.getFirstName());
       storedDetails.setLastName(userDetails.getLastName());
       users.put(userId,storedDetails);
       return storedDetails;
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id)
    {
        users.remove(id);
        return ResponseEntity.noContent().build();
    }
}
