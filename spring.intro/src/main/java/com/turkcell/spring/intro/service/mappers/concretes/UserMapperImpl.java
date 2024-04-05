package com.turkcell.spring.intro.service.mappers.concretes;

import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.service.dtos.requests.borrow.GetBorrowRequest;
import com.turkcell.spring.intro.service.dtos.requests.user.AddUserRequest;
import com.turkcell.spring.intro.service.dtos.requests.user.GetUserRequest;
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
        return userMapper.mapToAddUserResponse(user);
    }

    @Override
    public User mapToUser(AddUserRequest userDto)
    {
        return userMapper.mapToUser(userDto);
    }

    @Override
    public GetUserResponse mapToUserResponse(User user) {

        return userMapper.mapToUserResponse(user);
    }

    @Override
    public DeleteUserResponse mapToDeleteUserResponse(User user) {

        return userMapper.mapToDeleteUserResponse(user);
    }

    @Override
    public UpdateUserResponse mapToUpdateUserResponse(User user) {

        return userMapper.mapToUpdateUserResponse(user);
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
