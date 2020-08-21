package com.cda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cda.entity.Livre;
import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Search {

	@Autowired
	private ILivreService livreService;

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	protected ModelAndView listeLivre(HttpServletRequest request) {
		log.info("Chercher un livre");

		ModelAndView model = new ModelAndView();

		List<Livre> livres = livreService.searchByTitre(request.getParameter("titre"));
		log.info(livres.toString());
		log.info(request.getParameter("titre"));

		model.addObject("livres", livres);
		model.setViewName("/utilisateur/search");
		return model;

	}

}
