<h2>Project goal:</h1>
<p>The goal of this project is to create a Java CLI (Command Line Interface) application that helps users track financial transactions, deposits, and payments, for business or personal use.</p>

<h2>Main Steps:</h2>
<ul>
  <li>Create a main file and call the homescreen class inside it.</li>
  <li>Create a CSV file to store all the transactions.</li>
  <li>Create 4 branches: Main, HomeScreen, AccountTransactions, and Ledger.</li>
</ul>

<h2>Project Features:</h2>
<p>Home Screen with main menu options:</p>
<ul>
   <li>Inside the <code>HomeScreen</code> class, <code>displayHomeScreen</code> method displays a menu in a <code>while</code> loop, allowing the user to choose between adding a deposit, making a payment, viewing the ledger, or 
        exiting.</li>
        <li>It uses a <code>Scanner</code> to read input, handles choices with a <code>switch</code> statement, and continues until the user selects "X" to exit.</li>
        <li>The logic for deposit and payment is handled by the <code>AccountTransactions</code> class, and ledger options are handled by the <code>LedgerScreen</code> class.</li>
</ul>

<h2>D) Add Deposit:</h3>
<img src="Images/AddDeposit.png" alt="Sample Output">

<h2>P) Make Payment (Debit):</h3>
<img src="Images/makePayment.png" alt="Sample Output">
<h2><strong>The following steps were applied for both Add Deposit and Make Payment actions:</strong></h2>
<ul>

   <li>In the <code>AccountTransactions</code> class, create a method called <code>handleTransactions</code>.</li>
        <li>The <code>handleTransactions</code> method takes a transaction type ("<code>addDeposit</code>" or "<code>makePayment</code>") and shows the appropriate heading.</li>
        <li>It collects user input for vendor name, amount (with numeric validation), and description.</li>
        <li>The current date and time are obtained using <code>LocalDateTime.now()</code> and formatted separately using <code>DateTimeFormatter</code> for display and saving.</li>
        <li>It adds a minus sign to the amount if it's a payment, formats the current date and time, and displays a confirmation summary.</li>
        <li>If confirmed, it writes the transaction to a CSV file; if not, it cancels the action and returns to the home screen.</li>
 
</ul>


<h2>L) View Ledger (Ledger Home Screen)</h3>
<ul>
 <li>Inside the <code>LedgerScreen</code> class, the <code>displayLedgerOptions()</code> method displays a menu with options to view all transactions, deposits, payments, generate reports, or return to the home screen.</li>
        <li>A <code>Scanner</code> object reads user input, and the input is converted to uppercase to ensure case-insensitivity.</li>
        <li>The method uses a <code>switch</code> statement to handle different choices based on the user’s input and performs actions accordingly.</li>
        <li>The method handles the transaction filtering to the <code>TransactionsFilters</code> class and the reports to the <code>Reports</code> class.</li>
</ul>
<ul>
  <li><h3>A) All - Display all entries</h3></li>
</ul>
<img src="Images/ledgerDisplayAll.png" alt="Sample Output">

<ul>
  <li><h3>D) Deposits - Display only the entries that are deposits into the account</h3></li>
</ul>
<img src="Images/ledgerDisplayDeposits.png" alt="Sample Output">

<ul>
  <li><h3>P) Payments - Display only the negative entries (or payments)</h2></li>
</ul>
<img src="Images/ledgerDisplayPayments.png" alt="Sample Output">

