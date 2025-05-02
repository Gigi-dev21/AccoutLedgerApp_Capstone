package Ledger;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CustomSearch {

    public void customSearchOptionDisplay() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("************** Custom Search Screen **************");

        // start date input
        LocalDate startDate = null;
        while (true) {
            System.out.print("Enter start date (YYYY-MM-DD) or leave blank: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;
            try {
                startDate = LocalDate.parse(input);
                break;
            } catch (Exception e) {
                System.out.println("\n"+ "Invalid start date. Please use a valid date (YYYY-MM-DD)!!"+"\n");
            }
        }

        // End date input
        LocalDate endDate = null;
        while (true) {
            System.out.print("Enter end date (YYYY-MM-DD) or leave blank: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;
            try {
                endDate = LocalDate.parse(input);
                break;
            } catch (Exception e) {
                System.out.println("\n"+"Invalid end date. Please use a valid end date (YYYY-MM-DD)!!"+"\n");
            }
        }


        System.out.print("Enter description or leave blank: ");
        String descriptionInserted = scanner.nextLine().toLowerCase().trim();

        System.out.print("Enter vendor or leave blank: ");
        String vendorNameInserted = scanner.nextLine().toLowerCase().trim();

        Double amount = null;
        while (true) {
            System.out.print("Enter amount or leave blank: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;
            try {
                amount = Double.parseDouble(input);
                break;
            } catch (Exception e) {
                System.out.println("\n"+ "Invalid amount. Please enter a number!!"+"\n");
            }
        }


        new LedgerFilters().getTransactionFromFile();

        System.out.println("\n************************** Custom Search Results *************************\n");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("--------------------------------------------------------------------------------------------");

        boolean found = false;

        for (TransactionsClass t : LedgerFilters.TransactionStore.allTransactions) {
            boolean match = true;


            LocalDate transactionDateFromFile = LocalDate.parse(t.getDate());

            if (startDate != null && transactionDateFromFile.isBefore(startDate)){
                match = false;
            }
            if (endDate != null && transactionDateFromFile.isAfter(endDate)){
                match = false;
            }

            // Apply description, vendor, and amount filters
            if (!descriptionInserted.isEmpty() && !t.getDescription().toLowerCase().contains(descriptionInserted)) {
                match = false;
            }
            if (!vendorNameInserted.isEmpty() && !t.getVendor().toLowerCase().contains(vendorNameInserted)) {
                match = false;
            }
            if (amount != null && t.getAmount() != amount) {
                match = false;
            }

            if (match) {
                found = true;
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
            }
        }

        if (!found) {
            System.out.println("No transactions found!!");
        }
    }
}
