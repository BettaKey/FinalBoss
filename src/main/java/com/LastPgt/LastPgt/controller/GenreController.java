package com.LastPgt.LastPgt.controller;

import com.LastPgt.LastPgt.model.Genre;
import com.LastPgt.LastPgt.service.genreService.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public String listGenres(Model model) {
        model.addAttribute("genres", genreService.findAllGenres());
        return "genres/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "genres/create";
    }

    @PostMapping("/create")
    public String createGenre(@ModelAttribute("genre") Genre genre) {
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Genre> genre = genreService.findGenreById(id);
        genre.ifPresent(value -> model.addAttribute("genre", value));
        return "genres/edit";
    }

    @PostMapping("/update/{id}")
    public String updateGenre(@PathVariable("id") Long id, @ModelAttribute("genre") Genre genre) {
        genre.setGenreId(id);
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable("id") Long id) {
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }
}
