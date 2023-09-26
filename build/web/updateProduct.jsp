<%-- 
    Document   : updateProduct
    Created on : Jul 11, 2023, 5:12:26 PM
    Author     : windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>Cập nhật sản phẩm</h1><hr>
<!--        <h1 style="color: red">${error}</h1>-->
        <form action="updateProduct" method="post">
            
            <c:set var="p" value="${product}"></c:set>
            <c:set var="c" value="${listCategory}"></c:set>
            <input type="hidden" name="productID" value="${p.id}"/>
                <label for="name">Tên sản phẩm</label>
                <input type="text" name="name" value="${p.name}"/><br>
            <label for="category">Danh mục</label>
            <select name="category">
                <c:forEach items="${listCategory}" var="c">
                    <c:choose>

                        <c:when test="${p.cateid eq c.name}">
                            <option value="${c.id}" selected>${c.name}</option>
                        </c:when>


                        <c:otherwise>
                            <option value="${c.id}">${c.name}</option>
                        </c:otherwise>

                    </c:choose>
                </c:forEach>

            </select>
            <br>
            <label for="price">Giá sản phẩm</label>
            <input type="text" name="price" value="${p.price}"/><br>
            <label for="stock">Số lượng trong kho</label>
            <input type="text" name="stock" value="${p.stock}"/><br>
            <label for="gender">Đối tượng sử dụng</label>
            <select name="gender">
                
                <c:choose>

                    <c:when test="${p.gender eq 'Female'}">
                        <option selected value="Female">Female</option>
                        <option value="Male">Male</option>
                        <option value="Other">Other</option>
                    </c:when>
                    <c:when test="${p.gender eq 'Male'}">
                        <option value="Female">Female</option>
                        <option selected value="Male">Male</option>
                        <option value="Other">Other</option>
                    </c:when>

                    <c:otherwise>
                        <option value="Female">Female</option>
                        <option  value="Male">Male</option>
                        <option selected value="Other">Other</option>
                    </c:otherwise>

                </c:choose>

                
            </select><br>
            <label for="description">Mô tả sản phẩm</label>
            <input type="text" name="description" value="${p.description}"/><br>
            <label for="image">Ảnh sản phẩm</label>            
            <input type="text" name="image" value="${p.image}"/><br>
            <label for="discount">Giảm giá</label>
            <input type="text" name="discount" value="${p.discount}"/><br>
            <input type="submit" value="Cập nhật" class="add" name="action"/>
        </form>
    </body>
</html>
