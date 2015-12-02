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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Produit")
public class Produit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PRODUIT")
	private Long idProduit ;
	
	
	@Column(name="NOM_PRODUIT")
	//@NotEmpty(message="Entrer le nom du produit")
	private String nomProduit ;
	
	@Column(name="DESIGNATION")
	private String designation ;
	
	@Column(name="DESCRIPTION")
	private String description ;
	
	@Column(name="PHOTO")
	private String photo ;
	
	@Column(name="PRIX")
	//@NotEmpty(message="Entrer le prix")
	private double prix ;
	
	@Column(name="QUANTITE")
	//@NotEmpty(message="Entrer la quantite")
	private int quantite ;
	
	@Column(name="ACTIVED")
	//@NotEmpty(message="Entrer l'etat du produit")
	private boolean active ;
	
	
	//@NotEmpty(message="Entrer la categorie")
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIE")
	private Categorie categorie ;
	
	
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public Produit(String nomProduit, String designation, String description, String photo, double prix, int quantite,
			boolean active) {
		super();
		this.nomProduit = nomProduit;
		this.designation = designation;
		this.description = description;
		this.photo = photo;
		this.prix = prix;
		this.quantite = quantite;
		this.active = active;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
