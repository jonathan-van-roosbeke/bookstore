package com.cda.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDto {

	private String login;
	private String motdepasse;
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private int statusUtilisateur;
	private int idAdresse;
	private Date dateDemande;
	private Date dateConnexion;
	private Timestamp ts;
}
