/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PDBac
 */
public class DBUtil {
 public static Connection connectSQlserver() throws SQLException
    {
        Connection conn = null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"+"databaseName=PlaneManagement;"+"user=bac;"+"password=bac230789";
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Lỗi kết nối: "+e);
        }
        return conn;
    }
    
}
