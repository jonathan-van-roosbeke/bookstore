package com.cda.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.cda.entity.ArticleCmd;
import com.cda.entity.Commande;
import com.cda.entity.Constant;
import com.cda.entity.Panier;
import com.cda.entity.Utilisateur;
import com.cda.service.ICommandeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/commande-client")
public class CommandeClientServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	ICommandeService commandeService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		log.info(methodName);
		if (methodName == null) {
			request.getRequestDispatcher("/commande-client?method=afficher").forward(request, response);
		} else if ("checkout".equals(methodName)) {
			checkout(request, response);
		} else if ("afficher".equals(methodName)) {
			afficher(request, response);
		} else if ("detail".equals(methodName)) {
			detail(request, response);
		} else if ("updateStatus".equals(methodName)) {
			updateStatus(request, response);
		} else if ("success".equals(methodName)) {
			success(request, response);
		} else if ("annuler".equals(methodName)) {
			annuler(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * Generer une commande, midifier la qte de stock
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
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

			response.sendRedirect(request.getContextPath() + "/commande-client?method=success");
		} else {
			request.getRequestDispatcher("/login").forward(request, response);
		}
	}

	/**
	 * lister toutes les commandes de ce utilisateur
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void afficher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur loginUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
		List<Commande> mesCommandes = commandeService.mesCmds(loginUtilisateur.getLogin());
		Collections.sort(mesCommandes);

		String pageNoStr = request.getParameter("pageNo");
		if (pageNoStr == null) {
			pageNoStr = "1";
		}
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNoStr);
			if (pageNo < 1) {
				pageNo = 1;
			}
		} catch (Exception e) {
		}

		Page<Commande> page = commandeService.getPage(pageNo, 10, mesCommandes, loginUtilisateur);
		request.setAttribute("commandes", mesCommandes);
		request.setAttribute("page", page);
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

	/**
	 * Client peut modifier le status de commande en livre
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateStatus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numeroCmd = request.getParameter("numeroCmd");
		commandeService.updateStatus(numeroCmd, Constant.LIVRE + "");
		log.info("Update de la commande numero " + numeroCmd);

		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

	/**
	 * Client peut signaler qu'il a recu une commande en livraison(status : 1)
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void success(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/utilisateur/checkout.jsp").forward(request, response);
	}

	/**
	 * Client peut annuler une commande en cours de preparation(status : 0)
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void annuler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numeroCmd = request.getParameter("numeroCmd");
		commandeService.updateStatus(numeroCmd, Constant.ANNULE + "");
		commandeService.annuler(numeroCmd);

		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
