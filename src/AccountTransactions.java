import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountTransactions {
    Scanner scanner = new Scanner(System.in);
    //Time and date formater//
    LocalDateTime currentDateTime = LocalDateTime.now();
    // Format date only
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = currentDateTime.format(dateFormatter);
    // Format time only
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedTime = currentDateTime.format(timeFormatter);

    public void addDeposit() {
        System.out.println("-- You chose to Add Deposit. --");
        System.out.print("Please enter vendor name: ");
        String vendorNameEntered = scanner.nextLine();

        System.out.print("Please enter the amount you want to pay: ");
        double amountEntered = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Please enter a description: ");
        String descriptionEntered = scanner.nextLine();

        //To confirm if its correct//
        System.out.println(
                "Date: " + formattedDate + "\n" +
                        "Time: " + formattedTime + "\n" +
                        "Vendor Name: " + vendorNameEntered + "\n" +
                        "Amount: $" + amountEntered + "\n" +
                        "Description: " + descriptionEntered + "\n" +
                        "\nIs this information correct? (Y/N): "
        );

        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equalsIgnoreCase("y")) {
            try {
                FileWriter fileWriter = new FileWriter("transactions.csv", true); // append mode
                fileWriter.write(formattedDate + "|" + formattedTime + "|" + descriptionEntered + "|" + vendorNameEntered + "|" + amountEntered + "\n");
                fileWriter.close();
                System.out.println("✅ Deposit information saved successfully!");
            } catch (Exception e) {
                System.out.println("An error occurred while saving the deposit: " + e.getMessage());
            }
        } else {
            System.out.println("Returning to Home screen, Please re-enter the correct information.");
        }
    }
}
