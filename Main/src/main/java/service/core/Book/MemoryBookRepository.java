package service.core.Book;

import service.core.loan.LoanState;

import java.util.HashMap;

public class MemoryBookRepository implements BookRepository{

    private static HashMap<Long, Book> store_book = new HashMap<>();
    @Override
    public void save(Book book) {
        store_book.put(book.getId(), book);
    }

    @Override
    public HashMap getBook() {
        return store_book;
    }

    @Override
    public void setBookNotLoanState(Long bookId) {
        store_book.get(bookId).setLoanState(LoanState.NOT_LOAN);
    }

    @Override
    public void setBookOnLoanState(Long bookId) {
        store_book.get(bookId).setLoanState(LoanState.ON_LOAN);
    }


}
