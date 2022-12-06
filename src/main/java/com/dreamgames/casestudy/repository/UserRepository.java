package com.dreamgames.casestudy.repository;

import com.dreamgames.casestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
