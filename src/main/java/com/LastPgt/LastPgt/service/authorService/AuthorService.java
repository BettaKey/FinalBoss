package com.LastPgt.LastPgt.service.authorService;

import com.LastPgt.LastPgt.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAllAuthors();
    Optional<Author> findAuthorById(Long id);
    Author saveAuthor(Author author);
    void deleteAuthor(Long id);
}
