package spring.com.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.com.beans.Nhanvien;
import spring.com.dao.NhanvienDAO;

@Controller
@RequestMapping("/nhanvien")
public class NhanvienController {

    @Autowired
    private NhanvienDAO nhanvienDAO;

    // 📌 API lấy danh sách nhân viên (JSON)
    @GetMapping("/api")
    @ResponseBody
    public List<Nhanvien> getNhanvienApi() {
        return nhanvienDAO.getAll();
    }

    // 📌 Hiển thị danh sách nhân viên (JSP)
    @GetMapping
    public String listNhanvien(Model model) {
        List<Nhanvien> ds = nhanvienDAO.getAll();
        System.out.println("Số lượng nhân viên: " + ds.size());
        model.addAttribute("listNhanvien", ds);
        return "nhanvien-list";
    }

    // 📌 Hiển thị form thêm nhân viên
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanvien", new Nhanvien());
        return "nhanvien-form";
    }

    // 📌 Xử lý thêm nhân viên (có kiểm tra lỗi)
    @PostMapping("/save")
    public String saveNhanvien(@Validated @ModelAttribute("nhanvien") Nhanvien nhanvien, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "nhanvien-form";
        }
        try {
            nhanvienDAO.save(nhanvien);
            redirect.addFlashAttribute("message", "Thêm nhân viên thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi thêm nhân viên: " + e.getMessage());
        }
        return "redirect:/nhanvien";
    }
    
    // 📌 Hiển thị form chỉnh sửa nhân viên
    @GetMapping("/edit/{nhanvienId}")
    public String showEditForm(@PathVariable("nhanvienId") String nhanvienId, Model model, RedirectAttributes redirect) {
        Nhanvien nv = nhanvienDAO.getById(nhanvienId);
        if (nv == null) {
            redirect.addFlashAttribute("error", "Không tìm thấy nhân viên với ID: " + nhanvienId);
            return "redirect:/nhanvien";
        }
        model.addAttribute("nhanvien", nv);
        return "nhanvien-form"; // Dùng chung form cho thêm và chỉnh sửa
    }
    
    // 📌 Xử lý cập nhật nhân viên
    @PostMapping("/update")
    public String updateNhanvien(@Validated @ModelAttribute("nhanvien") Nhanvien nhanvien, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "nhanvien-form";
        }
        try {
            nhanvienDAO.update(nhanvien);
            redirect.addFlashAttribute("message", "Cập nhật nhân viên thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi cập nhật nhân viên: " + e.getMessage());
        }
        return "redirect:/nhanvien";
    }
    
    // 📌 Xóa nhân viên
    @GetMapping("/delete/{nhanvienId}")
    public String deleteNhanvien(@PathVariable("nhanvienId") String nhanvienId, RedirectAttributes redirect) {
        try {
            nhanvienDAO.delete(nhanvienId);
            redirect.addFlashAttribute("message", "Xóa nhân viên thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi xóa nhân viên: " + e.getMessage());
        }
        return "redirect:/nhanvien";
    }
}
