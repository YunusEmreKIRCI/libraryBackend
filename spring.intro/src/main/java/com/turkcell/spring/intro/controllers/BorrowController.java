package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Borrow;
import com.turkcell.spring.intro.service.dtos.BorrowToAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.turkcell.spring.intro.service.abtracts.BorrowService;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService borrowService;

    @GetMapping("/all")
    public List<Borrow> getAll(){
        return borrowService.list();
    }

    @DeleteMapping("/delete")
    public void deleteBorrow(@RequestParam int id){
        borrowService.delete(id);
    }

    @PutMapping("/update")
    public void updateBorrow(@RequestParam int id){
        borrowService.update(id);
    }

    @PostMapping("/add")
    public void addBorrow(@RequestBody BorrowToAddDto borrowToAddDto){
        borrowService.add(borrowToAddDto);
    }

    @GetMapping("/getborrow")
    public Borrow getBorrow(int id){
        return borrowService.getById(id);
    }
}
