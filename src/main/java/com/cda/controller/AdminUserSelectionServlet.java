package com.cda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

@Controller
public class AdminUserSelectionServlet {
	@Autowired
	IUtilisateurService utilisateurService;
     
	@GetMapping(value = "/select-user")
	public ModelAndView selectUser(@RequestParam(value="id") String id) {
		Utilisateur utilisateur = utilisateurService.findById(id);
		ModelAndView model = new ModelAndView();
		model.addObject("utilisateur", utilisateur);
		model.setViewName("/admin/info-user");
		return model;
	}
}
