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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/editer-livre")
public class AdminEditerUnLivre extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	ILivreService livreService;
	
	@Autowired
	IAuteurService auteurService;
	
	private int id;
	private Auteur auteur;
	private Livre livre;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		id = Integer.parseInt(idParam);
		Livre livre = livreService.findById(id);

		request.setAttribute("livre", livre);
		request.getRequestDispatcher("WEB-INF/admin/editer-livre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// livre actuel
		livre = livreService.findById(id);
		Auteur auteurActuel = auteurService.findByNomPrenom(livre.getAuteur().getNom(), livre.getAuteur().getPrenom());
		
		// infos livre input
		String titre = request.getParameter("titre");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String synopsis = request.getParameter("synopsis");
		String nombrePage = request.getParameter("nombre-page");
		String quantiteStock = request.getParameter("quantitee-stock");
		String prix = request.getParameter("prix");
		
		// update infos auteur
		if (auteurActuel.getNom().equalsIgnoreCase(nom) &&
			auteurActuel.getPrenom().equalsIgnoreCase(prenom)) {
			auteur = auteurActuel;
		} else {
			auteur = auteurActuel.builder()
					  .nom(nom)
					  .prenom(prenom)
					  .build();
			
			auteurService.save(auteur);
		}
		
		// update infos livre
		Livre livreUpdate = livre.builder()
							.id(livre.getId())
							.idAuteur(auteur.getId())
							.titre(titre)
							.quantiteStock(Integer.parseInt(quantiteStock))
							.nombrePage(Integer.parseInt(nombrePage))
							.synopsis(synopsis)
							.nomImage(livre.getNomImage())
							.prix(new BigDecimal(prix))
							.auteur(auteur)
							.build();

		log.info("Vous avez édité le livre : " + livre + " en " + livreUpdate);
		livreService.save(livreUpdate);
		
		response.sendRedirect(request.getContextPath() + "/index");
	}

}
