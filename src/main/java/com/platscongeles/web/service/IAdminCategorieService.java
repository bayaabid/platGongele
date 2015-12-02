package com.platscongeles.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.platscongeles.web.entity.*;

public interface IAdminCategorieService extends IAdminProduitService {
	
	public Long ajouterCategorie(Categorie categorie);
	public void supprimerCategorie(Long idCategorie);
	public void modifierCategorie(Categorie categorie);
	public void ajouterUser(User user ,List<Role> roles);
	public void deleteUser(Long idUser);
	public List<User> getAllUsers();
	public User getUser(Long idUser);
	public User getUserByName(String nameUser);
	public void attribuerRole(Role role ,Long idUser);
	public List<Role> getAllRoles();

}
