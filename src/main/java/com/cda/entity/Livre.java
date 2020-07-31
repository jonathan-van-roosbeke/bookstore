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
<<<<<<< HEAD
    private Integer referenceLivre;
=======
    int referenceLivre;
    @Column(name = "id_auteur")
    int idAuteur;
>>>>>>> dev
    @Column(name = "titre_livre")
    private String titreLivre;
    @Column(name = "quantite_stock")
    private int quantiteStock;
    @Column(name = "nombre_page")
    private int nombrePage;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "nom_image")
    private String nomImage;
    @Column(name = "prix_livre")
<<<<<<< HEAD
    private float prixLivre;
=======
    BigDecimal prixLivre;
>>>>>>> dev
}
