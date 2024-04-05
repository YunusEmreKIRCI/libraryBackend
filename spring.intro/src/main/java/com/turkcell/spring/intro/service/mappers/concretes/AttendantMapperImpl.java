package com.turkcell.spring.intro.service.mappers.concretes;
import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.service.dtos.requests.attendant.AddAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.UpdateAttendantRequest;
import com.turkcell.spring.intro.service.dtos.responses.attendant.AddAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.DeleteAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.GetAttendantResponse;
import com.turkcell.spring.intro.service.mappers.abstracts.AttendantMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AttendantMapperImpl implements AttendantMapper {

    AttendantMapper attendantMapper;

    @Override
    public Attendant mapToAttendant(AddAttendantRequest attendantDto) {
        Attendant attendant = new Attendant();
        attendant.setEmail(attendantDto.getEmail());
        attendant.setPassword(attendantDto.getPassword());
        return attendant;

    }

    @Override
    public DeleteAttendantResponse mapToDeleteAttendantResponse(Attendant attendant) {
        DeleteAttendantResponse response = new DeleteAttendantResponse();
        response.setEmail(attendant.getEmail());
        response.setId(attendant.getId());
        return response;

    }

    @Override
    public AddAttendantResponse mapToAddAttendantResponse(Attendant attendant) {
        AddAttendantResponse response = new AddAttendantResponse();
        response.setEmail(attendant.getEmail());
        response.setId(attendant.getId());
        return response;

    }

    @Override
    public UpdateAttendantRequest mapToUpdateAttendantResponse(Attendant attendant) {
        UpdateAttendantRequest response = new UpdateAttendantRequest();
        response.setPassword(attendant.getPassword());
        response.setId(attendant.getId());
        return response;
    }

    @Override
    public List<GetAttendantResponse> mapToAttendantResponseList(List<Attendant> attendants) {
       List<GetAttendantResponse> attendantResponses = new ArrayList<>();
        for (Attendant attendant : attendants) {
            attendantResponses.add(mapToAttendantResponse(attendant));
        }
        return attendantResponses;
    }

    @Override
    public GetAttendantResponse mapToAttendantResponse(Attendant attendant) {
        GetAttendantResponse response = new GetAttendantResponse();
           response.setEmail(attendant.getEmail());
           response.setPassword(attendant.getPassword());

        return response;
    }
}
