<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="spring.com.beans.Nhanvien" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="nhanvien" scope="request" type="spring.com.beans.Nhanvien" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm / Sửa Nhân Viên</title>
    
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          integrity="sha384-..."
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <!-- Tiêu đề form -->
    <h2 class="mb-4">Thêm / Sửa Nhân Viên</h2>

    <!-- Bắt đầu form -->
    <form action="<%= request.getContextPath() %>/nhanvien/save" method="post" class="row g-3">

        <!-- ID ẩn (nếu cần hiển thị thì bỏ type="hidden") -->
        <input type="hidden" name="nhanvienId"
               value="<%= nhanvien.getNhanvienId() == null ? "" : nhanvien.getNhanvienId() %>" />

        <!-- Họ tên -->
        <div class="col-12">
            <label for="hoTen" class="form-label">Họ tên</label>
            <input type="text" class="form-control" id="hoTen" name="hoTen"
                   value="<%= nhanvien.getHoTen() == null ? "" : nhanvien.getHoTen() %>"
                   required />
        </div>

        <!-- Ngày sinh -->
        <div class="col-12">
            <label for="ngaySinh" class="form-label">Ngày sinh</label>
            <input type="text" class="form-control" id="ngaySinh" name="ngaySinh"
                   value="<%= nhanvien.getNgaySinh() == null ? "" : nhanvien.getNgaySinh() %>"
                   required />
        </div>

        <!-- Giới tính -->
        <div class="col-12">
            <label for="gioiTinh" class="form-label">Giới tính</label>
            <select class="form-select" id="gioiTinh" name="gioiTinh">
                <option value="Nam"
                    <%= "Nam".equals(nhanvien.getGioiTinh()) ? "selected" : "" %>>
                    Nam
                </option>
                <option value="Nữ"
                    <%= "Nữ".equals(nhanvien.getGioiTinh()) ? "selected" : "" %>>
                    Nữ
                </option>
            </select>
        </div>

        <!-- Địa chỉ -->
        <div class="col-12">
            <label for="diaChi" class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi"
                   value="<%= nhanvien.getDiaChi() == null ? "" : nhanvien.getDiaChi() %>"
                   required />
        </div>

        <!-- Số điện thoại -->
        <div class="col-12">
            <label for="soDienThoai" class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" id="soDienThoai" name="soDienThoai"
                   value="<%= nhanvien.getSoDienThoai() == null ? "" : nhanvien.getSoDienThoai() %>"
                   required />
        </div>

        <!-- Vị trí ID -->
        <div class="col-12">
            <label for="vitriId" class="form-label">Vị trí ID</label>
            <input type="text" class="form-control" id="vitriId" name="vitriId"
                   value="<%= nhanvien.getVitriId() == null ? "" : nhanvien.getVitriId() %>"
                   required />
        </div>

        <!-- Nút Thêm/Cập nhật -->
        <div class="col-12">
            <button type="submit" class="btn 
                <%= (nhanvien.getNhanvienId() == null) ? "btn-success" : "btn-primary" %>">
                <%= (nhanvien.getNhanvienId() == null) ? "Thêm" : "Cập nhật" %>
            </button>
            <!-- Nút quay lại danh sách -->
            <a href="<%= request.getContextPath() %>/nhanvien" class="btn btn-secondary">
                Quay lại danh sách
            </a>
        </div>
    </form>
    <!-- Kết thúc form -->
</div>

<!-- Link Bootstrap JS (nếu cần) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-..."
        crossorigin="anonymous"></script>
</body>
</html>
