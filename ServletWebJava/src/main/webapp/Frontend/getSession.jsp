<%
    String token=session.getAttribute("token").toString();
    System.out.println(token);
    
    %>
    <%=token%>