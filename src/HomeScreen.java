import Ledger.LedgerScreen;

import java.util.Scanner;

public class HomeScreen {
    AccountTransactions accountTransactions=new AccountTransactions();

    public void displayHomeScreen() {
        Scanner scanner = new Scanner(System.in);
        String letterInserted = "";

        while (!letterInserted.equalsIgnoreCase("x")) {
            System.out.println("************** Home Screen **************");
            System.out.println("D) Add Deposit ");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Please choose an option: ");
            letterInserted = scanner.nextLine().toUpperCase();

            switch (letterInserted){
                case "D":
                    accountTransactions.handleTransactions("addDeposit");
                    break;
                case "P":
                    accountTransactions.handleTransactions("makePayment");
                    break;
                case "L":
                    LedgerScreen ledger = new LedgerScreen();
                    ledger.displayLedgerOptions();
                    break;
                case "X":
                    System.out.println("---Exiting the application.---\n");
                    break;
                default:
                    System.out.println("---Invalid choice, please try again.---\n");
            }
        }
    }

}
