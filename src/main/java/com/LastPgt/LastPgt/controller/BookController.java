package com.LastPgt.LastPgt.controller;

import com.LastPgt.LastPgt.model.Book;
import com.LastPgt.LastPgt.service.bookService.BookService;
import com.LastPgt.LastPgt.service.authorService.AuthorService;
import com.LastPgt.LastPgt.service.genreService.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "books/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("genres", genreService.findAllGenres());
        return "books/create";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Book> book = bookService.findBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            model.addAttribute("authors", authorService.findAllAuthors());
            model.addAttribute("genres", genreService.findAllGenres());
        }
        return "books/edit";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        book.setBookId(id);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
