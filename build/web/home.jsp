<%-- 
    Document   : home
    Created on : Jun 19, 2023, 10:29:49 PM
    Author     : windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Merhaba</title>
        <link rel="stylesheet" href="css/style.css">
        <script src="https://kit.fontawesome.com/b4227f65bf.js"></script>
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
                        <c:if test="${sessionScope.account.role=='1'}">
                        <li><a href="manager.jsp">Quản lí</a></li>
                        </c:if>
                    <li><a href="logout">Đăng xuất</a></li>
                    <li><a href="profile">Xin chào ${sessionScope.account.account}</a></li>
                    <li><a href="shopcart"><i class="fas fa-cart-shopping"></i></a></li>
                        </c:if>
            </ul>

        </div>
<!--        <p>${sessionScope.account}</p>-->
        <div class="menu">
            <img src="images/logosuperfinal.jpg"/>
            <ul id="menu2">
                <li><a href="listProduct">Sản phẩm
                        <i class="fas fa-chevron-down"></i>
                    </a>
                    <ul class="submenu">
                        <c:forEach items="${listC}" var="c" >
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

        <div class="list-category">
            <h1>Danh mục mua hàng</h1>
            <i class="horizotal"></i>
            <ul class="cate-item">
                <div>
                    <c:forEach items="${listC}" var="c" >
                        <li>
                            <a href="listProduct?cateid=${c.id}">
                                <img class="cate-img" src="${c.image}"/>
                                <p>${c.name}</p>
                            </a>
                        </li>
                    </c:forEach>
                </div>


            </ul>
        </div>
        <img class="banner-img2" src="images/banner12.jpg"/>
        <div class="introduce">
            <h1>Merhaba - Thời trang là đời sống</h1>
            <div class="desc">
                <p class="intro-desc">Với tôn chỉ hoạt động: luôn luôn tôn trọng sự đa dạng và sẵn lòng
                    đem hết tiềm lực bảo tồn các nền văn hóa. Mỗi sản phẩm của Merhaba 
                    đều mang trên mình một câu chuyện về lịch sử, về con người.
                    Bên cạnh đó vẫn là những nét thiết kế chấm phá hiện đại thể hiện được
                    sự năng động, trẻ trung, cá tính. Không chỉ chú trọng về thiết kế, Merhaba 
                    cũng rất quan tâm đến vấn đề về trách nhiệm sản phẩm của mình đối với môi trường.
                    Những bộ cánh từ thương hiệu Merhaba được làm từ những nguyên liệu rõ nguồn gốc
                    xuất xứ, đảm bảo thân thiện với môi trường. Vì vậy, các bạn hãy yên tâm khi lựa chọn
                    sản phẩm của tụi mình nhé!</p>
                <img src="images/thoitrangxanh.jfif"/>
            </div>
            <h3>CHỌN MERHABA - CHỌN LỐI SỐNG XANH!</h3>
        </div>
        <div class="footer">

            <input class="butt-store" type="button" value="TÌM CỬA HÀNG"/>

            <div class="footer-content">
                <div class="content-items">
                    <h2 class="footer-title">Về chúng tôi</h2>
                    <ul>
                        <li>Tuyển dụng</li>
                        <li>Liên hệ nhượng quyền</li>
                        <li>Về Merhaba</li>
                    </ul>
                </div>
                <div class="content-items">
                    <h2 class="footer-title">Hỗ trợ</h2>
                    <ul>
                        <li>Câu hỏi thường gặp</li>
                        <li>Bảo mật thông tin</li>
                        <li>Chính sách khách hàng</li>
                    </ul>
                </div>
                <div class="content-items">
                    <h2 class="footer-title">Liên hệ</h2>
                    <ul>
                        <li>Email góp ý</li>
                        <li>Hotline</li>
                    </ul>
                </div>

            </div>
            <div class="social-contact">
                <a href="https://www.facebook.com/profile.php?id=100022861361286"> <img src="images/facebook.svg"/></a>
                <a href="https://www.instagram.com/ttla203/" ><img src="images/instagram.svg"/></a>
                <a href="https://www.youtube.com/channel/UCMrr_hg95nIvtAMWAZzkazw" ><img src="images/youtube.svg"/></a>
            </div>
            <p>Copyright © 2023 Merhaba. All rights reserved.</p>
        </div>

    </body>
</html>
