package SavingsAccount;

import Home.EstablishConnection;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class TransferFunds
{
    public static void transferFunds()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to transfer into PAY ACCOUNT [Y/N]? : ");
        char userChoice = scan.next().toUpperCase().charAt(0);
        System.out.print("Please enter the Your Account Number : ");
        long accountNumber = scan.nextLong();
        System.out.print("Please enter the Beneficiary Account Number : ");
        long beneficiaryAccountNumber = scan.nextLong();
        System.out.print("Please enter the amount to be transferred : ");
        int deposit = scan.nextInt();
        Random random = new Random();
        int transactionid = random.nextInt(10000000);

        if(userChoice == 'Y')
        {
            try
            {
                Connection connect = EstablishConnection.establish();
                String getBalanceQuery = "select balance from savingsaccount where AccountNumber = ?";
                PreparedStatement stmt = connect.prepareStatement(getBalanceQuery);
                stmt.setLong(1,accountNumber);
                ResultSet data = stmt.executeQuery();
                data.next();
                int balance = data.getInt(1);
                String getBeneBalanceQuery = "select balance from payaccount where AccountNumber = ?";
                stmt = connect.prepareStatement(getBeneBalanceQuery);
                stmt.setLong(1,beneficiaryAccountNumber);
                data = stmt.executeQuery();
                data.next();
                int beneBalance = data.getInt(1);
                if(balance > 0 && deposit < balance)
                {
                    String query1 = "update SavingsAccount set Balance = ? where AccountNumber = ?";
                    PreparedStatement updateStmt = connect.prepareStatement(query1);
                    updateStmt.setInt(1,balance-deposit);
                    updateStmt.setLong(2,accountNumber);
                    updateStmt.executeUpdate();

                    String query2 = "update payaccount set Balance = ? where AccountNumber = ?";
                    updateStmt = connect.prepareStatement(query2);
                    updateStmt.setInt(1,beneBalance+deposit);
                    updateStmt.setLong(2,beneficiaryAccountNumber);
                    updateStmt.executeUpdate();

                    String query3 = "insert into SavingTransactions values(?,?,?,?,?,?)";
                    updateStmt = connect.prepareStatement(query3);
                    updateStmt.setLong(1,accountNumber);
                    updateStmt.setInt(2,transactionid);
                    updateStmt.setDate(3, Date.valueOf(java.time.LocalDate.now()));
                    updateStmt.setInt(4,deposit);
                    updateStmt.setInt(5,0);
                    updateStmt.setTime(6, Time.valueOf(java.time.LocalTime.now()));
                    updateStmt.executeUpdate();

                    String query4 = "insert into PayTransactions values(?,?,?,?,?,?)";
                    updateStmt = connect.prepareStatement(query4);
                    updateStmt.setLong(1,beneficiaryAccountNumber);
                    updateStmt.setInt(2,transactionid);
                    updateStmt.setDate(3, Date.valueOf(java.time.LocalDate.now()));
                    updateStmt.setInt(4,deposit);
                    updateStmt.setInt(5,0);
                    updateStmt.setTime(6, Time.valueOf(java.time.LocalTime.now()));
                    updateStmt.executeUpdate();

                    System.out.println("Amount Deposited Successfully.");
                    AccountDetailsAndTransactions.showTransactionDetails(transactionid,connect);
                }
                else
                    System.out.println("Insufficient Funds.");

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                Connection connect = EstablishConnection.establish();
                String getBalanceQuery = "select balance from savingsaccount where AccountNumber = ?";
                PreparedStatement stmt = connect.prepareStatement(getBalanceQuery);
                stmt.setLong(1,accountNumber);
                ResultSet data = stmt.executeQuery();
                data.next();
                int balance = data.getInt(1);
                String getBeneBalanceQuery = "select balance from payaccount where AccountNumber = ?";
                stmt = connect.prepareStatement(getBeneBalanceQuery);
                stmt.setLong(1,beneficiaryAccountNumber);
                data = stmt.executeQuery();
                data.next();
                int beneBalance = data.getInt(1);
                if(balance > 0 && deposit < balance)
                {
                    String query1 = "update SavingsAccount set Balance = ? where AccountNumber = ?";
                    PreparedStatement updateStmt = connect.prepareStatement(query1);
                    updateStmt.setInt(1,balance-deposit);
                    updateStmt.setLong(2,accountNumber);
                    updateStmt.executeUpdate();

                    String query2 = "update SavingsAccount set Balance = ? where AccountNumber = ?";
                    updateStmt = connect.prepareStatement(query2);
                    updateStmt.setInt(1,beneBalance+deposit);
                    updateStmt.setLong(2,beneficiaryAccountNumber);
                    updateStmt.executeUpdate();

                    String query3 = "insert into SavingTransactions values(?,?,?,?,?,?)";
                    updateStmt = connect.prepareStatement(query3);
                    updateStmt.setLong(1,accountNumber);
                    updateStmt.setInt(2,transactionid);
                    updateStmt.setDate(3, Date.valueOf(java.time.LocalDate.now()));
                    updateStmt.setInt(4,deposit);
                    updateStmt.setInt(5,0);
                    updateStmt.setTime(6, Time.valueOf(java.time.LocalTime.now()));
                    updateStmt.executeUpdate();

                    String query4 = "insert into SavingTransactions values(?,?,?,?,?,?)";
                    updateStmt = connect.prepareStatement(query4);
                    updateStmt.setLong(1,beneficiaryAccountNumber);
                    updateStmt.setInt(2,transactionid);
                    updateStmt.setDate(3, Date.valueOf(java.time.LocalDate.now()));
                    updateStmt.setInt(4,deposit);
                    updateStmt.setInt(5,0);
                    updateStmt.setTime(6, Time.valueOf(java.time.LocalTime.now()));
                    updateStmt.executeUpdate();

                    System.out.println("Amount Deposited Successfully.");
                    AccountDetailsAndTransactions.showTransactionDetails(transactionid,connect);
                }
                else
                    System.out.println("Insufficient Funds.");

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}
