package spring.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.com.beans.Nhamay;
import spring.com.beans.Sanpham;
import spring.com.dao.SanphamDAO;

@Controller
@RequestMapping("/sanpham")
public class SanphamController {

    @Autowired
    private SanphamDAO sanphamDAO;

    // 📌 API JSON trả về danh sách sản phẩm
    @GetMapping("/api")
    @ResponseBody
    public List<Sanpham> getSanphamApi() {
        return sanphamDAO.getAll();
    }

    // 📌 Hiển thị danh sách sản phẩm (JSP)
    @GetMapping
    public String listSanpham(Model model) {
        List<Sanpham> list = sanphamDAO.getAll();
        model.addAttribute("listSanpham", list);
        return "sanpham-list";
    }

    // 📌 Hiển thị form thêm sản phẩm
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sanpham", new Sanpham());
        return "sanpham-form";
    }

    // 📌 Xử lý thêm sản phẩm (có kiểm tra lỗi)
    @PostMapping("/save")
    public String saveSanpham(@Validated @ModelAttribute("sanpham") Sanpham sanpham, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "sanpham-form";
        }
        try {
            sanphamDAO.save(sanpham);
            redirect.addFlashAttribute("message", "Thêm sản phẩm thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi thêm sản phẩm: " + e.getMessage());
        }
        return "redirect:/sanpham";
    }

    // 📌 Hiển thị form chỉnh sửa sản phẩm
    @GetMapping("/edit/{sanphamId}")
    public String showEditForm(@PathVariable("sanphamId") String sanphamId, Model model, RedirectAttributes redirect) {
        Sanpham sanpham = sanphamDAO.getById(sanphamId);
        if (sanpham == null) {
            redirect.addFlashAttribute("error", "Không tìm thấy sản phẩm với ID: " + sanphamId);
            return "redirect:/sanpham";
        }
        model.addAttribute("sanpham", sanpham);
        return "sanpham-form"; // Sử dụng chung form cho thêm và chỉnh sửa
    }

    // 📌 Xử lý cập nhật sản phẩm
    @PostMapping("/edit/{sanphamId}")
    public String updateSanpham(@RequestParam("sanphamId") String sanphamId, 
            @ModelAttribute("sanpham") Sanpham sanpham) {
    	sanpham.setSanphamId(sanphamId); // Gán ID từ request vào đối tượng
    	sanphamDAO.update(sanpham);
    	return "redirect:/sanpham";
}

    // 📌 Xóa sản phẩm
    @GetMapping("/delete/{sanphamId}")
    public String deleteSanpham(@PathVariable("sanphamId") String sanphamId, RedirectAttributes redirect) {
        try {
            sanphamDAO.delete(sanphamId);
            redirect.addFlashAttribute("message", "Xóa sản phẩm thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi xóa sản phẩm: " + e.getMessage());
        }
        return "redirect:/sanpham";
    }
}
