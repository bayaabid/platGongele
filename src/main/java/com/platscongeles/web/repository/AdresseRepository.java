package com.platscongeles.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.platscongeles.web.entity.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Long>{

	public List<Adresse> findByCodeCivique(String codeCivique);
}
