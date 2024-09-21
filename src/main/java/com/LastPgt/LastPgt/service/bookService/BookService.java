package com.LastPgt.LastPgt.service.bookService;

import com.LastPgt.LastPgt.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAllBooks();
    Optional<Book> findBookById(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);
}
