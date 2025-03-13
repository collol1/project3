<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Nhân viên</title>
    
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          integrity="sha384-..." 
          crossorigin="anonymous">
</head>
<body>

<div class="container mt-4">
    <h1 class="mb-4">Danh sách Nhân viên</h1>
    
    <!-- Nút thêm nhân viên -->
    <a class="btn btn-primary mb-3" href="nhanvien/add">
        ➕ Thêm Nhân viên
    </a>
    
    <!-- Bảng danh sách nhân viên -->
    <table class="table table-bordered table-hover">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Họ Tên</th>
                <th>Ngày Sinh</th>
                <th>Giới Tính</th>
                <th>Địa Chỉ</th>
                <th>Số Điện Thoại</th>
                <th>Vị Trí</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="nv" items="${listNhanvien}">
                <tr>
                    <td>${nv.nhanvienId}</td>
                    <td>${nv.hoTen}</td>
                    <td>${nv.ngaySinh}</td>
                    <td>${nv.gioiTinh}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.soDienThoai}</td>
                    <td>${nv.vitriId}</td>
                    <td>
                        <a class="btn btn-sm btn-warning" href="nhanvien/edit/${nv.nhanvienId}">
                            ✏ Sửa
                        </a>
                        <a class="btn btn-sm btn-danger" 
                           href="nhanvien/delete/${nv.nhanvienId}" 
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
