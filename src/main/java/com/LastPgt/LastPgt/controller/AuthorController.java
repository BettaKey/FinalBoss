package com.LastPgt.LastPgt.controller;

import com.LastPgt.LastPgt.model.Author;
import com.LastPgt.LastPgt.service.authorService.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.findAllAuthors());
        return "authors/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/create";
    }

    @PostMapping("/create")
    public String createAuthor(@ModelAttribute("author") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Author> author = authorService.findAuthorById(id);
        author.ifPresent(value -> model.addAttribute("author", value));
        return "authors/edit";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable("id") Long id, @ModelAttribute("author") Author author) {
        author.setAuthorId(id);
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }
}
