package org.example.library.Services;

import org.example.library.Entity.Emprunte;
import java.util.List;

public interface EmprunteService {
    List<Emprunte> getAllEmprunte();
    Emprunte createEmprunte(Emprunte emprunte);
    Emprunte getEmprunteByID(Long id);
    Emprunte updateEmprunte(Emprunte emprunte);
    void deleteEmprunte(Long id);
}