<%-- 
    Document   : order]
    Created on : Jul 7, 2023, 3:52:47 PM
    Author     : windy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .title {
                text-transform: uppercase;
                font-size: 30px;
                text-align: center;
                margin-top: 20px;
            }
            #frm {
                width: 80%;
                margin: 0 auto;
                line-height: 45px;
            }
            label {
                width: 120px;
                display: inline-block;
            }
            input {
                width: 200px;
                line-height: 23px;
                width: 250px;
            }
            span {
                color: red;
            }
            p{
                line-height: 20px;
            }
            .action {
                display: flex;
                justify-content: space-between;
                width: 95%;
                margin: 0 auto;
                margin-top: 30px;
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
            .sum{
                font-size: 23px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <h1 class='title'>Thanh toán hóa đơn</h1>
        <hr>
        <form action="finish" id="frm" method="post">
            <h1></h1>
            <c:set var="c" value="${customer}"></c:set>

            <c:if test="${c.getFname()==null}">
                <h1 style="color: #238ffd;">Đây là đơn hàng đầu tiên của fen, hãy điền thông tin, chú ý nó được sử dụng cho những đơn hàng sau nữa nhé!</h1>
            </c:if>
            <label for="name">Tên khách hàng: </label>
            <input type="text" name="name" value="${c.getFname()}" readonly/><br/>
            <label for="address"> Địa chỉ: </label>
            <input type="text" name="address" value="${c.getAddress()}" readonly/><br/>
            <label for="phone">Số điện thoại: </label>
            <input type="text" name="phone" value="${c.getPhone()}" readonly/><br/>
            Phương thức thanh toán: COD (Thanh toán khi nhận hàng)<br/>
            <fmt:setLocale value = "vi_VN"/>
            <input type="hidden" name="totalPrice" value="${totalPrice}"/>         
            <p class="sum">Tổng số tiền cho đơn hàng của quý khách: <fmt:formatNumber value = "${totalPrice}" type = "currency"/></p>
            <p><span>(*)</span>Mọi đơn hàng đều được đồng kiểm. Các sản phẩm của Merhaba đã có bảo hiểm thời trang đi kèm. Mọi vấn đề liên quan đến sản phẩm 
                vui lòng liên hệ với chúng tôi trong 7 ngày kể từ khi nhận hàng. Sau 7 ngày, chúng tôi sẽ không chịu trách nhiệm.</p>
            <div class="action">
                <a href="shopcart">
                    <input type="button" value="Không, cho tôi quay lại giỏ hàng" class="back"/>
                </a>

                <input type="hidden" name="cid" value="${c.getCid()}"/>
                <input type="hidden" name="customer" value="${customer.getCid()}"/>
                <input type="hidden" name="uid" value="${uid}"/>
                <input type="submit" value="Hoàn thành đơn hàng" class="continue"/>


            </div>

        </form>
    </body>
</html>
