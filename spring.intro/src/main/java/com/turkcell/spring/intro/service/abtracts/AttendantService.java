package com.turkcell.spring.intro.service.abtracts;

import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.service.dtos.AttendantToAddDto;

import java.util.List;

public interface AttendantService {
    void add(AttendantToAddDto attendantToAddDto);
    void delete(int id);
    void updatePassword(int id, String password);
    List<Attendant> list();
    Attendant getById(int id);

}
