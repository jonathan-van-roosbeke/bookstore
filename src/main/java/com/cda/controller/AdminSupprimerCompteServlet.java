package com.cda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cda.service.IUtilisateurService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminSupprimerCompteServlet {

	@Autowired
	IUtilisateurService utilisateurService;

	@GetMapping("/supprimer-compte")
	String getCompte() {
		return "admin/demande-compte";
	}

	@PostMapping("/supprimer-compte")
	String supprimerCompte(@RequestParam(value = "id") String id) {
		utilisateurService.deleteById(id);
		log.info("Le compte " + id + " à été supprimé");
		return "admin/demande-compte";
	}
}