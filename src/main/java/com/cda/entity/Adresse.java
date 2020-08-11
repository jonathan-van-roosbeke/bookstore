package com.cda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_adresse")
public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adresse")
	private int idAdresse;

	@Column(name = "numero")
	private int numero;

	@Column(name = "rue")
	private String rue;

	@Column(name = "ville")
	private String ville;

	@Column(name = "cp")
	private String cp;

	@Column(name = "pays")
	private String pays;
}
