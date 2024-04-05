package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.service.dtos.requests.user.AddUserRequest;
import com.turkcell.spring.intro.service.dtos.responses.user.AddUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.DeleteUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.GetUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.UpdateUserResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-06T00:39:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public AddUserResponse mapToAddUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        AddUserResponse addUserResponse = new AddUserResponse();

        addUserResponse.setId( user.getId() );
        addUserResponse.setEmail( user.getEmail() );

        return addUserResponse;
    }

    @Override
    public User mapToUser(AddUserRequest userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    @Override
    public GetUserResponse mapToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        GetUserResponse getUserResponse = new GetUserResponse();

        getUserResponse.setEmail( user.getEmail() );
        getUserResponse.setPassword( user.getPassword() );

        return getUserResponse;
    }

    @Override
    public DeleteUserResponse mapToDeleteUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        DeleteUserResponse deleteUserResponse = new DeleteUserResponse();

        deleteUserResponse.setId( user.getId() );
        deleteUserResponse.setEmail( user.getEmail() );

        return deleteUserResponse;
    }

    @Override
    public UpdateUserResponse mapToUpdateUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UpdateUserResponse updateUserResponse = new UpdateUserResponse();

        updateUserResponse.setId( user.getId() );
        updateUserResponse.setEmail( user.getEmail() );

        return updateUserResponse;
    }

    @Override
    public List<GetUserResponse> mapToUserResponseList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<GetUserResponse> list = new ArrayList<GetUserResponse>( users.size() );
        for ( User user : users ) {
            list.add( mapToUserResponse( user ) );
        }

        return list;
    }
}
