package com.cda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cda.entity.Livre;
import com.cda.entity.Panier;
import com.cda.service.ILivreService;

@Controller
public class PanierServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ILivreService livreService;

	@GetMapping(value = "/panier")
	String getPanier(HttpSession session, @RequestParam(value = "method", required = false) String methodName,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "qte", defaultValue = "1", required = false) String qte) {

		if ("ajouter".equals(methodName)) {
			return ajouter(session, id);
		} else if ("supprimer".equals(methodName)) {
			return supprimer(session, id);
		} else if ("modifier".equals(methodName)) {
			return modifier(session, id, qte);
		}
		return "utilisateur/panier";
	}

	private String ajouter(HttpSession session, String id) {
		Panier panier = (Panier) session.getAttribute("panier");
		if (panier == null) {
			panier = new Panier();
			session.setAttribute("panier", panier);
		}
		Livre livre = livreService.findById(Integer.parseInt(id));
		panier.ajouterLivre(livre);

		return "utilisateur/index";
	}

	protected String supprimer(HttpSession session, String id) {
		Panier panier = (Panier) session.getAttribute("panier");
		panier.supprimerLivre(Integer.parseInt(id));
		return "utilisateur/panier";
	}

	private String modifier(HttpSession session, String id, String qte) {
		Panier panier = (Panier) session.getAttribute("panier");
		panier.updateQuantite(Integer.parseInt(id), qte);
		return "utilisateur/panier";
	}
}