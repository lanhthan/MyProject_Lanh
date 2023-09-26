<%-- 
    Document   : addProduct
    Created on : Jul 11, 2023, 8:57:14 AM
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
            form{
                margin-left: 20%;
                height: 23px;
            }
            label{
                width: 150px;
                display: inline-block;
                line-height: 34px;
                font-size: 19px;
            }
            input, select{
                line-height: 30px;
                width: 250px;
                margin-top: 23px;
            }
            select{
                font-size: 19px;
            }
            .add {
                font-size: 23px;
                margin-left: 75px;
            }
        </style>
    </head>
    <body>
        <h1>Thêm sản phẩm</h1><hr>
<!--        <h1 style="color: red">${error}</h1>-->
        <form action="addProduct" method="post">
            <label for="name">Tên sản phẩm</label>
            <input type="text" name="name"/><br>
            <label for="category">Danh mục</label>
            <select name="category">
                <c:forEach items="${listCategory}" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </select>
            <br>
            <label for="price">Giá sản phẩm</label>
            <input type="text" name="price"/><br>
            <label for="stock">Số lượng trong kho</label>
            <input type="text" name="stock"/><br>
            <label for="gender">Đối tượng sử dụng</label>
            <select name="gender">
                <option selected value="Female">Female</option>
                <option value="Male">Male</option>
                <option value="Other">Other</option>
            </select><br>
            <label for="description">Mô tả sản phẩm</label>
            <input type="text" name="description"/><br>
            <label for="image">Ảnh sản phẩm</label>            
            <input type="text" name="image"/><br>
            <label for="discount">Giảm giá</label>
            <input type="text" name="discount"/><br>
            <input type="submit" value="Thêm" class="add" name="action"/>
        </form>
    </body>
</html>
