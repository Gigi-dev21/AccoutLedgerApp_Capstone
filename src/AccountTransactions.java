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



    public void handleTransactions(String type){
        System.out.println("\n"+ "-- " + (type.equals("addDeposit") ? "Add Deposit" : "Make Payment") + " --");

        System.out.print("Please enter vendor name: ");
        String vendorName = scanner.nextLine();

        double amount = 0;
        while (true) {
            System.out.print("Please enter the amount: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        System.out.print("Please enter a description: ");
        String description = scanner.nextLine();

        // Display the users input
        System.out.println(
                "\n"+ "Date: " + formattedDate + "\n" +
                        "Time: " + formattedTime + "\n" +
                        "Vendor Name: " + vendorName + "\n" +
                        "Amount: $" + amount + "\n" +
                        "Description: " + description + "\n" +
                        "\nIs this information correct? (Y/N): "
        );

        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equalsIgnoreCase("y")) {
            try {
                FileWriter fileWriter = new FileWriter("transactions.csv", true);
                String sign = type.equals("makePayment") ? "-" : "";
                fileWriter.write(formattedDate + "|" + formattedTime + "|" + description + "|" + vendorName + "|" + sign + amount + "\n");
                System.out.println(type.equals("addDeposit") ? "✅ Deposit saved successfully!" : "✅ Payment made successfully!");
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(" Error saving transaction:: " + e.getMessage());
            }
        } else {
            System.out.println("Returning to Home screen, Please re-enter the correct information.");
        }
    }







}
