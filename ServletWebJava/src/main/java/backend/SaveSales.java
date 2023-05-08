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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class SaveSales extends HttpServlet {
 Connection con;

    @Override
    public void init() throws ServletException {
        
      try {
          con = DBConnect.connect();
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(PurchaseSave.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(PurchaseSave.class.getName()).log(Level.SEVERE, null, ex);
      }
      
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       
      try {
          String item_id = req.getParameter("item_id");
          String price = req.getParameter("itemPrice");
          String quantity = req.getParameter("itemQuantity");
          
          String query = "INSERT INTO `tbl_purchase`( `item_id`, `quantity`, `price`) VALUES (?,?,?) ";
          String query1="UPDATE `tbl_item` SET `stock`= (SELECT stock from tbl_item WHERE id= ?)- ? WHERE id=?";
          
          PreparedStatement obj = con.prepareStatement(query);
          
          obj.setString(1, item_id);
          obj.setString(2, quantity);
          obj.setString(3, price);
          
          obj.executeUpdate();
          
          PreparedStatement obj2 = con.prepareStatement(query1);
          obj2.setString(1, item_id);
          obj2.setString(2, quantity);
          obj2.setString(3, item_id);
          
          obj2.executeUpdate();
          
          HttpSession session = req.getSession();
          session.setAttribute("successMsg","data inserted successfully");
          res.sendRedirect("frontend/menu.jsp");
          res.getWriter().println("purchase data inserted successfully");
      } catch (SQLException ex) {
         res.getWriter().println(ex.getMessage());
          Logger.getLogger(PurchaseSave.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    @Override
    public void destroy() {
        
      try {
          con.close();
      } catch (SQLException ex) {
          Logger.getLogger(PurchaseSave.class.getName()).log(Level.SEVERE, null, ex);
      }
        }
}