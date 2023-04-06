package service.core.Book;

import java.util.HashMap;

public interface BookRepository {
    void save(Book book);
    HashMap getBook();

    void setBookNotLoanState(Long bookId);
    void setBookOnLoanState(Long bookId);
}
