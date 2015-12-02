package com.platscongeles.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.platscongeles.web.entity.*;


public interface InternauteService {
	public Long ajouterProduit( Produit produit, Long idCategorie);
	public List<Categorie> getAllCategorie();
	public Categorie getCategorie(Long idCategorie);
	public Produit getProduit(Long idProduit);
	public List<Produit> getAllProduit();
	public Page<Produit> produitsParMotCle(String motCle ,int page);
	public List<Produit> produitsParCategorie(Long idCategorie);
	public List<Produit> produitsSelectionnes(boolean active);
	public Commande enregistrerCommande(Panier panier, Client client);
}
