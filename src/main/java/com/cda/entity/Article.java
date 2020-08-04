package com.cda.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	private Livre livre;
	private int quantite;
	private BigDecimal total;

	public double getTotal() {
		BigDecimal total = getLivre().getPrix().multiply(new BigDecimal(getQuantite()));
		return total.doubleValue();
	}
}
