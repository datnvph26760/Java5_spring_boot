<%@ taglib prefix="fr" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>Hien thi</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%--<%@include file="form/layout.jsp" %>--%>
<div class="container" style="margin-top: 30px">
    <header>
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-white">
            <div class="container-fluid">
                <button
                        class="navbar-toggler"
                        type="button"
                        data-mdb-toggle="collapse"
                        data-mdb-target="#navbarExample01"
                        aria-controls="navbarExample01"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarExample01">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item active">
                            <a class="nav-link" aria-current="page" href=""><img
                                    src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/FPT_Polytechnic.png/1200px-FPT_Polytechnic.png?20200416064027"
                                    alt="" style="width: 100px;height: 50px;"></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Hóa đơn</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/nhan-vien/hien-thi">Nhân viên</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/khach-hang/hien-thi">Khách hàng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/cua-hang/hien-thi">Cửa hàng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/chuc-vu/hien-thi">Chức vụ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/san-pham/hien-thi">Sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/dong-san-pham/hien-thi">Dòng sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/nha-san-xuat/hien-thi">Nhà sản xuất</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/mau-sac/hien-thi">Màu sắc</a>
                        </li>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Navbar -->

        <!-- Background image -->
        <div
                class="p-5 text-center bg-image"
                style="
            background-image: url('https://mdbcdn.b-cdn.net/img/new/slides/041.webp');
            height: 400px;
          "
        >

            <!-- Background image -->
        </div>
    </header>
    <h3 style="text-align: center">Quản lý hóa đơn</h3>
    <a href="/hoa-don/create" class="btn btn-warning">Add</a>
    <form action="" method="post" style="margin-top: 30px">
        <table class="table table-sub-heading-color">
            <thead>
            <tr>
                <td>#</td>
                <td>Mã</td>
                <td>Tên khách hàng</td>
                <td>Tên nhân viên</td>
                <td>Người nhận</td>
                <td>SĐT</td>
                <td>Địa chỉ</td>
                <td>Ngày tạo</td>
                <td>Ngày thanh toán</td>
                <td>Ngày ship</td>
                <td>Ngày nhận</td>
                <td>Trạng thái</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHD}" var="hd" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${hd.ma}</td>
                    <td>${hd.kh.ho} ${hd.kh.tenDem} ${hd.kh.ten}</td>
                    <td>${hd.nv.ho} ${hd.nv.tenDem} ${hd.nv.ten}</td>
                    <td>${hd.tenNguoiNhan}</td>
                    <td>${hd.sdt}</td>
                    <td>${hd.diaChi}</td>
                    <td>${hd.ngayTao}</td>
                    <td>${hd.ngayThanhToan}</td>
                    <td>${hd.ngayShip}</td>
                    <td>${hd.ngayNhan}</td>
                    <td>${hd.tinhTrang == 0 ? "Đã thanh toán" : "chưa thanh toán"}</td>
                    <td>
                        <a class="btn btn-primary" href="/hoa-don/delete/${hd.id}">Delete</a>
                        <a class="btn btn-danger" href="/hoa-don/edit/${hd.id}">Update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
    <footer class="bg-light text-center text-white">
        <!-- Grid container -->
        <div class="container p-4 pb-0">
            <!-- Section: Social media -->
            <section class="mb-4">
                <!-- Facebook -->
                <a
                        class="btn text-white btn-floating m-1"
                        style="background-color: #3b5998;"
                        href="https://www.facebook.com/profile.php?id=100046530497373"
                        role="button"
                ><i class="fab fa-facebook-f"></i
                ></a>

                <!-- Google -->
                <a
                        class="btn text-white btn-floating m-1"
                        style="background-color: #dd4b39;"
                        href="#!"
                        role="button"
                ><i class="fab fa-google"></i
                ></a>

                <!-- Instagram -->
                <a
                        class="btn text-white btn-floating m-1"
                        style="background-color: #ac2bac;"
                        href="https://www.instagram.com/ng.uyen8209/"
                        role="button"
                ><i class="fab fa-instagram"></i
                ></a>

                <!-- Github -->
                <a
                        class="btn text-white btn-floating m-1"
                        style="background-color: #333333;"
                        href="#!"
                        role="button"
                ><i class="fab fa-github"></i
                ></a>
            </section>
            <!-- Section: Social media -->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            FPT Polytechnic:
            <a class="text-white" href="https://www.facebook.com/profile.php?id=100046530497373">DatNVPH26760</a>
        </div>
        <!-- Copyright -->
    </footer>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>