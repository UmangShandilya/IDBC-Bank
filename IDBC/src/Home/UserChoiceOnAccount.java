package Home;

import java.util.Scanner;
import SavingsAccount.*;
import PayAccount.*;

public class UserChoiceOnAccount
{
    //The method below gets user choice on account type and directs user to respective destination.
    public static void getUserChoiceOnAccountType()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the number corresponding to the account : ");
        int userChoice = scan.nextInt();
        while(userChoice < 1 || userChoice > 2)
        {
            System.out.println("Invalid choice.");
            System.out.print("Please enter the number corresponding to the account : ");
            userChoice = scan.nextInt();
        }
        if(userChoice == 1)
        {
            SavingsAccountHomeScreen.displaySavingsMenu();
        }
        else
        {
            PayAccountHomeScreen.displayPayAccountMenu();
        }
    }
}
