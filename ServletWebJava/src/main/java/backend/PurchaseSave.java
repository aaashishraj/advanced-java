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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acer
 */
public class PurchaseSave extends HttpServlet {
   Connection con;
    @Override
    public void init() throws ServletException {
    
        try {
            con = DBConnect.connect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(itemSave.class.getName()).log(Level.SEVERE, null, ex);
        }
   
      
    }

    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       // normalWay(req, res);
        PreparedWay(req, res);
    }
    
    public void PreparedWay(HttpServletRequest req, HttpServletResponse res){
        
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        String itemDate = req.getParameter("itemDate");
        String itemClient = req.getParameter("itemClient");
        int itemQty = Integer.parseInt(req.getParameter("itemQty"));
        int itemPrice = Integer.parseInt(req.getParameter("itemPrice"));
        String itemRemarks = req.getParameter("itemRemarks");
    
        try {
            con = DBConnect.connect();
            String query = "INSERT INTO `tbl_purchase`(`item_id`, `date`, `client`, `quantity`, `price`, `remarks`) VALUES (?,?,?,?,?,?)";
            PreparedStatement stat  = con.prepareStatement(query);
            //binding parameter value
            stat.setInt(1, itemId);
            stat.setString(2, itemDate);
            stat.setString(3, itemClient);
            stat.setInt(4, itemQty);
            stat.setInt(5, itemPrice);
            stat.setString(6, itemRemarks);
            stat.executeUpdate();
            res.getWriter().println("inserted succesfully");
                    
                    
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }

    public void normalWay(HttpServletRequest req, HttpServletResponse res){
        String itemName = req.getParameter("itemName");
        int itemPrice = Integer.parseInt(req.getParameter("itemPrice"));
        try {
            Connection con = DBConnect.connect();
            String query = String.format("INSERT INTO `tbl_item`(`name`, `price`, `stock`, `photo`) VALUES ('%s', %d,0,'')",itemName,itemPrice);
            Statement stat  = con.createStatement();
            stat.executeUpdate(query);
            res.getWriter().println("inserted succesfully");
                    
                    
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
    }
    @Override
    public void destroy() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(itemSave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}