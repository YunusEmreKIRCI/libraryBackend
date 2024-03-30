package com.turkcell.spring.intro.service.concretes;

import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.repositories.UserRepository;
import com.turkcell.spring.intro.service.abtracts.UserService;
import com.turkcell.spring.intro.service.dtos.UserToAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public void add(UserToAddDto userToAddDto) {
        User user = new User();
        user.setEmail(userToAddDto.getEmail());
        user.setPassword(userToAddDto.getPassword());

        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            throw new IllegalArgumentException("User not found");
        }
        else{
            userRepository.delete(user);
        }

    }

    @Override
    public void updatePassword(int id, String password) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            throw new IllegalArgumentException("User not found");
        }
        else{
            user.setPassword(password);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
