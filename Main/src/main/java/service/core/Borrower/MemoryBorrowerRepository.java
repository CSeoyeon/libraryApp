package service.core.Borrower;

import java.util.HashMap;
import java.util.Map;

public class MemoryBorrowerRepository implements BorrowerRepository{

    private static Map<Long, Borrower> store_Borrower = new HashMap<>();
    @Override
    public void save(Borrower borrower) {
        store_Borrower.put(borrower.getId(), borrower);
    }

}
