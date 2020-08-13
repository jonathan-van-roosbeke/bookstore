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

@WebServlet("/editer-livre")
public class AdminEditerUnLivre extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	ILivreService livreService;
	
	@Autowired
	IAuteurService auteurService;
	
	private int id;

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
		Livre livreActuel = livreService.findById(id);
		Auteur auteurActuel = auteurService.findByNomPrenom(livreActuel.getAuteur().getNom(), livreActuel.getAuteur().getPrenom());
		
		// infos livre input
		String titre = request.getParameter("titre");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String synopsis = request.getParameter("synopsis");
		String nombrePage = request.getParameter("nombre-page");
		String quantiteStock = request.getParameter("quantitee-stock");
		String prix = request.getParameter("prix");
		
		// update infos
		Auteur auteurUpdate = auteurActuel.builder()
							  .id(auteurActuel.getId())
							  .nom(nom)
							  .prenom(prenom)
							  .build();
		
		auteurService.save(auteurUpdate);
		
		Livre livreUpdate = livreActuel.builder()
							.id(livreActuel.getId())
							.idAuteur(auteurUpdate.getId())
							.titre(titre)
							.quantiteStock(Integer.parseInt(quantiteStock))
							.nombrePage(Integer.parseInt(nombrePage))
							.synopsis(synopsis)
							.nomImage(livreActuel.getNomImage())
							.prix(new BigDecimal(prix))
							.auteur(auteurUpdate)
							.build();

		livreService.save(livreUpdate);
		
		response.sendRedirect(request.getContextPath() + "/index");
	}

}
