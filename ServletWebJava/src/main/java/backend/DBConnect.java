/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class DBConnect {
    public static Connection connect() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/inventory_db";
            String username="root";
            String password="";
            Connection con= DriverManager.getConnection(url,username,password);
            return con;
    }
}