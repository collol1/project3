package spring.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.com.beans.Luong;
import spring.com.dao.LuongDAO;

@Controller
@RequestMapping("/luong")
public class LuongController {

    @Autowired
    private LuongDAO luongDAO;

    // 📌 API JSON: Lấy danh sách lương
    @GetMapping("/api")
    @ResponseBody
    public List<Luong> getLuongApi() {
        return luongDAO.getAll();
    }

    // 📌 Hiển thị danh sách lương (JSP)
    @GetMapping
    public String listLuong(Model model) {
        model.addAttribute("listLuong", luongDAO.getAll());
        return "luong-list";
    }

    // 📌 Hiển thị form thêm lương
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("luong", new Luong());
        return "luong-form";
    }

    // 📌 Xử lý thêm lương (có kiểm tra lỗi)
    @PostMapping("/save")
    public String saveLuong(@Validated @ModelAttribute("luong") Luong luong, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "luong-form";
        }
        try {
            luongDAO.save(luong);
            redirect.addFlashAttribute("message", "Thêm lương thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi thêm lương: " + e.getMessage());
        }
        return "redirect:/luong";
    }

    // 📌 Hiển thị form chỉnh sửa lương
    @GetMapping("/edit/{luongId}")
    public String showEditForm(@PathVariable("luongId") String luongId, Model model, RedirectAttributes redirect) {
        Luong luong = luongDAO.getById(luongId);
        if (luong == null) {
            redirect.addFlashAttribute("error", "Không tìm thấy lương với ID: " + luongId);
            return "redirect:/luong";
        }
        model.addAttribute("luong", luong);
        return "luong-form"; // Dùng chung form cho thêm và chỉnh sửa
    }

    // 📌 Xử lý cập nhật lương
    @PostMapping("/update")
    public String updateLuong(@Validated @ModelAttribute("luong") Luong luong, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "luong-form";
        }
        try {
            luongDAO.update(luong);
            redirect.addFlashAttribute("message", "Cập nhật lương thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi cập nhật lương: " + e.getMessage());
        }
        return "redirect:/luong";
    }

    // 📌 Xóa lương
    @GetMapping("/delete/{luongId}")
    public String deleteLuong(@PathVariable("luongId") String luongId, RedirectAttributes redirect) {
        try {
            luongDAO.delete(luongId);
            redirect.addFlashAttribute("message", "Xóa lương thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi xóa lương: " + e.getMessage());
        }
        return "redirect:/luong";
    }
}
