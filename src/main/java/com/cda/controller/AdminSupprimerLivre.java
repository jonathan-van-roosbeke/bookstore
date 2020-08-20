package com.cda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminSupprimerLivre {

	@Autowired
	ILivreService livreService;

	@GetMapping(value = "/supprimer-livre")
	String getLivre(@RequestParam(value = "id") String id) {
		livreService.deleteById(Integer.parseInt(id));
		log.info("Livre " + id + " supprimé");
		return "/utilisateur/index";
	}
}
