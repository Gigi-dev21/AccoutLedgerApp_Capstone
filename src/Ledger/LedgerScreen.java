package Ledger;

import java.util.Scanner;

public class LedgerScreen {
    Scanner scanner = new Scanner(System.in);
    String letterInserted = "";
    LedgerFilters ledgerFilters = new LedgerFilters();
    Reports reports = new Reports();

    public void displayLedgerOptions() {
        while (!letterInserted.equalsIgnoreCase("h")) {
            System.out.println("\n" + "************** Ledger Screen **************");
            System.out.println("A) All - Display all entries");
            System.out.println("D) Deposits - Display deposits only");
            System.out.println("P) Payments - Display payments only");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Please choose an option: ");
            letterInserted = scanner.nextLine().toUpperCase();

            switch (letterInserted) {
                case "A":
                    ledgerFilters.displayAllTransactionsFilter("displayAllTransactions");
                    break;
                case "D":
                    ledgerFilters.displayAllTransactionsFilter("displayDepositOnly");
                    break;
                case "P":
                    ledgerFilters.displayAllTransactionsFilter("displayPaymentsOnly");
                    break;
                case "R":
                    reports.displayReportOptions();
                    break;
                case "H":
                    System.out.println("---Going back to the home page---\n");
                    break;
                default:
                    System.out.println("--Invalid choice, please try again--\n");
            }

        }
    }
}
