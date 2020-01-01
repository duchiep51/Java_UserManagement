<%-- 
    Document   : edit
    Created on : Nov 16, 2019, 7:53:54 PM
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
        <h1>Edit page!</h1>
        <%@include file="logout.jsp" %>
        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" src="js/additional-methods.js"></script>
        <script type="text/javascript">
            $(function() {
               $("#update").validate({
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
        <form action="MainController" method="POST" name="update" id="update"
              enctype="multipart/form-data">
            Username: <input type="text" name="txtUsername" value="${requestScope.INFO.username}" readonly="true"/><br/>
            Password: <input id="txtPassword" type="password" name="txtPassword" value="" /><br/>
            Confirm password <input type="password" name="txtConfirm" value=""/><br/>
            Fullname: <input type="text" name="txtFullname" value="${requestScope.INFO.fullname}"/><br/>
            Email: <input type="text" name="txtEmail" value="${requestScope.INFO.email}" /><br/>
            Phone: <input type="text" name="txtPhone" value="${requestScope.INFO.phone}" /><br/>
            Photo <input type="file" name="fileUp" value="${requestScope.INFO.photo}"/><br/>
            Role: <select name="cboRoleid">
                <c:if test="${requestScope.ROLE != null}">
                    <c:if test="${not empty requestScope.ROLE}" var="listRole">
                        <c:forEach items="${requestScope.ROLE}" var="role">
                            <option value="${role.roleid}"<c:if test="${requestScope.INFO.roleid eq role.roleid}">selected</c:if>>${role.rolename}</option>
                    </c:forEach>
                </c:if>
            </c:if>
            </select><br/>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="action" value="Update" />
        </form>
    </body>
</html>
