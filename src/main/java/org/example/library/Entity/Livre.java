package org.example.library.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "description")
    private String description;

    @Column(name = "categorie")
    private String categorie;

    @JsonIgnore
    @OneToMany(mappedBy = "livre")
    private List<Emprunte> emprunte = new ArrayList<>();
}
