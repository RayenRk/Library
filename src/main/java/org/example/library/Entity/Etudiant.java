package org.example.library.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.example.library.Entity.Emprunte;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cin")
    private int cin;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "classe")
    private String classe;

    @JsonIgnore
    @OneToMany(mappedBy = "etudiant")
    private List<Emprunte> emprunte = new ArrayList<>();
}