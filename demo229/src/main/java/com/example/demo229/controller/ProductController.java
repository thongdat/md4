package com.example.demo229.controller;

import com.example.demo229.entity.Product;
import com.example.demo229.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        return Arrays.asList("cơm", "cá", "gà");
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "products/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("product", new Product());
        return "products/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("product") Product product,
                       RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm sản phẩm thành công!");
        return "redirect:/products";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id", required = false, defaultValue = "3") int id,
                         Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "products/detail";
    }

    // Hiển thị chi tiết sản phẩm theo path variable
    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable("id") int id,
                          Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "products/detail";
    }
}
