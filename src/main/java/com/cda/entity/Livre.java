package com.cda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_livre")
    int referenceLivre;
    @Column(name = "id_auteur")
    int idAuteur;
    @Column(name = "titre_livre")
    String titreLivre;
    @Column(name = "quantite_stock")
    int quantiteStock;
    @Column(name = "nombre_page")
    int nombrePage;
    @Column(name = "synopsis")
    String synopsis;
    @Column(name = "nom_image")
    String nomImage;
    @Column(name = "prix_livre")
    BigDecimal prixLivre;
}
