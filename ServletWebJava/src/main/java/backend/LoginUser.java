/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shalon
 */
public class LoginUser extends HttpServlet {
Connection con;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String status = "active";
        con = DBConnect.connect();
        String query = "SELECT * FROM `tbl_user` WHERE username = ? AND password=? AND status = ? ";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setString(3, status);
        ResultSet result = stmt.executeQuery();
//        System.out.println(stmt.getUpdateCount());
        if(!result.next()){
            res.getWriter().println("wrong user password");
        }else{
            res.sendRedirect("frontend/menu.jsp");
        }
        
        
    } catch (ClassNotFoundException | SQLException ex) {
        res.getWriter().println("wrong user password");
        Logger.getLogger(LoginUser.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
        
}