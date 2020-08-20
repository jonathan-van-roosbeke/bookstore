package com.cda.controller;

import java.sql.Date;
import java.util.Calendar;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cda.entity.Adresse;
import com.cda.entity.Utilisateur;
import com.cda.service.IAdresseService;
import com.cda.service.IUtilisateurService;

@Controller
public class InscriptionServlet {

	@Autowired
	IAdresseService adresseService;

	@Autowired
	IUtilisateurService utilisateurService;
	
	@GetMapping(value = "/inscription")
	public ModelAndView initInscription() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/utilisateur/inscription");
		return model;
	}

	@PostMapping(value = "/inscription")
	public ModelAndView validerInscription(
			@RequestParam(value = "nom") String nom, 
			@RequestParam(value = "prenom") String prenom, 
			@RequestParam(value = "email") String email,
			@RequestParam(value = "login") String login, 
			@RequestParam(value = "password") String password, 
			@RequestParam(value = "numero") String numero,
			@RequestParam(value = "rue") String rue, 
			@RequestParam(value = "ville") String ville, 
			@RequestParam(value = "cp") String cp,
			@RequestParam(value = "pays") String pays) {

		Adresse adresse = new Adresse(Integer.parseInt(numero), rue, ville, cp, pays);
		Adresse adresseInscription = adresseService.save(adresse);

		Utilisateur utilisateur = new Utilisateur(login, DigestUtils.md5Hex(password), nom, prenom, email, 0,
				adresseInscription.getIdAdresse(), new Date(Calendar.getInstance().getTime().getTime()),
				new Date(Calendar.getInstance().getTime().getTime()));
		utilisateurService.save(utilisateur);

		return new ModelAndView("redirect:/index");
	}
}