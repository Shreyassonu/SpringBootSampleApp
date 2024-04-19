package com.appsdeveloperblog.mobileappws.serviceImpl;

import com.appsdeveloperblog.mobileappws.model.request.UserRequestModel;
import com.appsdeveloperblog.mobileappws.model.response.UserRest;
import com.appsdeveloperblog.mobileappws.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    Map<String,UserRest> users;
    @Override
    public UserRest CreateUser(UserRequestModel userDetails) {
        UserRest returnValue =new UserRest();
        returnValue.setEmailId(userDetails.getEmailId());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        // returnValue.setPassword(userDetails.getPassword());
        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if(users == null) users=new HashMap<>();
        users.put(userId,returnValue);
        return returnValue;
    }
}
