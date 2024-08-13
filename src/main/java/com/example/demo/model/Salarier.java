package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SALARIER")
public class Salarier {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  long id;

    private String Nom;
    @Column(length=255)

    private String Prenom;
    @Column(length = 255)

    private String Sexe;
    @Column(length = 13)

    private int Age;
    //pour specifier l'heure et les minutes je peut ecrire
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    //private LocalTime heureArrive;

    @DateTimeFormat(pattern = "HH:mm")
    @JsonProperty("heure_arrive")
    private LocalTime heureArrive;

    @JsonProperty("heure_depart")
    private  LocalTime heureDepart;

    @JsonProperty("EmailAddress")
    private String EmailAddress;

    @Column(length = 13)
    private double Salaire;


}
