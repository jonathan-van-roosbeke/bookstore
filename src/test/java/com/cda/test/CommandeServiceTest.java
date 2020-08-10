package com.cda.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cda.dao.IArticleCmdDao;
import com.cda.dao.ICommandeDao;
import com.cda.dao.ILivreDao;
import com.cda.entity.Livre;
import com.cda.service.ILivreService;

public class CommandeServiceTest {

	@Autowired
	ICommandeDao commandeDao;
	@Autowired
	IArticleCmdDao articleCmdDao;
	@Autowired
	ILivreDao livreDao;
	@Autowired
	ILivreService livreService;

	@Test
	public void test() {
//		System.out.println(livreDao.count());
		List<Livre> list = livreService.findAll();
		System.out.println(list);
	}

//	@Test
//	public void checkoutTest() {
////		Livre livre1 = livreService.findById(1);
////		Livre livre2 = livreService.findById(2);
//		Livre livre3 = new Livre(100, 1, "test", 10, 200, "testestest", "", new BigDecimal(20.1), new Auteur());
//		Panier panier = new Panier();
//
//		livreDao.save(livre3);
//		panier.ajouterLivre(livre3);
////		panier.ajouterLivre(livre2);
//		System.out.println(panier);
//
//		Adresse adresse = new Adresse(3, 100, "rue de paris", "Lille", "59000", "France");
//		Utilisateur utilisateur = new Utilisateur(100, "abc", "cba", "a", "b", "abc@afpa.fr", 1, adresse);
//
////		String numeroCmd = commandeService.checkout(panier, utilisateur);
////		System.out.println(numeroCmd);
//
//		long millis = System.currentTimeMillis();
//		String numeroCmd = millis + "" + utilisateur.getId();
//
//		Commande commande = new Commande();
//		commande.setDate(LocalDateTime.now());
//		commande.setNumeroCmd(numeroCmd);
//		commande.setTotalCmd(panier.getTotalPrix());
//		commande.setStatus(0);
//		commande.setUtilisateur(utilisateur);
//
//		List<Article> allArticles = panier.getAll();
//		List<ArticleCmd> cmdArticles = new ArrayList<>();
//
//		for (Article article : allArticles) {
//			ArticleCmd articleCmd = new ArticleCmd(article.getLivre().getId(), article.getLivre().getTitre(),
//					article.getQuantite(), article.getLivre().getPrix().doubleValue(), article.getTotal(), commande);
//			cmdArticles.add(articleCmd);
//			System.out.println(articleCmd);
////			articleCmdDao.save(articleCmd);
//		}
//
//		commandeDao.save(commande);
//		articleCmdDao.saveAll(cmdArticles);
//
//		for (Article article : allArticles) {
//			Livre tempLivre = livreDao.findById(article.getLivre().getId()).get();
//			int qteAchete = article.getQuantite();
//			tempLivre.setQuantiteStock(tempLivre.getQuantiteStock() - qteAchete);
//			livreDao.save(tempLivre);
//		}
//
//	}
}
