<%-- 
    Document   : productDetail
    Created on : Jun 30, 2023, 1:00:04 PM
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
        <script src="https://kit.fontawesome.com/b4227f65bf.js"></script>
        <style>
            * {
                /*font-family: 'Poppins', sans-serif;*/
                padding: 0;
                margin: 0;
                box-sizing: border-box;
                font-family: "Helvetica Neue", Helvetica, Arial,sans-serif;
            }

            #header {
                height: 30px;
                background-color: #333333;
                top: 0;
                left: 0;
                right: 0;

            }



            #nav{
                display: inline-block;
                float: right;
            }
            #nav li{
                display: inline-block;
                line-height: 30px;
                position: relative;
            }

            #nav > li > a {
                color: white;
                text-decoration: none;
                padding: 0px 24px;
                display: inline-block;
                font-family: none;
            }
            .contain {
                width: 94%;
                margin: 0 auto;
                margin-top: 53px;
                height: 454px;
                border: 2px solid #ff6600;
                border-radius: 5px;
                position: relative;
            }
            .img{

                /*background-image: url('${p.image}');*/
                width: 405px;
                height: 450px;
                /*                background-repeat: none;
                                background-size: cover;*/
                float: left;
                border-radius: 5px;
            }
            .content {
                margin-left: 65px;
                margin-top: 20px;
                float: left;
                width: 56%;
            }

            .title {
                font-size: 28px;
                font-weight: bold;
                display: inline;
            }
            .inStock{
                text-indent: 23px;
                color: #0066cc;
            }
            .price {
                text-decoration: line-through;
                color: #cccccc;
                font-size: 23px;
                margin-top: 10px;
            }
            .newPrice {
                color: red;
                font-size: 23px;
            }

            .category {
                margin-top: 20px;
                font-size:20px;
            }

            .description{
                text-indent: 23px;
                text-align: justify;
            }

            .buy-button{
                background-color: #ff6600;
                /*                background-color: #0066cc;*/
                border-radius: 5px;
                width: 190px;
                height: 40px;
                color: white;
                font-size: 19px;
                margin-right: 60px;
                margin-top: 60px;
            }

            .buy-button:hover{
                background-color: #ff9999;
                color: #ff6600;
            }
            .purchase-item{
                text-align: center;
                width: 216px;
                display: block;
                position: absolute;
                top: 180px;
                left: 458px;
                background: rgba(51,50,50,0.8);
                color: white;
                padding: 20px 20px;
                border-radius: 5px;
                display: none;
            }

        </style>
    </head>
    <body>
        <div id="header">

            <ul id="nav">
                <li><a href="searchOrder">Tra cứu đơn hàng</a></li>

                <c:if test="${sessionScope.account==null}">
                    <li><a href="register.jsp">Đăng kí</a></li>
                    <li><a href="login.jsp">Đăng nhập</a></li>
                    </c:if>
                    <c:if test="${sessionScope.account!=null}">
                    <li><a href="logout">Đăng xuất</a></li>
                    <li><a href="profile">Xin chào ${sessionScope.account.account}</a></li>
                    <li><a href="shopcart"><i class="fas fa-cart-shopping"></i></a></li>
                        </c:if>
            </ul>

        </div>
        <a href="listProduct" style="margin-left: 20px; margin-top: 40px">Quay lại</a>
        <div class="contain">
            <c:set var="p" value="${requestScope.product}"/>
            <!--            <div class="img" ></div>-->
            <img class="img" src="${p.image}"/>
            <div class="content">

                <p class="title">${p.name}</p><br/>
                <p class="inStock">Số lượng trong kho: ${p.stock}</p><br/>
                <fmt:setLocale value = "vi_VN"/>
                <c:choose>
                    <c:when test="${p.discount eq 0}">
                        <span class='price' style="text-decoration: none;color: red"><fmt:formatNumber value = "${p.price}" type = "currency"/></span>
                    </c:when>
                    <c:otherwise>
                        <span class='price'><fmt:formatNumber value = "${p.price}" type = "currency"/></span>
                        <span class="newPrice"><fmt:formatNumber value = "${p.price-p.price*p.discount/100}" type = "currency"/></span>
                    </c:otherwise>
                </c:choose>
                <br/>
                <p class="category">Danh mục: ${p.cateid}</p><br/>
                <p class="description">${p.description}</p><br/>
                <a href="addtocart?pid=${p.getId()}"><input type="button" value="Thêm vào giỏ hàng" class="buy-button" onclick="addToCart()"/></a>
                <a href=""><input type="button" value="Mua ngay" class="buy-button"/></a>

            </div>
            <div class="purchase-item" id="purchase-item">
                <p>Sản phẩm của bạn đã được thêm vào giỏ hàng</p>
            </div>
        </div>

        <script>
            function addToCart() {
                //for (let i = 0; i < 30; i++) {
                    document.getElementById("purchase-item").style.display = "block";
                //}
                //await 
                //setTimeout(addToCart(), 5000);
                //setInterval(addToCart(), 1000);
            }


        </script>
    </body>
</html>
