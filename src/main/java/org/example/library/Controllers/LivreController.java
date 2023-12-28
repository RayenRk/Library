package org.example.library.Controllers;

import org.example.library.Entity.Livre;
import org.example.library.Services.LivreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class LivreController {
    @Autowired
    private LivreServiceImpl livreServiceImpl;

    @GetMapping("/allLivres")
    public String listeLivres(Model model) {
        List<Livre> listLivres = livreServiceImpl.getAllLivre();
        model.addAttribute("listeLivres", listLivres);
        return "liste_livres";
    }

    @GetMapping("/addLivre")
    public String addLivre(Model model) {
        Livre livre = new Livre();
        model.addAttribute("LivreForm", livre);
        return "new_livre";
    }

    @RequestMapping(value = "/saveLivre", method = RequestMethod.POST)
    public String saveLivre(@ModelAttribute("livre") Livre livre) {
        livreServiceImpl.updateLivre(livre);
        return "redirect:/allLivres";
    }

    @GetMapping("/editLivre/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Livre livre = livreServiceImpl.getLivreByID(id);
        model.addAttribute("livre", livre);
        return "update_livre";
    }

    @PostMapping("/updateLivre/{id}")
    public String updateLivre(@PathVariable("id") long id, Livre livre, BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            livre.setId(id);
            return "update_livre";
        }
        livreServiceImpl.createLivre(livre);
        return "redirect:/allLivres";
    }

    @GetMapping("/deleteLivre/{id}")
    public String deleteLivre(@PathVariable("id") long id) {
        livreServiceImpl.deleteLivre(id);
        return "redirect:/allLivres";
    }
}