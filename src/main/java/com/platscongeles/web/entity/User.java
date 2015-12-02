package com.platscongeles.web.entity;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long idUser ;
	
	
	@NotEmpty(message="Entrer userName")
	private String userName ;
	
	
	@NotEmpty(message="Entrer le mot de passe")
	private String password ;
	
	@Column(name="ACTIVED")
	//@NotEmpty(message="Entrer l'etat")
	private boolean actived ;
	
	@NotEmpty(message="Selectionner un role")
	@ManyToMany
	@JoinTable
	private List<Role> roles ;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String password, boolean actived) {
		super();
		this.userName = userName;
		this.password = password;
		this.actived = actived;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	
	

}
