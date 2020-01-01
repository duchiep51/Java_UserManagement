<%-- 
    Document   : index
    Created on : Nov 13, 2019, 2:56:53 PM
    Author     : Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="MainController">
            Username: <input type="text" name="txtUsername" value="admin"/> <br/>
            Password: <input type="password" name="txtPassword" value="1"/><br/>
            <input type="submit" name="action" value="Login"/>
        </form>
    </body>
</html>
