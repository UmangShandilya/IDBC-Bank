package SavingsAccount;
import Home.EstablishConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Interest
{
    public static void calculateInterest()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the Account Number : ");
        long accountNumber = scan.nextLong();
        try
        {
            Connection connect = EstablishConnection.establish();
            String query = "select accountnumber, accountholder, balance from savingsaccount where accountnumber = ?";
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setLong(1,accountNumber);
            ResultSet data = stmt.executeQuery();
            data.next();
            int balance = data.getInt(3);
            double interest = balance * 0.025d;
            System.out.printf("| %-15s | %-20s | %10s |%15s |%n", "Account Number", "Account Holder","Balance","Interest Amount");
            System.out.println("-----------------------------------------------------------------------");
            System.out.printf("| %-15s | %-20s | %10s |%15s |%n", data.getLong(1), data.getString(2), data.getInt(3), interest);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
