package com.cda.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.dao.ILivreDao;
import com.cda.entity.Livre;
import org.springframework.beans.factory.annotation.Autowired;


@WebServlet(urlPatterns = {"/list.do","/index.html","/index.jsp","/index.do"})
public class ListController extends AbstractController {
    private static final long serialVersionUID = 1L;
    @Autowired
    private ILivreDao livreDao;
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Livre> livre = (List<Livre>) this.livreDao.findAll();
        System.out.println(livre);
    }
}