package com.cda.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cda.dao.IArticleCmdDao;
import com.cda.dao.ICommandeDao;
import com.cda.dao.ILivreDao;
import com.cda.entity.Article;
import com.cda.entity.ArticleCmd;
import com.cda.entity.Commande;
import com.cda.entity.Livre;
import com.cda.entity.Panier;
import com.cda.entity.Utilisateur;

@Service
public class CommandeServiceImpl implements ICommandeService {

	@Autowired
	ICommandeDao commandeDao;
	@Autowired
	IArticleCmdDao articleCmdDao;
	@Autowired
	ILivreDao livreDao;

	@Override
	public Page<Commande> getPage(int pageNo, int pageSize) {
		PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
		return commandeDao.findAll(pageable);
	}

	@Override
	public String checkout(Panier panier, Utilisateur utilisateur) {
		long millis = System.currentTimeMillis();
		String numeroCmd = millis + "" + utilisateur.getId();

		Commande commande = new Commande();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-yyyy HH:mm:ss");
//		commande.setDate(dtf.format(LocalDateTime.now()));
		commande.setDate(LocalDateTime.now());
		commande.setNumeroCmd(numeroCmd);
		commande.setTotalCmd(panier.getTotalPrix());
		commande.setStatus(0);
		commande.setLogin(utilisateur.getLogin());
//		commande.setUtilisateur(utilisateur);

		List<Article> allArticles = panier.getAll();
		List<ArticleCmd> cmdArticles = new ArrayList<>();

		for (Article article : allArticles) {
			ArticleCmd articleCmd = new ArticleCmd(article.getLivre().getId(), article.getLivre().getTitre(),
					article.getQuantite(), article.getLivre().getPrix().doubleValue(), article.getTotal(), commande,
					commande.getNumeroCmd(), article.getLivre(), article.getLivre().getId());
			cmdArticles.add(articleCmd);
		}

		commandeDao.save(commande);
		articleCmdDao.saveAll(cmdArticles);

		for (Article article : allArticles) {
			Livre tempLivre = livreDao.findById(article.getLivre().getId()).get();
			int qteAchete = article.getQuantite();
			tempLivre.setQuantiteStock(tempLivre.getQuantiteStock() - qteAchete);
			livreDao.save(tempLivre);
		}

		panier.vider();
		return numeroCmd;
	}

	@Override
	public void updateStatus(String numeroCmd, String status) {
		Commande temp = commandeDao.findById(numeroCmd).get();
		int statusFinal = Integer.parseInt(status);
		temp.setStatus(statusFinal);
		commandeDao.save(temp);
		System.out.println(temp);
	}

	@Override
	public List<Commande> mesCmds(String login) {
		return commandeDao.mesCmds(login);
	}

	@Override
	public List<ArticleCmd> detailCmd(String numeroCmd) {
		return commandeDao.detailCmd(numeroCmd);
	}

	@Override
	public List<Commande> getCommandes() {
		return commandeDao.findAll();
	}

	@Override
	public void annuler(String numeroCmd) {
		List<ArticleCmd> list = commandeDao.detailCmd(numeroCmd);
		for (ArticleCmd articleCmd : list) {
			Livre tempLivre = livreDao.findById(articleCmd.getId()).get();
			if (tempLivre != null) {
				int qteAchete = articleCmd.getQuantite();
				tempLivre.setQuantiteStock(tempLivre.getQuantiteStock() + qteAchete);
				livreDao.save(tempLivre);
			}
		}
	}

	@Override
	public Page<Commande> getPage(int pageNo, int pageSize, List list, Utilisateur login) {
		PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);

		int start = (int) pageable.getOffset();
		int end = (start + pageable.getPageSize()) > list.size() ? list.size() : (start + pageable.getPageSize());
		Page<Commande> page = new PageImpl<Commande>(list.subList(start, end), pageable, list.size());

		return page;
	}

}
