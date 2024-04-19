package com.appsdeveloperblog.mobileappws.service;

import com.appsdeveloperblog.mobileappws.model.request.UserRequestModel;
import com.appsdeveloperblog.mobileappws.model.response.UserRest;

public interface UserService {
UserRest CreateUser(UserRequestModel userDetails);
}
