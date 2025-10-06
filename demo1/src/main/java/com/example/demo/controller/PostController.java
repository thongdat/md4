package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @GetMapping
    public String list(Model model,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> postPage = postService.findAll(pageable);
        model.addAttribute("posts", postPage);
        return "posts/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("post") Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "posts/form";
        }
        if (post.getSummary() == null || post.getSummary().isBlank()) {
            post.setSummary(post.getContent().substring(0, Math.min(100, post.getContent().length())) + "...");
        }
        postService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable int id, Model model) {
        Post post = postService.findById(id).orElseThrow();
        model.addAttribute("post", post);
        return "posts/view";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Post post = postService.findById(id).orElseThrow();
        model.addAttribute("post", post);
        return "posts/form";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        postService.deleteById(id);
        return "redirect:/posts";
    }
}