package service.core.loan;

import java.util.HashMap;

public class MemoryLoanRepository implements LoanRepository{

    HashMap<Long, Loan> loanHashMap = new HashMap<>();
    @Override
    public void save(Loan loan) {
        loanHashMap.put(loan.getonLoanBookId(), loan);
    }
}
