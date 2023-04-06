package service.core.loan;

import service.core.Book.Book;
import service.core.Book.BookRepository;
import service.core.Borrower.Borrower;
import service.core.Borrower.BorrowerRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class LoanServiceImpl implements LoanService {

    private BookRepository bookRepository;
    private LoanRepository loanRepository;
    private BorrowerRepository borrowerRepository;

    public LoanServiceImpl(BookRepository bookRepository, LoanRepository loanRepository, BorrowerRepository borrowerRepository) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public ArrayList<Book> LoanPossibleBooks() {
        HashMap hashMap = bookRepository.getBook();
        ArrayList<Book> arrayList = new ArrayList<>();

        for(Object x : hashMap.values()){
            Book book = (Book) x;
            if(book.getLoanState() == LoanState.NOT_LOAN){
                arrayList.add(book);
            }
        }
        return arrayList;
    }


    @Override
    public ArrayList<Book> LoanImpossibleBooks() {
        HashMap hashMap = bookRepository.getBook();
        ArrayList<Book> arrayList = new ArrayList<>();

        for(Object x : hashMap.values()){
            Book book = (Book) x;
            if(book.getLoanState() == LoanState.ON_LOAN){
                arrayList.add(book);
            }

        }
        return arrayList;
    }

    @Override
    public LoanState bookLoan(Long bookId, Long borrowerId) {
        makeLoan(bookId, borrowerId);
        bookRepository.setBookOnLoanState(bookId);
        return LoanState.COMPLETE_LOAN;


    }

    @Override
    public void makeLoan(Long bookId, Long borrowerId){
        Date localDate = new Date();
        Loan loan = new Loan(bookId, borrowerId, localDate, LoanState.COMPLETE_LOAN);
        loanRepository.save(loan);
    }

    @Override
    public void makeBackLoan(Long bookId, Long borrowerId) {
        Date localDate = new Date();
        Loan loan = new Loan(bookId, borrowerId, localDate, LoanState.COMPLETE_BACKLOAN);
        loanRepository.save(loan);
    }

    @Override
    public LoanState backLoan(Long bookId, Long borrowerId) {
        bookRepository.setBookNotLoanState(bookId);
        makeBackLoan(bookId, borrowerId);
        return LoanState.COMPLETE_BACKLOAN;
    }


    @Override
    public LoanState registerBookVerification(Long bookId){
        Long tmpId = 0L;
        for(Object id : bookRepository.getBook().keySet()){
            if(id == bookId){
                tmpId = bookId;
            }
        }
        if(tmpId == bookId){
            return LoanState.POSSIBLE_LOAN;
        }

        else{
            return LoanState.NOT_BOOK_REGISTER;
        }

    }

    @Override
    public LoanState registerBorrowerVerification(Long borrowerId){
        Long tmpId = 0L;
        for(Object id : borrowerRepository.getBorrower().keySet()){
            if(borrowerId == id){
                tmpId = borrowerId;
            }
        }

        if(tmpId == borrowerId){
            return LoanState.POSSIBLE_LOAN;
        }
        else{
            return LoanState.NOT_BORROWER_REGISTER;
        }

    }

    @Override
    public LoanState borrowerConfirm(Long borrowerID) {
        Borrower borrower = (Borrower) borrowerRepository.getBorrower().get(borrowerID);
        if (borrower.getOnLoanBook_id().size() >= 6){
            return LoanState.MAX_LOAN;
        }else return LoanState.POSSIBLE_LOAN;

    }

    @Override
    public LoanState bookConfirm(Long bookId) {
        String[] authors = {};
        Book book =new Book(Long.parseLong("0"), "", authors , LoanState.NOT_LOAN);
        for(Object id : bookRepository.getBook().keySet()){
            if(bookId == id ){
                book = (Book) bookRepository.getBook().get(id) ;
            }
        }

        if (book.getLoanState() == LoanState.NOT_LOAN){
            return LoanState.POSSIBLE_LOAN;
        }else return LoanState.ON_LOAN;

    }




}
