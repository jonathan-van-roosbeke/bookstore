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
			request.getRequestDispatcher("/WEB-INF/admin/lister-commande.jsp").forward(request, response);
		} else if ("afficher".equals(methodName)) {
			afficher(request, response);
		} else if ("detail".equals(methodName)) {
			detail(request, response);
		} else if ("updateStatus".equals(methodName)) {
			updateStatus(request, response);
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
	protected void afficher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur loginUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
		List<Commande> commandes = commandeService.getCommandes();
		Collections.sort(commandes);

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
		Page<Commande> page = commandeService.getPage(pageNo, 10);
		request.setAttribute("page", page);
		request.setAttribute("commandes", commandes);
		request.getRequestDispatcher("/WEB-INF/admin/lister-commande.jsp").forward(request, response);
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
		request.getRequestDispatcher("/WEB-INF/admin/detail.jsp").forward(request, response);
	}

	/**
	 * Admin change le status de commande de 'en cour de preparation(0)' a 'en cours
	 * de livraison(1)'
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateStatus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numeroCmd = request.getParameter("numeroCmd");
		commandeService.updateStatus(numeroCmd, Constant.ENVOYE + "");

		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

}