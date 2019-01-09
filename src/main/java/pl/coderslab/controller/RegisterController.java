package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Role;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.service.AdminService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    AdminService adminService;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/register")
    public String registerForm(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "registration";
    }

    @PostMapping("/register")
    public String registerAction(@ModelAttribute @Valid Admin admin, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        } else if (!admin.getPassword().equals(admin.getPasswordCheck())) {
            return "registration";
        }

        Admin adminCheckEmail = adminService.findByEmail(admin.getEmail());
        Admin adminCheckUsername = adminService.findByUsername(admin.getUsername());

        if (adminCheckEmail == null && adminCheckUsername == null) {
            Role role = roleRepository.findByName("ROLE_USER");
            admin.setRole(role);
            adminService.save(admin);
            return "redirect:/login";
        }
        if (admin.getPassword().length() > 45) {
            return "registration";
        }
        if (adminCheckEmail != null) admin.setEmail("Email zarejestrowany");
        if (adminCheckUsername != null) admin.setUsername("Użytkownik zarejestrowany");
        return "registration";
    }
}
