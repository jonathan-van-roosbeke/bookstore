package com.cda.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

@WebServlet("/supprimer-compte")
public class AdminSupprimerCompteServlet extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/demande-compte");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("id");
		utilisateurService.deleteById(login);
		response.sendRedirect(request.getContextPath()+"/demande-compte");
	}

}
