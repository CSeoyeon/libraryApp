package service.core.loan;

import service.core.Book.Book;
import service.core.Borrower.Borrower;

import java.util.ArrayList;

public interface LoanService {
    ArrayList<Book> LoanPossibleBooks();
    ArrayList<Book> LoanImpossibleBooks();
    void bookLoan(Book book, Borrower borrower);
    void bookReturn(Book book, Borrower borrower);
}
