package service.core.loan;

import java.util.Date;

public class Loan {

    private Long onLoanBorrowerId;
    private Long onLoanBookId;
    private Date date;
    private LoanState loanState;

    public Loan(Long onLoanBookId, Long onLoanBorrowerId, Date date, LoanState loanState) {
        this.onLoanBorrowerId = onLoanBorrowerId;
        this.onLoanBookId = onLoanBookId;
        this.date = date;
        this.loanState = loanState;
    }

    public LoanState getLoanState() {
        return loanState;
    }

    public void setLoanState(LoanState loanState) {
        this.loanState = loanState;
    }

    public Long getonLoanBorrowerId() {
        return onLoanBorrowerId;
    }

    public void setonLoanBorrowerId(Long onLoanBorrowerId) {
        this.onLoanBorrowerId = onLoanBorrowerId;
    }

    public Long getonLoanBookId() {
        return onLoanBookId;
    }

    public void setonLoanBookId(Long onLoanBookId) {
        this.onLoanBookId = onLoanBookId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
