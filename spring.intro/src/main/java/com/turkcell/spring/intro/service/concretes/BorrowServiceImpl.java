package com.turkcell.spring.intro.service.concretes;

import com.turkcell.spring.intro.entities.Borrow;
import com.turkcell.spring.intro.repositories.BookRepository;
import com.turkcell.spring.intro.repositories.UserRepository;
import com.turkcell.spring.intro.service.dtos.requests.borrow.AddBorrowRequest;
import com.turkcell.spring.intro.service.dtos.requests.borrow.DeleteBorrowRequest;
import com.turkcell.spring.intro.service.dtos.requests.borrow.GetBorrowRequest;
import com.turkcell.spring.intro.service.dtos.requests.borrow.UpdateBorrowRequest;
import com.turkcell.spring.intro.service.dtos.responses.book.GetBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.AddBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.DeleteBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.GetBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.UpdateBorrowResponse;
import com.turkcell.spring.intro.service.mappers.abstracts.BorrowMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
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

    private BorrowMapper borrowMapper = Mappers.getMapper(BorrowMapper.class);

   @Override
    public AddBorrowResponse add(AddBorrowRequest request) {
        Borrow borrow = new Borrow();
        borrow.setBook(bookRepository.findById(request.getBookId()).orElse(null));
        borrow.setUser(userRepository.findById(request.getUserId()).orElse(null));
        borrow.setBorrowDate(LocalDate.now());
        borrow.setReturnDate(LocalDate.now().plusDays(7));
        borrow.setReturned(false);
        borrow.setLate(false);
        return borrowMapper.mapToAddBorrowResponse(borrowRepository.save(borrow));
    }

    @Override
    public DeleteBorrowResponse delete(DeleteBorrowRequest request) {
        Borrow borrow = borrowRepository.findById(request.getId()).orElse(null);
        if(borrow == null){
            throw new IllegalArgumentException("Borrow not found");
        }
        else{
            borrowRepository.delete(borrow);
            return borrowMapper.mapToDeleteBorrowResponse(borrow);
        }
    }

    @Override
    public UpdateBorrowResponse update(UpdateBorrowRequest request) {
        Borrow borrow = borrowRepository.findById(request.getId()).orElse(null);
        if(borrow == null){
            throw new IllegalArgumentException("Borrow not found");
        }
        else{
            if(borrow.getReturnDate().isBefore(LocalDate.now())){
                borrow.setLate(true);
            }
            borrow.setReturned(true);
            return borrowMapper.mapToUpdateBorrowResponse(borrowRepository.save(borrow));
        }
    }

    @Override
    public List<GetBorrowResponse> list() {
        return borrowMapper.mapToBorrowResponseList(borrowRepository.findAll());
    }
    @Override
    public GetBorrowResponse getById(GetBorrowRequest request) {
        return borrowMapper.mapToBorrowResponse(borrowRepository.findById(request.getId()).orElse(null));
    }


}
