<jsp:include page="menu.jsp"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .passwordField{
            box-sizing: border-box;
			display: block;
                                              width: 100%;
		    padding: 0.375rem 0.75rem;
		    font-size: 1rem;
		    line-height: 1.5;
		    color: #495057;
		    background-color: #fff;
		    background-clip: padding-box;
		    border: 1px solid #ced4da;
		    border-radius: 0.25rem;
		    margin-top: 8px;
		    margin-bottom: 15px;
        }
    </style>
    <body>
      
        
        <div class="main-content">
            <div class="title">Sign Up</div>
            <div class="content">
            <form action="../SaveUser" method="post">
            <label>Username:</label><input type="text" name="username" />
            <label>Password:</label><input type="password" name="password" class="passwordField"/>

            <input type="submit" class="btn_success" value="Sign Up" />
             </form>
        </div>
            </div>
    </body>
</html>