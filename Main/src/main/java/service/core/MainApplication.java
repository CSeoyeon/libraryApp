package service.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.core.Book.Book;
import service.core.Book.BookRegisterService;
import service.core.Book.LoanState;
import service.core.Borrower.Borrower;
import service.core.Borrower.BorrowerService;
import service.core.loan.LoanService;

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
                    Borrower borrower = new Borrower(userId, name);
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
                  ArrayList<Book> possible_bookArrayList = loanService.LoanImpossibleBooks();
                    displayMenu.showingLoanPossibleBook_showingText1(possible_bookArrayList.size());
                    for(Book x : possible_bookArrayList){
                        System.out.printf("%s, %s",x.getId(), x.getTitle());
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
                        System.out.printf("%s, %s",x.getId(), x.getTitle());
                        for(String t : x.getAuthors()){
                            System.out.printf("%s", t);
                        }
                        System.out.println("\n");
                    }

                    break;

                case "5":
                    break;

                case "6":
                    break;

                default:
                    displayMenu.warning_showingText1();

            }
        }



    }
}
