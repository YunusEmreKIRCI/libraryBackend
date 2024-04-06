package com.turkcell.spring.intro.repositories;

import com.turkcell.spring.intro.entities.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttendantRepository extends JpaRepository<Attendant, Integer> {

    Optional<Attendant> findByEmail(String email);
}
