/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteItem extends HttpServlet {
Connection con;
    @Override
    public void init() throws ServletException {
    try {
        con = DBConnect.connect();
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(DeleteItem.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
        String query = "delete from tbl_item where id = ?";
        PreparedStatement  statement = con.prepareStatement(query);
        int id = Integer.parseInt(req.getParameter("id"));
        statement.setInt(1, id);
        statement.executeUpdate();
        res.getWriter().println("data deleted successfully");
        
                } catch (SQLException ex) {
                    res.getWriter().println(ex.getMessage());
        Logger.getLogger(DeleteItem.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    

    @Override
    public void destroy() {
    try {
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(DeleteItem.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}