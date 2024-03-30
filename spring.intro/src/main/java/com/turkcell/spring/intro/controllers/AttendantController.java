package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.service.dtos.AttendantToAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.turkcell.spring.intro.service.abtracts.AttendantService;

import java.util.List;

@RestController
@RequestMapping("/api/attendant")
@RequiredArgsConstructor
public class AttendantController {

    private final AttendantService attendantService;

    @GetMapping("/all")
    public List<Attendant> getAll(){
        return attendantService.list();
    }

    @PostMapping("/add")
    public void addAttendant(@RequestBody AttendantToAddDto attendantToAddDto){
        attendantService.add(attendantToAddDto);
    }

    @GetMapping("/getattendant")
    public Attendant getAttendant(@RequestParam int id){
        return attendantService.getById(id);
    }

    @DeleteMapping("/delete")
    public void deleteAttendant(@RequestParam int id){
        attendantService.delete(id);
    }

    @PutMapping("/update")
    public void updateAttendant(int id, @RequestBody String password){
        attendantService.updatePassword(id, password);
    }




}
