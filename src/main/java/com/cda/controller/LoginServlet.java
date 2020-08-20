package com.cda.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		Utilisateur utilisateur = utilisateurService.connexion(login, password);

		if (utilisateur == null) {
			request.setAttribute("error", true);
			request.getRequestDispatcher("WEB-INF/utilisateur/login.jsp").forward(request, response);
		} else if (utilisateur.getStatusUtilisateur() == 0){
			request.setAttribute("en_attente", true);
			request.getRequestDispatcher("WEB-INF/utilisateur/login.jsp").forward(request, response);
		}else {
			Date date = new Date(Calendar.getInstance().getTime().getTime());
			utilisateur.setDateConnexion(new Date(Calendar.getInstance().getTime().getTime()));
			utilisateur.setTs(new Timestamp(date.getTime()));
			utilisateurService.save(utilisateur);
			//System.out.println(utilisateur.getTs());
			Cookie cookie = new Cookie("login", login);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);
			log.debug("L'utilisateur " + login + " s'est connecté");
			request.getSession().setAttribute("utilisateur", utilisateur);
			request.getRequestDispatcher("/index").forward(request, response);
		}
	}
}