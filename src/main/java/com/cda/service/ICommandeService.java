package com.cda.service;

import java.util.List;

import com.cda.entity.Commande;
import com.cda.entity.Panier;
import com.cda.entity.Utilisateur;

public interface ICommandeService {

	String checkout(Panier panier, Utilisateur utilisateur);

	void updateStatus(String numeroCmd, String status);

	List<Commande> getCommandes();

	List<Commande> mesCommandes(Iterable<String> login);

	List<Commande> mesCmds(String login);

}
