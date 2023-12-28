package org.example.library.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
@Entity
public class Emprunte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_debut")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_debut;

    @Column(name = "date_retour")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_retour;


    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "livre_id")
    private Livre livre;
}