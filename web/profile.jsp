<%-- 
    Document   : info
    Created on : Jul 13, 2023, 8:34:12 AM
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
            .frm{
                width: 50%;
                float: left;
            }
            h1{
                text-align: center;
            }
            label{
                width: 160px;
                display: inline-block;
                margin-bottom: 20px;
                margin-left: 80px;
            }
            .button {
                margin-left: 220px;

            }
        </style>
    </head>
    <body>
        <a href="home">Quay về trang chủ</a>
        <h1 style="text-align: center">Thông tin cá nhân</h1>
        <form action="profile" method="post" class="frm">
            <input type="hidden" name="uid" value="${sessionScope.account.id}"/>
            <h1>Đổi mật khẩu</h1>
            <p style="color: red">${error}</p>
            <label>Mật khẩu cũ</label>
            <input type="text" name="oldPass"/><br>
            <label>Mật khẩu mới</label>
            <input type="text" name="newPass"/><br>
            <label>Nhập lại mật khẩu mới</label>
            <input type="text" name="renewPass"/><br>
            <input type="submit" value="Đổi mật khẩu" class="button"/>
        </form>
        <form action="profile" method="get" class="frm">
            <input type="hidden" name="action" value="update"/>
            <h1>Thông tin</h1>
            <input type="hidden" name="cid" value="${cid}"/>
            <p style="color: red">${error}</p>
            <label>Tên khách hàng</label>
            <input type="text" name="name" value="${name}"/><br>
            <label>Giới tính</label>
            <select name="gender">
                <c:choose>
                    <c:when test="${gender eq '1'}">
                        <option value="0">Female</option>
                        <option value="1" selected>Male</option>
                    </c:when>
                    <c:otherwise>
                        <option value="0" selected>Female</option>
                        <option value="1">Male</option>
                    </c:otherwise>
                </c:choose>
            </select><br>
            <label>Ngày sinh</label>
            <input type="text" name="dob" value="${dob}"/><br>
            <label>Địa chỉ</label>
            <input type="text" name="address" value="${address}"/><br>
            <label>Số điện thoại</label>
            <input type="text" name="phone" value="${phone}"/><br>
            <input type="submit" value="Cập nhật" class="button"/>
        </form>
    </body>
</html>
