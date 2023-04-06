package service.core.loan;

import java.util.HashMap;

public interface LoanRepository {
    void save(Loan loan);
    HashMap<Long, Loan> getLoan();
}
