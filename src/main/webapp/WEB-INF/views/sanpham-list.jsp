<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Sản phẩm</title>
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          integrity="sha384-..." 
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Danh sách Sản phẩm</h1>
    
    <!-- Nút thêm Sản phẩm -->
    <a class="btn btn-primary mb-3" href="sanpham/add">
        ➕ Thêm Sản phẩm
    </a>
    
    <!-- Bảng danh sách Sản phẩm -->
    <table class="table table-bordered table-hover">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Tên Sản Phẩm</th>
                <th>Số Lượng Tồn</th>
                <th>Số Lượng Bán</th>
                <th>Giá</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="sp" items="${listSanpham}">
                <tr>
                    <td>${sp.sanphamId}</td>
                    <td>${sp.tenSanPham}</td>
                    <td>${sp.soLuongTon}</td>
                    <td>${sp.soLuongBan}</td>
                    <td>${sp.gia}</td>
                    <td>
                        <a class="btn btn-sm btn-warning" href="sanpham/edit/${sp.sanphamId}">
                            ✏ Sửa
                        </a>
                        <a class="btn btn-sm btn-danger" 
                           href="sanpham/delete/${sp.sanphamId}" 
                           onclick="return confirm('Bạn có chắc muốn xóa?')">
                            ❌ Xóa
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <!-- Nút quay lại trang chủ -->
    <a class="btn btn-secondary" href="/xuongmaybinhminh/">Quay lại trang chủ</a>
</div>

<!-- Link Bootstrap JS (nếu cần) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-..." 
        crossorigin="anonymous"></script>
</body>
</html>
