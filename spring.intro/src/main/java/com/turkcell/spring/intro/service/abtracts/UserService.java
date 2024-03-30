package com.turkcell.spring.intro.service.abtracts;

import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.service.dtos.UserToAddDto;

import java.util.List;

public interface UserService {
    void add(UserToAddDto userToAddDto);
    void delete(int id);
    void updatePassword(int id, String password);

    List<User> list();
    User getById(int id);


}
