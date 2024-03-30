package com.turkcell.spring.intro.repositories;

import com.turkcell.spring.intro.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{

}
