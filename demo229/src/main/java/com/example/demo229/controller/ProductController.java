package com.example.demo229.controller;

import com.example.demo229.entity.Product;
import com.example.demo229.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("product", productService.findAll());
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/product";
    }
}
