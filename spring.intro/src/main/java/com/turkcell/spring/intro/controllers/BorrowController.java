package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Borrow;
import com.turkcell.spring.intro.service.dtos.BorrowToAddDto;
import com.turkcell.spring.intro.service.dtos.requests.borrow.AddBorrowRequest;
import com.turkcell.spring.intro.service.dtos.requests.borrow.DeleteBorrowRequest;
import com.turkcell.spring.intro.service.dtos.requests.borrow.GetBorrowRequest;
import com.turkcell.spring.intro.service.dtos.requests.borrow.UpdateBorrowRequest;
import com.turkcell.spring.intro.service.dtos.responses.book.DeleteBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.GetBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.AddBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.DeleteBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.GetBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.UpdateBorrowResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.turkcell.spring.intro.service.abtracts.BorrowService;


import java.util.List;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService borrowService;

    @GetMapping("/all")
    public ResponseEntity<List<GetBorrowResponse>> getAll(){
        return ResponseEntity.ok(borrowService.list());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteBorrowResponse> deleteBorrow(@RequestBody @Valid DeleteBorrowRequest request){
        return ResponseEntity.ok(borrowService.delete(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateBorrowResponse> updateBorrow(@RequestBody @Valid UpdateBorrowRequest request){
        return ResponseEntity.ok(borrowService.update(request));
    }

    @PostMapping("/add")
    public ResponseEntity<AddBorrowResponse> addBorrow(@RequestBody @Valid AddBorrowRequest request){
        return ResponseEntity.ok(borrowService.add(request));
    }

    @GetMapping("/getborrow")
    public ResponseEntity<GetBorrowResponse> getBorrow(@RequestBody @Valid GetBorrowRequest request){
        return ResponseEntity.ok(borrowService.getById(request));
    }
}
