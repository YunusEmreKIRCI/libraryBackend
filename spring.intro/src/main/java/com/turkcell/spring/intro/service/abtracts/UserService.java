package com.turkcell.spring.intro.service.abtracts;

import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.service.dtos.UserToAddDto;
import com.turkcell.spring.intro.service.dtos.requests.user.AddUserRequest;
import com.turkcell.spring.intro.service.dtos.requests.user.DeleteUserRequest;
import com.turkcell.spring.intro.service.dtos.requests.user.GetUserRequest;
import com.turkcell.spring.intro.service.dtos.requests.user.UpdateUserRequest;
import com.turkcell.spring.intro.service.dtos.responses.user.AddUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.DeleteUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.GetUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.UpdateUserResponse;

import java.util.List;

public interface UserService {
    AddUserResponse add(AddUserRequest request);

    DeleteUserResponse delete(DeleteUserRequest request);
    UpdateUserResponse updatePassword(UpdateUserRequest request);

    List<GetUserResponse> list();
    GetUserResponse getById(GetUserRequest request);



}
