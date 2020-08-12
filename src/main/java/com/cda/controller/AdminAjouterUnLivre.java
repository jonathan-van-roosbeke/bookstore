package com.cda.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.Auteur;
import com.cda.entity.Livre;
import com.cda.service.IAuteurService;
import com.cda.service.ILivreService;

@WebServlet("/ajouter-livre")
public class AdminAjouterUnLivre extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAuteurService auteurService; 
	@Autowired
	ILivreService livreService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/admin/ajouter-livre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String synopsis = request.getParameter("synopsis");
		String nombrePage = request.getParameter("nombre-page");
		String quantiteStock= request.getParameter("quantitee-stock");
		String prix= request.getParameter("prix");
		String image = request.getParameter("image");
		
		Auteur auteur = new Auteur(nom, prenom);
		auteurService.save(auteur);
		
		Livre livre = new Livre(auteur.getId(), titre, Integer.parseInt(quantiteStock), Integer.parseInt(nombrePage), synopsis, "coucou", new BigDecimal(prix));
		livreService.save(livre);
	}

}
