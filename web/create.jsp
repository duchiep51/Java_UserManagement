<%-- 
    Document   : create
    Created on : Nov 18, 2019, 2:57:51 PM
    Author     : Hiep
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="logout.jsp" %>
        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" src="js/additional-methods.js"></script>
        <script type="text/javascript">
            $(function() {
               $("#register").validate({
                   rules: {
                       txtUsername: {
                           required: true,
                           rangelength: [1,20]
                       },
                       txtPassword: {
                           required: true,
                           rangelength: [1,20]
                       },
                       txtConfirm: {
                           equalTo: "#txtPassword"
                       },
                       txtFullname: {
                           required: true,
                           rangelength: [1,50]
                       },
                       txtEmail: {
                           required: true,
                           email: true
                       },
                       txtPhone: {
                           required: true,
                           phoneUK: true
                       }
                   }
               });
            });
        </script>
        <h1>Create account!</h1>
        <form name="register" action="MainController" id="register"
              enctype="multipart/form-data" method="post">
            Username <input type="text" name="txtUsername" value=""/><br/>
            <c:if test="${requestScope.DUPLICATE != null}">
                ${requestScope.DUPLICATE}<br/>
            </c:if>
            Password <input type="password" name="txtPassword" value="" id="txtPassword"/><br/>
            Confirm password <input type="password" name="txtConfirm" value=""/><br/>
            FullName <input type="text" name="txtFullname" value=""/><br/>
            Email <input type="text" name="txtEmail" value=""/><br/>
            Phone <input type="text" name="txtPhone" value=""/><br/>
            Photo <input type="file" name="fileUp" value=""/><br/>
            Role: <select name="cboRoleid">
            <c:if test="${requestScope.ROLE != null}">
                <c:if test="${not empty requestScope.ROLE}" var="listRole">
                    <c:forEach items="${requestScope.ROLE}" var="role">
                        <option value="${role.roleid}">${role.rolename}</option> 
                    </c:forEach>
                </c:if>
            </c:if>
            </select><br/>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="action" value="Register"/>
        </form>
    </body>
</html>
