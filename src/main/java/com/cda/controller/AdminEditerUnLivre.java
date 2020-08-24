package com.cda.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cda.entity.Auteur;
import com.cda.entity.Livre;
import com.cda.service.IAuteurService;
import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminEditerUnLivre {

	@Autowired
	ILivreService livreService;

	@Autowired
	IAuteurService auteurService;

	private int id;
	private Auteur auteur;
	private Livre livre;

	@GetMapping(value = "/editer-livre")
	public ModelAndView getLivre(@RequestParam(value = "id") String idParam) {
		id = Integer.parseInt(idParam);
		Livre livre = livreService.findById(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/editer-livre");
		model.addObject("livre", livre);
		return model;
	}

	@PostMapping(value = "/editer-livre")
	public String editerLivre(@RequestParam(value = "titre") String titre, @RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom, @RequestParam(value = "synopsis") String synopsis,
			@RequestParam(value = "nombre-page") String nombrePage,
			@RequestParam(value = "quantitee-stock") String quantiteStock, @RequestParam(value = "prix") String prix) {
		livre = livreService.findById(id);
		Auteur auteurActuel = auteurService.findByNomPrenom(livre.getAuteur().getNom(), livre.getAuteur().getPrenom());

		// update infos auteur
		if (auteurActuel.getNom().equalsIgnoreCase(nom) && auteurActuel.getPrenom().equalsIgnoreCase(prenom)) {
			auteur = auteurActuel;
		} else {
			auteur = Auteur.builder().nom(nom).prenom(prenom).build();

			auteurService.save(auteur);
		}

		// update infos livre
		Livre livreUpdate = Livre.builder().id(livre.getId()).idAuteur(auteur.getId()).titre(titre)
				.quantiteStock(Integer.parseInt(quantiteStock)).nombrePage(Integer.parseInt(nombrePage))
				.synopsis(synopsis).nomImage(livre.getNomImage()).prix(new BigDecimal(prix)).auteur(auteur).build();

		log.info("Vous avez édité le livre : " + livre + " en " + livreUpdate);
		livreService.save(livreUpdate);

		return "redirect:/index";
	}
}
