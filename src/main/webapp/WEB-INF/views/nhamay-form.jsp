<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhập thông tin Nhà máy</title>
    
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          integrity="sha384-..." 
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Nhập thông tin Nhà máy</h2>
    
    <form action="nhamay/save" method="post" class="row g-3">
        <!-- ID ẩn -->
        <input type="hidden" name="nhamayId" value="${nhamay.nhamayId}">
        
        <!-- Tên Nhà máy -->
        <div class="col-12">
            <label for="tenNhaMay" class="form-label">Tên Nhà máy:</label>
            <input type="text" class="form-control" id="tenNhaMay" name="tenNhaMay" 
                   value="${nhamay.tenNhaMay}" required>
        </div>
        
        <!-- Địa Chỉ -->
        <div class="col-12">
            <label for="diaChi" class="form-label">Địa Chỉ:</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi" 
                   value="${nhamay.diaChi}" required>
        </div>
        
        <!-- Số Điện Thoại -->
        <div class="col-12">
            <label for="soDienThoai" class="form-label">Số Điện Thoại:</label>
            <input type="text" class="form-control" id="soDienThoai" name="soDienThoai" 
                   value="${nhamay.soDienThoai}" required>
        </div>
        
        <!-- Nút Lưu và Quay lại -->
        <div class="col-12">
            <button type="submit" class="btn btn-success">💾 Lưu</button>
            <a href="<%= request.getContextPath() %>/nhamay" class="btn btn-secondary">
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
