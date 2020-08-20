package com.cda.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginServlet {

	@Autowired
	IUtilisateurService utilisateurService;

	@GetMapping(value = "/login")
	public ModelAndView initLogin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/utilisateur/login");
		return model;
	}

	@PostMapping(value = "/login")
	public ModelAndView validationAjout(
			@RequestParam(value = "login") String login, 
			@RequestParam(value = "password") String password,
			HttpServletRequest request,
			HttpServletResponse response
			) {
		
		Utilisateur utilisateur = utilisateurService.connexion(login, password);
		ModelAndView model = new ModelAndView();
		if (utilisateur == null) {
			model.addObject("error", true);
			model.setViewName("/utilisateur/login");
			return model;
		} else if (utilisateur.getStatusUtilisateur() == 0){
			model.addObject("en_attente", true);
			model.setViewName("/utilisateur/login");
			return model;
		}else {
			Date date = new Date(Calendar.getInstance().getTime().getTime());
			utilisateur.setDateConnexion(new Date(Calendar.getInstance().getTime().getTime()));
			utilisateur.setTs(new Timestamp(date.getTime()));
			utilisateurService.save(utilisateur);
			Cookie cookie = new Cookie("login", login);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			
			response.addCookie(cookie);
			log.info("Utilisateur : {} est connecté", login);
			request.getSession().setAttribute("utilisateur", utilisateur);
			return new ModelAndView("redirect:/index");
		}
	}
}