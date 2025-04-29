Project goal: 
  -The goal of this project is to create a Java CLI (Command Line Interface) application that helps users track financial transactions, deposits and payments, for business or personal use.
  
Main Steps:
- Create a main file and call the homescreen class inside it.
- Create a csv file to store all the transactions.
- Create 4 branch: Main, HomeScreen, AccountTransactions and Ledger

Project Features: 
  - Home Screen with main menu options:
     - Create a new file and make a class named HomeScreen
     - Inside the class, create a method called displayHomeScreen
     - Declare a Scanner object to handle user input and assist with file writing operations.
     - Inside the method, create a while loop that continuously displays the home screen options until the user chooses to exit (inputs "X").
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
             - Create a new file inside the ledger folder called LedgerScreen.
             - Declare a Scanner object to handle user input.
             - Inside a ledgerScreen class, create displayLedgerOptions methods.
             - Inside the displayLedgerOptions, create a while loop that continuously displays the ledger screen options until the user chooses to exit (inputs "H").
             - Within the loop, use a switch statement to handle different menu choices:
                - A) All - Display all entries
                  
                - D) Deposits - Display only the entries that are deposits into theaccount
                - P) Payments - Display only the negative entries (or payments)
                - R) Reports - A new screen that allows the user to run pre-defined reports or to run a custom search
                     - 1) Month To Date
                     - 2) Previous Month
                     - 3) Year To Date
                     - 4) Previous Year
                     - 5) Search by Vendor - prompt the user for the vendor nameand display all entries for that vendor
                     - 6) Custom Search - prompt the user for the following search values.
                     - 0) Back - go back to the ledger page
                - H) Home - go back to the home page
              
         - X) Exit
            - Tell the program to stop running and close cleanly. 
           
  
