package service.core.Book;

import service.core.loan.LoanState;

public class Book {
    private Long id;
    private String title;
    private String[] authors;
    private LoanState loanState;

    public Book(Long id, String title, String[] authors, LoanState loanState) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.loanState = loanState;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public LoanState getLoanState() {
        return loanState;
    }

    public void setLoanState(LoanState loanState) {
        this.loanState = loanState;
    }
}
