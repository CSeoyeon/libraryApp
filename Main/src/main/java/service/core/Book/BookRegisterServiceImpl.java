package service.core.Book;

public class BookRegisterServiceImpl implements BookRegisterService{

    private BookRepository bookRepository;

    public BookRegisterServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void register(Book book) {
        bookRepository.saveBook(book);
    }




}
