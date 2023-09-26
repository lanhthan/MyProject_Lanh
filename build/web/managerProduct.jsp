<%-- 
    Document   : managerProduct
    Created on : Jul 11, 2023, 9:57:39 AM
    Author     : windy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1 {
                text-align: center;
            }
            table {
                line-height: 35px;
                width: 100%;
            }
            p{
                text-align: center;
                margin-top: 20px;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <h1>Quản lí sản phẩm</h1>
        <a href="home">Quay về home</a>
        <form action="managerProduct">
<!--            <input type="submit" value="Thêm sản phẩm"/>-->
            <a href="managerProduct?action=add" style="text-align: center; display: block; margin-bottom: 20px">Thêm sản phẩm</a>
            <table border="1px">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Gender</th>
                    <th>Discount</th>
                    <th>Action</th>

                </tr>
                <c:forEach items="${listProduct}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>

                        <c:forEach items="${listCategory}" var="c">
                            <c:if test="${c.id == p.cateid}">
                                <td>${c.name}</td>
                            </c:if>
                        </c:forEach>
                        <td>${p.price}</td>
                        <td>${p.stock}</td>
                        <td>${p.gender}</td>
                        <td>${p.discount}</td>
                        <td style="display: flex; justify-content: space-around; align-items: center">
                            <a href="managerProduct?action=update&pid=${p.id}">Sửa</a>
                            <a href="managerProduct?action=delete&pid=${p.id}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </form>
    </body>
</html>
