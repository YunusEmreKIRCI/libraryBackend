package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.service.dtos.requests.borrow.GetBorrowRequest;
import com.turkcell.spring.intro.service.dtos.responses.user.DeleteUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.GetUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.UpdateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User mapToUser(GetBorrowRequest userDto);
    GetUserResponse mapToUserResponse(User user);
    DeleteUserResponse mapToDeleteUserResponse(User user);
    UpdateUserResponse mapToUpdateUserResponse(User user);

    List<GetUserResponse> mapToUserResponseList(List<User> users);
}
