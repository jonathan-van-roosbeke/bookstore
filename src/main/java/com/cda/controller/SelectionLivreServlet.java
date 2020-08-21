package com.cda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cda.dao.ILivreDao;
import com.cda.entity.Livre;
import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SelectionLivreServlet {

	@Autowired
	private ILivreService livreService;

	@Autowired
	private ILivreDao livreDao;

	private String idLivre;

	@GetMapping(value = "/select")
	protected ModelAndView selectLivre(@RequestParam(value = "id") String id) {

		idLivre = id;
		boolean exists = false;

		if (idLivre.matches("[0-9]+")) {
			exists = livreDao.existsById(Integer.parseInt(idLivre));
		} else {
			log.info("une lettre est rentré dans l'id");
		}

		Livre livre;
		if (idLivre != null && exists) {
			livre = livreService.findById(Integer.parseInt(idLivre));
			ModelAndView model = new ModelAndView();
			model.addObject("livre", livre);
			model.setViewName("/utilisateur/selection-livre");
			return model;
		} else {
			return new ModelAndView("redirect:/index");
		}
	}
}
