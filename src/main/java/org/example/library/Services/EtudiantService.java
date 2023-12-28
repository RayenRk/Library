package org.example.library.Services;

import org.example.library.Entity.Etudiant;
import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiant();
    Etudiant createEtudiant(Etudiant etudiant);
    Etudiant getEtudiantByID(Long id);
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);
}