<h2><strong>The following steps were applied for Display all, Deposit only and payments only:</strong></h2>
<ul>
   <li>Inside the <code>TransactionsFilters</code> class, I created two methods called <code>getTransactionFromFile()</code> and <code>displayAllTransactionsFilter()</code>.</li>
        <li>The <code>getTransactionFromFile()</code> method reads data from a CSV file and stores transaction details (date, time, description, vendor, amount) in an ArrayList called <code>TransactionStore.allTransactions</code>.</li>
        <li>The <code>displayAllTransactionsFilter()</code> takes an argument. The method displays transactions based on the filter type provided, such as deposits, payments, or all transactions.</li>
        <li>A <code>switch</code> statement is used to handle different filter types, determining which transactions to display (deposits, payments, or all).</li>
        <li>A <code>for</code> loop iterates through each transaction in the <code>TransactionStore.allTransactions</code> ArrayList, checking if it matches the selected filter condition (deposit, payment, or all). If it matches, the transaction details are printed.</li>
        <li>The method checks each transaction to see if it matches the selected filter condition and then prints the transaction details accordingly.</li>
   


 <li><h3>R) Reports - A new screen that allows the user to run pre-defined reports or to run a custom search</h3></li>
  <ul>
    <li><h3>1) Month To Date: Month to Date" (MTD) means from the start of the current month up to today</h3></li>
     <br>
     <img src="Images/reports-monthToDate.png" alt="Sample Output">
     <br>
     <br>
     <li><h3>2) Previous Month: Previous Month refers to the entire month before the current one</h3></li>
     <br>
     <img src="Images/reports-PreviousMonth.png" alt="Sample Output">
     <br>
     <br>
     <li><h3>3) Year To Date: Year to Date (YTD) refers to the period from the beginning of the current year up to the present date</h3></li>
     <br>
     <img src="Images/reports-YearToDate.png" alt="Sample Output">
     <br>
     <br>
     <li><h3>4) Previous Year: Previous Year refers to the year that occurred immediately before the current year</h3></li>
     <img src="Images/reports-PreviousYear.png" alt="Sample Output">
     <br>
     <br>
     <li><h3>5) Search by Vendor: Prompt the user for the vendor name and display all entries for that vendor</h3></li>
     <img src="Images/reports-SearchByVendor.png" alt="Sample Output">
    
  
   
  </ul>
  <p>For those 5 conditions above I created:</p>
  <ul>
    <li>Created a class called <code>ReportFilters</code>, inside it created <code>filters()</code> method and it calls the <code>getTransactionFromFile</code> method from the <code>TransactionsFilters</code> class and displays them based 
        on the selected filter type(arguments), such as <code>monthToDate</code>, <code>previousMonth</code>, <code>yearToDate</code>, <code>previousYearr</code>, or <code>searchByVendorName</code>.</li>
        <li>The method checks for each filter type, setting the appropriate date range or vendor name to filter the transactions accordingly.</li>
        <li>A <code>for</code> loop iterates over all transactions, checking if each transaction meets the filter criteria based on the selected filter type.</li>
        <li>If a transaction matches the filter condition, it is displayed with relevant details such as date, time, description, vendor, and amount.</li>
        <li>If no matching transactions are found after checking all entries, the message "No transactions found." is displayed.</li>
  
  </ul>

  <br>
  <li><h3>6) Custom Search: Prompt the user for the following search values.</h3></li>
  <img src="Images/customSearch1.png" alt="Sample Output">
  <br>
  <br>
  <img src="Images/customSearch2.png" alt="Sample Output">
   <br>
  <br>
  <img src="Images/CustomSearch3.png" alt="Sample Output">
   <br>
  <br>
  <img src="Images/customSearch4.png" alt="Sample Output">
   <br>
  <br>
  <img src="Images/customSearch5.png" alt="Sample Output">
   <br>
  <br>
  <img src="Images/cusromSearch6.png" alt="Sample Output">

  <p>The customSearch class has the following applied: </p>
  <ul>
    <li>The <code>customSearchOptionDisplay()</code> method lets the user enter different search options like dates, description, vendor name, and amount to find specific transactions.</li>
        <li>The method calls <code>getTransactionFromFile()</code> to load the transaction data from a file. A <strong>for loop</strong> iterates over the transactions in the file to apply the filters.</li>
        <li>An <code>if</code> statement checks each transaction, ensuring that the search filters (start date, end date, description, vendor name, and amount) are not empty. If a filter is empty, it is skipped.</li>
        <li>Start and end dates are parsed from strings into <code>LocalDate</code> objects so that they can be compared properly (since dates need to be in a <code>LocalDate</code> format to compare correctly).</li>
        <li>If the transaction's date is before the start date or after the end date, it returns <code>false</code>, meaning the transaction doesn’t match the search criteria and is excluded from the results.</li>
        <li>For the description and vendor name, the method first checks if they are empty. If they are not empty, it converts both the entered values and the transaction values to lowercase and then uses the <code>contains()</code> method to check if the transaction description or vendor name contains the search term.</li>
        <li>The method checks if the amount (entered as a string) can be parsed into a <code>double</code> and if it matches the transaction's amount. If the amount can't be parsed correctly, the method skips the amount filter and continues checking other filters.</li>
        <li>When a transaction matches all search criteria, it shows the details (date, time, description, vendor, and amount) in a clear, formatted table.</li>
        <li>If no transactions match the search criteria, the method informs the user that no results were found.</li>

  </ul>
<br/>

  <ul>
    <li><h3>0) Back - go back to the ledger page</h3></li>
  </ul>
  <img src="Images/BackToLedgerScreen.png" alt="Sample Output">
 <br/>

  <ul>
    <li><h3>H) Home - go back to the home page</h2></li>
  </ul>
  <img src="Images/BackToHome.png" alt="Sample Output">

  <h2>X) Exit - Tell the program to stop running and close cleanly</h3>
  <img src="Images/exitX.png" alt="Sample Output">
</ul>

<h1>Interesting piece of my code</h1>
 <img src="Images/Interesting1.png" alt="Sample Output">
 <br>
 <br>
  <img src="Images/Interesting2 copy.png" alt="Sample Output">
  <br>
 <br>
   <img src="Images/Intersting3.png" alt="Sample Output">
   <br>
 <br>
 <p><strong>What makes this code interesting is:</strong></p>
  <br>
<ul>
   <li><strong>ArrayList in a Class:</strong> You can declare an ArrayList inside a class as static to make it globally available. This prevents the need to repeatedly declare it elsewhere, providing easy access throughout the program.</li>
   <br>

   <li><strong>Loading the File Once:</strong> The <code>getTransactionFromFile()</code> method loads the file once and stores the data in an ArrayList. This way, you can easily call the transactions from anywhere in the program without reloading the file, avoiding duplicate code and improving efficiency.</li>
   <br>

   <li><strong>Using <code>displayAllTransactionsFilter</code> with Switch Statements:</strong> The <code>displayAllTransactionsFilter</code> method takes an argument that determines which type of transactions to display. It uses a switch statement to assign a condition to a boolean variable (<code>shouldPrint</code>), which is then used to filter the transactions. This design simplifies the process of displaying different types of transactions based on user input.</li>
</ul>


