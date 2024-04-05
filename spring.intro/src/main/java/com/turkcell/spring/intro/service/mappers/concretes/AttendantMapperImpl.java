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
    AttendantMapper attendantMapper;

    @Override
    public Attendant mapToAttendant(AddAttendantRequest attendantDto) {

        return attendantMapper.mapToAttendant(attendantDto);
    }

    @Override
    public DeleteAttendantResponse mapToDeleteAttendantResponse(Attendant attendant) {

        return attendantMapper.mapToDeleteAttendantResponse(attendant);
    }

    @Override
    public AddAttendantResponse mapToAddAttendantResponse(Attendant attendant) {

        return attendantMapper.mapToAddAttendantResponse(attendant);
    }

    @Override
    public UpdateAttendantResponse mapToUpdateAttendantResponse(Attendant attendant) {
        return attendantMapper.mapToUpdateAttendantResponse(attendant);
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
        return attendantMapper.mapToAttendantResponse(attendant);
    }
}
