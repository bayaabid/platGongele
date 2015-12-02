package com.platscongeles.web.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.platscongeles.web.entity.Categorie;
import com.platscongeles.web.entity.Produit;
import com.platscongeles.web.entity.Role;
import com.platscongeles.web.entity.User;
import com.platscongeles.web.service.IAdminCategorieService;

@Controller
public class UserController {
	
	@Autowired
	private IAdminCategorieService adminCategorieService ;
	
	@ModelAttribute("user")
	public User contructUser(){
		return new User() ;
	}
	
	@ModelAttribute("produit")
	public Produit contructProduit(){
		return new Produit() ;
	}
	
	@ModelAttribute("roles")
	public List<Role> contructRoles(){
		return adminCategorieService.getAllRoles() ;
	}
	
	@ModelAttribute("categories")
	public List<Categorie> contructCategories(){
		return adminCategorieService.getAllCategorie() ;
	}
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users", adminCategorieService.getAllUsers());
		return "users";
	}
	
	
	
	@RequestMapping("/users/produit/{idPro}")
	public String deleteP(@PathVariable Long idPro){
		
		adminCategorieService.supprimerProduit(idPro);
		return "redirect:/account.html";
	}

	
	@RequestMapping("/users/{id}")
	public String detail(Model model , @PathVariable Long id){
		model.addAttribute("user", adminCategorieService.getUser(id));
		return "user-detail";
	}
	
	@RequestMapping("/users/remove/{idUser}")
	public String deleteUsers(@PathVariable Long idUser){
		
		adminCategorieService.deleteUser(idUser);;
		return "redirect:/users.html";
	}
	
	@RequestMapping("/register")
	public String showRegister( ){
		return "user-register";
	}
	
	@RequestMapping(value="/register" ,method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user")  User user,
							BindingResult result){
		
		if(result.hasErrors() ){
			return "user-register";
		}
		
		adminCategorieService.ajouterUser(user,user.getRoles());
		return "redirect:/register.html?success=true";
	}

	@RequestMapping("/account")
	public String account(Model model , Principal principal){
		String name = principal.getName();
		model.addAttribute("produits", adminCategorieService.getAllProduit());
		model.addAttribute("user", adminCategorieService.getUserByName(name));
		return "account";
	}
	
	@RequestMapping(value="/users/{id}" ,method=RequestMethod.POST)
	public String addProdui(@ModelAttribute("produit")  Produit produit ){
		
		adminCategorieService.ajouterProduit(produit,produit.getCategorie().getIdCategorie());
		return "redirect:/account.html";
	}
	
	@RequestMapping(value="/account" ,method=RequestMethod.POST)
	public String addProduit(@ModelAttribute("produit")  Produit produit ){
	
		adminCategorieService.ajouterProduit(produit,produit.getCategorie().getIdCategorie());
		return "redirect:/account.html";
	}
	
	
}
