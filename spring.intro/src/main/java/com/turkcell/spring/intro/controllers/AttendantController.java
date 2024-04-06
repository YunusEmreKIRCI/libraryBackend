package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.service.dtos.requests.attendant.AddAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.DeleteAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.GetAttendantRequest;
import com.turkcell.spring.intro.service.dtos.requests.attendant.UpdateAttendantRequest;
import com.turkcell.spring.intro.service.dtos.responses.attendant.AddAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.DeleteAttendantResponse;
import com.turkcell.spring.intro.service.dtos.responses.attendant.GetAttendantResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.turkcell.spring.intro.service.abtracts.AttendantService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/attendant")
@RequiredArgsConstructor
public class AttendantController {

    private final AttendantService attendantService;


    @GetMapping("/all")
    public ResponseEntity<List<GetAttendantResponse>> getAll(){

        return ResponseEntity.ok(attendantService.list());
    }

    @PostMapping("/add")
    public ResponseEntity<AddAttendantResponse> addAttendant(@RequestBody @Valid AddAttendantRequest request){
        AddAttendantResponse response = attendantService.add(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/getattendant")
    public ResponseEntity<GetAttendantResponse> getAttendant(@Valid GetAttendantRequest request){

        return ResponseEntity.ok(attendantService.getById(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteAttendantResponse> deleteAttendant(@RequestBody @Valid DeleteAttendantRequest request){
        return ResponseEntity.ok(attendantService.delete(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateAttendantRequest> updateAttendant(@RequestBody @Valid UpdateAttendantRequest request){
        return ResponseEntity.ok(attendantService.updatePassword(request));
    }




}
