package com.platscongeles.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.platscongeles.web.entity.*;
import com.platscongeles.web.repository.AdresseRepository;
import com.platscongeles.web.repository.CategorieRepository;
import com.platscongeles.web.repository.ClientRepository;
import com.platscongeles.web.repository.CommandeRepository;
import com.platscongeles.web.repository.LigneCommandeRepository;
import com.platscongeles.web.repository.ProduitRepository;
import com.platscongeles.web.repository.RoleRepository;
import com.platscongeles.web.repository.UserRepository;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleRepository roleRepository ;
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private ProduitRepository produitRepository ;
	
	
	@Autowired
	private CategorieRepository categorieRepository ;
	
	@Autowired
	private AdresseRepository adresseRepository ;
	
	@Autowired
	private ClientRepository clientRepository ;
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository ;
	
	@PostConstruct
	public void init(){
		
		Role roleUser = new Role();
		roleUser.setRoleName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setRoleName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setUserName("admin");
		userAdmin.setActived(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Categorie c1 = new Categorie("Poulet", "Viande blanche et cuisse", "poulet.ejp");
		Categorie c2 = new Categorie("Viande Rouge", "Viande rouge", "rouge.ejp");
		Categorie c3 = new Categorie("Lasagne", "pate", "pate.ejp");
		categorieRepository.save(c1);
		categorieRepository.save(c2);
		categorieRepository.save(c3);
		
		Produit p1 = new Produit("Poitine de poulet", "Viande blanche", "poitrine patate pile et legume", "photo", 7.25, 7, true);
		Produit p2 = new Produit("Cuisse de poulet", "poulet", "cuisse patate pile et legume", "photo", 7, 7, true);
		Produit p3 = new Produit("Lasagne", "Pate", "pate lasagne sauce a la viande", "photo", 7.25, 7, true);
		Produit p4 = new Produit("Bourguignon", "Viande rouge", "cube de boeuf pate pile et legumes", "photo", 7, 12, true);
		p1.setCategorie(c1);
		p2.setCategorie(c1);
		p3.setCategorie(c3);
		p4.setCategorie(c2);
		produitRepository.save(p1);
		produitRepository.save(p2);
		produitRepository.save(p3);
		produitRepository.save(p4);
		
		Adresse adresse1 = new Adresse("MauriceDuplaicie", "8860", "4", "4");
		adresseRepository.save(adresse1);
		Adresse adresse2 = new Adresse("Gouin Ouest", "3255", "1204", "1204");
		adresseRepository.save(adresse2);
		
		LigneCommande ligneCommande1 = new LigneCommande(7.25, 4);
		ligneCommande1.setProduit(p1);
		ligneCommandeRepository.save(ligneCommande1);
		
		LigneCommande ligneCommande2 = new LigneCommande(7, 3);
		ligneCommande2.setProduit(p2);
		ligneCommandeRepository.save(ligneCommande2);
		
		LigneCommande ligneCommande3 = new LigneCommande(7.25, 5);
		ligneCommande3.setProduit(p3);
		ligneCommandeRepository.save(ligneCommande3);

		LigneCommande ligneCommande4 = new LigneCommande(7.25, 4);
		ligneCommande4.setProduit(p4);
		ligneCommandeRepository.save(ligneCommande4);
		
		List<LigneCommande> lCommandes1 = new ArrayList<LigneCommande>();
		lCommandes1.add(ligneCommande1);
		lCommandes1.add(ligneCommande2);
		lCommandes1.add(ligneCommande3);
		
		List<LigneCommande> lCommandes2 = new ArrayList<LigneCommande>();
		lCommandes2.add(ligneCommande1);
		lCommandes2.add(ligneCommande2);
		lCommandes2.add(ligneCommande4);
		
		Client client1 = new Client("Madamme Stebens", "514 574-3448");
		client1.setAdresse(adresse1);
		clientRepository.save(client1);
		Client client2 = new Client("Madamme Dubois", "514 576-6967");
		client2.setAdresse(adresse2);
		clientRepository.save(client2);
		
		Commande commande1 = new Commande();
		commande1.setClient(client1);
		commande1.setDateCommande(new Date());
		commande1.setLigneCommandes(lCommandes1);
		commandeRepository.save(commande1);
		
		Commande commande2 = new Commande();
		commande2.setClient(client2);
		commande2.setDateCommande(new Date());
		commande2.setLigneCommandes(lCommandes2);
		commandeRepository.save(commande2);
		
		List<Commande> commandes1 = new ArrayList<Commande>();
		commandes1.add(commande1);
		client1.setCommandes(commandes1);
		clientRepository.saveAndFlush(client1);
		
		List<Commande> commandes2 = new ArrayList<Commande>();
		commandes2.add(commande2);
		client2.setCommandes(commandes2);
		clientRepository.saveAndFlush(client2);
	
		

	}

}
