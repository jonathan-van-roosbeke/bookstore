package com.cda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "t_utilisateur")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

	@Id
	@Column(name = "login")
	private String login;

	@Column(name = "uid")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "motdepasse")
	private String motdepasse;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "email")
	private String email;

	@Column(name = "status_utilisateur")
	private int statusUtilisateur;

	@ManyToOne
	@JoinColumn(name = "id_adresse", nullable = false, insertable = false, updatable = false)
	private Adresse adresse;
}
