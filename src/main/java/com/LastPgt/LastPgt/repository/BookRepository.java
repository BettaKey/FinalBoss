package com.LastPgt.LastPgt.repository;

import com.LastPgt.LastPgt.model.Book;
import com.LastPgt.LastPgt.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
