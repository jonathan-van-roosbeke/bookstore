package com.cda.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Paths;

import javax.servlet.http.Part;

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
	public ModelAndView validationAjout(
			@RequestParam(value = "titre") String titre, 
			@RequestParam(value = "nom") String nom, 
			@RequestParam(value = "prenom") String prenom,
			@RequestParam(value = "synopsis") String synopsis, 
			@RequestParam(value = "nombre-page") String nombrePage, 
			@RequestParam(value = "quantitee-stock") String quantiteStock,
			@RequestParam(value = "prix") String prix)
			// @RequestParam(value = "file") Part filePart)
	{
	
		ModelAndView model = new ModelAndView();
		log.info(titre);
//		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//		InputStream fileContent;
//		try {
//			fileContent = filePart.getInputStream();
//			byte[] buffer = new byte[fileContent.available()];
//			fileContent.read(buffer);
//			File targetFile = new File("/home/jonathan/Documents/java-projects/bookstore/src/main/webapp/resources/images/img-couverture-livre/" + fileName);
//			OutputStream outStream = new FileOutputStream(targetFile);
//			outStream.write(buffer);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		Auteur auteur = new Auteur(nom, prenom);
		auteurService.save(auteur);
		Livre livre = new Livre(auteur.getId(), titre, Integer.parseInt(quantiteStock), Integer.parseInt(nombrePage),
				synopsis, "test", new BigDecimal(prix), auteur);
		livreService.save(livre);
		log.info("Livre : " + livre + " ajouté");
		model.setViewName("/utilisateur/index");
		return model;
	}
}