package SavingsAccount;

public class SavingsAccountHomeScreen
{
    public static void displaySavingsMenu()
    {
        System.out.println("      SAVINGS ACCOUNT MENU        ");
        System.out.printf("| %-5s | %-20s | %n","SNo.","Facilities");
        System.out.println("________________________________");
        System.out.printf("| %-5s | %-20s | %n","1","Open Account");
        System.out.printf("| %-5s | %-20s | %n","2","Deposit");
        System.out.printf("| %-5s | %-20s | %n","3","Withdraw");
        System.out.printf("| %-5s | %-20s | %n","4","Balance Enquiry");
        System.out.printf("| %-5s | %-20s | %n","5","Transfer Funds");
        System.out.printf("| %-5s | %-20s | %n","6","Interest Calculation");
        System.out.printf("| %-5s | %-20s | %n","7","Statement");
        System.out.println();
        UserChoiceOnSavingsFacilities.getUserChoiceOnFacilities();
    }
}
