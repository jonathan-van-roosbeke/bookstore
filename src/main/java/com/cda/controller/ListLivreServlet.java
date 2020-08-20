package com.cda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cda.dto.LivreDto;
import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ListLivreServlet {

	@Autowired
	private ILivreService iLivreService;

	@RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
	protected ModelAndView listeLivre() {
		log.info("Affichage des livres");
		
		ModelAndView model = new ModelAndView();
			
		List<LivreDto> livres = iLivreService.findAll();
		//Page<Livre> page = iLivreService.getPage(pageEnCours, 4);
		
		model.addObject("livres", livres);
		//model.addObject("page", 4);
		//model.addObject("count", this.iLivreService.count());
		//model.addObject("pageEnCours", pageEnCours);
		
		model.setViewName("/utilisateur/index");
		return model;

	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		List<LivreDto> livres = iLivreService.findAll();
//		Utilisateur utlisateur = (Utilisateur) request.getAttribute("utilisateur");
//
//		String pageNoStr = request.getParameter("pageNo");
//		if (pageNoStr == null) {
//			pageNoStr = "1";
//		}
//		int pageNo = 1;
//		try {
//			pageNo = Integer.parseInt(pageNoStr);
//			if (pageNo < 1) {
//				pageNo = 1;
//			}
//		} catch (Exception e) {
//		}
//		Page<Livre> page = iLivreService.getPage(pageNo, 4);
//		request.setAttribute("page", page);
//
//		request.setAttribute("livres", livres);
//		request.setAttribute("utilisateur", utlisateur);
//		request.getRequestDispatcher("WEB-INF/utilisateur/index.jsp").forward(request, response);
//	}
}