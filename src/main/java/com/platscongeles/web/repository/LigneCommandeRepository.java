package com.platscongeles.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platscongeles.web.entity.LigneCommande;
import com.platscongeles.web.entity.Produit;;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long>{

	LigneCommande findByProduit(Produit produit);

}
