<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
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

    <!-- Form nhập lương -->
	<form action="${pageContext.request.contextPath}/luong/edit/${luong.luongId}" method="post">


        <!-- ID Lương -->
        <div class="col-12">
            <label for="luongId" class="form-label">Lương ID</label>
            <input type="hidden" class="form-control" id="luongId" name="luongId"
                   value="${luong.luongId}" required />
        </div>

        <!-- Nhân viên ID -->
        <div class="col-12">
            <label for="nhanvienId" class="form-label">Nhân viên ID</label>
            <input type="text" class="form-control" id="nhanvienId" name="nhanvienId"
                   value="${luong.nhanvienId}" required />
        </div>

        <!-- Tháng -->
        <div class="col-12">
            <label for="thang" class="form-label">Tháng</label>
            <input type="number" class="form-control" id="thang" name="thang"
                   value="${luong.thang}" min="1" max="12" required />
        </div>

        <!-- Năm -->
        <div class="col-12">
            <label for="nam" class="form-label">Năm</label>
            <input type="number" class="form-control" id="nam" name="nam"
                   value="${luong.nam}" min="2000" max="2100" required />
        </div>

        <!-- Tổng giờ làm -->
        <div class="col-12">
            <label for="tongGioLam" class="form-label">Tổng giờ làm</label>
            <input type="number" class="form-control" id="tongGioLam" name="tongGioLam"
                   value="${luong.tongGioLam}" min="0" required />
        </div>

        <!-- Lương tháng -->
        <div class="col-12">
            <label for="luongThang" class="form-label">Lương tháng</label>
            <input type="number" class="form-control" id="luongThang" name="luongThang"
                   value="${luong.luongThang}" min="0" required />
        </div>

        <!-- Nút Lưu và Quay lại -->
        <div class="col-12 mt-3">
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="${pageContext.request.contextPath}/luong" class="btn btn-secondary">Quay lại danh sách</a>
        </div>
    </form>
</div>

<!-- Link Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-..."
        crossorigin="anonymous"></script>
</body>
</html>
