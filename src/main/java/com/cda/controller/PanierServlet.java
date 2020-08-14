package com.cda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.entity.Livre;
import com.cda.entity.Panier;
import com.cda.service.ILivreService;

@WebServlet("/panier")
public class PanierServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ILivreService livreService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		System.out.println(methodName);
		if (methodName == null) {
			request.getRequestDispatcher("/WEB-INF/utilisateur/panier.jsp").forward(request, response);
		} else if ("ajouter".equals(methodName)) {
			ajouter(request, response);
		} else if ("supprimer".equals(methodName)) {
			supprimer(request, response);
		} else if ("modifier".equals(methodName)) {
			modifier(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void ajouter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		if (panier == null) {
			panier = new Panier();
			session.setAttribute("panier", panier);

		}
		System.out.println(request.getParameter("id"));
		Livre livre = livreService.findById(Integer.parseInt(request.getParameter("id")));
		panier.ajouterLivre(livre);

//		response.sendRedirect(request.getContextPath() + "/index");
		request.getRequestDispatcher("/index").forward(request, response);
	}

	protected void supprimer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");

		System.out.println(request.getParameter("id"));
		panier.supprimerLivre(Integer.parseInt(request.getParameter("id")));

//		response.sendRedirect(request.getContextPath() + "/WEB-INF/utilisateur/panier.jsp");
		request.getRequestDispatcher("/WEB-INF/utilisateur/panier.jsp").forward(request, response);
	}

	private void modifier(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");

		panier.updateQuantite(Integer.parseInt(request.getParameter("id")), request.getParameter("qte"));

//		response.sendRedirect(request.getContextPath() + "/WEB-INF/utilisateur/panier.jsp");
		request.getRequestDispatcher("/WEB-INF/utilisateur/panier.jsp").forward(request, response);
	}
}
