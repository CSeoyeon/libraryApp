package service.core.loan;

import service.core.Book.Book;
import service.core.Borrower.Borrower;

import java.util.ArrayList;

public interface LoanService {
    ArrayList<Book> loanPossibleBooks();
    ArrayList<Book> loanImpossibleBooks();
    LoanState bookLoan(Long bookId, Long borrowerId);
    LoanState registerBorrowerVerification(Long borrowerId);
    LoanState registerBookVerification(Long bookId);
    LoanState borrowerConfirm(Long borrowerID);
    LoanState bookConfirm(Long bookId);
    void makeLoan(Long bookId, Long borrowerName);
    void makeBackLoan(Long bookId, Long borrowerName);
    LoanState backLoan(Long bookId, Long borrowerId);

    ArrayList<Loan> loanHistory();
    void historyToString(ArrayList<Loan> arrayList);

}
