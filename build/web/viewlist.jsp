<%-- 
    Document   : viewcart
    Created on : Nov 21, 2019, 7:36:16 AM
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
        <h1>Promotion List!</h1>
        <c:if test="${sessionScope.list != null}">
            <c:if test="${not empty sessionScope.list.getList()}" var="listUser">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>UserName</th>
                            <th>Rank</th>
                        </tr>
                    </thead>
                    <c:forEach items="${sessionScope.list.getList()}" var="account" varStatus="counter">
                        <tbody>
                            <tr>
                                <td>${counter.count}</td>
                                <td>${account.key}</td>
                                <td>
                                    <select name="listRank">
                                        <c:forEach var="i" begin="1" end="10" step="1">
                                            <option value="${i}" <c:if test="${account.value == i}">selected</c:if>>${i}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </c:if>
        </c:if>
        <form action="MainController">
            <input type="submit" name="action" value="Confirm"/>
        </form>
    </body>
</html>
