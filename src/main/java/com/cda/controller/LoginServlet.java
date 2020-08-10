package com.cda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	IUtilisateurService utilisateurService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/utilisateur/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Utilisateur loginUtilisateur = utilisateurService.connexion(login, password);

		if (loginUtilisateur == null) {
			request.getRequestDispatcher("/WEB-INF/utilisateur/login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/index").forward(request, response);
		}
	}
}