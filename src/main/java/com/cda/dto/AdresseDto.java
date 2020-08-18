package com.cda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdresseDto {

	private int idAdresse;
	private int numero;
	private String rue;
	private String ville;
	private String cp;
	private String pays;
	
}
