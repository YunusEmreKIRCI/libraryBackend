package com.turkcell.spring.intro.service.concretes;

import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.repositories.AttendantRepository;
import com.turkcell.spring.intro.service.dtos.AttendantToAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.turkcell.spring.intro.service.abtracts.AttendantService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendantServiceImpl implements AttendantService{
    private final AttendantRepository attendantRepository;

    @Override
    public void add(AttendantToAddDto attendantToAddDto) {
        Attendant attendant = new Attendant();
        attendant.setEmail(attendantToAddDto.getEmail());
        attendant.setPassword(attendantToAddDto.getPassword());

        attendantRepository.save(attendant);
    }

    @Override
    public void delete(int id) {
        Attendant attendant = attendantRepository.findById(id).orElse(null);
        if(attendant == null){
            throw new IllegalArgumentException("Attendant not found");
        }
        else{
            attendantRepository.delete(attendant);
        }
    }

    @Override
    public void updatePassword(int id, String password) {
        Attendant attendant = attendantRepository.findById(id).orElse(null);
        if(attendant == null){
            throw new IllegalArgumentException("Attendant not found");
        }
        else{
            attendant.setPassword(password);
            attendantRepository.save(attendant);
        }
    }

    @Override
    public List<Attendant> list() {
        return attendantRepository.findAll();
    }

    @Override
    public Attendant getById(int id) {
        return attendantRepository.findById(id).orElse(null);
    }


}
