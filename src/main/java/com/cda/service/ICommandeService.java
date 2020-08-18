package com.cda.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cda.entity.ArticleCmd;
import com.cda.entity.Commande;
import com.cda.entity.Panier;
import com.cda.entity.Utilisateur;

public interface ICommandeService {

	String checkout(Panier panier, Utilisateur utilisateur);

	List<Commande> mesCmds(String login);

	List<ArticleCmd> detailCmd(String numeroCmd);

	List<Commande> getCommandes();

	void updateStatus(String numeroCmd, String status);

	void annuler(String numeroCmd);

	Page<Commande> getPage(int pageNo, int pageSize);

	Page<Commande> getPage(int pageNo, int pageSize, List list, Utilisateur login);

}
