<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhập thông tin Vị trí Nhân viên</title>
    
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          integrity="sha384-..." 
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Nhập thông tin Vị trí Nhân viên</h2>
    
    <form action="vitrinhanvien/save" method="post" class="row g-3">
        <!-- Input ẩn cho vitriId -->
        <input type="hidden" name="vitriId" value="${vitri.vitriId}">
        
        <!-- Tên Vị trí -->
        <div class="col-12">
            <label for="tenViTri" class="form-label">Tên Vị trí:</label>
            <input type="text" class="form-control" id="tenViTri" name="tenViTri" value="${vitri.tenViTri}" required>
        </div>
        
        <!-- Lương Cơ Bản -->
        <div class="col-12">
            <label for="luongCoBan" class="form-label">Lương Cơ Bản:</label>
            <input type="number" step="0.01" class="form-control" id="luongCoBan" name="luongCoBan" value="${vitri.luongCoBan}" required>
        </div>
        
        <!-- Nút Lưu và Quay lại -->
        <div class="col-12">
            <button type="submit" class="btn btn-success">💾 Lưu</button>
            <a href="<%= request.getContextPath() %>/vitrinhanvien" class="btn btn-secondary">
                Quay lại danh sách
            </a>
        </div>
    </form>
</div>

<!-- Link Bootstrap JS (nếu cần) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-..." 
        crossorigin="anonymous"></script>
</body>
</html>
