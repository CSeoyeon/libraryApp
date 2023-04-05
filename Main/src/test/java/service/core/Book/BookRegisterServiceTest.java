package service.core.Book;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.core.AppConfig;
import service.core.Borrower.BorrowerService;

import static org.junit.jupiter.api.Assertions.*;

class BookRegisterServiceTest {


    BookRegisterService bookRegisterService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        bookRegisterService = appConfig.bookRegisterService();
    }

    @Test
    void register() {
        String[] authors = { "David", "Tom"};
        Book book = new Book(1L, "bookTitle", authors, LoanState.NOT_LOAN);

        Assertions.assertThat(book.getTitle()).isEqualTo("bookTitle");




    }
}