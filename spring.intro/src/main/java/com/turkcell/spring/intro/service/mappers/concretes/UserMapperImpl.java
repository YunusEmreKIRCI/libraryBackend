package com.turkcell.spring.intro.service.mappers.concretes;

import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.service.dtos.requests.user.AddUserRequest;
import com.turkcell.spring.intro.service.dtos.responses.user.AddUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.DeleteUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.GetUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.UpdateUserResponse;
import com.turkcell.spring.intro.service.mappers.abstracts.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {

    UserMapper userMapper;
    @Override
    public AddUserResponse mapToAddUserResponse(User user) {
        AddUserResponse response = new AddUserResponse();
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        return response;

    }

    @Override
    public User mapToUser(AddUserRequest userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

    @Override
    public GetUserResponse mapToUserResponse(User user) {
        GetUserResponse response = new GetUserResponse();
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        return response;
    }

    @Override
    public DeleteUserResponse mapToDeleteUserResponse(User user) {
        DeleteUserResponse response = new DeleteUserResponse();
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        return response;

    }

    @Override
    public UpdateUserResponse mapToUpdateUserResponse(User user) {
        UpdateUserResponse response = new UpdateUserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;

    }

    @Override
    public List<GetUserResponse> mapToUserResponseList(List<User> users) {
        List<GetUserResponse> userResponses = new ArrayList<>();
        for(User user : users){
            userResponses.add(mapToUserResponse(user));
        }
        return userResponses;
    }


}