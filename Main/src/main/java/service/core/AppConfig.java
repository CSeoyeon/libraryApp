package service.core;

import service.core.Book.BookRegisterService;
import service.core.Book.BookRegisterServiceImpl;
import service.core.Book.BookRepository;
import service.core.Book.MemoryBookRepository;
import service.core.Borrower.BorrowerRepository;
import service.core.Borrower.BorrowerService;
import service.core.Borrower.BorrowerServiceImpl;
import service.core.Borrower.MemoryBorrowerRepository;
import service.core.loan.LoanRepository;
import service.core.loan.LoanService;
import service.core.loan.LoanServiceImpl;
import service.core.loan.MemoryLoanRepository;

public class AppConfig {

    //대출 이용자 등록 (Borrower Register Service)
    public BorrowerService borrowerService(){
        return new BorrowerServiceImpl(borrowerRepository());
    }

    private static BorrowerRepository borrowerRepository(){
        return new MemoryBorrowerRepository();
    }

    //도서 등록 (Register Book Service)
    public BookRegisterService bookRegisterService(){
        return new BookRegisterServiceImpl(bookRepository());
    }

    private static BookRepository bookRepository(){
        return new MemoryBookRepository();
    }

    //LoanService
    public LoanService loanService(){
        return new LoanServiceImpl(bookRepository(), loanRepository(), borrowerRepository());
    }
    private static LoanRepository loanRepository(){return new MemoryLoanRepository();}

}
