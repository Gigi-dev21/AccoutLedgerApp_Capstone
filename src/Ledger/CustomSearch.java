package Ledger;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CustomSearch {

    public void customSearchOptionDisplay() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("************** Custom Search Screen **************");


        System.out.print("Enter start date (YYYY-MM-DD) or leave blank: ");
        String startDateInserted = scanner.nextLine();

        System.out.print("Enter end date (YYYY-MM-DD) or leave blank: ");
        String endDateInserted = scanner.nextLine();

        System.out.print("Enter description or leave blank: ");
        String descriptionInserted = scanner.nextLine().toLowerCase();

        System.out.print("Enter vendor or leave blank: ");
        String vendorNameInserted = scanner.nextLine().toLowerCase();

        System.out.print("Enter amount or leave blank: ");
        String amountInserted = scanner.nextLine();


        new TransactionsFilters().getTransactionFromFile();

        System.out.println("\n"+ "************************** Custom Search Results *************************"+"\n");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("--------------------------------------------------------------------------------------------");

        boolean found = false;


        for (TransactionsClass t : TransactionsFilters.TransactionStore.allTransactions) {
            boolean match = true;

            // Handle start date filter
            if (!startDateInserted.isEmpty()) {
                try {
                    LocalDate startDate = LocalDate.parse(startDateInserted.trim());
                    if (LocalDate.parse(t.getDate()).isBefore(startDate)) {
                        match = false;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid start date format. Skipping start date filter.");
                    match = false;
                }
            }

            // Handle end date filter
            if (!endDateInserted.isEmpty()) {
                try {
                    LocalDate endDate = LocalDate.parse(endDateInserted.trim());
                    if (LocalDate.parse(t.getDate()).isAfter(endDate)) {
                        match = false;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid end date format. Skipping end date filter.");
                    match = false;
                }
            }

            // Handle description filter
            if (!descriptionInserted.isEmpty() && !t.getDescription().toLowerCase().contains(descriptionInserted)) {
                match = false;
            }

            // Handle vendor filter
            if (!vendorNameInserted.isEmpty() && !t.getVendor().toLowerCase().contains(vendorNameInserted)) {
                match = false;
            }

            // Handle amount filter
            if (!amountInserted.isEmpty()) {
                try {
                    double amount = Double.parseDouble(amountInserted);
                    if (t.getAmount() != amount) {
                        match = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount entered. Skipping amount filter.");
                    match = false;
                }
            }

            // If a transaction matches all filters, print the result
            if (match) {
                found = true;
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        t.getDate(),
                        t.getTime(),
                        t.getDescription(),
                        t.getVendor(),
                        t.getAmount());
            }
        }

        // If no matching transactions were found
        if (!found) {
            System.out.println("No transactions found matching your search criteria.");
        }
    }
}
