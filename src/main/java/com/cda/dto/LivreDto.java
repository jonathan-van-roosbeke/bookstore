package com.cda.dto;

import java.math.BigDecimal;

import com.cda.entity.Auteur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivreDto {

	int id;
	int idAuteur;
	String titre;
	int quantiteStock;
	int nombrePage;
	String synopsis;
	String nomImage;
	BigDecimal prix;
	Auteur auteur;
}
