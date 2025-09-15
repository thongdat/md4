package com.example.demo159.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @PostMapping("/calculate")
    public String calculate(@RequestParam("a") double a,
                            @RequestParam("b") double b,
                            @RequestParam("op") String op,
                            Model model) {
        Double result = null;
        String expr = null;
        String error = null;

        switch (op) {
            case "add": result = a + b; expr = a+" + "+b; break;
            case "sub": result = a - b; expr = a+" - "+b; break;
            case "mul": result = a * b; expr = a+" × "+b; break;
            case "div":
                if (b==0) error = "Không thể chia cho 0!";
                else { result = a / b; expr = a+" ÷ "+b; }
                break;
            default: error = "Phép tính không hợp lệ!";
        }

        model.addAttribute("calcExpr", expr);
        model.addAttribute("calcResult", result);
        model.addAttribute("calcError", error);
        return "result";
    }
}
