package SavingsAccount;

import java.util.Scanner;

public class UserChoiceOnSavingsFacilities
{
    public static void getUserChoiceOnFacilities()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the number corresponding to the facility : ");
        int userChoice = scan.nextInt();
        while(userChoice < 1 || userChoice > 7)
        {
            System.out.println("Invalid choice.");
            System.out.print("Please enter the number corresponding to the account : ");
            userChoice = scan.nextInt();
        }
        switch (userChoice)
        {
            case 1 ->
                    OpenAccount.openAccount();
            case 2 ->
                    DepositInSavings.makeDeposit();
            case 3 ->
                    WithdrawInSavings.makeWithdraw();
            case 4 ->
                    AccountDetailsAndTransactions.showBalance();
            case 5 ->
                    TransferFunds.transferFunds();
            case 6 ->
                    Interest.calculateInterest();
            case 7 ->
                    AccountDetailsAndTransactions.showLastTransactionDetails();
        }
    }
}
