package PayAccount;

import java.util.Scanner;

public class UserChoiceOnPayFacilities
{
    public static void getUserChoiceOnFacilities()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the number corresponding to the facility : ");
        int userChoice = scan.nextInt();
        while(userChoice < 1 || userChoice > 6)
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
                    DepositInPay.makeDeposit();
            case 3 ->
                    WithdrawInPay.makeWithdraw();
            case 4 ->
                    AccountDetailsAndTransactions.showBalance();
            case 5 ->
                    TransferFunds.transferFunds();
            case 6 ->
                    AccountDetailsAndTransactions.showLastTransactionDetails();
        }
    }
}
