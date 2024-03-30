package com.turkcell.spring.intro.repositories;
import com.turkcell.spring.intro.entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BorrowRepository extends JpaRepository<Borrow, Integer>{
}
