package service.core.Borrower;

import java.util.HashMap;

public interface BorrowerRepository {
    void save(Borrower borrower);
    HashMap getBorrower();
}
