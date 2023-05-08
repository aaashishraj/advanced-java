/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SaveUser extends HttpServlet {
    Connection con;

    @Override
    public void init() throws ServletException {
        try {
            con = DBConnect.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String status = "pending";
            String query = "INSERT INTO `tbl_usr`( `username`, `password`, `status`) VALUES (?,?,?) ";
            PreparedStatement obj = con.prepareStatement(query);
            
            obj.setString(1, username);
            obj.setString(2, password);
            obj.setString(3, status);
            
            obj.executeUpdate();
            
            res.getWriter().println("user inserted successfully");
            
            
        } catch (SQLException ex) {
            res.getWriter().println(ex.getMessage());
            Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
      
    }

    @Override
    public void destroy() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}