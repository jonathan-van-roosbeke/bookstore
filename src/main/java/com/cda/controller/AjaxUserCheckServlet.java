package com.cda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

@WebServlet("/user-check")
public class AjaxUserCheckServlet extends AbstractController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login").trim();
		Utilisateur utilisateur = utilisateurService.findById(login);
		System.out.println(utilisateur);
		
		if(utilisateur != null) {
			response.setContentType("text/plain");
		    response.getWriter().write(utilisateur.getLogin() + " existe déjà");
		} else {
			response.setContentType("text/plain");
		    response.getWriter().write("valide");
		}
	}

}