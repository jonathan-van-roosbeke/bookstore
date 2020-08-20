package com.cda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeconnexionServlet {

	@GetMapping(value = "/deconnexion")
	public String deconnexion(HttpSession session) {
		session.invalidate();
		return "/utilisateur/index";
	}
}
