package com.platscongeles.web.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CLIENT")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLIENT")
	private Long idClient ;
	
	@Column(name="NOM_CLIENT")
	//@NotEmpty(message="Entrer le nom du client")
	private String nomClient ;
	
	@OneToOne
	@JoinColumn(name="ID_ADRESSE")
	private Adresse adresse ;
	
	@Column(name="TELEPHONE")
	//@NotEmpty(message="Entrer le numero de telephone")
	private String telephone ;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy="client")
	private List<Commande> commandes ;

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nomClient, String telephone) {
		super();
		this.nomClient = nomClient;
		this.telephone = telephone;
	}

	
	
	

}
