package org.example.library.Services;

import org.example.library.Entity.Livre;
import java.util.List;

public interface LivreService {
    List<Livre> getAllLivre();
    Livre createLivre(Livre livre);
    Livre getLivreByID(Long id);
    Livre updateLivre(Livre livre);
    void deleteLivre(Long id);
}