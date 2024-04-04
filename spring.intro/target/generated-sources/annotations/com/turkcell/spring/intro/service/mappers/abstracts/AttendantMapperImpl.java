package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.service.dtos.requests.attendant.AddAttendantRequest;
import com.turkcell.spring.intro.service.dtos.responses.attendant.AddAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.DeleteAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.GetAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.UpdateAttendantResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-04T11:59:50+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class AttendantMapperImpl implements AttendantMapper {

    @Override
    public Attendant mapToAttendant(AddAttendantRequest attendantDto) {
        if ( attendantDto == null ) {
            return null;
        }

        Attendant attendant = new Attendant();

        attendant.setEmail( attendantDto.getEmail() );
        attendant.setPassword( attendantDto.getPassword() );

        return attendant;
    }

    @Override
    public DeleteAttendantResponse mapToDeleteAttendantResponse(Attendant attendant) {
        if ( attendant == null ) {
            return null;
        }

        DeleteAttendantResponse deleteAttendantResponse = new DeleteAttendantResponse();

        deleteAttendantResponse.setId( attendant.getId() );
        deleteAttendantResponse.setEmail( attendant.getEmail() );

        return deleteAttendantResponse;
    }

    @Override
    public AddAttendantResponse mapToAddAttendantResponse(Attendant attendant) {
        if ( attendant == null ) {
            return null;
        }

        AddAttendantResponse addAttendantResponse = new AddAttendantResponse();

        addAttendantResponse.setId( attendant.getId() );
        addAttendantResponse.setEmail( attendant.getEmail() );

        return addAttendantResponse;
    }

    @Override
    public UpdateAttendantResponse mapToUpdateAttendantResponse(Attendant attendant) {
        if ( attendant == null ) {
            return null;
        }

        UpdateAttendantResponse updateAttendantResponse = new UpdateAttendantResponse();

        updateAttendantResponse.setId( attendant.getId() );
        updateAttendantResponse.setEmail( attendant.getEmail() );

        return updateAttendantResponse;
    }

    @Override
    public List<GetAttendantResponse> mapToAttendantResponseList(List<Attendant> attendants) {
        if ( attendants == null ) {
            return null;
        }

        List<GetAttendantResponse> list = new ArrayList<GetAttendantResponse>( attendants.size() );
        for ( Attendant attendant : attendants ) {
            list.add( mapToAttendantResponse( attendant ) );
        }

        return list;
    }

    @Override
    public GetAttendantResponse mapToAttendantResponse(Attendant attendant) {
        if ( attendant == null ) {
            return null;
        }

        GetAttendantResponse getAttendantResponse = new GetAttendantResponse();

        getAttendantResponse.setEmail( attendant.getEmail() );
        getAttendantResponse.setPassword( attendant.getPassword() );

        return getAttendantResponse;
    }
}
