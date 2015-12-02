package com.platscongeles.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platscongeles.web.entity.Client;
import com.platscongeles.web.entity.Commande;
import com.platscongeles.web.entity.Panier;;


public interface CommandeRepository extends JpaRepository<Commande, Long>{

	

}
