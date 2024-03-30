package com.turkcell.spring.intro.repositories;

import com.turkcell.spring.intro.entities.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendantRepository extends JpaRepository<Attendant, Integer> {

}
