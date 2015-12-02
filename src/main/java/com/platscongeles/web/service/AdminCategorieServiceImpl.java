package com.platscongeles.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.platscongeles.web.entity.Categorie;
import com.platscongeles.web.entity.Client;
import com.platscongeles.web.entity.Commande;
import com.platscongeles.web.entity.LigneCommande;
import com.platscongeles.web.entity.Panier;
import com.platscongeles.web.entity.Produit;
import com.platscongeles.web.entity.Role;
import com.platscongeles.web.entity.User;
import com.platscongeles.web.repository.AdresseRepository;
import com.platscongeles.web.repository.CategorieRepository;
import com.platscongeles.web.repository.ClientRepository;
import com.platscongeles.web.repository.CommandeRepository;
import com.platscongeles.web.repository.LigneCommandeRepository;
import com.platscongeles.web.repository.ProduitRepository;
import com.platscongeles.web.repository.RoleRepository;
import com.platscongeles.web.repository.UserRepository;

@Service
@Transactional
public class AdminCategorieServiceImpl implements IAdminCategorieService  {
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private LigneCommandeRepository ligneCommande ;
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private AdresseRepository adresseRepository;
	
	@Autowired
	private LigneCommandeRepository ligneCommandeRepositry ;

	
	
	@Override
	public Long ajouterProduit(Produit produit , Long idCategorie) {
		
		Categorie categorie =getCategorie(idCategorie);
		produit.setCategorie(categorie);
		produitRepository.save(produit);
		return produit.getIdProduit();
	}

	@Override
	public void supprimerProduit(Long idProduit) {
		Produit produit = getProduit(idProduit);
		LigneCommande ligneCommande = ligneCommandeRepositry.findByProduit(produit);
		if(ligneCommande!=null){
			ligneCommandeRepositry.delete(ligneCommande);
			}
		produitRepository.delete(produit);
	}

	@Override
	public void modifierProduit(Produit produit) {

		produitRepository.saveAndFlush(produit);
		
	}

	@Override
	public List<Categorie> getAllCategorie() {
		
		return categorieRepository.findAll();
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		
		return categorieRepository.findOne(idCategorie);
	}

	@Override
	public Produit getProduit(Long idProduit) {
		
		return produitRepository.findOne(idProduit);
	}

	@Override
	public List<Produit> getAllProduit() {
		
		return produitRepository.findAll();
	}

	@Override
	public Page<Produit> produitsParMotCle(String motCle ,int page) {
		
		return produitRepository.produitsParMotCle("%"+motCle+"%", new PageRequest(page, 5));
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCategorie) {
		
		return produitRepository.findByCategorie(getCategorie(idCategorie));
	}

	@Override
	public List<Produit> produitsSelectionnes(boolean active) {
		
		return produitRepository.findByActive(active);
		
	}

	@Override
	public Commande enregistrerCommande(Panier panier, Client client) {
		
		Client client1=clientRepository.findOne(client.getIdClient());
		Commande  commande = new Commande();
		
		if(client1==null){
			
			clientRepository.save(client);
			
			commande.setDateCommande(new Date());
			commande.setClient(client1);
			commande.setLigneCommandes(panier.getItems());
			for (LigneCommande ligneCommande : panier.getItems()) {
				ligneCommandeRepositry.save(ligneCommande);
				
			}
			commandeRepository.save(commande);
		}else{
			commande.setDateCommande(new Date());
			commande.setClient(client1);
			commande.setLigneCommandes(panier.getItems());
			for (LigneCommande ligneCommande : panier.getItems()) {
				ligneCommandeRepositry.save(ligneCommande);
				
			}
			commandeRepository.save(commande);
			
		}
		return commande;
	}

	@Override
	public Long ajouterCategorie(Categorie categorie) {
		categorieRepository.save(categorie);	
		return categorie.getIdCategorie();
	}

	@Override
	public void supprimerCategorie(Long idCategorie) {
		
		categorieRepository.delete(idCategorie);
	}

	@Override
	public void modifierCategorie(Categorie categorie) {
		
		categorieRepository.saveAndFlush(categorie);
		
	}

	@Override
	public void ajouterUser(User user ,List<Role>roles) {
		user.setActived(true);
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> roles1 = new ArrayList<Role>();
		roles1.add(roleRepository.findByRoleName(roles.get(0).getRoleName()));
		user.setRoles(roles1);
		
		userRepository.save(user);
		
	}

	@Override
	public void attribuerRole(Role role, Long idUser) {
	 
		User user = userRepository.findOne(idUser);
		role.getUsers().add(user);
		
		
		
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long idUser) {
		
		return userRepository.findOne(idUser);
	}

	@Override
	public User getUserByName(String nameUser) {
		
		return userRepository.findByUserName(nameUser);
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role> roles = roleRepository.findAll();
		
		return roles;
	}

	@Override
	public void deleteUser(Long idUser) {
		userRepository.delete(idUser);
		
	}
	
	
	
}
