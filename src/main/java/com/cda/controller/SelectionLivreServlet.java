package com.cda.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.dao.ILivreDao;
import com.cda.entity.Livre;
import com.cda.service.ILivreService;

@WebServlet("/SelectionLivreServlet")
public class SelectionLivreServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ILivreService livreService;
	
	@Autowired
	private ILivreDao livreDao;
	
	private String idLivre;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		idLivre = request.getParameter("id");
		boolean exists = false;
		
		if (idLivre.matches("[0-9]+")) {
			exists = livreDao.existsById(Integer.parseInt(idLivre));
		} else {
			System.out.println("error lettre");
		};

		Livre livre;
		if (idLivre != null && exists) {
			livre = livreService.findById(Integer.parseInt(idLivre));
			request.setAttribute("livre", livre);
			request.getRequestDispatcher("/selection-livre.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/ListLivreServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
