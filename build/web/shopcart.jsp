<%-- 
    Document   : shopcart
    Created on : Jul 6, 2023, 8:18:48 AM
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
            .title {
                text-transform: uppercase;
                font-size: 30px;
                margin-left: 45%;
                margin-top: 20px;
            }
            table{
                width: 100%;
                text-align: center;
                margin-top: 10px;
                line-height: 30px;
            }
            .mess {
                /*                margin-left: 20px;*/
                margin-top: 20px;
                text-align: center;
            }
            .return {
                text-align: center;
                margin-top: 20px;
            }
            .sum {
                margin-left: 20px;
                margin-top: 30px;
                font-size: 23px;
            }
            .action {
                display: flex;
                justify-content: space-between;
                width: 95%;
                margin: 20px auto;
            }
            .back {
                /*text-decoration: none;*/
                color: #3399ff;
            }
            .changeQuantity{
                width: 20px;
            }
            .continue {
                float: right;
                color: #3399ff;
            }
            .back{
                text-decoration: none;
                font-size: 15px;
                height: 42px;
                width: 230px;
                background-color: #238ffd;
                color: white;
                border-radius: 5px;
            }
            .back:hover {
                background-color: orange;
            }
            .continue {
                text-decoration: none;
                font-size: 15px;
                height: 42px;
                width: 200px;
                border-radius: 5px;
                background-color: #238ffd;
                color: white;
            }
            .continue:hover {
                background-color: orange;
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


        <h1 class='title'>Giỏ hàng</h1>
        <hr>
        <c:if test="${requestScope.listItem==null}">
            <p class="mess">Giỏ hàng của bạn đang trống. Hãy đi mua sắm rồi quay lại đấy nhé!</p>
            <a href="home" ><p class="return">Quay lại trang chủ</p></a>
        </c:if>
        <c:if test="${requestScope.listItem!=null}">
            <table>
                <tr>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Giá sau giảm</th>
                    <th>Thành tiền</th>
                    <th>Xóa</th>
                </tr>
                <c:forEach items="${requestScope.listItem}" var="i">
                    <tr>
                        <td>${i.getProduct().getName()}</td>
                        <td>
                            <form action="changeQuantity" method="post">
                                <input type ="hidden" value="${i.getProduct().getId()}" name="iid"/>
                                <input type ="hidden" value="${i.getQuantity()}" name="quantity"/>
                                <input type="submit" value="-" class="changeQuantity" name="action"/>
                                ${i.getQuantity()}
                                <input type="submit" value="+" class="changeQuantity" name="action"/>
                            </form>
                        </td>

                        <fmt:setLocale value = "vi_VN"/>
                        <td><fmt:formatNumber value = "${i.getPrice()}" type = "currency"/></td>
                        <td><fmt:formatNumber value = "${i.getPrice()-i.getPrice()*i.getProduct().getDiscount()/100}" type = "currency"/></td>
                        <td><fmt:formatNumber value = "${(i.getPrice()-i.getPrice()*i.getProduct().getDiscount()/100) * i.getQuantity()}" type = "currency"/></td>
                        <td><a href="delete?id=${i.getProduct().getId()}">Xóa</a></td>
                    </tr>
                </c:forEach>


            </table>
            <c:set var="sum" value="0"></c:set>
            <c:forEach items="${requestScope.listItem}" var="it" varStatus="status">
                <c:if test="${status.last eq true}">
                    <c:set var="tP" value="${sum + (it.getPrice()-it.getPrice()*it.getProduct().getDiscount()/100) * it.getQuantity()}"></c:set>
                    <p class="sum">Tổng số tiền cho đơn hàng: <fmt:formatNumber value = "${sum + (it.getPrice()-it.getPrice()*it.getProduct().getDiscount()/100) * it.getQuantity()}" type = "currency"/></p>
                </c:if>


                <c:set var="sum" value="${sum + (it.getPrice()-it.getPrice()*it.getProduct().getDiscount()/100) * it.getQuantity()}"></c:set>
            </c:forEach>
            <div class="action">
                <form action="listProduct">
                    <input type="submit" class="back" value="Tiếp tục mua sắm"/>
                </form>
                <!--            <a href="listProduct" class="back">Tiếp tục mua sắm</a>-->
                <form action="order" method="post">
                    <input type="hidden" name="totalPrice" value="${tP}"/>
                    <input type="submit" class="continue" value="Thanh toán"/>
                </form>
            </div>
        </c:if>




        <!--<c:set var = "balance" value = "120000" />
        <c:set var = "balance2" value = "3" />
               <p>Currency in USA :
        <fmt:setLocale value = "vi_VN"/>
        <fmt:formatNumber value = "${balance * balance2}" type = "currency"/>-->
    </p>



</body>
</html>
