package com.cda.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cda.service.IArticleCmdService;
import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminSupprimerLivre {

	@Autowired
	ILivreService livreService;

	@Autowired
	IArticleCmdService articleCmdService;

	@GetMapping(value = "/supprimer-livre")
	void getLivre(@RequestParam(value = "id") int id, HttpServletResponse response) throws IOException {
		if (articleCmdService.findByReferenceLivre(id) == null) {
			livreService.deleteById(id);
			log.info("Livre " + id + " supprimé");
			response.sendRedirect("index");
		} else {
			response.setStatus(400);
			response.setContentType("text/plain");
			response.getWriter().write("Imposible de supprimer le  livre");
		}
	}
}