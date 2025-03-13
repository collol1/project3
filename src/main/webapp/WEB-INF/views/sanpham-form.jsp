<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhập thông tin Sản phẩm</title>
    
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          integrity="sha384-..." 
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Nhập thông tin Sản phẩm</h2>
    <form action="sanpham/save" method="post" class="row g-3">
        <!-- Input ẩn cho SanphamId -->
        <input type="hidden" name="sanphamId" value="${sanpham.sanphamId}">
        
        <!-- Tên Sản phẩm -->
        <div class="col-12">
            <label for="tenSanPham" class="form-label">Tên Sản phẩm:</label>
            <input type="text" class="form-control" id="tenSanPham" name="tenSanPham" value="${sanpham.tenSanPham}" required>
        </div>
        
        <!-- Số Lượng Tồn -->
        <div class="col-12">
            <label for="soLuongTon" class="form-label">Số Lượng Tồn:</label>
            <input type="number" class="form-control" id="soLuongTon" name="soLuongTon" value="${sanpham.soLuongTon}" required>
        </div>
        
        <!-- Số Lượng Bán -->
        <div class="col-12">
            <label for="soLuongBan" class="form-label">Số Lượng Bán:</label>
            <input type="number" class="form-control" id="soLuongBan" name="soLuongBan" value="${sanpham.soLuongBan}" required>
        </div>
        
        <!-- Giá -->
        <div class="col-12">
            <label for="gia" class="form-label">Giá:</label>
            <input type="number" step="0.01" class="form-control" id="gia" name="gia" value="${sanpham.gia}" required>
        </div>
        
        <!-- Nút Lưu và Quay lại -->
        <div class="col-12">
            <button type="submit" class="btn btn-success">💾 Lưu</button>
            <a href="<%= request.getContextPath() %>/sanpham" class="btn btn-secondary">
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
