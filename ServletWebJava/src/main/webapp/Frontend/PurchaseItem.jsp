<%-- 
    Document   : PurchaseItem
    Created on : Apr 26, 2023, 9:24:03 AM
    Author     : Sudip
--%>
<jsp:include page="menu.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="main-content">
            <div class="title">PURCHASE FIELD</div>
            <div class="content">
                
        <form action="../PurchaseSave" method="post">
            <label>Item id</label> <input type="number" name="itemId"/>
            <label>Item Date</label><input type="String" name="itemDate"/>
             <label>Client</label><input type="text" name="itemClient"/>
              <label>Item Qty</label><input type="number" name="itemQty"/>
               <label>Item Price</label><input type="number" name="itemPrice"/>
               <label>Remarks</label><textarea rows="50" cols="50" name="itemRemarks"></textarea>
            <input type="submit" />
        </form>
            </div>
        </div>
    </body>
</html>