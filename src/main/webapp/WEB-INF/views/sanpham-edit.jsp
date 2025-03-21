<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
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

    <!-- Form nhập thông tin sản phẩm -->
    <form action="${pageContext.request.contextPath}/sanpham/edit/${sanpham.sanphamId}" method="post">

        <!-- ID Sản phẩm (hidden) -->
        <input type="hidden" name="sanphamId" value="${sanpham.sanphamId}">

        <!-- Tên Sản phẩm -->
        <div class="col-12">
            <label for="tenSanPham" class="form-label">Tên Sản phẩm</label>
            <input type="text" class="form-control" id="tenSanPham" name="tenSanPham"
                   value="${sanpham.tenSanPham}" required />
        </div>

        <!-- Số Lượng Tồn -->
        <div class="col-12">
            <label for="soLuongTon" class="form-label">Số Lượng Tồn</label>
            <input type="number" class="form-control" id="soLuongTon" name="soLuongTon"
                   value="${sanpham.soLuongTon}" min="0" required />
        </div>

        <!-- Số Lượng Bán -->
        <div class="col-12">
            <label for="soLuongBan" class="form-label">Số Lượng Bán</label>
            <input type="number" class="form-control" id="soLuongBan" name="soLuongBan"
                   value="${sanpham.soLuongBan}" min="0" required />
        </div>

        <!-- Giá -->
        <div class="col-12">
            <label for="gia" class="form-label">Giá</label>
            <input type="number" step="0.01" class="form-control" id="gia" name="gia"
                   value="${sanpham.gia}" min="0" required />
        </div>

        <!-- Nút Lưu và Quay lại -->
        <div class="col-12 mt-3">
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="${pageContext.request.contextPath}/sanpham" class="btn btn-secondary">Quay lại danh sách</a>
        </div>
    </form>
</div>

<!-- Link Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-..."
        crossorigin="anonymous"></script>
</body>
</html>
