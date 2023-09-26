<%-- 
    Document   : product
    Created on : Jun 25, 2023, 3:31:25 PM
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
        <style>
            * {
                /*font-family: 'Poppins', sans-serif;*/
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            .menu{
                background-color: white;

            }

            .menu img{
                position: relative;
                width: 50px;
                height: 50px;
                margin-left: 5px;
                margin-right: auto;

            }
            #menu2{
                display: inline-block;
                margin-left: 10px;
            }
            #menu2 li{
                display: inline-block;
                line-height: 46px;
                position: relative;
                margin-left: 5px;
            }
            #menu2 > li > a{
                color: black;
                text-decoration: none;
                display: inline-block;
                background-color: #fff;
                font-size: 23px;
                font-family: GeometricExtraBold;
                margin-right: 10px;
                font-weight: 900;
                text-transform: uppercase;

            }
            /*#menu2 > li:hover > a{
                color: white;
                background-color: #333333;
            }*/

            #menu2 .submenu{
                display: none;
                position: absolute;
            }
            #menu2 li:hover .submenu{
                display: block;
            }
            #menu2 .submenu li{
                width: 160px;
                background-color: white;
            }

            #menu2 .submenu li a{
                text-decoration: none;
                color: black;
                padding: 8px 16px;
            }
            #menu2 .submenu li:hover{

                background-color: #e4e1dc;
            }
            .line{
                border-right: #e3e2e2 2px solid;
                margin-top: 38px;
                height: 23px;
            }

            .search-icon{
                position: absolute;
                margin-left: 430px;
                margin-top: 50px;
                z-index: 1;
                padding-left: 5px;
            }
            .menu input{
                line-height: 23px;
                position: relative;
                margin-left: 430px;
                padding-left: 23px;
            }
            form{
                float: right;
                margin-top: 44px;
                margin-right: 12px;
            }
            .banner{
                margin-top: 20px;
                background-color: #e4e1dc;
                height: 550px;
            }
            .banner .advers-content{
                text-transform: uppercase;
                font-size: 18px;
                font-style: italic;
                padding-top: 10px;
                text-align: center;
                color: black;
                margin-bottom: 10px;
            }
            .banner-img{
                width: 100%;
                height: 500px;
            }
            .contain{
                float: left;
                width: 100%;
            }
            .category{
                width: 18%;
                float: left;
                margin-top: 50px;
            }
            .items > li{
                text-transform: uppercase;
                height: 45px;
                font-size: 25px;
                font-weight: 600;
                font-family: sans-serif;
                /* margin-top: 10px; */
                padding-bottom: 10px;
                padding-top: 8px;


            }
            .items > li:hover {
                background-color: #ff6600;

            }
            .items > li:hover > a{
                color: white;
            }
            .items > li > a{
                text-decoration: none;
                color: #ff6600;
                padding-left: 25px;
                width: 100%;
                display: block;
            }
            .horizotal {
                width: 100%;
                display: block;
                height: 3px;
                background-color: #cccccc;
                text-align: center;
            }
            .subItems{
                margin-top: 20px;
            }
            .subItems li {
                text-transform: none;
                font-size: 20px;
                padding-top: 10px;
                padding-bottom: 10px;
            }
            .subItems li:hover {
                background-color: black;
            }
            .subItems a {
                color: black;
                list-style: circle;
                text-decoration: none;
                font-weight: 600;
                padding-left: 35px;
                ;

            }
            .subItems > li:hover > a {
                color: white;
            }
            .product {
                float: right;
                margin-top: 50px;
                width: 78%;
            }
            .subProduct {

            }
            .productItems li{
                margin-left: 20px;
                list-style: none;
                float: left;
                width: 30%;
                height: 400px;
                border: 1px solid orange;
                margin-bottom: 20px;
            }
            .productItems li:hover {
                background-color: #e4e1dc;
                box-shadow: 5px 5px 5px grey;
            }
            .productItems img{
                width: 100%;
                height: 300px;
            }

            .productItems a {
                text-decoration: none;
            }
            .productItems .title {
                margin-top: 5px;
                color: black;
                font-size: 20px;
                text-align: center;
                font-weight: bold;
            }
            .price {
                text-decoration: line-through;
                color: #cccccc;
                display: block;
                margin-top: 10px;
                text-align: center;
            }
            .newPrice {
                color: red;
                display: block;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>

        <div class="menu">
            <img src="images/logosuperfinal.jpg"/>
            <ul id="menu2">
                <li><a href="listProduct">Sản phẩm
                        <i class="fas fa-chevron-down"></i>
                    </a>
                    <ul class="submenu">
                        <c:forEach items="${requestScope.listCategory}" var="c" >
                            <li><a href="listProduct?cateid=${c.id}">${c.name}</a></li>
                            </c:forEach>
                    </ul>
                </li>
                <li class="line"></li>
                <li><a href="listProduct?gender=Male">Nam</a></li>
                <li class="line"></li>
                <li><a href="listProduct?gender=Female">Nữ</a></li>
                <li class="line"></li>
                <li><a href="listProduct?status=sale">Sale-off</a></li>
            </ul>
            <i class="search-icon fas fa-magnifying-glass"></i>
            <form action="search" method="post">
                <input type="text" name="search" placeholder="Tìm kiếm"/>
            </form>

        </div>

        <div class="banner">
            <h6 class="advers-content">Bảo hành 3 năm - Đổi trả miễn phí - Bao ship toàn cầu</h6>
            <img class="banner-img" src="images/banner2.png"/>
        </div>
        <form action="listProduct">
            <input type="hidden" name="gender" value="${gender}"/>
            <input type="hidden" name="cateid" value="${cateid}"/>
            <input type="hidden" name="status" value="${status}"/>
            <label>Sort by price</label>
            <select name="sort">
                <option selected value="1">From highest to lowest</option>
                <option value="0">From lowest to highest</option>
            </select>
            <input type="submit" value="Sort"/>
        </form>
        <div class="contain">
            <div class="category">
                <ul class="items">
                    <li class="outer"><a href="listProduct">Sản phẩm</a></li>
                    <p class="horizotal"></p>
                    <li class="outer"><a href="listProduct?gender=Male">Nam</a></li>
                    <i class="horizotal"></i>
                    <li class="outer"><a href="listProduct?gender=Female">Nữ</a></li>
                    <i class="horizotal"></i>
                    <li class="outer"><a href="">Danh mục</a>
                        <ul class="subItems">
                            <c:forEach items="${listCategory}" var="c">
                                <li><a href="listProduct?cateid=${c.id}">${c.name}</a></li>
                                </c:forEach>

                        </ul>
                    </li>
                    <p class="horizotal"></p>
                </ul>            </div>
            <div class="product">
                <ul class="productItems">
                    <div class='subProduct'>
                        <c:forEach items="${listProduct}" var="p">
                            <li>
                                <a href="product?pid=${p.id}">
                                    <img src="${p.image}">
                                    <p class='title'>${p.name}</p>
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
                                </a>
                            </li>
                        </c:forEach>
                    </div>


                </ul>
            </div>
        </div>



    </body>
</html>
