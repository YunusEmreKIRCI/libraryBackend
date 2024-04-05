package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.service.dtos.requests.attendant.AddAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.UpdateAttendantRequest;
import com.turkcell.spring.intro.service.dtos.responses.attendant.AddAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.DeleteAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.GetAttendantResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper

public interface AttendantMapper {
    AttendantMapper INSTANCE = Mappers.getMapper(AttendantMapper.class);

    Attendant mapToAttendant(AddAttendantRequest attendantDto);
    DeleteAttendantResponse mapToDeleteAttendantResponse(Attendant attendant);
    AddAttendantResponse mapToAddAttendantResponse(Attendant attendant);
    UpdateAttendantRequest mapToUpdateAttendantResponse(Attendant attendant);

    List<GetAttendantResponse> mapToAttendantResponseList(List<Attendant> attendants);

    GetAttendantResponse mapToAttendantResponse(Attendant attendant);
}
