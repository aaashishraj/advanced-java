<jsp:include page="menu.jsp"/>
<% 
 String id=   session.getAttribute("id").toString();
  
 String itemName=   session.getAttribute("itemName").toString();
  String itemPrice=  session.getAttribute("itemPrice").toString(); 

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="main-content">
            <div class="title">Update Item</div>
            <div class="content">
                
        <form action="../UpdateItem" method="post">
            <input type="hidden" name="id" value="<%= id %>"/>
            <label>Item Name</label> <input type="text" name="itemName" value="<%= itemName%>"/>
            <label>Item Price</label><input type="text" name="itemPrice" value="<%= itemPrice%>"/>
            <input type="submit"  />
        </form>
            </div>
        </div>
    </body>
</html>