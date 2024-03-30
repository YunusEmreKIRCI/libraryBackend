package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Attendant;
import com.turkcell.spring.intro.entities.User;

import com.turkcell.spring.intro.repositories.AttendantRepository;
import com.turkcell.spring.intro.repositories.UserRepository;
import com.turkcell.spring.intro.service.abtracts.UserService;
import com.turkcell.spring.intro.service.dtos.UserToAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/all")
    public List<User> getAll(){


        return userService.list();
    }


    @GetMapping("/getuser")
    public User getUser(int id){
        return userService.getById(id);
    }
    @PostMapping("/add")
    public void addUser(@RequestBody UserToAddDto userToAddDto){

        userService.add(userToAddDto);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam int id){
        userService.delete(id);

    }
    @PutMapping("/update")
    public void updateUser( int id, @RequestBody String password){
        userService.updatePassword(id, password);
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
