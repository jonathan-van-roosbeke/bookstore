package com.cda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.cda.dto.LivreDto;
import com.cda.entity.Livre;
import com.cda.entity.Utilisateur;
import com.cda.service.ILivreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/index")
public class ListLivreServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ILivreService iLivreService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		request.setAttribute("livres", livres);
		log.info("Affichage des livres");
		request.getRequestDispatcher("WEB-INF/utilisateur/index.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<LivreDto> livres = iLivreService.findAll();
		Utilisateur utlisateur = (Utilisateur) request.getAttribute("utilisateur");

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

		request.setAttribute("livres", livres);
		request.setAttribute("utilisateur", utlisateur);
		request.getRequestDispatcher("WEB-INF/utilisateur/index.jsp").forward(request, response);
	}
}