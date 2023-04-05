package service.core;

import service.core.Borrower.Borrower;
import service.core.Borrower.BorrowerService;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BorrowerService borrowerService = appConfig.borrowerService();

        DisplayMenu displayMenu = new DisplayMenu();
        displayMenu.displayMenu();

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        switch (choice) {
            case "0":
                displayMenu.quit();
                break;

            case "1":
                Long id = scanner.nextLong();
                String name = scanner.next();
                Borrower borrower = new Borrower(id, name);
                borrowerService.join(borrower);
                break;

            case "2":
                break;

            case "3":
                break;

            case "4":
                break;

            case "5":
                break;

            case "6":
                break;


        }

    }
}
