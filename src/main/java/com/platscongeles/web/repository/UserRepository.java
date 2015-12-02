package com.platscongeles.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platscongeles.web.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String nameUser);

}
