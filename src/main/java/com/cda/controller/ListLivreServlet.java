package com.cda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.Livre;
import com.cda.entity.Utilisateur;
import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@WebServlet("/index")
public class ListLivreServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ILivreService iLivreService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Livre> livres = iLivreService.findAll();
		for (Livre livre : livres) {
			System.out.println(livre);
		}
		log.info("livres affichés avec succes");
		request.setAttribute("livres", livres);
		request.getRequestDispatcher("WEB-INF/utilisateur/index.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Livre> livres = iLivreService.findAll();
		Utilisateur utlisateur = (Utilisateur) request.getAttribute("utilisateur");

		request.setAttribute("livres", livres);
		request.setAttribute("utilisateur", utlisateur);
		request.getRequestDispatcher("WEB-INF/utilisateur/index.jsp").forward(request, response);
	}
}