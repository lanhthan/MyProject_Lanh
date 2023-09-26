<%-- 
    Document   : finish
    Created on : Jul 10, 2023, 10:19:13 AM
    Author     : windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            h1{
                text-align: center;
                margin-top: 20px;
            }
            h3, p {
                margin-left: 30px;
                margin-top: 20px;
            }
            .return {
                text-align: center;
                display: block;
                margin-top: 20px;

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
        <h1>Đặt đơn hàng thành công</h1>
        <h3>Mã đơn hàng của bạn là: ${oid}</h3>
        <p>Bạn đã đặt hàng thành công. Sản phẩm sẽ được giao đến bạn trong một vài ngày tới. Merhaba chân thành cảm ơn quý khách đã ủng hộ.</p>
        <p style="color: red">Lưu ý: Hãy ghi nhớ mã đơn hàng để tiện theo dõi đơn trên trang web của chúng mình quý khách nhé!</p>
        <a href="home" class="return">Quay về trang chủ tiếp tục mua sắm</a>
    </body>
</html>
