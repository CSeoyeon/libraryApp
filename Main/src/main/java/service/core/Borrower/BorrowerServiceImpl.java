package service.core.Borrower;

public class BorrowerServiceImpl implements BorrowerService{
    private BorrowerRepository  borrowerRepository;

    public BorrowerServiceImpl(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public void join(Borrower borrower) {
        borrowerRepository.save(borrower);
    }
}
