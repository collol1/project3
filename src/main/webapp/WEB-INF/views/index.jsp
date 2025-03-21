<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    
    <style>
        body { margin: 0; padding: 0; font-family: Arial, sans-serif; }
        .sidebar { width: 250px; min-height: 100vh; background-color: #0d6efd; color: #fff; padding-top: 20px; }
        .sidebar-header { font-size: 1.5rem; font-weight: bold; padding: 0 20px 20px 20px; }
        .nav-link { color: #fff; padding: 10px 20px; }
        .nav-link:hover, .nav-link.active { background-color: rgba(255, 255, 255, 0.2); }
        .content { flex: 1; background-color: #f8f9fa; min-height: 100vh; display: flex; flex-direction: column; }
        .topbar { background-color: #fff; border-bottom: 1px solid #ddd; }
        .card { margin: 10px; }
        .card-title { font-weight: 600; }
    </style>
</head>
<body>
    <div class="d-flex">
        <!-- Sidebar -->
        <div class="sidebar">
            <div class="sidebar-header">Xưởng Máy</div>
            <ul class="nav flex-column">
                <li class="nav-item"><a class="nav-link active" href="#">Dashboard</a></li>
                <li class="nav-item"><a class="nav-link" href="nhanvien">Nhân viên</a></li>
                <li class="nav-item"><a class="nav-link" href="vitrinhanvien">Vị trí nhân viên</a></li>
                <li class="nav-item"><a class="nav-link" href="sanpham">Sản phẩm</a></li>
                <li class="nav-item"><a class="nav-link" href="nhamay">Nhà máy</a></li>
                <li class="nav-item"><a class="nav-link" href="chamcong">Chấm công</a></li>
                <li class="nav-item"><a class="nav-link" href="luong">Bảng lương</a></li>
            </ul>
        </div>

        <!-- Content -->
        <div class="content">
            <nav class="navbar topbar">
                <div class="container-fluid">
                    <span class="navbar-text ms-auto me-4">Admin</span>
                </div>
            </nav>

            <!-- Dashboard -->
            <div class="container-fluid mt-4">
                <div class="row">
                    <!-- Card: Tổng số nhân viên -->
                    <div class="col-md-3">
                        <div class="card text-center">
                            <div class="card-body">
                                <h5 class="card-title">Tổng số nhân viên</h5>
                                <p class="card-text">${totalEmployees}</p> <!-- Dữ liệu động -->
                            </div>
                        </div>
                    </div>
                    <!-- Card: Tổng số sản phẩm -->
                    <div class="col-md-3">
                        <div class="card text-center">
                            <div class="card-body">
                                <h5 class="card-title">Tổng số sản phẩm</h5>
                                <p class="card-text">${totalProducts}</p> <!-- Dữ liệu động -->
                            </div>
                        </div>
                    </div>
                    <!-- Card: Tổng số nhà máy -->
                    <div class="col-md-3">
                        <div class="card text-center">
                            <div class="card-body">
                                <h5 class="card-title">Tổng số nhà máy</h5>
                                <p class="card-text">${totalFactories}</p> <!-- Dữ liệu động -->
                            </div>
                        </div>
                    </div>
                    <!-- Card: Tổng số giờ làm -->
                    <div class="col-md-3">
                        <div class="card text-center">
                            <div class="card-body">
                                <h5 class="card-title">Tổng số giờ làm</h5>
                                <p class="card-text">${totalWorkHours}</p> <!-- Dữ liệu động -->
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div> 
    </div> 
<script src="/js/dashboard.js"></script>

    <!-- Link Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
