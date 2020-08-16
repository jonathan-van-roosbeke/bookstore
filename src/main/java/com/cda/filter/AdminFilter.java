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

@WebFilter(urlPatterns = { "/ajouter-livre", "/demande-compte", "/editer-livre", "/supprimer-compte",
		"/supprimer-livre", "/valider-compte", "/tous-comptes" })
public class AdminFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        
        if(utilisateur == null) {
        	((HttpServletResponse)response).sendRedirect("index");        	
        } else if (utilisateur.getStatusUtilisateur() == 1) {
        	((HttpServletResponse)response).sendRedirect("index");        	
        } else if (utilisateur.getStatusUtilisateur() == 2) {
        	chain.doFilter(request, response);
        }
	}
}