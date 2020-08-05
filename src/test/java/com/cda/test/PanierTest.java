package com.cda.test;

import java.math.BigDecimal;

import org.junit.Test;

import com.cda.entity.Auteur;
import com.cda.entity.Livre;
import com.cda.entity.Panier;

public class PanierTest {

	Livre livre1 = new Livre(1, 1, "Test Book", 10, 500, "c'est un livre de test", "abc", new BigDecimal(20.23),
			new Auteur());
	Livre livre2 = new Livre(2, 1, "Test Book", 10, 500, "c'est un livre de test", "abc", new BigDecimal(51.75),
			new Auteur());
	Livre livre3 = new Livre(3, 1, "Test Book", 10, 500, "c'est un livre de test", "abc", new BigDecimal(63.28),
			new Auteur());

	@Test
	public void testPanier() {
		Panier panier = new Panier();
		panier.ajouterLivre(livre1);
		panier.ajouterLivre(livre1);
		panier.ajouterLivre(livre2);
		panier.ajouterLivre(livre3);
		System.out.println("Qte : " + panier.getTotalQuantite());
		System.out.println("Prix total de livre : " + panier.getTotalPrix());
		System.out.println("Les articles : " + panier.getAll());

		System.out.println("\n\nSupprime un livre...");
		panier.supprimerLivre(1);
		System.out.println("Qte : " + panier.getTotalQuantite());
		System.out.println("Prix total de livre : " + panier.getTotalPrix());
		System.out.println("Les articles : " + panier.getAll());

		System.out.println("\n\nUpdate un livre...");
		panier.updateQuantite(2, String.valueOf(5));
		System.out.println("Qte : " + panier.getTotalQuantite());
		System.out.println("Prix total de livre : " + panier.getTotalPrix());
		System.out.println("Les articles : " + panier.getAll());
	}

}
