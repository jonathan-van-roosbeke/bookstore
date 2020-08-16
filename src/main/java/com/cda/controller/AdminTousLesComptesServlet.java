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

@WebServlet("/tous-comptes")
public class AdminTousLesComptesServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	IUtilisateurService utilisateurService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Utilisateur> utilisateurs = utilisateurService.findAll();
		
		request.setAttribute("utilisateurs", utilisateurs);
		request.getRequestDispatcher("WEB-INF/admin/tous-les-comptes.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
