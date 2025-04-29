package Ledger;

import java.time.LocalDate;
import java.util.Scanner;

public class ReportFilters {
    Scanner scanner = new Scanner(System.in);
    static TransactionsFilters getTransactionFromFile = new TransactionsFilters();


    public void monthToDate() {
        getTransactionFromFile.getTransactionFromFile();

        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);

        boolean found = false;

        System.out.println("**************************Displaying Month-To-Date Transactions*************************");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        for (TransactionsClass t : TransactionsFilters.TransactionStore.allTransactions) {
            if (t.getDate() == null || t.getTime() == null || t.getDescription() == null || t.getVendor() == null || t.getAmount() == 0) {
                continue;
            }


            LocalDate transactionDate = LocalDate.parse(t.getDate());

            if (!transactionDate.isBefore(startOfMonth) && !transactionDate.isAfter(today)) {
                found = true;
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        t.getDate(),
                        t.getTime(),
                        t.getDescription(),
                        t.getVendor(),
                        t.getAmount());
            }
        }

        if (!found) {
            System.out.println("No Month-To-Date transactions found.");
        }
    }

    public void previousMonth() {
        getTransactionFromFile.getTransactionFromFile();  // Load all transactions

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfPreviousMonth = today.minusMonths(1).withDayOfMonth(1);
        LocalDate lastDayOfPreviousMonth = today.withDayOfMonth(1).minusDays(1);  // last day of previous month

        boolean found = false;

        System.out.println("********************** Displaying Previous Month Transactions **********************");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------------");

        for (TransactionsClass t : TransactionsFilters.TransactionStore.allTransactions) {
            if (t.getDate() == null || t.getTime() == null || t.getDescription() == null ||
                    t.getVendor() == null || t.getAmount() == 0) {
                continue;  // Skip incomplete transactions
            }

            LocalDate transactionDate = LocalDate.parse(t.getDate());

            if (!transactionDate.isBefore(firstDayOfPreviousMonth) && !transactionDate.isAfter(lastDayOfPreviousMonth)) {
                found = true;
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
            }
        }

        if (!found) {
            System.out.println("No transactions found for the previous month.");
        }
    }


    public void yearToDate() {
        getTransactionFromFile.getTransactionFromFile();

        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.withDayOfYear(1);

        boolean found = false;

        System.out.println("**************************Displaying Year-To-Date Transactions*************************");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");


        for (TransactionsClass t : TransactionsFilters.TransactionStore.allTransactions) {

            if (t.getDate() == null || t.getTime() == null || t.getDescription() == null || t.getVendor() == null || t.getAmount() == 0) {
                continue;
            }


            LocalDate transactionDate = LocalDate.parse(t.getDate());


            if (!transactionDate.isBefore(startOfYear)) {
                found = true;
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        t.getDate(),
                        t.getTime(),
                        t.getDescription(),
                        t.getVendor(),
                        t.getAmount());
            }
        }

        if (!found) {
            System.out.println("No transactions found for the current year.");
        }
    }


    public void previousYear() {
        getTransactionFromFile.getTransactionFromFile();

        LocalDate today = LocalDate.now();
        LocalDate startOfPreviousYear = today.minusYears(1).withDayOfYear(1);
        LocalDate endOfPreviousYear = today.minusYears(1).withDayOfYear(365);

        boolean found = false;

        System.out.println("**************************Displaying Previous Year Transactions*************************");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");


        for (TransactionsClass t : TransactionsFilters.TransactionStore.allTransactions) {

            if (t.getDate() == null || t.getTime() == null || t.getDescription() == null || t.getVendor() == null || t.getAmount() == 0) {
                continue;
            }


            LocalDate transactionDate = LocalDate.parse(t.getDate());


            if (!transactionDate.isBefore(startOfPreviousYear) && !transactionDate.isAfter(endOfPreviousYear)) {
                found = true;
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        t.getDate(),
                        t.getTime(),
                        t.getDescription(),
                        t.getVendor(),
                        t.getAmount());
            }
        }

        if (!found) {
            System.out.println("No transactions found for the previous year.");
        }
    }

    public void searchByVendorName() {
        System.out.println("Please enter Vendor's name:");
        String insertedVendorName = scanner.nextLine().trim().toUpperCase();

        getTransactionFromFile.getTransactionFromFile();;

        boolean found = false;

        System.out.println("**************************Displaying Transactions for Vendor: " + insertedVendorName + "*************************");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        for (TransactionsClass t : TransactionsFilters.TransactionStore.allTransactions) {
            if (t.getVendor() != null && t.getVendor().toUpperCase().contains(insertedVendorName)) {
                found = true;
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        t.getDate(),
                        t.getTime(),
                        t.getDescription(),
                        t.getVendor(),
                        t.getAmount());
            }
        }

        if (!found) {
            System.out.println("No transactions found for vendor: " + insertedVendorName);
        }
    }


}
