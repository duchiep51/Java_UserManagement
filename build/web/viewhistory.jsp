<%-- 
    Document   : viewhistory
    Created on : Nov 21, 2019, 12:48:17 PM
    Author     : Hiep
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Promote History</h1>
        <c:if test="${requestScope.HISTORY != null}">
            <c:if test="${not empty requestScope.HISTORY}" var="history">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Rank</th>
                            <th>Time</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.HISTORY}" var="row">
                        <tbody>
                            <tr>
                                <td>${row.username}</td>
                                <td>${row.promotionrank}</td>
                                <td>${row.date}</td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </c:if>
        </c:if>

    </body>
</html>
