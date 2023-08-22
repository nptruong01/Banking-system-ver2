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
 * @author Son Thuol
 */
public class MySQLConnection {
    public Connection ConnectMySQL(){
        Connection connec = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
           // connec = DriverManager.getConnection("jdbc:mysql://localhost/doan_dbms?" + "user=root");
           connec = DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=bank; user=sa;password=123456");
//          System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
//          System.out.println("Ket noi khong hop le");
            e.printStackTrace();
        }
        return connec;
    } 
}
