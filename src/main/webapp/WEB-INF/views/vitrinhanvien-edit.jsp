<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
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

    <!-- Form nhập thông tin vị trí nhân viên -->
    <form action="${pageContext.request.contextPath}/vitrinhanvien/edit/${vitri.vitriId}" method="post">

        <!-- ID Vị trí -->
        <div class="col-12">
            <label for="vitriId" class="form-label">Vị trí ID</label>
            <input type="text" class="form-control" id="vitriId" name="vitriId"
                   value="${vitri.vitriId}" required />
        </div>

        <!-- Tên Vị trí -->
        <div class="col-12">
            <label for="tenViTri" class="form-label">Tên Vị trí</label>
            <input type="text" class="form-control" id="tenViTri" name="tenViTri"
                   value="${vitri.tenViTri}" required />
        </div>

        <!-- Lương Cơ Bản -->
        <div class="col-12">
            <label for="luongCoBan" class="form-label">Lương Cơ Bản</label>
            <input type="number" step="0.01" class="form-control" id="luongCoBan" name="luongCoBan"
                   value="${vitri.luongCoBan}" min="0" required />
        </div>

        <!-- Nút Lưu và Quay lại -->
        <div class="col-12 mt-3">
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="${pageContext.request.contextPath}/vitrinhanvien" class="btn btn-secondary">Quay lại danh sách</a>
        </div>
    </form>
</div>

<!-- Link Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-..."
        crossorigin="anonymous"></script>
</body>
</html>
