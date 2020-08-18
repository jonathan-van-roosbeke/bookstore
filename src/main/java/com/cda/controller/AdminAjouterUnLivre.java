package com.cda.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.Auteur;
import com.cda.entity.Livre;
import com.cda.service.IAuteurService;
import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/ajouter-livre")
@MultipartConfig
public class AdminAjouterUnLivre extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	IAuteurService auteurService;
	@Autowired
	ILivreService livreService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/admin/ajouter-livre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// infos livre
		String titre = request.getParameter("titre");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String synopsis = request.getParameter("synopsis");
		String nombrePage = request.getParameter("nombre-page");
		String quantiteStock = request.getParameter("quantitee-stock");
		String prix = request.getParameter("prix");
		
		

		// image
		// String description = request.getParameter("description"); // Retrieves <input
		// type="text" name="description">
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		
		InputStream fileContent = filePart.getInputStream();
		byte[] buffer = new byte[fileContent.available()];
		fileContent.read(buffer);

		File targetFile = new File("/home/jonathan/Documents/java-projects/bookstore/src/main/webapp/resources/images/img-couverture-livre/" + fileName);
		OutputStream outStream = new FileOutputStream(targetFile);
		outStream.write(buffer);

		Auteur auteur = new Auteur(nom, prenom);
		auteurService.save(auteur);

		
		Livre livre = new Livre(auteur.getId(), titre, Integer.parseInt(quantiteStock), Integer.parseInt(nombrePage),
				synopsis, fileName, new BigDecimal(prix), auteur);
		livreService.save(livre);
		
		log.info("Livre : " + livre + " ajouté");
		
		response.sendRedirect(request.getContextPath() + "/index");

	}
}
