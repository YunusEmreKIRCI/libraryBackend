package com.turkcell.spring.intro.service.concretes;

import com.turkcell.spring.intro.entities.Borrow;
import com.turkcell.spring.intro.repositories.BookRepository;
import com.turkcell.spring.intro.repositories.UserRepository;
import com.turkcell.spring.intro.service.dtos.BorrowToAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.turkcell.spring.intro.service.abtracts.BorrowService;
import com.turkcell.spring.intro.repositories.BorrowRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService{
    private final BorrowRepository borrowRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

   @Override
    public void add(BorrowToAddDto borrowToAddDto) {
        Borrow borrow = new Borrow();
        borrow.setBook(bookRepository.findById(borrowToAddDto.getBookId()).orElse(null));
        borrow.setUser(userRepository.findById(borrowToAddDto.getUserId()).orElse(null));
        borrow.setBorrowDate(LocalDate.now());
        borrow.setReturnDate(LocalDate.now().plusDays(7));
        borrow.setReturned(false);
        borrow.setLate(false);
        borrowRepository.save(borrow);
    }

    @Override
    public void delete(int id) {
        Borrow borrow = borrowRepository.findById(id).orElse(null);
        if(borrow == null){
            throw new IllegalArgumentException("Borrow not found");
        }
        else{
            borrowRepository.delete(borrow);
        }
    }

    @Override
    public void update(int id) {
        Borrow borrow = borrowRepository.findById(id).orElse(null);
        if(borrow == null){
            throw new IllegalArgumentException("Borrow not found");
        }
        else{
            if(borrow.getReturnDate().isBefore(LocalDate.now())){
                borrow.setLate(true);
            }
            borrow.setReturned(true);
            borrowRepository.save(borrow);
        }
    }

    @Override
    public List<Borrow> list() {
        return borrowRepository.findAll();
    }

    @Override
    public Borrow getById(int id) {
        return borrowRepository.findById(id).orElse(null);
    }


}
