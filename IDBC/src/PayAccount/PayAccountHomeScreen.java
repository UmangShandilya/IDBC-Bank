package PayAccount;

public class PayAccountHomeScreen
{
    public static void displayPayAccountMenu()
    {
        System.out.println("        PAY ACCOUNT MENU        ");
        System.out.printf("| %-5s | %-20s | %n","SNo.","Facilities");
        System.out.println("________________________________");
        System.out.printf("| %-5s | %-20s | %n","1","Open Account");
        System.out.printf("| %-5s | %-20s | %n","2","Deposit");
        System.out.printf("| %-5s | %-20s | %n","3","Withdraw");
        System.out.printf("| %-5s | %-20s | %n","4","Balance Enquiry");
        System.out.printf("| %-5s | %-20s | %n","5","Transfer Funds");
        System.out.printf("| %-5s | %-20s | %n","6","Statement");
        System.out.println();
        UserChoiceOnPayFacilities.getUserChoiceOnFacilities();
    }
}
