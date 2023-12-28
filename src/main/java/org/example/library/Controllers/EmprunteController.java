package org.example.library.Controllers;

import org.example.library.Entity.Emprunte;
import org.example.library.Entity.Etudiant;
import org.example.library.Entity.Livre;
import org.example.library.Services.EmprunteServiceImpl;
import org.example.library.Services.EtudiantServiceImpl;
import org.example.library.Services.LivreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EmprunteController {
    @Autowired
    private EmprunteServiceImpl emprunteServiceImpl;
    @Autowired
    private EtudiantServiceImpl etudiant;
    @Autowired
    private LivreServiceImpl livre;

    @GetMapping("/allEmpruntes")
    public String listeEmpruntes(Model model) {
        List<Emprunte> listEmpruntes = emprunteServiceImpl.getAllEmprunte();
        model.addAttribute("listeEmpruntes", listEmpruntes);
        return "liste_empruntes";
    }

    @GetMapping("/addEmprunte")
    public String addEmprunte(Model model) {
        Emprunte emprunte = new Emprunte();
        List<Etudiant> listeEtudiant= etudiant.getAllEtudiant();
        List<Livre> listeLivre = livre.getAllLivre();
        model.addAttribute("EmprunteForm", emprunte);
        model.addAttribute("listEtudiant", listeEtudiant);
        model.addAttribute("listLivre", listeLivre);
        return "new_emprunte";
    }

    @RequestMapping(value = "/saveEmprunte", method = RequestMethod.POST)
    public String saveEmprunte(@ModelAttribute("emprunte") Emprunte emprunte) {
        emprunteServiceImpl.updateEmprunte(emprunte);
        return "redirect:/allEmpruntes";
    }

    @GetMapping("/editEmprunte/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Emprunte emprunte = emprunteServiceImpl.getEmprunteByID(id);
        List<Etudiant> listeEtudiant = etudiant.getAllEtudiant();
        List<Livre> listeLivre = livre.getAllLivre();
        model.addAttribute("emprunte", emprunte);
        model.addAttribute("listEtudiant", listeEtudiant);
        model.addAttribute("listLivre", listeLivre);
        return "update_emprunte";
    }

    @PostMapping("/updateEmprunte/{id}")
    public String updateEmprunte(@PathVariable("id") long id, Emprunte emprunte, BindingResult result, Model model) {
        if (result.hasErrors()) {
            emprunte.setId(id);
            return "update_emprunte";
        }
        emprunteServiceImpl.createEmprunte(emprunte);
        return "redirect:/allEmpruntes";
    }

    @GetMapping("/deleteEmprunte/{id}")
    public String deleteEmprunte(@PathVariable("id") long id) {
        emprunteServiceImpl.deleteEmprunte(id);
        return "redirect:/allEmpruntes";
    }
}