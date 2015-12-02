package com.platscongeles.web.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LIGNECOMMANDE")
public class LigneCommande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_LIGNECOMMANDE")
	private Long  idLignecommande;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUIT")
	private Produit produit ;
	
	@Column(name="PRIX")
	private double prix ;
	
	@Column(name="QUANTITE")
	private int quantite ;

	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommande(double prix, int quantite) {
		super();
		this.prix = prix;
		this.quantite = quantite;
	}

	public Long getIdLignecommande() {
		return idLignecommande;
	}

	public void setIdLignecommande(Long idLignecommande) {
		this.idLignecommande = idLignecommande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	

}
