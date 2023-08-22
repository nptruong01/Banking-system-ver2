/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author MSI-VN
 */
public class MyConnection {
    
//   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=khooto;"
//                    + "username=sa;password=123456"); 
    
    String hostName="localhost";
        String dbName="bank";
        String userName="sa";
        String passWord="123456";
        String connectionURL="jdbc:sqlserver://"+hostName+":1433;databasename="+dbName;
    private static MyConnection instant;

    private  MyConnection() {
    }
    public  static MyConnection getInstance()
    {
        if(instant==null)
        {
             instant = new MyConnection();
        }
        return instant;
    }
    public Connection getConnection()
    {
        Connection conn=null;
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             conn=DriverManager.getConnection(connectionURL, userName, passWord);
        }
        catch(Exception e)
        {
            
        }
        
        return conn;
    }
    public static void main(String[] args) {
        Connection conn=MyConnection.getInstance().getConnection();
        if(conn!=null)
        {
            System.out.println("Thành công");
        }
        else
        {
            System.out.println("Fail");
        }
    }
}
