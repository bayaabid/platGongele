package com.platscongeles.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platscongeles.web.entity.Client;;


public interface ClientRepository extends JpaRepository<Client, Long>{

}
