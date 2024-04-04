package com.turkcell.spring.intro.service.abtracts;

import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.service.dtos.AttendantToAddDto;
import com.turkcell.spring.intro.service.dtos.requests.attendant.AddAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.DeleteAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.GetAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.UpdateAttendantRequest;
import com.turkcell.spring.intro.service.dtos.responses.attendant.AddAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.DeleteAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.GetAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.UpdateAttendantResponse;

import java.util.List;

public interface AttendantService {
    AddAttendantResponse add(AddAttendantRequest request);
    DeleteAttendantResponse delete(DeleteAttendantRequest request);
    UpdateAttendantResponse updatePassword(UpdateAttendantRequest request);


    List<GetAttendantResponse> list();
    GetAttendantResponse getById(GetAttendantRequest request);

}
