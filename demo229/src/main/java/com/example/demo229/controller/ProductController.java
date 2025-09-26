package com.example.demo229.controller;

import com.example.demo229.entity.Product;
import com.example.demo229.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("category")
    public List<String> getCategory() {
        return Arrays.asList("Bánh mì", "Cơm", "Hải Sản", "Mì-Bún");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView products(Model model) {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("productList", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/product/add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute(name = "product") Product product,
                             RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("mess", "Add product successfully");
        return "redirect:/products";
    }

    @GetMapping("/detail/{id}")
    public String productDetails(@PathVariable(name = "id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/detail";
    }
}
