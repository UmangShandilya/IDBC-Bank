package SavingsAccount;

import Home.EstablishConnection;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class WithdrawInSavings
{
    public static void makeWithdraw()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the Account Number : ");
        long accountNumber = scan.nextLong();
        System.out.print("Please enter the amount to be withdrawn : ");
        int withdraw = scan.nextInt();
        Random random = new Random();
        int transactionid = random.nextInt(10000000);

        try
        {
            Connection connect = EstablishConnection.establish();
            String getBalanceQuery = "select balance from savingsaccount where AccountNumber = ?";
            PreparedStatement stmt = connect.prepareStatement(getBalanceQuery);
            stmt.setLong(1,accountNumber);
            ResultSet data = stmt.executeQuery();
            data.next();
            int balance = data.getInt(1);
            if(balance > 0 && withdraw < balance)
            {
                String query1 = "update SavingsAccount set Balance = ? where AccountNumber = ?";
                String query2 = "insert into SavingTransactions values(?,?,?,?,?,?)";
                PreparedStatement updateStmt = connect.prepareStatement(query1);
                PreparedStatement insertStmt = connect.prepareStatement(query2);
                updateStmt.setInt(1,balance - withdraw);
                updateStmt.setLong(2,accountNumber);
                updateStmt.executeUpdate();
                insertStmt.setLong(1,accountNumber);
                insertStmt.setInt(2,transactionid);
                insertStmt.setDate(3, Date.valueOf(java.time.LocalDate.now()));
                insertStmt.setInt(4,withdraw);
                insertStmt.setInt(5,0);
                insertStmt.setTime(6, Time.valueOf(java.time.LocalTime.now()));
                insertStmt.executeUpdate();
                System.out.println("Amount Withdrawn Successfully.");
                AccountDetailsAndTransactions.showTransactionDetails(transactionid,connect);
            }
            else
                System.out.println("Insufficient Account Balance.");
        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }
}
