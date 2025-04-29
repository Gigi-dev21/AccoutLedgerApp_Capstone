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
                    accountTransactions.addDeposit();
                    break;
                case "P":
                    accountTransactions.makePayment();
                    break;
                case "L":
                    Ledger ledger = new Ledger();
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
