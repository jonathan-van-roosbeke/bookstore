package com.cda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

import lombok.extern.slf4j.Slf4j;

@WebServlet("/demande-compte")
public class AdminDemandeCompteServlet extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Utilisateur> utilisateurs = utilisateurService.findCompteEnAttente();
		request.setAttribute("utilisateurs", utilisateurs);
		request.getRequestDispatcher("WEB-INF/admin/demande-compte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Utilisateur> utilisateurs = utilisateurService.findCompteEnAttente();
		request.setAttribute("utilisateurs", utilisateurs);
		request.getRequestDispatcher("WEB-INF/admin/demande-compte.jsp").forward(request, response);
	}

}
