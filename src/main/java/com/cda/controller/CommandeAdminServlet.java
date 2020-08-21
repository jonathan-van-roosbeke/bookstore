package com.cda.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cda.entity.ArticleCmd;
import com.cda.entity.Commande;
import com.cda.entity.Constant;
import com.cda.entity.Utilisateur;
import com.cda.service.ICommandeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommandeAdminServlet {

	@Autowired
	ICommandeService commandeService;

	@GetMapping(value = "/commande-admin")
	protected String commandeAdmin(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "method", required = false) String methodName,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNo,
			@RequestParam(value = "numeroCmd", required = false) String numeroCmd)
			throws ServletException, IOException {
		log.info(methodName);
		if ("afficher".equals(methodName)) {
			return afficher(session, request);
		} else if ("detail".equals(methodName)) {
			return detail(session, numeroCmd);
		} else if ("updateStatus".equals(methodName)) {
			return updateStatus(numeroCmd);
		} else {
			return "/admin/lister-commande";
		}
	}

	/**
	 * lister toutes les commandes
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String afficher(HttpSession session, HttpServletRequest request) {
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
		session.setAttribute("commandes", commandes);
		return "/admin/lister-commande";
	}

	/**
	 * afficher la detail d'une commande
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String detail(HttpSession session, String id) throws ServletException, IOException {
		Utilisateur loginUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String numeroCmd = id;
		List<ArticleCmd> detailCmd = commandeService.detailCmd(numeroCmd);
		session.setAttribute("detailCmd", detailCmd);
		session.setAttribute("numeroCmd", numeroCmd);
		return "/utilisateur/detail";
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
	protected String updateStatus(String numeroCmd) throws ServletException, IOException {
//		String numeroCmd = request.getParameter("numeroCmd");
		commandeService.updateStatus(numeroCmd, Constant.ENVOYE + "");

		return "redirect:/commande-admin?method=afficher";
	}

}