package com.cda.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cda.entity.ArticleCmd;
import com.cda.entity.Commande;
import com.cda.entity.Constant;
import com.cda.entity.Panier;
import com.cda.entity.Utilisateur;
import com.cda.service.ICommandeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommandeClientServlet {


	@Autowired
	ICommandeService commandeService;

	@GetMapping(value = "/commande-client")
	protected String commandeClient(HttpSession session,
			@RequestParam(value = "method", required = false) String methodName,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNo,
			@RequestParam(value = "numeroCmd", required = false) String numeroCmd)
			throws ServletException, IOException {
		log.info(methodName);
		if ("checkout".equals(methodName)) {
			return checkout(session);
		} else if ("afficher".equals(methodName)) {
			return afficher(session, pageNo);
		} else if ("detail".equals(methodName)) {
			return detail(session, id);
		} else if ("updateStatus".equals(methodName)) {
			return updateStatus(numeroCmd);
		} else if ("annuler".equals(methodName)) {
			return annuler(numeroCmd);
		}
		return "/utilisateur/commande";

	}

	/**
	 * Generer une commande, midifier la qte de stock
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String checkout(HttpSession session) {
		log.info("checkout");
		Utilisateur loginUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
		ModelAndView model = new ModelAndView();

		if (loginUtilisateur != null) {
			Panier panier = (Panier) session.getAttribute("panier");
			if (panier == null) {
				panier = new Panier();
				session.setAttribute("panier", panier);
			}
			String numeroCmd = commandeService.checkout(panier, loginUtilisateur);
			session.setAttribute("numeroCmd", numeroCmd);

			return "/utilisateur/checkout";
		} else {
			return "/utilisateur/login";
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
	protected String afficher(HttpSession session, String pageNo) {
		Utilisateur loginUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
		List<Commande> mesCommandes = commandeService.mesCmds(loginUtilisateur.getLogin());
		Collections.sort(mesCommandes);

		log.info("afficher les commandes d'une client");
		log.info(mesCommandes.toString());

		session.setAttribute("commandes", mesCommandes);
		return "/utilisateur/commande";

//		Page<Commande> page = commandeService.getPage(Integer.parseInt(pageNo), 10, mesCommandes, loginUtilisateur);
//		session.setAttribute("page", page);
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
	 * Client peut modifier le status de commande en livre Client peut signaler
	 * qu'il a recu une commande en livraison(status : 1)
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String updateStatus(String numeroCmd) {
		commandeService.updateStatus(numeroCmd, Constant.LIVRE + "");
		log.info("Update de la commande numero " + numeroCmd);

		return "redirect:/commande-client?method=afficher";
	}

	/**
	 * Client peut annuler une commande en cours de preparation(status : 0)
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String annuler(String numeroCmd) {
		commandeService.updateStatus(numeroCmd, Constant.ANNULE + "");
		commandeService.annuler(numeroCmd);

		return "redirect:/commande-client?method=afficher";
	}

}
