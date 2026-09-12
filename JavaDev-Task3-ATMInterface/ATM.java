//////////////////////////////////////////////////////////////////////////////
//
// Project Name : Oasis Infobyte Internship (OIBSIP) - Java Development
// Task         : Task 3 - ATM Interface
// Author       : Apurva Vilas Shinde
// File         : ATM.java
// Description  : Manages user authentication, menu loops, and banking transactions.
// Date         : 2026-09-12
//
//////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class ATM 
{
    private Bank bank;
    private Scanner scanner;

    //////////////////////////////////////////////////////////////////////////////
    // Function Name: ATM
    // Description  : Constructor to initialize the ATM with a Bank reference and Scanner.
    // Input        : Bank bank
    // Output       : None (Initializes ATM instance)
    // Author       : Apurva Vilas Shinde
    // Date         : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public ATM(Bank bank)
    {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name : start
    // Description   : Starts the ATM session, prompting for User ID and PIN with 3 attempt limits.
    // Input         : None
    // Output        : None
    // Author        : Apurva Vilas Shinde
    // Date          : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    public void start()
    {
        System.out.println("=====Welcom to the ATM Interface=====");
        int attempts = 3;

        while(attempts > 0)
        {
            System.out.print("Enter User ID : ");
            String userId = scanner.next();

            System.out.print("Enter 4-digit PIN : ");
            String pin = scanner.next();

            Account account = bank.getAccount(userId);
            if(account != null && account.validatePin(pin))
            {
                System.out.println("\nLogin Successful !");
                showMenu(account);
                return ;
            }
            else
            {
                attempts--;
                System.out.println("Invalid credentials. Attempts remaining : "+attempts);

            }
        }
        System.out.println("Too many incorrect attempts. Access locked.");
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name : showMenu
    // Description   : Displays the main menu and processes user navigation choices.
    // Input         : Account account
    // Output        : None
    // Author        : Apurva Vilas Shinde
    // Date          : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    private void showMenu(Account account)
    {
        int choice = 0;

        do
        {
            System.out.println("\n--------ATM Main Menu----------");
            System.out.println("1 : transaction History");
            System.out.println("2 : Withdraw");
            System.out.println("3 : Deposit");
            System.out.println("4 : Transfer");
            System.out.println("5 : Quit");
            System.out.print("Choose an option (1-5) : ");

            if(!scanner.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    printTransactionHistory(account);
                    break;
                case 2:
                    handleWithdraw(account);
                    break;
                case 3:
                    handleDeposit(account);
                    break;
                case 4:
                    handleTransfer(account);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
                    break;
            }
        }while (choice != 5);    
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name : printTransactionHistory
    // Description   : Prints all past transactions and the current balance for the session.
    // Input         : Account account
    // Output        : None
    // Author        : Apurva Vilas Shinde
    // Date          : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    private void printTransactionHistory(Account account)
    {
        System.out.println("\n------Transaction History------");

        if(account.getTransactionHistory().isEmpty())
        {
            System.out.println("No transaction made in this session.");
        }
        else
        {
            for(String tx : account.getTransactionHistory())
            {
                System.out.println(tx);
            }
        }

        System.out.println("Current Balance : $"+account.getBalance());
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name : handleWithdraw
    // Description   : Handles cash withdrawal requests after validating funds.
    // Input         : Account account
    // Output        : None
    // Author        : Apurva Vilas Shinde
    // Date          : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    private void handleWithdraw(Account account)
    {
        System.out.println("Enter amount to withdraw : $");

        double amount = scanner.nextDouble();

        if(account.withdraw(amount))
        {
            System.out.println("Withdrawal successful! New balance : $"+account.getBalance());
        }
        else
        {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
        }
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name : handleDeposit
    // Description   : Handles cash deposit requests and updates the account balance.
    // Input         : Account account
    // Output        : None
    // Author        : Apurva Vilas Shinde
    // Date          : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    private void handleDeposit(Account account)
    {
        System.out.println("Enter amount to deposit : $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful! New balance : $"+account.getBalance());
    }

    //////////////////////////////////////////////////////////////////////////////
    // Function Name : handleTransfer
    // Description   : Handles money transfers from the current account to a recipient account ID.
    // Input         : Account account
    // Output        : None
    // Author        : Apurva Vilas Shinde
    // Date          : 2026-09-12
    //////////////////////////////////////////////////////////////////////////////
    private void handleTransfer(Account account)
    {
        System.out.println("Enter recipient User ID : ");
        String recipientId = scanner.next();
        Account recipient = bank.getAccount(recipientId);

        if(recipient == null)
        {
            System.out.println("recipient account not found.");
            return;
        }

        if(recipient.getUserId().equals(account.getUserId()))
        {
            System.out.println("You cannot transfer money to your own account.");
            return;
        }

        System.out.print("Enter amount to transfer : $");
        double amount = scanner.nextDouble();

        if(account.withdraw(amount))
        {
            recipient.deposit(amount);
            account.addCustomTransaction("Transferred : -$" + amount + " to " + recipientId);
            recipient.addCustomTransaction("Received : +$"+ amount + " from "+account.getUserId());
            System.out.println("Transfer successful! New balance : $"+account.getBalance());
        }
        else
        {
            System.out.println("Transfer failed. Insufficient funds.");
        }
    }
}