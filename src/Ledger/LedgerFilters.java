package Ledger;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerFilters {
    public static class TransactionStore {
        public static ArrayList<TransactionsClass> allTransactions = new ArrayList<>();
    }

    public void getTransactionFromFile() {
        TransactionStore.allTransactions.clear();
        try {
            Scanner fileReader = new Scanner(new File("transactions.csv"));
            if (fileReader.hasNextLine()) {
                fileReader.nextLine();
            }
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] fields = line.split("\\|");

                String date = fields[0].trim();
                String time = fields[1].trim();
                String description = fields[2].trim();
                String vendor = fields[3].trim();
                double amount = Double.parseDouble(fields[4].trim());
                TransactionStore.allTransactions.add(new TransactionsClass(date, time, description, vendor, amount));
            }

            // Sort by date + time descending (latest first)
            TransactionStore.allTransactions.sort((t1, t2) -> {
                String dt1 = t1.getDate() + " " + t1.getTime();
                String dt2 = t2.getDate() + " " + t2.getTime();
                return dt2.compareTo(dt1);
            });

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void displayAllTransactionsFilter(String type) {
        getTransactionFromFile();

        switch (type) {
            case "displayDepositOnly":
                System.out.println("\n"+"********** Displaying Deposit Transactions **********");
                break;
            case "displayPaymentsOnly":
                System.out.println("\n"+"********** Displaying Payment Transactions **********");
                break;
            case "displayAllTransactions":
                System.out.println("\n"+"********** Displaying All Transactions **********");
                break;
            default:
                System.out.println("❌ Invalid filter type");
                return;
        }

        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("--------------------------------------------------------------------------------");

        for (TransactionsClass transaction : TransactionStore.allTransactions) {
            boolean shouldPrint;

            switch (type) {
                case "displayDepositOnly":
                    shouldPrint = transaction.getAmount() > 0;
                    break;
                case "displayPaymentsOnly":
                    shouldPrint = transaction.getAmount() <= 0;
                    break;
                case "displayAllTransactions":
                    shouldPrint = true;
                    break;
                default:
                    shouldPrint = false;
                    break;
            }

            if (shouldPrint) {
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount());
            }
        }
    }

}
