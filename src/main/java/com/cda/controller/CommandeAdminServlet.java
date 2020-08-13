package com.cda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.ArticleCmd;
import com.cda.entity.Commande;
import com.cda.entity.Utilisateur;
import com.cda.service.ICommandeService;

@WebServlet("/commande-admin")
public class CommandeAdminServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	ICommandeService commandeService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		System.out.println(methodName);
		if (methodName == null) {
			request.getRequestDispatcher("/WEB-INF/utilisateur/commande.jsp").forward(request, response);
		} else if ("afficherAll".contentEquals(methodName)) {
			afficherAll(request, response);
		} else if ("detail".contentEquals(methodName)) {
			detail(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * lister toutes les commandes
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void afficherAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur loginUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
		List<Commande> mesCommandes = commandeService.mesCmds(loginUtilisateur.getLogin());
		request.setAttribute("commandes", mesCommandes);
		request.getRequestDispatcher("/WEB-INF/utilisateur/commande.jsp").forward(request, response);
	}

	/**
	 * afficher la detail d'une commande
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur loginUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String numeroCmd = request.getParameter("id");
		List<ArticleCmd> detailCmd = commandeService.detailCmd(numeroCmd);
		request.setAttribute("detailCmd", detailCmd);
		request.setAttribute("numeroCmd", numeroCmd);
		request.getRequestDispatcher("/WEB-INF/utilisateur/detail.jsp").forward(request, response);
	}

}