package PayAccount;

import Home.EstablishConnection;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class DepositInPay
{
    public static void makeDeposit()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the Account Number : ");
        long accountNumber = scan.nextLong();
        System.out.print("Please enter the amount to be deposited : ");
        int deposit = scan.nextInt();
        Random random = new Random();
        int transactionid = random.nextInt(10000000);

        try
        {
            Connection connect = EstablishConnection.establish();
            String getBalanceQuery = "select balance from payaccount where AccountNumber = ?";
            PreparedStatement stmt = connect.prepareStatement(getBalanceQuery);
            stmt.setLong(1,accountNumber);
            ResultSet data = stmt.executeQuery();
            data.next();
            int balance = data.getInt(1);
            String query1 = "update payaccount set Balance = ? where AccountNumber = ?";
            String query2 = "insert into paytransactions values(?,?,?,?,?,?)";
            PreparedStatement updateStmt = connect.prepareStatement(query1);
            PreparedStatement insertStmt = connect.prepareStatement(query2);
            updateStmt.setInt(1,deposit+balance);
            updateStmt.setLong(2,accountNumber);
            updateStmt.executeUpdate();
            insertStmt.setLong(1,accountNumber);
            insertStmt.setInt(2,transactionid);
            insertStmt.setDate(3, Date.valueOf(java.time.LocalDate.now()));
            insertStmt.setInt(4,0);
            insertStmt.setInt(5,deposit);
            insertStmt.setTime(6, Time.valueOf(java.time.LocalTime.now()));
            insertStmt.executeUpdate();
            System.out.println("Amount Deposited Successfully.");
            AccountDetailsAndTransactions.showTransactionDetails(transactionid,connect);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
