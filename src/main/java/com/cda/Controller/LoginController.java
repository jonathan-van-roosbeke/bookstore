package com.cda.Controller;

import com.cda.Utils.Constantes;
import com.cda.dto.UtilisateurDto;
import com.cda.service.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = {"/login.do"})
public class LoginController extends AbstractController {
    private static final long serialVersionUID = 1L;

    @Autowired
    private IUtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession vSession = req.getSession();

        if(vSession.getAttribute(Constantes.USER_EN_COURS) != null) {
            //  redirection vers dashboard
            this.getServletContext().getRequestDispatcher("/list.do").forward(req, resp);
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        HttpSession vSession = request.getSession();

        if(vSession.getAttribute(Constantes.USER_EN_COURS) != null) {
            //  redirection vers dashboard
            this.getServletContext().getRequestDispatcher("/list.do").forward(request, response);
        } else if(this.utilisateurService.exists(login,password)) {
            request.setAttribute("infos", "connecté");
            vSession.setAttribute(Constantes.USER_EN_COURS, UtilisateurDto.builder().login(login).dateConnexion(new Date()).build());
            this.getServletContext().getRequestDispatcher("/list.do").forward(request, response);
        } else {
            request.setAttribute("erreurs", "identifiants incorrects");
            this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}