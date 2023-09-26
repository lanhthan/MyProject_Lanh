<%-- 
    Document   : header
    Created on : Jun 25, 2023, 4:03:36 PM
    Author     : windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            }
/*            #header{
                position: fixed;
            }*/

            
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
        
    </body>
</html>
