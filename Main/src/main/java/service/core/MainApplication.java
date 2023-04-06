package service.core;

import service.core.Book.Book;
import service.core.Book.BookRegisterService;
import service.core.Borrower.Borrower;
import service.core.Borrower.BorrowerService;
import service.core.loan.LoanService;
import service.core.loan.LoanState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        AppConfig appConfig = new AppConfig();

        //선택지에 따른 작동(Service)
        BorrowerService borrowerService = appConfig.borrowerService();
        BookRegisterService bookRegisterService = appConfig.bookRegisterService();
        LoanService loanService = appConfig.loanService();

        //선택 메뉴 (활자)
        DisplayMenu displayMenu = new DisplayMenu();

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            displayMenu.displayMenu();
            String choice = br.readLine();
            if(choice.equals("0")) {
                //종료할 때 로그 및 사용 히스토리 출력 해야함
                break;
            }
            switch (choice) {
                case "1":
                    displayMenu.registerBorrower_showingText1();
                    Long userId = Long.parseLong(br.readLine());
                    displayMenu.registerBorrower_showingText2();
                    String name = br.readLine();
                    ArrayList<Long> onLoanBook_id = new ArrayList<>();
                    Borrower borrower = new Borrower(userId, name, onLoanBook_id);
                    borrowerService.join(borrower);
                    break;

                case "2":
                    displayMenu.registerBook_showingText1();
                    Long bookId = Long.parseLong(br.readLine());

                    displayMenu.registerBook_showingText2();
                    String bookName = br.readLine();

                    displayMenu.registerBook_showingText3();
                    String author = br.readLine();
                    String[] authors = (author).split(",");

                    Book book  = new Book(bookId, bookName, authors, LoanState.NOT_LOAN);
                    bookRegisterService.register(book);
                    break;

                case "3":
                  ArrayList<Book> possible_bookArrayList = loanService.LoanPossibleBooks();
                    displayMenu.showingLoanPossibleBook_showingText1(possible_bookArrayList.size());
                    for(Book x : possible_bookArrayList){
                        System.out.printf("고유번호: %s, 제목: %s",x.getId(), x.getTitle());
                        System.out.printf(" 저자 : ");
                        for(String t : x.getAuthors()){
                            System.out.printf("%s", t);
                        }
                        System.out.println("\n");
                    }

                    break;

                case "4":

                    ArrayList<Book> impossible_bookArrayList = loanService.LoanImpossibleBooks();
                    displayMenu.showingLoanImpossibleBook_showingText1(impossible_bookArrayList.size());
                    for(Book x : impossible_bookArrayList){
                        System.out.printf("고유번호: %s, 제목: %s",x.getId(), x.getTitle());
                        System.out.printf(" 저자 : ");
                        for(String t : x.getAuthors()){
                            System.out.printf("%s", t);
                        }
                        System.out.println("\n");
                    }

                    break;

                case "5":
                    displayMenu.LoanBook_showingText1();
                    Long onLoanBorrowerId = Long.valueOf(br.readLine());
                    if(loanService.registerBorrowerVerification(onLoanBorrowerId) == LoanState.POSSIBLE_LOAN){
                        displayMenu.LoanBook_showingText4();
                        Long onLoanBookId = Long.valueOf(br.readLine());
                        if(loanService.registerBookVerification(onLoanBorrowerId) == LoanState.POSSIBLE_LOAN){
                            if(loanService.bookConfirm(onLoanBorrowerId) == LoanState.POSSIBLE_LOAN){
                                if(loanService.borrowerConfirm(onLoanBorrowerId) == LoanState.POSSIBLE_LOAN){
                                    if(loanService.bookLoan(onLoanBookId, onLoanBorrowerId) == LoanState.COMPLETE_LOAN){
                                        displayMenu.LoanBook_showingText5();
                                    }
                                }else{
                                    displayMenu.LoanBook_showingText3();}
                            }
                        } else {
                            displayMenu.LoanBook_showingText6();
                        }
                    } else displayMenu.LoanBook_showingText2();

                    break;

                case "6":
                    displayMenu.backLoan_showingText1();
                    Long backLoanBorrowerId = Long.valueOf(br.readLine());
                    if(loanService.registerBorrowerVerification(backLoanBorrowerId) == LoanState.POSSIBLE_LOAN){
                        displayMenu.backLoan_showingText3();
                        Long backLoanBookId = Long.valueOf(br.readLine());
                        if(loanService.registerBookVerification(backLoanBookId) == LoanState.POSSIBLE_LOAN){
                           if(loanService.bookConfirm(backLoanBookId) == LoanState.ON_LOAN ){
                               if(loanService.backLoan(backLoanBookId, backLoanBorrowerId) == LoanState.COMPLETE_BACKLOAN) {
                                   displayMenu.backLoan_showingText6();
                               }
                           } else displayMenu.backLoan_showingText5();
                        }else  displayMenu. backLoan_showingText4();
                    } else displayMenu.backLoan_showingText2();


                    break;

                default:
                    displayMenu.warning_showingText1();

            }
        }



    }
}
