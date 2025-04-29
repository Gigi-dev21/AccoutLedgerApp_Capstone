package Ledger;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionsFilters {
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

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void displayDepositOnly(){
        getTransactionFromFile();
        System.out.println("**********************Displaying Deposit Transactions Only************************");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("--------------------------------------------------------------------------------");
        for (TransactionsClass transaction : TransactionStore.allTransactions) {
            if (transaction.getAmount() > 0) {
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount());
            }
        }
    }

    public void displayPaymentsOnly(){
        getTransactionFromFile();
        System.out.println("*********************** Displaying Payment Transactions Only *************************");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("--------------------------------------------------------------------------------");
        for (TransactionsClass transaction : TransactionStore.allTransactions) {
            if (transaction.getAmount() <= 0) {
                System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount());
            }
        }
    }

    public void displayAllTransactions() {
        getTransactionFromFile();
        System.out.println("**************************Displaying All Transactions*************************");
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (TransactionsClass transaction : TransactionStore.allTransactions) {
            System.out.printf("%-12s %-10s %-30s %-20s %10.2f%n",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
        }
    }
}
