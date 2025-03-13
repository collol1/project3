<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Chấm công</title>
    
    <style>
        /* Ví dụ CSS đơn giản cho bảng */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 16px;
        }
        thead {
            background-color: #f2f2f2;
        }
        th, td {
            padding: 8px 12px;
            border-bottom: 1px solid #ccc;
            text-align: left;
        }
        /* Căn lề phải cho cột số nếu muốn */
        /* td:nth-child(4) { text-align: right; } */

        /* Định dạng link hành động */
        a {
            margin-right: 8px;
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
        }

        /* Định dạng nút quay lại */
        .back-link {
            display: inline-block;
            margin-top: 16px;
            color: #000;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Danh sách Chấm công</h1>
    <a href="chamcong/add">➕ Thêm Chấm công</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>ID Nhân viên</th>
                <th>Ngày</th>
                <th>Số Giờ Làm</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cc" items="${listChamcong}">
                <tr>
                    <td>${cc.chamcongId}</td>
                    <td>${cc.nhanvienId}</td>
                    <td>${cc.ngay}</td>
                    <td>${cc.soGioLam}</td>
                    <td>
                        <a href="chamcong/edit/${cc.chamcongId}">✏ Sửa</a>
                        <a href="chamcong/delete/${cc.chamcongId}"
                           onclick="return confirm('Bạn có chắc muốn xóa?')">❌ Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a class="back-link" href="/xuongmaybinhminh/">Quay lại trang chủ</a>
</body>
</html>
