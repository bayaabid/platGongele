package com.platscongeles.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CATEGORIE")
public class Categorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CATEGORIE")
	private Long idCategorie ;
	
	
	@Column(name="NOM_CATEGORIE")
	//@NotEmpty(message="Entrer le nom de la categorie")
	//@Size(min=4,max=25,message="La taille dunom entre ")
	private String nomCategorie ;
	
	
	@Column(name="DESCRIPTION")
	private String description ;
	
	@Column(name="NOM_PHOTO")
	private String nomPhoto ;
	
	
	@Lob
	@Column(name="PHOTO")
	private byte[] photo ;
	
	@OneToMany(mappedBy="categorie")
	private List<Produit> produits ;
	
	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategrie) {
		this.idCategorie = idCategrie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Categorie(String nomCategorie, String description, String nomPhoto) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.nomPhoto = nomPhoto;
	}
	
	

}
