package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.service.dtos.requests.attendant.AddAttendantRequest;
import com.turkcell.spring.intro.service.dtos.responses.attendant.AddAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.DeleteAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.GetAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.UpdateAttendantResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AttendantMapper {
    BorrowMapper INSTANCE = Mappers.getMapper(BorrowMapper.class);
    Attendant mapToAttendant(AddAttendantRequest attendantDto);
    DeleteAttendantResponse mapToDeleteAttendantResponse(Attendant attendant);
    AddAttendantResponse mapToAddAttendantResponse(Attendant attendant);
    UpdateAttendantResponse mapToUpdateAttendantResponse(Attendant attendant);

    List<GetAttendantResponse> mapToAttendantResponseList(List<Attendant> attendants);
}
