<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="spring.com.beans.Chamcong" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="chamcong" scope="request" type="spring.com.beans.Chamcong" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm / Sửa Chấm Công</title>
    
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          integrity="sha384-..."
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Thêm / Sửa Chấm Công</h2>

    <form action="<%= request.getContextPath() %>/chamcong/edit/<%= chamcong.getChamcongId() %>" method="post">

        <!-- ID ẩn -->
        <input type="hidden" name="chamcongId" value="<%= chamcong.getChamcongId() == null ? "" : chamcong.getChamcongId() %>" />

        <div class="col-12">
            <label for="nhanvienId" class="form-label">Nhân viên ID</label>
            <input type="text" class="form-control" id="nhanvienId" name="nhanvienId"
                   value="<%= chamcong.getNhanvienId() == null ? "" : chamcong.getNhanvienId() %>"
                   required />
        </div>

        <div class="col-12">
            <label for="ngay" class="form-label">Ngày</label>
            <input type="text" class="form-control" id="ngay" name="ngay"
                   value="<%= chamcong.getNgay() == null ? "" : chamcong.getNgay() %>"
                   required />
        </div>

        <div class="col-12">
            <label for="soGioLam" class="form-label">Số giờ làm</label>
            <input type="number" class="form-control" id="soGioLam" name="soGioLam"
                   value="<%= chamcong.getSoGioLam() %>"
                   min="0" max="24" required />
        </div>

        <div class="col-12 mt-3">
            <button type="submit" class="btn <%= (chamcong.getChamcongId() == null) ? "btn-success" : "btn-primary" %>">
                <%= (chamcong.getChamcongId() == null) ? "Thêm" : "Cập nhật" %>
            </button>
            <a href="<%= request.getContextPath() %>/chamcong" class="btn btn-secondary">Quay lại danh sách</a>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-..."
        crossorigin="anonymous"></script>
</body>
</html>
