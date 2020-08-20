package com.cda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class AdminValiderCompteServlet {
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@GetMapping(value = "/valider-compte")
	public ModelAndView initValidationCompte() {
		return new ModelAndView("redirect:/demande-compte");
	}

	@PostMapping(value = "/valider-compte")
	public ModelAndView validationCompte(
			@RequestParam(value = "id") String login){
		Utilisateur utilisateur = utilisateurService.findById(login);
		utilisateur.setStatusUtilisateur(1);
		utilisateurService.save(utilisateur);
		log.info("Le compte " + utilisateur.getLogin() + " à été validé");
		
		return new ModelAndView("redirect:/demande-compte");
	}

}
