package service.core.Book;

import java.util.HashMap;

public class MemoryBookRepository implements BookRepository{

    private static HashMap<Long, Book> store_book = new HashMap<>();
    @Override
    public void saveBook(Book book) {
        store_book.put(book.getId(), book);
    }

    @Override
    public HashMap getBook() {
        return store_book;
    }

}
