package Ledger;

import java.time.LocalDate;
import java.util.Scanner;

public class ReportFilters {
    Scanner scanner = new Scanner(System.in);
    static TransactionsFilters getTransactionFromFile = new TransactionsFilters();

    LocalDate today = LocalDate.now();
    LocalDate startOfMonth = today.withDayOfMonth(1);
    LocalDate firstDayOfPreviousMonth = today.minusMonths(1).withDayOfMonth(1);
    LocalDate lastDayOfPreviousMonth = today.withDayOfMonth(1).minusDays(1);
    LocalDate startOfYear = today.withDayOfYear(1);
    LocalDate startOfPreviousYear = today.minusYears(1).withDayOfYear(1);
    LocalDate endOfPreviousYear = today.minusYears(1).withDayOfYear(365);


    public void filters(String type) {
        getTransactionFromFile.getTransactionFromFile();
        boolean found = false;
        String display;
        String insertedVendorName = "";
        switch (type) {
            case "monthToDate":
                display = "Displaying Month-To-Date Transactions";
                break;
            case "previousMonth":
                display = "Displaying Previous Month Transactions";
                break;
            case "yearToDate":
                display = "Displaying Year-To-Date Transactions";
                break;
            case "previousYear":
                display = "Displaying Previous Year Transactions";
                break;
            case "searchByVendorName":
                System.out.print("Please enter Vendor's name: ");
                insertedVendorName = scanner.nextLine().trim().toUpperCase();
                display = "Displaying Transactions for Vendor: " + insertedVendorName;
                break;
            default:
                System.out.println("Invalid filter type");
                return;
        }

        System.out.println("**********************"+ display+ "**********************");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");


        for (TransactionsClass t : TransactionsFilters.TransactionStore.allTransactions) {
            if (t.getDate() == null || t.getTime() == null || t.getDescription() == null || t.getVendor() == null || t.getAmount() == 0) {
                continue;
            }

            LocalDate transactionDate = LocalDate.parse(t.getDate());
            boolean matches = false;

            switch (type) {
                case "monthToDate":
                    matches= !transactionDate.isBefore(startOfMonth) && !transactionDate.isAfter(today);
                    break;
                case "previousMonth":
                    matches= !transactionDate.isBefore(firstDayOfPreviousMonth) && !transactionDate.isAfter(lastDayOfPreviousMonth);
                    break;
                case "yearToDate":
                    matches = !transactionDate.isBefore(startOfYear);
                    break;
                case "previousYear":
                    matches=!transactionDate.isBefore(startOfPreviousYear) && !transactionDate.isAfter(endOfPreviousYear);
                    break;
                case "searchByVendorName":
                    matches = t.getVendor().toUpperCase().contains(insertedVendorName);
                    break;

            };

            if (matches) {
                found = true;
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
            }
        }
        if (!found) {
            System.out.println("No transactions found.");
        }

    }

}
