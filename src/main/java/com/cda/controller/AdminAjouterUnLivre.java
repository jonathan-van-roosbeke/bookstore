package com.cda.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cda.entity.Auteur;
import com.cda.entity.Livre;
import com.cda.service.IAuteurService;
import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@MultipartConfig
@Controller
public class AdminAjouterUnLivre {
	@Autowired
	IAuteurService auteurService;
	@Autowired
	ILivreService livreService;

	@RequestMapping(value = "/ajouter-livre", method = RequestMethod.GET)
	public ModelAndView initialisationAjout() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/ajouter-livre");
		return model;
	}

	@RequestMapping(value = "/ajouter-livre", method = RequestMethod.POST)
	public ModelAndView validationAjout(@RequestParam(value = "titre") String titre,
			@RequestParam(value = "nom") String nom, @RequestParam(value = "prenom") String prenom,
			@RequestParam(value = "synopsis") String synopsis, @RequestParam(value = "nombre-page") String nombrePage,
			@RequestParam(value = "quantitee-stock") String quantiteStock, @RequestParam(value = "prix") String prix)
	// @RequestParam(value = "file") Part filePart)
	{

		ModelAndView model = new ModelAndView();
		log.info(titre);
		Auteur auteur = new Auteur(nom, prenom);
		auteurService.save(auteur);
		Livre livre = new Livre(auteur.getId(), titre, Integer.parseInt(quantiteStock), Integer.parseInt(nombrePage),
				synopsis, "test", new BigDecimal(prix), auteur);
		if (livreService.findByTitre(titre) != null) {
			livreService.save(livre);
			log.info("Livre : " + livre + " ajouté");
			model.setViewName("/utilisateur/index");
		} else {
			log.info("Livre : " + livre + " existe déja");
			model.addObject("error", "Le livre existe déja");
			model.setViewName("/admin/ajouter-livre");
		}
		return model;
	}
}