package service.core.Borrower;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.core.AppConfig;
import org.assertj.core.api.*;


class BorrowerServiceTest {


    BorrowerService borrowerService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        borrowerService = appConfig.borrowerService();
    }

    @Test
    void join() {
        Borrower borrower = new Borrower(1L, "member");
        borrowerService.join(borrower);

        Assertions.assertThat(borrower.getName()).isEqualTo("member");

    }
}