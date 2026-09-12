//////////////////////////////////////////////////////////////////////////////
//
// Project Name : Oasis Infobyte Internship (OIBSIP) - Java Development
// Task         : Task 3 - ATM Interface
// Author       : Apurva Vilas Shinde
// File         : Transaction.java
// Description  : Represents transaction metadata objects for logging.
// Date         : 2026-09-12
//
//////////////////////////////////////////////////////////////////////////////

public class Transaction
{
    private String type;
    private double amount;

    //////////////////////////////////////////////////////////////////////////////
    // Function Name : Transaction
    // Description   : Initializes a transaction object with a type and amount.
    // Input         : String type, double amount
    // Output        : None (Initializes Transaction instance)
    // Author        : Apurva Vilas Shinde
    // Date          : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public Transaction(String type, double amount)
    {
        this.type = type;
        this.amount = amount;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name : toString
    // Description   : Returns a formatted string representation of the transaction.
    // Input         : None
    // Output        : String formatted with type and amount
    // Author        : Apurva Vilas Shinde
    // Date          : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    @Override 
    public String toString()
    {
        return type + " : $" + amount;
    }
}