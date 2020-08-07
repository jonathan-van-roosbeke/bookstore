package com.cda.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adresse")
	private int idAdresse;

	@Column(name = "rue")
	private String rue;

	@Column(name = "ville")
	private String ville;

	@Column(name = "cp")
	private String cp;

	@Column(name = "pays")
	private String pays;
}
