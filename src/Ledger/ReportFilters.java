package Ledger;

import java.time.LocalDate;
import java.util.Scanner;

public class ReportFilters {
    Scanner scanner = new Scanner(System.in);
    static LedgerFilters getTransactionFromFile = new LedgerFilters();

    LocalDate today = LocalDate.now();
    //withDayOfMonth(1) means 1st day of the same month,
    LocalDate startOfMonth = today.withDayOfMonth(1);

    //minusMonths(1) will subtract 1 from the month
    LocalDate firstDayOfPreviousMonth = today.minusMonths(1).withDayOfMonth(1);

   //withDayOfMonth(1) returns day of the same month - 1 day = last day of previous month
    LocalDate lastDayOfPreviousMonth = today.withDayOfMonth(1).minusDays(1);

    //withDayOfYear(1) give first day of current year (January 1st)
    LocalDate startOfYear = today.withDayOfYear(1);

    //minusYears(1) Moves to the same day of the previous year.
    LocalDate startOfPreviousYear = today.minusYears(1).withDayOfYear(1);

    //withMonth(12): Sets the month to December.,withDayOfMonth(31): Sets the day to the 31st, which is the last day of December.
    LocalDate endOfPreviousYear = today.minusYears(1).withMonth(12).withDayOfMonth(31);

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

        System.out.println("\n" + "**********************" + " " + display + " " + "**********************" + "\n" );
        System.out.printf("%-12s %-10s %-30s %-20s %-10s%n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("------------------------------------------------------------------------------------------------------------");


        for (TransactionsClass t : LedgerFilters.TransactionStore.allTransactions) {
            if (t.getDate() == null || t.getTime() == null || t.getDescription() == null || t.getVendor() == null || t.getAmount() == 0) {
                continue;
            }

            LocalDate transactionDate = LocalDate.parse(t.getDate());
            boolean matches = false;

            switch (type) {
                case "monthToDate":
                    //it doesn't have to be before this current month and must not be after today(currentdate)
                    matches = !transactionDate.isBefore(startOfMonth) && !transactionDate.isAfter(today);
                    break;
                case "previousMonth":
                    //Must not be before first Day Of PreviousMonth and must not be after last Day Of Previous Month
                    matches = !transactionDate.isBefore(firstDayOfPreviousMonth) && !transactionDate.isAfter(lastDayOfPreviousMonth);
                    break;
                case "yearToDate":
                    //must not be before start Of the Year
                    matches = !transactionDate.isBefore(startOfYear);
                    break;
                case "previousYear":
                    //must not be before start Of Previous Year and end Of the Previous Year
                    matches = !transactionDate.isBefore(startOfPreviousYear) && !transactionDate.isAfter(endOfPreviousYear);
                    break;
                case "searchByVendorName":
                    matches = t.getVendor() != null && t.getVendor().toUpperCase().contains(insertedVendorName);
                    break;

            }
            ;

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
