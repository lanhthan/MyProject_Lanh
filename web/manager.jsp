<%-- 
    Document   : manager
    Created on : Jul 11, 2023, 8:23:21 AM
    Author     : windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1{
                text-align: center;

            }
            li{
                list-style: none;
                margin-top: 20px;
            }
            a {
                font-size: 25px;
                margin-right: 180px;
                margin-left: 96px;
            }
            /*            li{
                            width: 33%;
                            list-style: none;
                            float: left;
                            text-align: center;
                            margin-top: 20px;
                        }
                        input{
                            font-size: 20px;
                            height: 42px;
                            width: 230px;
                            width: 33%;
                            background-color: #238ffd;
                            color: white;
                            border-radius: 5px;
                                            margin-left: 40px;
                                            margin-right: 40px;
                                            margin-top: 20px;
                            margin: 0 auto;
                            float: left;
                        }
                        input:hover{
                            background-color: orange;
                        }*/
        </style>
    </head>
    <body>
        <a href="home">Quay về home</a>
        <h1>Quản lí cửa hàng</h1>
        <hr>

        <a href="manager?type=product">Sản phẩm</a>
        <a href="manager?type=customer">Khách hàng</a>
        <a href="manager?type=order">Đơn hàng</a>
        <!--            <ul>
                        <li><a href="addProduct.jsp">Thêm sản phẩm</a></li>
                        <li><a href="updateProduct.jsp">Sửa sản phẩm</a></li>
                        <li><a href="deleteProduct.jsp">Xóa sản phẩm</a></li>
                        <li><a href="customerInfo.jsp">Trích xuất thông tin khách hàng</a></li>
                         
                        
                    </ul>-->



    </body>
</html>
