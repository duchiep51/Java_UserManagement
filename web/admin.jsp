<%-- 
    Document   : admin
    Created on : Nov 13, 2019, 5:01:36 PM
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
        <h1>Welcome ${sessionScope.USERNAME}</h1>
        <h2>Search</h2>
        <%@include file="logout.jsp" %>
        <form action="MainController">
            UserName: <input type="text" name="txtSearch"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <form action="viewlist.jsp">
            <button type="submit"/>View Promotion List</button>
        </form>
        <form action="MainController">
            <button type="submit" name="action" value="Create">Create account</button>
        </form>
        <form action="MainController">
            <button type="submit" name="action" value="View history">View history</button>
        </form>
        <c:forEach items="${requestScope.TAG}" var="entry">
            ${entry.key}(${entry.value})
        </c:forEach>
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="listAccount">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Username</th>
                            <th>Fullname</th>
                            <th>Phone</th>
                            <th>Photo</th>
                            <th>Delete</th>
                            <th>Update</th>
                            <th>Promote</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.INFO}" var="account" varStatus="counter">
                    <tbody>
                        <tr>
                            <td>${counter.count}</td>
                            <td>${account.username}</td>
                            <td>${account.fullname}</td>
                            <td>${account.phone}</td>
                            <td><img src="images/${account.photo}" height="50px" width="50px"/></td>
                            <td>
                                <form action="MainController">
                                    <input type="hidden" name="username" value="${account.username}"/>
                                    <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    <input type="submit" name="action" value="Delete"/>
                                </form>
                            </td>
                            <td>
                                <form action="MainController">
                                    <input type="hidden" name="username" value="${account.username}"/>
                                    <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    <input type="submit" name="action" value="Edit"/>
                                </form>
                            </td>
                            <td>
                                <form action="MainController" method="post">
                                    <input type="hidden" name="rank" value="5"/>
                                    <input type="hidden" name="username" value="${account.username}"/>
                                    <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    <input type="submit" name="action" value="Add to promotion list"/>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                    </c:forEach>
                </table>
                </c:if>
        </c:if>
    </body>
</html>
