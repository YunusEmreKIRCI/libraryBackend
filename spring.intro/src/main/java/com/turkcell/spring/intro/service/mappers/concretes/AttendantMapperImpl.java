package com.turkcell.spring.intro.service.mappers.concretes;
import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.service.dtos.requests.attendant.AddAttendantRequest;
import com.turkcell.spring.intro.service.dtos.responses.attendant.AddAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.DeleteAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.GetAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.UpdateAttendantResponse;
import com.turkcell.spring.intro.service.mappers.abstracts.AttendantMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AttendantMapperImpl implements AttendantMapper {

    @Override
    public Attendant mapToAttendant(AddAttendantRequest attendantDto) {
        return null;
    }

    @Override
    public DeleteAttendantResponse mapToDeleteAttendantResponse(Attendant attendant) {
        return null;
    }

    @Override
    public AddAttendantResponse mapToAddAttendantResponse(Attendant attendant) {
        return null;
    }

    @Override
    public UpdateAttendantResponse mapToUpdateAttendantResponse(Attendant attendant) {
        return null;
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
        GetAttendantResponse attendantResponse = new GetAttendantResponse();
        attendantResponse.setPassword(attendant.getPassword());
        attendantResponse.setEmail(attendant.getEmail());
        return attendantResponse;
    }
}
