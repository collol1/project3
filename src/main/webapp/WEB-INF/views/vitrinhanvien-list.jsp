<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Vị trí Nhân viên</title>
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          integrity="sha384-..." 
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Danh sách Vị trí Nhân viên</h1>
    
    <!-- Nút thêm Vị trí -->
    <a class="btn btn-primary mb-3" href="vitrinhanvien/add">
        ➕ Thêm Vị trí
    </a>
    
    <!-- Bảng danh sách Vị trí Nhân viên -->
    <table class="table table-bordered table-hover">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Tên Vị Trí</th>
                <th>Lương Cơ Bản</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="vt" items="${listVitrinhanvien}">
                <tr>
                    <td>${vt.vitriId}</td>
                    <td>${vt.tenViTri}</td>
                    <td>${vt.luongCoBan}</td>
                    <td>
                        <a class="btn btn-sm btn-warning" href="vitrinhanvien/edit/${vt.vitriId}">
                            ✏ Sửa
                        </a>
                        <a class="btn btn-sm btn-danger" 
                           href="vitrinhanvien/delete/${vt.vitriId}" 
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
