package com.cda.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.Adresse;
import com.cda.entity.Utilisateur;
import com.cda.service.IAdresseService;
import com.cda.service.IUtilisateurService;

@WebServlet(urlPatterns = {"/inscription"})
public class InscriptionServlet extends AbstractController {
    private static final long serialVersionUID = 1L;
    
    @Autowired
    IAdresseService adresseService;
    
    @Autowired
    IUtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("WEB-INF/utilisateur/inscription.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {
    	String nom = request.getParameter("nom");
    	String prenom = request.getParameter("prenom");
    	String email = request.getParameter("email");
    	String login = request.getParameter("login");
    	String password = request.getParameter("password");
    	
    	String numero = request.getParameter("numero");
    	String rue = request.getParameter("rue");
    	String ville = request.getParameter("ville");
    	String cp = request.getParameter("cp");
    	String pays = request.getParameter("pays");
    	
    	Adresse adresse = new Adresse(Integer.parseInt(numero), rue, ville, cp, pays);
    	Adresse adresseInscription = adresseService.save(adresse);
    	
    	Utilisateur utilisateur = new Utilisateur(login, DigestUtils.md5Hex(password), nom, prenom, email, 0, adresseInscription.getIdAdresse(), new Date());
    	utilisateurService.save(utilisateur);
    	
    	response.sendRedirect(request.getContextPath() + "/index");
    	
    }
}