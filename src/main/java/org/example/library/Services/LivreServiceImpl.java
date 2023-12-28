package org.example.library.Services;

import org.example.library.Entity.Livre;
import org.example.library.Repository.LivreRepository;
import org.example.library.Services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    @Autowired
    private LivreRepository livreRepository;

    @Override
    public List<Livre> getAllLivre() {
        return livreRepository.findAll();
    }

    @Override
    public Livre createLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Livre getLivreByID(Long id) {
        return livreRepository.findById(id).get();
    }

    @Override
    public Livre updateLivre(Livre livre) {
        return livreRepository.saveAndFlush(livre);
    }

    @Override
    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }
}