package service.core.Borrower;

import java.util.ArrayList;

public class Borrower {
    private String name;
    private Long id;
    private ArrayList<Long> onLoanBook_id;

    public Borrower(Long id, String name, ArrayList<Long> onLoanBook_id) {
        this.id = id;
        this.name = name;
        this.onLoanBook_id = onLoanBook_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Long> getOnLoanBook_id() {
        return onLoanBook_id;
    }

    public void setOnLoanBook_id(ArrayList<Long> onLoanBook_id) {
        this.onLoanBook_id = onLoanBook_id;
    }
}
