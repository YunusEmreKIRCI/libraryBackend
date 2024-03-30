package com.turkcell.spring.intro.service.abtracts;

import com.turkcell.spring.intro.entities.Borrow;
import com.turkcell.spring.intro.service.dtos.BorrowToAddDto;

import java.util.List;

public interface BorrowService {
    void add(BorrowToAddDto borrowToAddDto);
    void delete(int id);
    void update(int id);
    List<Borrow> list();
    Borrow getById(int id);
}
