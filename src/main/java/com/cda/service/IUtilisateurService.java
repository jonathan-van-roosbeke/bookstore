package com.cda.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cda.entity.Utilisateur;

@Service
public interface IUtilisateurService {

	public Utilisateur connexion(String login, String motdepasse);

	public Utilisateur save(Utilisateur utilisateur);

	public Utilisateur findById(String login);

	public List<Utilisateur> findCompteEnAttente();

	public List<Utilisateur> findAll();

	public void deleteById(String id);

	Page<Utilisateur> getPage(int pageNo, int pageSize);

	Page<Utilisateur> getPage(int pageNo, int pageSize, List list);
}
