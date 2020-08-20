package com.cda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

@Controller
public class AdminDemandeCompteServlet {

	@Autowired
	IUtilisateurService utilisateurService;

	@GetMapping(value = "/demande-compte")
	ModelAndView getCompte(ModelAndView model, @RequestParam(value = "pageNo", defaultValue = "1") String pageNoStr) {
		List<Utilisateur> utilisateurs = utilisateurService.findCompteEnAttente();
		if (pageNoStr == null) {
			pageNoStr = "1";
		}
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNoStr);
			if (pageNo < 1) {
				pageNo = 1;
			}
		} catch (Exception e) {
		}

		Page<Utilisateur> page = utilisateurService.getPage(pageNo, 10, utilisateurs);
		model.setViewName("admin/demande-compte");
		model.addObject("page", page);
		model.addObject("utilisateurs", utilisateurs);
		return model;
	}

	@PostMapping(value = "/demande-compte")
	ModelAndView editerLaDemande(ModelAndView model) {
		List<Utilisateur> utilisateurs = utilisateurService.findCompteEnAttente();
		model.addObject("utilisateurs", utilisateurs);
		model.setViewName("admin/demande-compte");
		return model;
	}
}
