package com.cda.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_cmd")
	private String numero;

	@Column(name = "date_creation")
	private LocalDateTime date;

	@Column(name = "status_cmd")
	private int status;

	@Column(name = "total_cmd")
	private double totalCmd;

	@ManyToOne
	@JoinColumn(name = "login_utilisateur", nullable = false, insertable = false, updatable = false)
	private Utilisateur u;
}
