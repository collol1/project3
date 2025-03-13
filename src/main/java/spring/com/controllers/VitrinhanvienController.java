package spring.com.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.com.beans.Sanpham;
import spring.com.beans.VitriNhanvien;
import spring.com.dao.VitriNhanvienDAO;

@Controller
@RequestMapping("/vitrinhanvien")
public class VitrinhanvienController {

    @Autowired
    private VitriNhanvienDAO vitriNhanvienDAO;

    // 📌 API JSON: Lấy danh sách vị trí nhân viên
    @GetMapping("/api")
    @ResponseBody
    public List<VitriNhanvien> getVitriNhanvienApi() {
        return vitriNhanvienDAO.getAll();
    }

    // 📌 Hiển thị danh sách vị trí nhân viên (JSP)
    
    @GetMapping
    public String listVitrinhanvien(Model model) {
        List<VitriNhanvien> list = vitriNhanvienDAO.getAll();
        model.addAttribute("listVitrinhanvien", list);
        return "vitrinhanvien-list";
    }
    // 📌 Hiển thị form thêm vị trí nhân viên
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("vitriNhanvien", new VitriNhanvien());
        return "vitrinhanvien-form";
    }

    // 📌 Xử lý thêm vị trí nhân viên (có kiểm tra lỗi)
    @PostMapping("/save")
    public String saveVitriNhanvien(@Validated @ModelAttribute("vitriNhanvien") VitriNhanvien vitriNhanvien, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "vitrinhanvien-form";
        }
        try {
            vitriNhanvienDAO.save(vitriNhanvien);
            redirect.addFlashAttribute("message", "Thêm vị trí nhân viên thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi thêm vị trí nhân viên: " + e.getMessage());
        }
        return "redirect:/vitrinhanvien";
    }
    
    // 📌 Hiển thị form chỉnh sửa vị trí nhân viên
    @GetMapping("/edit/{vitriId}")
    public String showEditForm(@PathVariable("vitriId") String vitriId, Model model, RedirectAttributes redirect) {
        VitriNhanvien vitriNhanvien = vitriNhanvienDAO.getById(vitriId);
        if (vitriNhanvien == null) {
            redirect.addFlashAttribute("error", "Không tìm thấy vị trí nhân viên với ID: " + vitriId);
            return "redirect:/vitrinhanvien";
        }
        model.addAttribute("vitriNhanvien", vitriNhanvien);
        return "vitrinhanvien-form"; // Sử dụng chung form cho thêm và chỉnh sửa
    }
    
    // 📌 Xử lý cập nhật vị trí nhân viên
    @PostMapping("/update")
    public String updateVitriNhanvien(@Validated @ModelAttribute("vitriNhanvien") VitriNhanvien vitriNhanvien, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "vitrinhanvien-form";
        }
        try {
            vitriNhanvienDAO.update(vitriNhanvien);
            redirect.addFlashAttribute("message", "Cập nhật vị trí nhân viên thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi cập nhật vị trí nhân viên: " + e.getMessage());
        }
        return "redirect:/vitrinhanvien";
    }
    
    // 📌 Xóa vị trí nhân viên
    @GetMapping("/delete/{vitriId}")
    public String deleteVitriNhanvien(@PathVariable("vitriId") String vitriId, RedirectAttributes redirect) {
        try {
            vitriNhanvienDAO.delete(vitriId);
            redirect.addFlashAttribute("message", "Xóa vị trí nhân viên thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi xóa vị trí nhân viên: " + e.getMessage());
        }
        return "redirect:/vitrinhanvien";
    }
}
