Project goal: 
  -The goal of this project is to create a Java CLI (Command Line Interface) application that helps users track financial transactions, deposits and payments, for business or personal use.
  
Main Steps:
- Create a main file and call the homescreen mthod inside.
- Create a csv file to store all the transactions.
- Create 3 branch: HomeScreen, AccountTransactions and Ledger

Project Features: 
  - Home Screen with main menu options:
     - Create a new file and make a class named HomeScreen
     - Inside the class, create a method called displayHomeScreen
     - Declare a Scanner object to handle user input and assist with file writing operations.
     - Inside the method, create a while loop that continuously displays the home screen options until the user chooses to exit (inputs "X").
     - Inside the method declare a while loop, and diplay the homescreen options until exit is insreted by user
     - Within the loop, use a switch statement to handle different menu choices:
         - D) Add Deposit:
             - In the AccountTransactions class, create a method called addDeposit.
             - Inside the method:
                - Use a scanner object to access the user inputs. 
                - Prompt the user to enter the deposit amount, description, and vendor name, and store these inputs in variables.
                - If not inserted a number/double, create a condition to avoid errors.
                - Display the user input and ask if it correct or not, if yes continue.
                - Use Java's date and time APIs to capture the current timestamp.
                - Use a Filewriter to write in the csv file.
                - Save the transaction details to a file as a properly formatted record.
                - Once all done, call it from the HomeScreen class when the user selects the "D" option (for Deposit) in the home screen menu.
         - P) Make Payment (Debit):
             - In the AccountTransactions class, create a method called makePayment.
             - Inside the method:
                - Repeat same steps as Add deposit
         - L) View Ledger
              
         - X) Exit 
  
