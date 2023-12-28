package org.example.library.Controllers;

import org.example.library.Entity.Etudiant;
import org.example.library.Services.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EtudiantController {

    @Autowired
    private EtudiantServiceImpl etudiantServiceImpl;

    @GetMapping("/all")
    public String listeEtudiants(Model model) {
        List<Etudiant> listEtudiants = etudiantServiceImpl.getAllEtudiant();
        model.addAttribute("listeEtudiants", listEtudiants);
        return "liste_etudiants";
    }

    @GetMapping("/addEtudiant")
    public String addEtudiant(Model model) {
        Etudiant etudiant = new Etudiant();
        model.addAttribute("EtudiantForm", etudiant);
        return "new_etudiant";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant) {
        etudiantServiceImpl.updateEtudiant(etudiant);
        return "redirect:/all";
    }

    @GetMapping("/editEtudiant/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Etudiant etudiant = etudiantServiceImpl.getEtudiantByID(id);
        model.addAttribute("etudiant", etudiant);
        return "update_etudiant";
    }

    @PostMapping("/update/{id}")
    public String updateEtudiant(@PathVariable("id") long id, Etudiant etudiant, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            etudiant.setId(id);
            return "update_etudiant";
        }
        etudiantServiceImpl.createEtudiant(etudiant);
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteEtudiant(@PathVariable("id") long id) {
        etudiantServiceImpl.deleteEtudiant(id);
        return "redirect:/all";
    }
}