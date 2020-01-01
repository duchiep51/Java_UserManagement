<%-- 
    Document   : user
    Created on : Nov 13, 2019, 5:01:54 PM
    Author     : Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome ${sessionScope.USERNAME}</h1>
        <h2>Search</h2>
        <%@include file="logout.jsp" %>
        <form action="MainController">
            UserName: <input type="hidden" name="txtUserSearch" value="${sessionScope.USERNAME}"/>
            <input type="submit" name="action" value="UserSearch"/>
        </form>
        <c:if test="${requestScope.INFO != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Fullname</th>
                            <th>Phone</th>
                            <th>Photo</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${requestScope.INFO.username}</td>
                            <td>${requestScope.INFO.fullname}</td>
                            <td>${requestScope.INFO.phone}</td>
                            <td><img src="images/${requestScope.INFO.photo}" height="50px" width="50px"/></td>
                            <td>
                                <form action="MainController">
                                    <input type="hidden" name="username" value="${requestScope.INFO.username}"/>
                                    <input type="submit" name="action" value="Edit"/>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>
        </c:if>
    </body>
</html>
