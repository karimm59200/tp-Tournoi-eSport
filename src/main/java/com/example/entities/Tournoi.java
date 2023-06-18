package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tournoi {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;

        private String nom;

        private String jeu;


        private LocalDateTime dateEtHeure;
      //Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
      @OneToMany(mappedBy = "tournoi")
      private List<Equipe> equipesList;

    public Tournoi(String nom, String jeu, String date, String equipeList) {
        this.nom = nom;
        this.jeu = jeu;
        this.dateEtHeure = LocalDateTime.parse(LocalDateTime.now().toString());
        this.equipesList = equipesList;
    }
}
