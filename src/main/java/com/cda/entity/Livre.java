package com.cda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_livre")
    private Integer referenceLivre;
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
    private float prixLivre;
}
