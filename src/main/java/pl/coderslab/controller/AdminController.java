package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Admin;
import pl.coderslab.model.CurrentAdmin;
import pl.coderslab.service.AdminService;

import javax.validation.Valid;

@Controller
@RequestMapping("/app/admin")
public class AdminController {

    @Autowired
    AdminService adminService;


    @GetMapping("/edit")
    public String editAdminData(@AuthenticationPrincipal CurrentAdmin customAdmin, Model model) {
        Admin admin = customAdmin.getAdmin();
        model.addAttribute("admin", admin);
        return "app-edit-user-data";
    }

    @PostMapping("/edit")
    public String editAdminData(@ModelAttribute @Valid Admin admin, BindingResult result) {
        if (result.hasErrors()) {
            return "app-edit-user-data";
        }

  /*      Admin currentAdmin = customAdmin.getAdmin();
        Admin adminFind = adminService.findById(currentAdmin.getId());
        adminFind.setFirstName(admin.getFirstName());
        adminFind.setLastName(admin.getLastName());
        adminFind.setEmail(admin.getEmail());
        adminService.update(adminFind);*/
        adminService.update(admin);
        return "dashboard";
    }

}
