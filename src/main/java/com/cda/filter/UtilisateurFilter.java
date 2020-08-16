package com.cda.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cda.entity.Utilisateur;

@WebFilter(urlPatterns = {"/inscription", "/login"})
public class UtilisateurFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        
        if(utilisateur == null) {
        	chain.doFilter(request, response);
        } else {
        	((HttpServletResponse)response).sendRedirect("index");
        }
	}
}
