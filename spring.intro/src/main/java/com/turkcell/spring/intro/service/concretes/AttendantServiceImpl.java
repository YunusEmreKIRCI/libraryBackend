package com.turkcell.spring.intro.service.concretes;

import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.repositories.AttendantRepository;
import com.turkcell.spring.intro.service.dtos.requests.attendant.AddAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.DeleteAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.GetAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.UpdateAttendantRequest;
import com.turkcell.spring.intro.service.dtos.responses.attendant.AddAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.DeleteAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.GetAttendantResponse;
import com.turkcell.spring.intro.service.mappers.abstracts.AttendantMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import com.turkcell.spring.intro.service.abtracts.AttendantService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendantServiceImpl implements AttendantService{
    private final AttendantRepository attendantRepository;
    private AttendantMapper attendantMapper= Mappers.getMapper(AttendantMapper.class);

    @Override
    public AddAttendantResponse add(AddAttendantRequest request) {
       attendantWithSameEmailShouldNotExist(request);
       Attendant attendant = attendantMapper.mapToAttendant(request);
       return attendantMapper.mapToAddAttendantResponse(attendantRepository.save(attendant));
    }

    @Override
    public DeleteAttendantResponse delete(DeleteAttendantRequest request) {
        Attendant attendant = attendantRepository.findById(request.getId()).orElse(null);
        if(attendant == null){
            throw new IllegalArgumentException("Attendant not found");
        }
        else{
            attendantRepository.delete(attendant);
            return attendantMapper.mapToDeleteAttendantResponse(attendant);
        }
    }

    @Override
    public UpdateAttendantRequest updatePassword(UpdateAttendantRequest request) {
        Attendant attendant = attendantRepository.findById(request.getId()).orElse(null);
        if(attendant == null){
            throw new IllegalArgumentException("Attendant not found");
        }
        else{
            attendant.setPassword(request.getPassword());
            return attendantMapper.mapToUpdateAttendantResponse(attendantRepository.save(attendant));
        }
    }

    @Override
    public List<GetAttendantResponse> list() {


        return attendantMapper.mapToAttendantResponseList(attendantRepository.findAll());
    }

    @Override
    public GetAttendantResponse getById(GetAttendantRequest request) {
        Attendant attendant = attendantRepository.findById(request.getId()).orElse(null);
        if (attendant == null) {
            throw new IllegalArgumentException("Attendant not found");
        } else {
            return attendantMapper.mapToAttendantResponse(attendant);
        }

    }
    private void attendantWithSameEmailShouldNotExist(AddAttendantRequest request) {
        Optional<Attendant> attendant = attendantRepository.findByEmail(request.getEmail());
        if (attendant.isPresent()) {
            throw new IllegalArgumentException("Attendant with same email already exists");
        }
    }
}
