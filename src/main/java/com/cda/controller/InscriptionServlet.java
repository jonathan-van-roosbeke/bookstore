package com.cda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/inscription"})
public class InscriptionServlet extends AbstractController {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("WEB-INF/utilisateur/inscription.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {
    }
}