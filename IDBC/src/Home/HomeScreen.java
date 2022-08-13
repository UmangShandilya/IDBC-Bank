package Home;

public class HomeScreen
{
    //The method below displays the information of Home Screen.
    public static void displayHomeScreen()
    {
        System.out.println("        IDBC BANK");
        System.out.println("--------------------------");
        System.out.println("Welcome to IDBC Bank Kiosk");
        System.out.println();
        System.out.println("        MAIN MENU    ");
        System.out.printf("| %-5s | %-15s | %n","SNo.","Account Type");
        System.out.println("___________________________");
        System.out.printf("| %-5s | %5s | %n","1","Savings Account");
        System.out.printf("| %-5s | %-15s | %n","2","Pay Account");
        System.out.println();
    }
}
