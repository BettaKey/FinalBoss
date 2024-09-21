package com.LastPgt.LastPgt.service.bookLoanService;

import com.LastPgt.LastPgt.model.BookLoan;
import com.LastPgt.LastPgt.repository.BookLoanRepository;
import com.LastPgt.LastPgt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookLoanServiceImpl implements BookLoanService {
    private final BookLoanRepository bookLoanRepository;

    @Autowired
    public BookLoanServiceImpl(BookLoanRepository bookLoanRepository) {
        this.bookLoanRepository = bookLoanRepository;
    }

    @Override
    public List<BookLoan> findAllBookLoans() {
        return bookLoanRepository.findAll();
    }

    @Override
    public Optional<BookLoan> findBookLoanById(Long id) {
        return bookLoanRepository.findById(id);
    }

    @Override
    public BookLoan saveBookLoan(BookLoan bookLoan) {
        return bookLoanRepository.save(bookLoan);
    }

    @Override
    public void deleteBookLoan(Long id) {
        bookLoanRepository.deleteById(id);
    }
}
