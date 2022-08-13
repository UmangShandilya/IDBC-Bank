package Home;

import java.util.Scanner;

public class ApplicationExecution
{
    public static void main(String[] args)
    {
        HomeScreen.displayHomeScreen();
        UserChoiceOnAccount.getUserChoiceOnAccountType();
        Scanner scan = new Scanner(System.in);
        char userChoice;
        do
        {
            System.out.print("Do you want to go back to HOME MENU? [Y/N]: ");
            userChoice = scan.next().toUpperCase().charAt(0);
            if(userChoice == 'Y')
            {
                HomeScreen.displayHomeScreen();
                UserChoiceOnAccount.getUserChoiceOnAccountType();
            }
        }
        while(userChoice == 'Y');
        System.out.println("Thanks for using IDBC Banking Kiosk.");
    }
}
