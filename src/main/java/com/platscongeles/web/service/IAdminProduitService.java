package com.platscongeles.web.service;

import org.springframework.stereotype.Service;

import com.platscongeles.web.entity.*;

public interface IAdminProduitService extends InternauteService {
	
	public void supprimerProduit(Long idProduit);
	public void modifierProduit(Produit produit);

}
