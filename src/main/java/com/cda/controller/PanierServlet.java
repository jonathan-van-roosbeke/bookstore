package com.cda.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.dao.ILivreDao;
import com.cda.entity.Livre;
import com.cda.entity.Panier;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet("/PanierServlet")
public class PanierServlet extends com.cda.controller.AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ILivreDao iLivreDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PanierServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		System.out.println(methodName);
		if ("ajouter".equals(methodName)) {
			ajouter(request, response);
		} else if ("supprimer".equals(methodName)) {
			supprimer(request, response);
		} else if ("modifier".contentEquals(methodName)) {
			modifier(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		Optional<Livre> optionalLivre = iLivreDao.findById(Integer.parseInt(request.getParameter("id")));
		Livre livre = new Livre();
		if (optionalLivre.isPresent()) {
			livre = optionalLivre.get();
			panier.ajouterLivre(livre);
		}

		response.sendRedirect(request.getContextPath() + "/ListLivreServlet");
	}

	protected void supprimer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");

		System.out.println(request.getParameter("id"));
		panier.supprimerLivre(Integer.parseInt(request.getParameter("id")));

		response.sendRedirect(request.getContextPath() + "/pages/panier.jsp");
	}

	private void modifier(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");

		panier.updateQuantite(Integer.parseInt(request.getParameter("id")), request.getParameter("qte"));
		response.sendRedirect(request.getContextPath() + "/pages/panier.jsp");
	}
}
