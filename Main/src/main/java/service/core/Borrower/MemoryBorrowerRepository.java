package service.core.Borrower;

import java.util.HashMap;

public class MemoryBorrowerRepository implements BorrowerRepository{

    private static HashMap<Long, Borrower> store_Borrower = new HashMap<>();
    @Override
    public void save(Borrower borrower) {
        store_Borrower.put(borrower.getId(), borrower);
    }

    @Override
    public HashMap getBorrower() {
        return store_Borrower;
    }



}
