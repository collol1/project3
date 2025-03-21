 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhập thông tin Chấm công</title>
    
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          integrity="sha384-..." 
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Nhập thông tin Chấm công</h2>
    
    <!-- Form chấm công -->
 		<form action="<%= request.getContextPath() %>/chamcong/save" method="post">

        <!-- ID ẩn (nếu cần hiển thị thì thay type="hidden" bằng type="text") -->
        <div>
        <label for="chamcongId" class="form-label">Chấm Công ID </label>
         <input type="text" name="chamcongId" value="${chamcong.chamcongId}">
        </div>
       

        <!-- Chọn Nhân viên -->
        <div class="col-12">
            <label for="nhanvienId" class="form-label">Nhân viên ID</label>
           <input type="text" name="nhanvienId" value="${nhanvien.nhanvienId}">
        </div>

        <!-- Ngày -->
        <div class="col-12">
            <label for="ngay" class="form-label">Ngày</label>
            <input type="text" class="form-control" id="ngay" name="ngay" 
                   value="${chamcong.ngay}" required />
        </div>

        <!-- Số Giờ Làm -->
        <div class="col-12">
            <label for="soGioLam" class="form-label">Số Giờ Làm</label>
            <input type="number" class="form-control" id="soGioLam" name="soGioLam" 
                   value="${chamcong.soGioLam}" required />
        </div>

        <!-- Nút Lưu và Quay lại -->
        <div class="col-12">
            <button type="submit" class="btn btn-success">Lưu</button>
           <a href="<%= request.getContextPath() %>/chamcong" class="btn btn-secondary">
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
