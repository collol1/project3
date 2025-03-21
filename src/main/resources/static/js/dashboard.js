document.addEventListener("DOMContentLoaded", function () {
    fetchDashboardData();
});

function fetchDashboardData() {
    fetch("/api/dashboard") // Gọi API backend
        .then(response => response.json())
        .then(data => {
            document.getElementById("totalEmployees").textContent = data.totalEmployees;
            document.getElementById("totalProducts").textContent = data.totalProducts;
            document.getElementById("totalFactories").textContent = data.totalFactories;
            document.getElementById("totalHours").textContent = data.totalHours;
        })
        .catch(error => {
            console.error("Lỗi khi tải dữ liệu dashboard:", error);
            document.getElementById("totalEmployees").textContent = "Lỗi!";
            document.getElementById("totalProducts").textContent = "Lỗi!";
            document.getElementById("totalFactories").textContent = "Lỗi!";
            document.getElementById("totalHours").textContent = "Lỗi!";
        });
}
