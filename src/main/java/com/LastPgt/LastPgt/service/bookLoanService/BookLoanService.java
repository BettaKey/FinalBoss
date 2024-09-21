package com.LastPgt.LastPgt.service.bookLoanService;

import com.LastPgt.LastPgt.model.BookLoan;
import java.util.List;
import java.util.Optional;

public interface BookLoanService {
    List<BookLoan> findAllBookLoans();
    Optional<BookLoan> findBookLoanById(Long id);
    BookLoan saveBookLoan(BookLoan bookLoan);
    void deleteBookLoan(Long id);
}
