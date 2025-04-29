package Ledger;

import java.time.LocalDate;
import java.util.Scanner;

public class Reports {
    Scanner scanner = new Scanner(System.in);
    String reportChoice = "";
    ReportFilters reportFilters = new ReportFilters();
    CustomSearch customSearch= new CustomSearch();

    public void displayReportOptions() {
        while (!reportChoice.equals("0")) {
            System.out.println("************** Reports Screen **************");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back ");
            System.out.print("Please choose an option: ");
            reportChoice = scanner.nextLine().toUpperCase();

            switch (reportChoice) {
                case "1":
                    reportFilters.filters("monthToDate");
                    break;
                case "2":
                    reportFilters.filters("previousMonth");
                    break;
                case "3":
                    reportFilters.filters("yearToDate");
                    break;
                case "4":
                    reportFilters.filters("previousYear");
                    break;
                case "5":
                    reportFilters.filters("searchByVendorName");
                    break;
                case "6":
                    customSearch.customSearchOptionDisplay();
                    break;
                case "0":
                    System.out.println("Going back to the report page");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

    }
}