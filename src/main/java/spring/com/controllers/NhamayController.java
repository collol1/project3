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

import spring.com.beans.Luong;
import spring.com.beans.Nhamay;
import spring.com.dao.NhamayDAO;

@Controller
@RequestMapping("/nhamay")
public class NhamayController {

    @Autowired
    private NhamayDAO nhamayDAO;

    // 📌 API JSON: Lấy danh sách nhà máy
    @GetMapping("/api")
    @ResponseBody
    public List<Nhamay> getNhamayApi() {
        return nhamayDAO.getAll();
    }

    // 📌 Hiển thị danh sách nhà máy (JSP)
    @GetMapping
    public String listNhamay(Model model) {
        model.addAttribute("listNhamay", nhamayDAO.getAll());
        return "nhamay-list";
    }

    // 📌 Hiển thị form thêm nhà máy
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhamay", new Nhamay());
        return "nhamay-form";
    }

    // 📌 Xử lý thêm nhà máy (có kiểm tra lỗi)
    @PostMapping("/save")
    public String saveNhamay(@Validated @ModelAttribute("nhamay") Nhamay nhamay, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "nhamay-form";
        }
        try {
            nhamayDAO.save(nhamay);
            redirect.addFlashAttribute("message", "Thêm nhà máy thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi thêm nhà máy: " + e.getMessage());
        }
        return "redirect:/nhamay";
    }

    // 📌 Hiển thị form chỉnh sửa nhà máy
    @GetMapping("/edit/{nhamayId}")
    public String showEditForm(@PathVariable("nhamayId") String nhamayId, Model model, RedirectAttributes redirect) {
        Nhamay nhamay = nhamayDAO.getById(nhamayId);
        if (nhamay == null) {
            redirect.addFlashAttribute("error", "Không tìm thấy nhà máy với ID: " + nhamayId);
            return "redirect:/nhamay";
        }
        model.addAttribute("nhamay", nhamay);
        return "nhamay-form"; // Sử dụng chung form cho thêm và chỉnh sửa
    }

    // 📌 Xử lý cập nhật nhà máy
    @PostMapping("/edit/{nhamayId}")
    public String updateNhamay(@RequestParam("nhamayId") String nhamayId, 
            @ModelAttribute("nhamay") Nhamay nhamay) {
    	nhamay.setNhamayId(nhamayId); // Gán ID từ request vào đối tượng
    	nhamayDAO.update(nhamay);
    	return "redirect:/nhamay";
}

    // 📌 Xóa nhà máy
    @GetMapping("/delete/{nhamayId}")
    public String deleteNhamay(@PathVariable("nhamayId") String nhamayId, RedirectAttributes redirect) {
        try {
            nhamayDAO.delete(nhamayId);
            redirect.addFlashAttribute("message", "Xóa nhà máy thành công!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Lỗi khi xóa nhà máy: " + e.getMessage());
        }
        return "redirect:/nhamay";
    }
}
