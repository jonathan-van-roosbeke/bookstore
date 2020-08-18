package com.cda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

import lombok.extern.slf4j.Slf4j;

@WebServlet("/demande-compte")
public class AdminDemandeCompteServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	IUtilisateurService utilisateurService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Utilisateur> utilisateurs = utilisateurService.findCompteEnAttente();

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

		Page<Utilisateur> page = utilisateurService.getPage(pageNo, 10, utilisateurs);
		request.setAttribute("page", page);
		request.setAttribute("utilisateurs", utilisateurs);
		request.getRequestDispatcher("WEB-INF/admin/demande-compte.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Utilisateur> utilisateurs = utilisateurService.findCompteEnAttente();
		request.setAttribute("utilisateurs", utilisateurs);
		request.getRequestDispatcher("WEB-INF/admin/demande-compte.jsp").forward(request, response);
	}

}
