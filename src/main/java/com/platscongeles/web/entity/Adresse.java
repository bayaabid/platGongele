package com.platscongeles.web.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ADRESSE")
public class Adresse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ADRESSE")
	private Long idAdresse ;
	
	@Column(name="RUE_NAME")
	//@NotEmpty(message="Entrer le nom de la rue")
	private String rueName ;
	
	@Column(name="CODE_CIVIQUE")
	//@NotEmpty(message="Entrer le code civique")
	private String codeCivique ;
	
	@Column(name="CODE")
	//@NotEmpty(message="Entrer le code")
	private String code ;
	
	@Column(name="APPARTEMENT")
	//@NotEmpty(message="Entrer l'appartement")
	private String appartement ;

	

	public Adresse(String rueName, String codeCivique, String code, String appartement) {
		super();
		this.rueName = rueName;
		this.codeCivique = codeCivique;
		this.code = code;
		this.appartement = appartement;
	}

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getRueName() {
		return rueName;
	}

	public void setRueName(String rueName) {
		this.rueName = rueName;
	}

	public String getCodeCivique() {
		return codeCivique;
	}

	public void setCodeCivique(String codeCivique) {
		this.codeCivique = codeCivique;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAppartement() {
		return appartement;
	}

	public void setAppartement(String appartement) {
		this.appartement = appartement;
	}
	
	


}
