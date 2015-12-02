package com.platscongeles.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platscongeles.web.entity.Categorie;
import com.platscongeles.web.entity.Produit;;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

	@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> produitsParMotCle(@Param("x")String motCle,Pageable page);

	public List<Produit> findByCategorie(Categorie categorie);

	public List<Produit> findByActive(boolean active);
	
	public List<Produit> findByNomProduit(String nomProduit);
}
