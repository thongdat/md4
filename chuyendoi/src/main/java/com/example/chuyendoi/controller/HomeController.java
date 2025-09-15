package com.example.chuyendoi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HomeController {

    private static final Map<String,String> DICT = Map.of(
            "hello","xin chào",
            "book","quyển sách",
            "computer","máy tính",
            "java","ngôn ngữ lập trình Java"
    );

    @GetMapping("/")
    public String index() {
        return "index"; // /WEB-INF/views/index.jsp
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("rate") String rateStr,
                          @RequestParam("usd") String usdStr,
                          Model model) {
        try {
            double rate = Double.parseDouble(rateStr);
            double usd  = Double.parseDouble(usdStr);
            if (rate <= 0 || usd < 0) {
                model.addAttribute("errorConvert", "Tỉ giá phải > 0 và USD ≥ 0.");
            } else {
                model.addAttribute("rate", rate);
                model.addAttribute("usd", usd);
                model.addAttribute("vnd", rate * usd);
            }
        } catch (NumberFormatException e) {
            model.addAttribute("errorConvert", "Vui lòng nhập số hợp lệ.");
        }
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model) {
        String meaning = (word == null) ? null : DICT.get(word.toLowerCase());
        if (meaning != null) {
            model.addAttribute("word", word);
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("word", word);
            model.addAttribute("errorDict", "Không tìm thấy từ '" + word + "'.");
        }
        return "index";
    }
}