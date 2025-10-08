package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.PostDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Post;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final IPostService postService;
    private final ICategoryService categoryService;

    @GetMapping
    public String list(Model model, @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Post> postPage = postService.findAll(pageable);
        model.addAttribute("posts", postPage);
        return "posts/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("postDto", new PostDto());
        model.addAttribute("categories", categoryService.findAll());
        return "posts/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Post postEntity = postService.findById(id);
        PostDto postDto = convertToDto(postEntity);
        model.addAttribute("postDto", postDto);
        model.addAttribute("categories", categoryService.findAll());
        return "posts/form";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("postDto") PostDto postDto,
                       BindingResult result,
                       Model model) {

        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "posts/form";
        }

        Post postEntity = convertToEntity(postDto);
        postService.save(postEntity);

        return "redirect:/posts";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        postService.deleteById(id);
        return "redirect:/posts";
    }

    private PostDto convertToDto(Post post) {
        CategoryDto categoryDto = new CategoryDto(post.getCategory().getId(), post.getCategory().getName());
        PostDto postDto = new PostDto();
        BeanUtils.copyProperties(post, postDto, "category");
        postDto.setCategory(categoryDto);
        return postDto;
    }

    private Post convertToEntity(PostDto postDto) {
        Post post = new Post();
        Category category = categoryService.findById(postDto.getCategory().getId());
        BeanUtils.copyProperties(postDto, post, "category");
        post.setCategory(category);

        if (postDto.getSummary() == null || postDto.getSummary().isBlank()) {
            String content = postDto.getContent();
            post.setSummary(content.substring(0, Math.min(100, content.length())) + "...");
        }

        return post;
    }
}