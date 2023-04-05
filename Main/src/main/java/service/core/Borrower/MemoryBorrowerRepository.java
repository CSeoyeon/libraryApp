package service.core.Borrower;

import java.util.HashMap;
import java.util.Map;

public class MemoryBorrowerRepository implements BorrowerRepository{

    private static Map<Long, Borrower> store = new HashMap<>();
    @Override
    public void save(Borrower borrower) {
        store.put(borrower.getId(), borrower);
    }

}
