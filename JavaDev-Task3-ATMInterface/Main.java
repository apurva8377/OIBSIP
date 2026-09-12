//////////////////////////////////////////////////////////////////////////////
//
// Project Name : Oasis Infobyte Internship (OIBSIP) - Java Development
// Task         : Task 3 - ATM Interface
// Author       : Apurva Vilas Shinde
// File         : Main.java
// Description  : Entry point for the ATM application.
// Date         : 2026-09-12
//
//////////////////////////////////////////////////////////////////////////////

public class Main 
{
    public static void main(String[] args)
    {
        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        atm.start();
    }
}
