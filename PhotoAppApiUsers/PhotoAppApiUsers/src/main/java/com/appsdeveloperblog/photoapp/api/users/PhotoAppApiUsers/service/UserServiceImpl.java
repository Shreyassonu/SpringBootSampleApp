package com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.service;

import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.data.UserEntity;
import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.data.UserRepo;
import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UserServiceImpl implements UserService{
    UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo)
    {
    this.userRepo=userRepo ;
    }
    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserid(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity= modelMapper.map(userDetails,UserEntity.class);
        userEntity=userRepo.save(userEntity);
        userEntity.setEncryptedpassword("test");
        return modelMapper.map(userEntity, UserDto.class);
    }
}
