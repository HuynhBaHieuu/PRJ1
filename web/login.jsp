<%-- 
    Document   : login
    Created on : May 7, 2025, 9:50:53 AM
    Author     : OS
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <% 
//        EL: Expression Language ~ ${requestScope.ten_bien} //requestScope ~ getAttribute();
//        JSTL: Java Servlet tag library 

        ArrayList<String> userList = new ArrayList();
        userList.add("HuynhBaHieu");
        userList.add("HuynhBaHieuu");
        userList.add("HuynhBaHieuuu");
        
        request.setAttribute("list_user", userList);
        %>
        <%
        //Viết code java
        String msg = (String) request.getAttribute("message_error");
        %>
        
        <%//= Nhận 1 giá trị trả về 1 biến để hiển thị ra màn hình client%>
        <h1>Login Form</h1>
        <form action="process" method="POST">
            <label>Username</label> <br>
            <input type="text" name="username" value="" /> <br><br>

            <label>Password</label> <br>
            <input type="password" name="password" value="" /> <br><br>

            <input type="submit"  value="login" />
        </form> 
        ${requestScope.message_error}
        <c:if test="${requestScope.message_error == null}">
            <h1>Hello World</h1>
        </c:if>
        
            <c:forEach var="tay" items="${requestScope.list_user}">
                <h1>${tay}</h1>
            </c:forEach>
                
    </body>
</html>

