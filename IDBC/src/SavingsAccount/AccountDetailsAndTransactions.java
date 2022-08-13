package SavingsAccount;

import Home.EstablishConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountDetailsAndTransactions
{
    //The method below displays account information on successful creation.
    public static void showNewAccountDetails(Long accountNumber, String accountHolder)
    {
        System.out.println("IDBC ACCOUNT DETAILS");
        System.out.println("--------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Type   : Savings");
    }

    //The method below shows transaction details
    public static void showTransactionDetails(int transactionID, Connection connect) throws SQLException
    {
        String query = "select savingtransactions.*,savingsaccount.balance from savingtransactions join savingsaccount on(savingtransactions.accountnumber = savingsaccount.accountnumber) where transactionid = ?";
        PreparedStatement stmt = connect.prepareStatement(query);
        stmt.setInt(1,transactionID);
        ResultSet data = stmt.executeQuery();
        System.out.printf("| %-15s | %-10s | %10s | %10s | %10s | %10s |%10s |%n", "Account Number", "Transaction ID", "Date", "Withdraw", "Deposit","Transaction Time", "Balance");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        while(data.next())
        {
            System.out.printf("| %-15s | %-14s | %10s | %10s | %10s | %16s |%10s |%n", data.getLong(1), data.getInt(2), data.getDate(3), data.getInt(4), data.getInt(5),data.getTime(6),data.getInt(7));
        }
    }

    //The method below shows balance of an account
    public static void showBalance()
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
            System.out.printf("| %-15s | %-20s | %10s |%n", "Account Number", "Account Holder","Balance");
            System.out.println("-------------------------------------------------------");
            while(data.next())
            {
                System.out.printf("| %-15s | %-20s | %10s |%n", data.getLong(1), data.getString(2), data.getInt(3));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //The method below shows last 5 transaction details
    public static void showLastTransactionDetails()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the Account Number : ");
        long accountNumber = scan.nextLong();
        String query = "select * from savingtransactions where accountnumber = ? order by transactiontime desc limit 5 ";
        try
        {
            Connection connect = EstablishConnection.establish();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setLong(1,accountNumber);
            ResultSet data = stmt.executeQuery();
            System.out.printf("| %-15s | %-10s | %10s | %10s | %10s | %10s |%n", "Account Number", "Transaction ID", "Date", "Withdraw", "Deposit","Transaction Time");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            while(data.next())
            {
                System.out.printf("| %-15s | %-14s | %10s | %10s | %10s | %16s |%n", data.getLong(1), data.getInt(2), data.getDate(3), data.getInt(4), data.getInt(5),data.getTime(6));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
