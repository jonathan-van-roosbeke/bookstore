package com.cda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.dao.ICommandeDao;
import com.cda.entity.Panier;
import com.cda.entity.Utilisateur;
import com.cda.service.ICommandeService;

@WebServlet("/commande-client")
public class CommandeClientServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	ICommandeService commandeService;
	@Autowired
	ICommandeDao commandeDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		System.out.println(methodName);
		if (methodName == null) {
			request.getRequestDispatcher("/WEB-INF/utilisateur/commande.jsp").forward(request, response);
		} else if ("checkout".equals(methodName)) {
			checkout(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void checkout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur loginUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
		if (loginUtilisateur != null) {
			Panier panier = (Panier) session.getAttribute("panier");
			if (panier == null) {
				panier = new Panier();
				session.setAttribute("panier", panier);
			}
			String numeroCmd = commandeService.checkout(panier, loginUtilisateur);
			System.out.println(numeroCmd);
			session.setAttribute("numeroCmd", numeroCmd);

			response.sendRedirect(request.getContextPath() + "/WEB-INF/utilisateur/checkout.jsp");
//			request.getRequestDispatcher("/WEB-INF/utilisateur/checkout.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/utilisateur/login.jsp").forward(request, response);
		}
	}

}
