package com.cda.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.dao.IArticleCmdDao;
import com.cda.dao.ICommandeDao;
import com.cda.dao.ILivreDao;
import com.cda.entity.Article;
import com.cda.entity.ArticleCmd;
import com.cda.entity.Commande;
import com.cda.entity.Panier;
import com.cda.entity.Utilisateur;

public class CommandeServiceImpl implements ICommandeService {

	@Autowired
	ICommandeDao commandeDao;
	IArticleCmdDao articlCmdDao;
	ILivreDao livreDao;

	@Override
	public String checkout(Panier panier, Utilisateur utilisateur) {
		long millis = System.currentTimeMillis();
		String numeroCmd = millis + "" + utilisateur.getId();

		Commande commande = new Commande();
		commande.setDate(LocalDateTime.now());
		commande.setNumeroCmd(numeroCmd);
		commande.setTotalCmd(panier.getTotalPrix());
		commande.setStatus(0);
		commande.setUtilisateur(utilisateur);

		List<Article> allArticles = panier.getAll();
		List<ArticleCmd> cmdArticles = new ArrayList<>();

		for (Article article : allArticles) {
			ArticleCmd articleCmd = new ArticleCmd(article.getLivre().getId(), article.getLivre().getTitre(),
					article.getQuantite(), article.getLivre().getPrix().doubleValue(), article.getTotal(), commande);
			cmdArticles.add(articleCmd);
		}

		commandeDao.save(commande);
		articlCmdDao.saveAll(cmdArticles);

		for (ArticleCmd articleCmd : cmdArticles) {
			livreDao.findById(articleCmd.getId());
		}

		return numeroCmd;
	}

	@Override
	public void updateStatus(String numeroCmd, String status) {
		int numero = Integer.parseInt(numeroCmd);
		Commande temp = commandeDao.findById(numero).get();
		int statusFinal = Integer.parseInt(status);
		temp.setStatus(statusFinal);
		commandeDao.save(temp);
	}

	@Override
	public List<Commande> getCommandes() {
		return (List<Commande>) commandeDao.findAll();
	}

	@Override
	public List<Commande> mesCommandes(Iterable<Integer> uid) {
		return (List<Commande>) commandeDao.findAllById(uid);
	}

}
