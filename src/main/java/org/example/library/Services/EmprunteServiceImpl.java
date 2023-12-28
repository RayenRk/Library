package org.example.library.Services;

import org.example.library.Entity.Emprunte;
import org.example.library.Repository.EmprunteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmprunteServiceImpl implements EmprunteService {

    @Autowired
    private EmprunteRepository emprunteRepository;

    @Override
    public List<Emprunte> getAllEmprunte() {
        return emprunteRepository.findAll();
    }

    @Override
    public Emprunte createEmprunte(Emprunte emprunte) {
        return emprunteRepository.save(emprunte);
    }

    @Override
    public Emprunte getEmprunteByID(Long id) {
        return emprunteRepository.findById(id).get();
    }

    @Override
    public Emprunte updateEmprunte(Emprunte emprunte) {
        return emprunteRepository.saveAndFlush(emprunte);
    }

    @Override
    public void deleteEmprunte(Long id) {
        emprunteRepository.deleteById(id);
    }
}