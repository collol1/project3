package springmvc.com.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.com.beans.User;
import springmvc.com.dao.Userdao;
import springmvc.com.dao.Productdao;


@Controller  
public class Homecontroller {  
	
    @Autowired  
    Userdao dao1;
      
    
    @GetMapping("/saveform")  
    public String showform1(Model m){  
    	m.addAttribute("command", new User());
    	return "saveform"; 
    }  
   
    @PostMapping(value="/save")  
    public String save1(@ModelAttribute("User") User user){  
        dao1.save(user);  
        return "redirect:/viewform";  
    }  
 
    @RequestMapping("/viewform")  
    public String viewemp1(Model m){  
        List<User> list=dao1.getEmployees();  
        m.addAttribute("list",list);
        return "viewform";  
    }  
    
    @RequestMapping(value="/edituser/{id}")  
    public String edit1(@PathVariable int id, Model m){  
    	User user=dao1.getEmpById(id);  
        m.addAttribute("command",user);
        return "editform";  
    }  
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave1(@ModelAttribute("User") User user){  
        dao1.update(user);  
        return "redirect:/viewform";  
    }  
     
    @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)  
    public String delete1(@PathVariable int id){  
        dao1.delete(id);  
        return "redirect:/viewform";  
    } 

    
    ///PRODUCT
    
    @Autowired  
    Productdao dao;
      
    
    @GetMapping("/saveform")  
    public String showform(Model m){  
    	m.addAttribute("command", new User());
    	return "saveform"; 
    }  
   
    @PostMapping(value="/save")  
    public String save(@ModelAttribute("User") User user){  
        dao1.save(user);  
        return "redirect:/viewform";  
    }  
 
    @RequestMapping("/viewform")  
    public String viewemp(Model m){  
        List<User> list=dao1.getEmployees();  
        m.addAttribute("list",list);
        return "viewform";  
    }  
    
    @RequestMapping(value="/edituser/{id}")  
    public String edit(@PathVariable int id, Model m){  
    	User user=dao1.getEmpById(id);  
        m.addAttribute("command",user);
        return "editform";  
    }  
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("User") User user){  
        dao1.update(user);  
        return "redirect:/viewform";  
    }  
     
    @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao1.delete(id);  
        return "redirect:/viewform";  
    } 
    
}  
