//////////////////////////////////////////////////////////////////////////////
//
// Project Name : Oasis Infobyte Internship (OIBSIP) - Java Development
// Task         : Task 3 - ATM Interface
// Author       : Apurva Vilas Shinde
// File         : Bank.java
// Description  : Manages the collection of registered user accounts in the bank.
// Date         : 2026-09-12
//
//////////////////////////////////////////////////////////////////////////////

import java.util.HashMap;
import java.util.Map;

public class Bank 
{
    private Map<String, Account> accounts;

    //////////////////////////////////////////////////////////////////////////////
    // Function Name : Bank
    // Description   : Constructor to initialize the bank and populate sample accounts.
    // Input         : None
    // Output        : None (Initializes Bank instance)
    // Author        : Apurva Vilas Shinde
    // Date          : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public Bank()
    {
        accounts = new HashMap<>();

        // sample accounts for testing
        accounts.put("user1", new Account("user1", "1111", 1000.00));
        accounts.put("user2", new Account("user2", "2222", 500.00));
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name : getAccount
    // Description   : Retrieves an Account object matching the specified user ID.
    // Input         : String userId
    // Output        : Account object corresponding to the user ID, or null if not found
    // Author        : Apurva Vilas Shinde
    // Date          : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public Account getAccount(String userId)
    {
        return accounts.get(userId);
    }
}