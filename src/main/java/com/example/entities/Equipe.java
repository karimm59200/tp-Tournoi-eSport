package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;


    @OneToMany(mappedBy = "equipe")
    private List<Joueurs> joueursList;


    @ManyToOne
    @JoinColumn(name="tournoi_id")
    private Tournoi tournoi;

}

