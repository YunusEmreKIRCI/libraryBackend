package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.entities.User;

import com.turkcell.spring.intro.repositories.AttendantRepository;
import com.turkcell.spring.intro.repositories.UserRepository;
import com.turkcell.spring.intro.service.abtracts.UserService;
import com.turkcell.spring.intro.service.dtos.UserToAddDto;
import com.turkcell.spring.intro.service.dtos.requests.user.AddUserRequest;
import com.turkcell.spring.intro.service.dtos.requests.user.DeleteUserRequest;
import com.turkcell.spring.intro.service.dtos.requests.user.GetUserRequest;
import com.turkcell.spring.intro.service.dtos.requests.user.UpdateUserRequest;
import com.turkcell.spring.intro.service.dtos.responses.user.AddUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.DeleteUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.GetUserResponse;
import com.turkcell.spring.intro.service.dtos.responses.user.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/all")
    public ResponseEntity<List<GetUserResponse>> getAll(){


        return ResponseEntity.ok(userService.list());
    }


    @GetMapping("/getuser")
    public ResponseEntity<GetUserResponse> getUser(GetUserRequest request){
        return ResponseEntity.ok(userService.getById(request));
    }
    @PostMapping("/add")
    public ResponseEntity<AddUserResponse> addUser(@RequestBody AddUserRequest request){

        return ResponseEntity.ok(userService.add(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteUserResponse> deleteUser(@RequestBody DeleteUserRequest request){
        return ResponseEntity.ok(userService.delete(request));
    }
    @PutMapping("/update")
    public ResponseEntity<UpdateUserResponse> updateUser(@RequestBody UpdateUserRequest request){
        return ResponseEntity.ok(userService.updatePassword(request));
    }



    @GetMapping("say")
    public String getNameByQueryString(@RequestParam String name, @RequestParam String surname){
        //REQUESTPARAM
        //Query string de endpointin sonuna ?name=Emre&surname=KIRCI şeklinde istek atıldığında
        //name ve surname parametrelerini alabiliriz
        //public String getNameByQueryString(@RequestParam String name, String surname) şeklinde de yapılabilir
        return "merhaba" + name + surname;
    }
    @GetMapping("{name}/{surname}")
    public String getNameByRootParam(@PathVariable String name, @PathVariable String surname){
        /*
            PATHVARİABLE
            Root parametresi ile alama is name /Emre/KIRCI şeklinde direkt alınabiliyor
         */

        return "Merhaba" + name + surname;
    }
    @PostMapping
    public String createUser(@RequestBody User user){

        return "ok" + user.getEmail();
    }

}
