package com.example.demo189.controller;



import com.example.demo189.entity.Language;
import com.example.demo189.entity.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MailController {

    private Mail saved = new Mail();

    @ModelAttribute("languages")
    public Language[] languages() {
        return Language.values();
    }

    @ModelAttribute("pageSizes")
    public int[] pageSizes() {
        return new int[]{5, 10, 15, 25, 50, 100};
    }

    @GetMapping("/settings")
    public String showForm(Model model) {
        model.addAttribute("mail", saved);
        return "settings";
    }

    @PostMapping("/settings")
    public String submit(@ModelAttribute("mail") Mail form, Model model) {
        saved = form;
        model.addAttribute("mail", saved);
        model.addAttribute("saved", true);
        return "settings";
    }
}
