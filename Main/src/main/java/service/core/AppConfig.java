package service.core;

import service.core.Borrower.BorrowerRepository;
import service.core.Borrower.BorrowerService;
import service.core.Borrower.BorrowerServiceImpl;
import service.core.Borrower.MemoryBorrowerRepository;

public class AppConfig {

    public BorrowerService borrowerService(){
        return new BorrowerServiceImpl(borrowerRepository());
    }

    private static BorrowerRepository borrowerRepository(){
        return new MemoryBorrowerRepository();
    }

}
