package com.cda.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

@Controller
public class AjaxUserCheckServlet {
	
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@GetMapping(value = "/user-check")
	public void validationAjout(
			@RequestParam(value = "login") String login,
			HttpServletResponse response) {
		
		Utilisateur utilisateur = utilisateurService.findById(login);
		System.out.println(utilisateur);
		
		if(utilisateur != null) {
			response.setContentType("text/plain");
			try {
				response.getWriter().write(utilisateur.getLogin() + " existe déjà");
				response.setStatus(400);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.setContentType("text/plain");
				response.getWriter().write("valide");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
}
