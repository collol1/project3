package spring.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Lấy dữ liệu từ database (dữ liệu giả lập)
        int totalEmployees = 4;  // Tổng số nhân viên
        int totalProducts = 4;   // Tổng số sản phẩm
        int totalFactories = 4;  // Tổng số nhà máy
        int totalWorkHours = 99; // Tổng số giờ làm

        // Đưa dữ liệu vào model để truyền sang JSP
        model.addAttribute("totalEmployees", totalEmployees);
        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("totalFactories", totalFactories);
        model.addAttribute("totalWorkHours", totalWorkHours);

        return "index"; // Trả về trang index.jsp
    }
}
