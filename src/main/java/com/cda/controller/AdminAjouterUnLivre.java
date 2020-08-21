package com.cda.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	private static final String OS = System.getProperty("os.name").toLowerCase();

	@RequestMapping(value = "/ajouter-livre", method = RequestMethod.GET)
	public ModelAndView initialisationAjout() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/ajouter-livre");
		return model;
	}

	@RequestMapping(value = "/ajouter-livre", consumes = { "multipart/form-data" }, method = RequestMethod.POST)
	public @ResponseBody ModelAndView validationAjout(@RequestParam("file") MultipartFile multipart,
			@RequestParam(value = "titre") String titre, @RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom, @RequestParam(value = "synopsis") String synopsis,
			@RequestParam(value = "nombre-page") String nombrePage,
			@RequestParam(value = "quantitee-stock") String quantiteStock, @RequestParam(value = "prix") String prix) {
		// test si le livre existe
		String SLASH = OS.contains("windows") ? "\\" : "/";
		ModelAndView model = new ModelAndView();
		if (livreService.findByTitre(titre) == null) {
			// vérifier si le fichier est bien une image
			if (FilenameUtils.getExtension(multipart.getOriginalFilename()).matches("jpg|jpeg|png")) {
				String home = System.getProperty("user.home");
				String pathDir = home + SLASH + "images";
				File dirPath = new File(pathDir);
				File filePath = new File(pathDir + SLASH + new Timestamp(System.currentTimeMillis()).getTime() + "."
						+ FilenameUtils.getExtension(multipart.getOriginalFilename()));
				try {
					if (!dirPath.exists()) {
						dirPath.mkdir();
					}
					boolean a = filePath.createNewFile();
					if (a) {
						multipart.transferTo(filePath);
					}
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			log.info(titre);
			Auteur auteur = new Auteur(nom, prenom);
			auteurService.save(auteur);
			Livre livre = new Livre(auteur.getId(), titre, Integer.parseInt(quantiteStock),
					Integer.parseInt(nombrePage), synopsis, "test", new BigDecimal(prix), auteur);
			livreService.save(livre);
			log.info("Livre : " + livre + " ajouté");
			return new ModelAndView("redirect:/index");
		} else {
			model.addObject("error", "Le livre existe déja");
			model.setViewName("/admin/ajouter-livre");
		}
		return model;
	}
}