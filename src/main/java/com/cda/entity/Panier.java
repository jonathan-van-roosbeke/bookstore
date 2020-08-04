package com.cda.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Panier {
	private Map<Integer, Article> map = new HashMap<>();
//	private int totalQuantite;
//	private double totalPrix;

	public List<Article> getAll() {
		Collection<Article> values = map.values();
		return new ArrayList<>(values);
	}

	public int getTotalQuantite() {
		List<Article> list = getAll();
		int count = 0;
		for (Article article : list) {
			count += article.getQuantite();
		}
		return count;
	}

	public double getTotalPrix() {
		List<Article> list = getAll();
		BigDecimal count = new BigDecimal(0);
		for (Article article : list) {
			count = count.add(new BigDecimal(article.getTotal()));
		}
		return count.doubleValue();
	}

	public void ajouterLivre(Livre livre) {

		Article article = map.get(livre.getId());
		if (article == null) {
			Article articleAjoute = new Article();
			articleAjoute.setLivre(livre);
			articleAjoute.setQuantite(1);

			map.put(livre.getId(), articleAjoute);
		} else {
			article.setQuantite(article.getQuantite() + 1);
		}
	}

	public void supprimerLivre(int reference) {
		map.remove(reference);
	}

	public void updateQuantite(int reference, String quantite) {
		int q = 1;
		try {
			q = Integer.parseInt(quantite);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			Article article = map.get(reference);
			article.setQuantite(q);
		}
	}

	public void vider() {
		map.clear();
	}
}
