<%-- 
    Document   : register
    Created on : Jun 24, 2023, 2:44:49 PM
    Author     : windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            * {
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            .contain{
                background-image: url("images/loginbackground.jpeg");
                background-repeat: no-repeat;
                background-size: cover;
                height: 602px;
                ;
                opacity: 0.8;
            }
            #frm{

                background-color: rgba(246, 237, 240, 0.5);
                width: 60%;
                height: 400px;
                margin-left: 238px;
            }
            h1{
                padding-top: 50px;
                text-transform: uppercase;
                text-align: center;
            }
            label{
                display: inline-block;
                width: 180px;
                margin-left: 180px;
                font-size: 23px;
            }
            input{
                line-height: 23px;
                margin-top: 20px;
                width: 200px;
            }
            .button-register{
                width: 180px;
                margin-left: 38%;
                background-color: #f6741b;
                color: white;
                font-size: 23px;
                font-weight: 400;
                text-transform: uppercase;
                border-radius: 5px;
                height: 40px;
                margin-top: 50px;
            }
            h2{

                color: red;
                text-align: center;
            }
            .title{
                padding-top: 50px;
                text-align: center;
                text-transform: none;
                color: #660001;
                margin-bottom: 5px;
            }
            .question{
                margin-top: 20px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="contain">
            <h1 class="title">Merhaba - Thời trang thay đổi thế giới</h1>
            <form action="register" id="frm">
                <h1>Đăng ký</h1><br>
                <h2>${requestScope.error}</h2>
                <label for="account">Tên đăng nhập:</label>
                <input type='text' name="account" value="${requestScope.account}"/><br>
                <label for="password">Mật khẩu:</label>
                <input type='password' name="password" value="${requestScope.password}"/><br>
                <label for="repassword">Nhập lại mật khẩu:</label>
                <input type='password' name="repassword" value="${requestScope.repassword}"/><br>
                <input type="submit" class="button-register" name="register" value="Đăng ký"/>
                <a href="login.jsp" ><p class="question">Bạn đã có tài khoản?</p></a>

            </form>


        </div>
    </body>
</html>
