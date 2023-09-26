<%-- 
    Document   : searchOrder
    Created on : Jul 13, 2023, 7:39:28 AM
    Author     : windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="home">Quay lại home</a>
        <h1>Tra cứu đơn hàng</h1>
        <form action="searchOrder" method="get">
            <label>Nhập mã đơn hàng</label>
            <input type="text" name="oid" />
        </form>
        <h1 style='color:red'>${error}</h1>
    <c:if test="${listItem!=null}">
        <table border="1px">
            <tr>
                <th>Tên sản phẩm</th>
                <th>Số lượng</th>
                <th>Thành tiền</th>
                <th>Giảm giá</th>
                <th>Còn</th>
            </tr>
            <fmt:setLocale value = "vi_VN"/>
            <c:forEach items="${listItem}" var="i">
                <tr>
                    <td>${i.getProduct().getName()}</td>
                    <td>${i.quantity}</td>
                    <td><fmt:formatNumber value = "${i.getPrice()}" type = "currency"/></td>
                    <td>${i.getProduct().getDiscount()}</td>
                    <td><fmt:formatNumber value = "${i.getPrice()-i.getPrice()*i.getProduct().getDiscount()/100}" type = "currency"/></td>
                </tr>
            </c:forEach>
        </table>
         
        <c:set var="sum" value="0"></c:set>
            <c:forEach items="${listItem}" var="it" varStatus="status">
                <c:if test="${status.last eq true}">
                    <c:set var="tP" value="${sum + (it.getPrice()-it.getPrice()*it.getProduct().getDiscount()/100) * it.getQuantity()}"></c:set>
                    <p style='font-size: 23px'>Tổng số tiền cho đơn hàng: <fmt:formatNumber value = "${sum + (it.getPrice()-it.getPrice()*it.getProduct().getDiscount()/100) * it.getQuantity()}" type = "currency"/></p>
                </c:if>


                <c:set var="sum" value="${sum + (it.getPrice()-it.getPrice()*it.getProduct().getDiscount()/100) * it.getQuantity()}"></c:set>
            </c:forEach>
    </c:if>
    </body>
</html>
