package com.cda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cda.dto.LivreDto;
import com.cda.entity.Livre;
import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ListLivreServlet {

	@Autowired
	private ILivreService iLivreService;

	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	protected ModelAndView listeLivre(HttpServletRequest request) {
		log.info("Affichage des livres");

		ModelAndView model = new ModelAndView();

		List<LivreDto> livres = iLivreService.findAll();

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
		Page<Livre> page = iLivreService.getPage(pageNo, 4);
		request.setAttribute("page", page);

		model.addObject("livres", livres);
		model.setViewName("/utilisateur/index");
		return model;

	}

}