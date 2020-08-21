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
import com.cda.utils.MyConstants;

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

	@RequestMapping(value = "/ajouter-livre", consumes = { "multipart/form-data" }, method = RequestMethod.POST)
	public @ResponseBody ModelAndView validationAjout(@RequestParam("file") MultipartFile multipart,
			@RequestParam(value = "titre") String titre, @RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom, @RequestParam(value = "synopsis") String synopsis,
			@RequestParam(value = "nombre-page") String nombrePage,
			@RequestParam(value = "quantitee-stock") String quantiteStock, @RequestParam(value = "prix") String prix) {
		ModelAndView model = new ModelAndView();
		if (livreService.findByTitre(titre) == null) {
			if (FilenameUtils.getExtension(multipart.getOriginalFilename().toLowerCase()).matches("jpg|jpeg|png")) {
				String pathDir = MyConstants.HOME_DIR + MyConstants.SLASH + "images";
				File dirPath = new File(pathDir);
				File filePath = new File(
						pathDir + MyConstants.SLASH + new Timestamp(System.currentTimeMillis()).getTime() + "."
								+ FilenameUtils.getExtension(multipart.getOriginalFilename()));
				try {
					if (!dirPath.exists()) {
						dirPath.mkdir();
					}
					boolean a = filePath.createNewFile();
					if (a) {
						multipart.transferTo(filePath);
					}
					Auteur auteur = new Auteur(nom, prenom);
					auteurService.save(auteur);
					Livre livre = new Livre(auteur.getId(), titre, Integer.parseInt(quantiteStock),
							Integer.parseInt(nombrePage), synopsis, filePath.getName(), new BigDecimal(prix), auteur);
					livreService.save(livre);
					log.info("Livre : " + livre + " ajouté");
					return new ModelAndView("redirect:/index");
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
				model.addObject("errorImg", "Veillez saisir un fichier avec une extension (jpg|jpeg|png) ");
				model.setViewName("/admin/ajouter-livre");
			}
		} else {
			model.addObject("error", "Le livre existe déja");
			model.setViewName("/admin/ajouter-livre");
		}
		return model;
	}
}