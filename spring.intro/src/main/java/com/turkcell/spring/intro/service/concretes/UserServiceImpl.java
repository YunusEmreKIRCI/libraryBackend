package com.turkcell.spring.intro.service.concretes;

import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.repositories.UserRepository;
import com.turkcell.spring.intro.service.abtracts.UserService;
import com.turkcell.spring.intro.service.dtos.UserToAddDto;
import com.turkcell.spring.intro.service.dtos.requests.user.AddUserRequest;
import com.turkcell.spring.intro.service.dtos.requests.user.DeleteUserRequest;
import com.turkcell.spring.intro.service.dtos.requests.user.UpdateUserRequest;
import com.turkcell.spring.intro.service.dtos.responses.user.AddUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.DeleteUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.GetUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.UpdateUserResponse;
import com.turkcell.spring.intro.service.mappers.abstracts.UserMapper;
import com.turkcell.spring.intro.service.dtos.requests.user.GetUserRequest;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Override
    public AddUserResponse add(AddUserRequest request) {
        Optional<User> userWithSameEmail = userRepository.findByEmail(request.getEmail());
        if(userWithSameEmail.isPresent()){
            throw new IllegalArgumentException("User with same email already exists");
        }
        User user = userMapper.mapToUser(request);
        return userMapper.mapToAddUserResponse(userRepository.save(user));
    }

    @Override
    public DeleteUserResponse delete(@RequestBody DeleteUserRequest request) {
        User user = userRepository.findById(request.getId()).orElse(null);
        if(user == null){
            throw new IllegalArgumentException("user not found");
        }
        else{
            userRepository.delete(user);
            return userMapper.mapToDeleteUserResponse(user);
        }

    }

    @Override
    public UpdateUserResponse updatePassword(UpdateUserRequest request) {
        User user = userRepository.findById(request.getId()).orElse(null);
        if(user == null){
            throw new IllegalArgumentException("user not found");
        }
        else{
            user.setPassword(request.getPassword());
            return userMapper.mapToUpdateUserResponse(userRepository.save(user));
        }
    }

    @Override
    public List<GetUserResponse> list() {
        return userMapper.mapToUserResponseList(userRepository.findAll());
    }

    @Override
    public GetUserResponse getById(GetUserRequest request) {
        User user = userRepository.findById(request.getId()).orElse(null);
        if(user == null){
            throw new IllegalArgumentException("user not found");
        }
        else{

            return userMapper.mapToUserResponse(userRepository.save(user));
        }
    }
}
