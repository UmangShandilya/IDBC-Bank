package PayAccount;

import Home.EstablishConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.Random;
import java.util.Scanner;

public class OpenAccount
{
    public static void openAccount()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name : ");
        String accountHolder = scan.nextLine();
        System.out.print("Please enter your Nationl ID number : ");
        int nationalID = scan.nextInt();
        System.out.print("Please enter your mobile number : ");
        long mobile = scan.nextLong();
        System.out.print("Please enter the amount to be deposited : ");
        int deposit = scan.nextInt();
        Random random = new Random();
        long accountNumber = random.nextLong(100000000000L);
        int transactionid = random.nextInt(10000000);

        try {
            Connection connect = EstablishConnection.establish();
            String query1 = "insert into PayAccount values(?,?,?,?,?,?)";
            String query2 = "insert into PayTransactions values(?,?,?,?,?,?)";
            PreparedStatement openStmt = connect.prepareStatement(query1);
            PreparedStatement insertStmt = connect.prepareStatement(query2);
            openStmt.setLong(1, accountNumber);
            openStmt.setString(2, accountHolder);
            openStmt.setInt(3, nationalID);
            openStmt.setLong(4, mobile);
            openStmt.setInt(5, deposit);
            openStmt.setDate(6, Date.valueOf(java.time.LocalDate.now()));
            openStmt.executeUpdate();
            insertStmt.setLong(1, accountNumber);
            insertStmt.setInt(2, transactionid);
            insertStmt.setDate(3, Date.valueOf(java.time.LocalDate.now()));
            insertStmt.setInt(4, 0);
            insertStmt.setInt(5, deposit);
            insertStmt.setTime(6, Time.valueOf(java.time.LocalTime.now()));
            insertStmt.executeUpdate();
            System.out.println("Account Opened Successfully.");
            AccountDetailsAndTransactions.showNewAccountDetails(accountNumber,accountHolder);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
