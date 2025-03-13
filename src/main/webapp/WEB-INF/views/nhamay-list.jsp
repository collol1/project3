<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Nhà máy</title>
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          integrity="sha384-..." 
          crossorigin="anonymous">
</head>
<body>

<div class="container mt-4">
    <h1 class="mb-4">Danh sách Nhà máy</h1>
    
    <!-- Nút thêm Nhà máy -->
    <a class="btn btn-primary mb-3" href="nhamay/add">
        ➕ Thêm Nhà máy
    </a>
    
    <!-- Bảng danh sách Nhà máy -->
    <table class="table table-bordered table-hover">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Tên Nhà Máy</th>
                <th>Địa Chỉ</th>
                <th>Số Điện Thoại</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="nm" items="${listNhamay}">
                <tr>
                    <td>${nm.nhamayId}</td>
                    <td>${nm.tenNhaMay}</td>
                    <td>${nm.diaChi}</td>
                    <td>${nm.soDienThoai}</td>
                    <td>
                        <a class="btn btn-sm btn-warning" href="nhamay/edit/${nm.nhamayId}">
                            ✏ Sửa
                        </a>
                        <a class="btn btn-sm btn-danger" 
                           href="nhamay/delete/${nm.nhamayId}" 
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
