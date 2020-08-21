package com.cda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cda.entity.Utilisateur;
import com.cda.service.IUtilisateurService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class AdminTousLesComptesServlet  {
	

	@Autowired
	IUtilisateurService utilisateurService;

	@RequestMapping(value = { "/tous-comptes"} , method = {RequestMethod.GET})
	protected ModelAndView listerTousLesComptes(@RequestParam(value = "pageNo", defaultValue = "1") String pageNoStr) {
		ModelAndView model = new ModelAndView();
		List<Utilisateur> utilisateurs = utilisateurService.findAll();
		
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
		Page<Utilisateur> page = utilisateurService.getPage(pageNo, 10);
		model.addObject("page", page);
		model.addObject("utilisateurs", utilisateurs);
		model.setViewName("/admin/tous-les-comptes");
		
		
		return model;

	
	}
}
