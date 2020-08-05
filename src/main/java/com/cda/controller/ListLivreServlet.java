package com.cda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.dao.ILivreDao;
import com.cda.entity.Livre;
import com.cda.service.ILivreService;

@WebServlet("/ListLivreServlet")
public class ListLivreServlet extends com.cda.controller.AbstractController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ILivreService iLivreService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Livre> livres = iLivreService.findAll();
		for (Livre livre : livres) {
			System.out.println(livre);
		}
		request.setAttribute("livres", livres);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}