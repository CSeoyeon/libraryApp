package service.core.Book;

import java.util.HashMap;

public interface BookRepository {
    void saveBook(Book book);
    HashMap getBook();
}
