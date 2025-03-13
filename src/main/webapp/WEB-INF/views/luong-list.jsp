<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Lương</title>

    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          integrity="sha384-..." 
          crossorigin="anonymous">
</head>
<body>

<div class="container mt-4">
    <h1 class="mb-4">Danh sách Lương</h1>
    
    <!-- Nút thêm Lương -->
    <a class="btn btn-primary mb-3" href="luong/add">
        ➕ Thêm Lương
    </a>
    
    <!-- Bảng danh sách Lương -->
    <table class="table table-bordered table-hover">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>ID Nhân viên</th>
                <th>Tháng</th>
                <th>Năm</th>
                <th>Tổng Giờ Làm</th>
                <th>Lương Tháng</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="l" items="${listLuong}">
                <tr>
                    <td>${l.luongId}</td>
                    <td>${l.nhanvienId}</td>
                    <td>${l.thang}</td>
                    <td>${l.nam}</td>
                    <td>${l.tongGioLam}</td>
                    <td>${l.luongThang}</td>
                    <td>
                        <a class="btn btn-sm btn-warning" href="luong/edit/${l.luongId}">
                            ✏ Sửa
                        </a>
                        <a class="btn btn-sm btn-danger" 
                           href="luong/delete/${l.luongId}" 
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
