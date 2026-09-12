//////////////////////////////////////////////////////////////////////////////
//
// Project Name : Oasis Infobyte Internship (OIBSIP) - Java Development
// Task         : Task 3 - ATM Interface
// Author       : Apurva Vilas Shinde
// File         : Account.java
// Description  : Encapsulates user account data, balances, and transaction history.
// Date         : 2026-09-12
//
//////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;

public class Account
{
    private String userId;
    private String pin;
    private double balance;
    private List<String> transactionHistory;

    //////////////////////////////////////////////////////////////////////////////
    // Function Name: Account
    // Description: Initializes an account with user ID, PIN, and initial balance.
    // Input: String userId, String pin, double initialBalance
    // Output: None (Initializes Account instance)
    // Author: Apurva Vilas Shinde
    // Date: 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public Account(String userId, String pin, double initialBalance)
    {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name: validatePin
    // Description: Validates whether the provided PIN matches the account's PIN.
    // Input: String inputPin
    // Output: boolean (true if match, false otherwise)
    // Author: Apurva Vilas Shinde
    // Date: 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public boolean validatePin(String inputPin)
    {
        return this.pin.equals(inputPin);
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name: getUserId
    // Description: Returns the user ID associated with this account.
    // Input: None
    // Output: String (user ID)
    // Author: Apurva Vilas Shinde
    // Date: 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public String getUserId()
    {
        return userId;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name: getBalance
    // Description: Returns the current balance of the account.
    // Input: None
    // Output: double (current balance)
    // Author: Apurva Vilas Shinde
    // Date: 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public double getBalance()
    {
        return balance;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name: deposit
    // Description: Deposits a positive amount into the account and logs the transaction.
    // Input: double amount
    // Output: None (void)
    // Author: Apurva Vilas Shinde
    // Date: 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public void deposit(double amount)
    {
        if(amount > 0)
        {
            balance = balance + amount;
            transactionHistory.add("Deposited : +$"+amount);
        }
    } 

    //////////////////////////////////////////////////////////////////////////////
    // Function Name: withdraw
    // Description: Withdraws a valid amount from the account if sufficient funds exist and logs it.
    // Input: double amount
    // Output: boolean (true if successful, false otherwise)
    // Author: Apurva Vilas Shinde
    // Date: 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public boolean withdraw(double amount)
    {
        if(amount > 0 && amount <= balance)
        {
            balance = balance - amount;
            transactionHistory.add("Withdrew : -$"+amount);
            return true;
        }
        return false;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name: addCustomTransaction
    // Description: Adds a custom transaction record (such as transfers) to the history log.
    // Input: String record
    // Output: None (void)
    // Author: Apurva Vilas Shinde
    // Date: 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public void addCustomTransaction(String record)
    {
        transactionHistory.add(record);
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name: getTransactionHistory
    // Description: Returns the full list of transaction history records for the current session.
    // Input: None
    // Output: List<String> (transaction history)
    // Author: Apurva Vilas Shinde
    // Date: 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public List<String> getTransactionHistory()
    {
        return transactionHistory;
    }
}