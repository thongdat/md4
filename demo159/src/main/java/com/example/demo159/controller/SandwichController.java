package com.example.demo159.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("condiments", getCondiments());
        return "index";
    }

    @PostMapping("/save")
    public String saveCondiments(@RequestParam(value = "condiment", required = false) String[] selected,
                                 Model model) {
        model.addAttribute("selectedCondiments", selected);
        return "result";
    }

    private List<String> getCondiments() {
        return Arrays.asList("Lettuce","Tomato","Mustard","Sprouts");
    }
}
