package com.LastPgt.LastPgt.controller;

import com.LastPgt.LastPgt.model.Book;
import com.LastPgt.LastPgt.model.BookLoan;
import com.LastPgt.LastPgt.model.User;
import com.LastPgt.LastPgt.service.bookLoanService.BookLoanService;
import com.LastPgt.LastPgt.service.bookService.BookService;
import com.LastPgt.LastPgt.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bookloans")
public class BookLoanController {
    private final BookLoanService bookLoanService;
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public BookLoanController(BookLoanService bookLoanService, BookService bookService, UserService userService) {
        this.bookLoanService = bookLoanService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    public String listBookLoans(Model model) {
        model.addAttribute("bookloans", bookLoanService.findAllBookLoans());
        return "bookloans/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("bookloan", new BookLoan());

        // Передаем список книг
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);

        // Передаем список пользователей
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return "bookloans/create";
    }


    @PostMapping("/create")
    public String createBookLoan(@ModelAttribute("bookloan") BookLoan bookLoan) {
        bookLoanService.saveBookLoan(bookLoan);
        return "redirect:/bookloans";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<BookLoan> bookLoan = bookLoanService.findBookLoanById(id);
        bookLoan.ifPresent(value -> model.addAttribute("bookloan", value));

        // Передаем список книг
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);

        // Передаем список пользователей
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return "bookloans/edit";
    }

    @PostMapping("/update/{id}")
    public String updateBookLoan(@PathVariable("id") Long id, @ModelAttribute("bookloan") BookLoan bookLoan) {
        bookLoan.setLoanId(id);
        bookLoanService.saveBookLoan(bookLoan);
        return "redirect:/bookloans";
    }

    @GetMapping("/delete/{id}")
    public String deleteBookLoan(@PathVariable("id") Long id) {
        bookLoanService.deleteBookLoan(id);
        return "redirect:/bookloans";
    }
}

