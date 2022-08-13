package Home;

import java.sql.Connection;
import java.sql.DriverManager;

public class EstablishConnection
{
    static Connection connect;
    public static Connection establish()
    {
        try
        {
            String user = "root";
            String password = "Innovative@1";
            String url = "jdbc:mysql://localhost:3306/idbc";
            connect = DriverManager.getConnection(url,user,password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return connect;
    }
}
