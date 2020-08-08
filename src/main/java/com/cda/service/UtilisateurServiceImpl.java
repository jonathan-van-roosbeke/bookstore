package com.cda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.dao.IUtilisateurDao;
import com.cda.entity.Utilisateur;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	private IUtilisateurDao utilisateurDao;


	@Override
	public Utilisateur connexion(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}