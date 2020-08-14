package com.cda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.dao.IUtilisateurDao;
import com.cda.entity.Utilisateur;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	private IUtilisateurDao utilisateurDao;

	@Override
	public Utilisateur connexion(String login, String motdepasse) {
		Utilisateur utilisateur = utilisateurDao.connexion(login, motdepasse);
		System.out.println(utilisateur);
		return utilisateur;
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurDao.save(utilisateur);
	}

	@Override
	public List<Utilisateur> findCompteEnAttente() {
		return utilisateurDao.findCompteEnAttente();
	}

	@Override
	public Utilisateur findById(String login) {
		Optional<Utilisateur> utilisateurOp = utilisateurDao.findById(login);
		if(utilisateurOp.isPresent()) {
			return utilisateurOp.get();
		}
		return null;
	}
}