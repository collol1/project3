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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.com.beans.Chamcong;
import spring.com.dao.ChamcongDAO;

@Controller
@RequestMapping("/chamcong")
public class ChamcongController {

    @Autowired
    private ChamcongDAO chamcongDAO;

    // 📌 API JSON: Lấy danh sách chấm công
    @GetMapping("/api")
    @ResponseBody
    public List<Chamcong> getChamcongApi() {
        return chamcongDAO.getAll();
    }

    // 📌 Hiển thị danh sách chấm công (JSP)
    @GetMapping
    public String listChamcong(Model model) {
        model.addAttribute("listChamcong", chamcongDAO.getAll());
        return "chamcong-list";
    }

    // 📌 Hiển thị form thêm chấm công
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("chamcong", new Chamcong());
        return "chamcong-form";
    }

    // 📌 Xử lý thêm chấm công (có kiểm tra lỗi)
    @PostMapping("/save")
    public String saveChamcong(@Validated @ModelAttribute("chamcong") Chamcong chamcong, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "chamcong-form";
        }
        try {
            chamcongDAO.save(chamcong);
            redirect.addFlashAttribute("message", "Thêm chấm công thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi thêm chấm công: " + e.getMessage());
        }
        return "redirect:/chamcong";
    }

    // 📌 Hiển thị form chỉnh sửa chấm công
    @GetMapping("/edit/{chamcongId}")
    public String showEditForm(@PathVariable("chamcongId") String chamcongId, Model model, RedirectAttributes redirect) {
        Chamcong chamcong = chamcongDAO.getById(chamcongId);
        if (chamcong == null) {
            redirect.addFlashAttribute("error", "Không tìm thấy chấm công với ID: " + chamcongId);
            return "redirect:/chamcong";
        }
        model.addAttribute("chamcong", chamcong);
        return "chamcong-edit"; 
    }

    // 📌 Xử lý cập nhật chấm công
    @PostMapping("/edit/{chamcongId}")
    public String updateChamcong(@RequestParam("chamcongId") String chamcongId, 
            @ModelAttribute("chamcong") Chamcong chamcong) {
chamcong.setChamcongId(chamcongId); // Gán ID từ request vào đối tượng
chamcongDAO.update(chamcong);
return "redirect:/chamcong";
}

    

    // 📌 Xóa chấm công
    @GetMapping("/delete/{chamcongId}")
    public String deleteChamcong(@PathVariable("chamcongId") String chamcongId, RedirectAttributes redirect) {
        try {
            chamcongDAO.delete(chamcongId);
            redirect.addFlashAttribute("message", "Xóa chấm công thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi xóa chấm công: " + e.getMessage());
        }
        return "redirect:/chamcong";
    }
}
