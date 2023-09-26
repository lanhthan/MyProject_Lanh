<%-- 
    Document   : managerCustomer
    Created on : Jul 11, 2023, 6:04:29 PM
    Author     : windy
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
        <table border="1px">
            <tr>
                <th>Account</th>
                <th>Role</th>
                <th>CustomerID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Birthdate</th>
                <th>Address</th>
                <th>Phone</th>
            </tr>
            <c:forEach items="${listUser}" var="c">
                <tr>
                    <td>${c.account}</td>
                    <td>${c.role}</td>
                    <c:forEach items="${listCustomer}" var="cus">
                        <c:if test="${cus.uid eq c.id}">
                            <td>${cus.cid}</td>
                            <td>${cus.fname}</td>
                            <td>${cus.gender}</td>
                            <td>${cus.dob}</td>
                            <td>${cus.address}</td>
                            <td>${cus.phone}</td>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
