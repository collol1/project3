<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhập thông tin Lương</title>
    
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          integrity="sha384-..." 
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Nhập thông tin Lương</h2>
    
    <form action="luong/save" method="post" class="row g-3">
        <!-- ID ẩn (nếu cần hiển thị thì thay type="hidden" bằng type="text") -->
        <input type="hidden" name="luongId" value="${luong.luongId}">

        <!-- Nhân viên -->
        <div class="col-12">
            <label for="nhanvienId" class="form-label">Nhân viên</label>
            <select class="form-select" id="nhanvienId" name="nhanvienId">
                <c:forEach var="nv" items="${listNhanvien}">
                    <option value="${nv.nhanvienId}"
                        ${luong.nhanvienId == nv.nhanvienId ? 'selected' : ''}>
                        ${nv.hoTen}
                    </option>
                </c:forEach>
            </select>
        </div>

        <!-- Tháng -->
        <div class="col-12">
            <label for="thang" class="form-label">Tháng</label>
            <input type="number" class="form-control" id="thang" name="thang"
                   value="${luong.thang}" required />
        </div>

        <!-- Năm -->
        <div class="col-12">
            <label for="nam" class="form-label">Năm</label>
            <input type="number" class="form-control" id="nam" name="nam"
                   value="${luong.nam}" required />
        </div>

        <!-- Nút Lưu và Quay lại -->
        <div class="col-12">
            <button type="submit" class="btn btn-success">Lưu</button>
           <a href="<%= request.getContextPath() %>/luong" class="btn btn-secondary">
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
	