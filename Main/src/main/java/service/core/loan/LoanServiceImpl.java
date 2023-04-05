package service.core.loan;

import service.core.Book.Book;
import service.core.Book.BookRepository;
import service.core.Book.LoanState;
import service.core.Borrower.Borrower;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class LoanServiceImpl implements LoanService {

    private BookRepository bookRepository;

    public LoanServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
    public void bookLoan(Book book, Borrower borrower) {

    }

    @Override
    public void bookReturn(Book book, Borrower borrower) {

    }




}
