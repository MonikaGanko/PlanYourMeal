package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.comparators.PlanRecipeOrderComparator;
import pl.coderslab.model.Admin;
import pl.coderslab.model.CurrentAdmin;
import pl.coderslab.model.Plan;
import pl.coderslab.model.PlanRecipe;
import pl.coderslab.service.AdminService;
import pl.coderslab.service.PlanService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/app/plan")
public class PlanController {

    @Autowired
    PlanService planService;
    @Autowired
    AdminService adminService;

    @RequestMapping("/list")
    public String planList(@AuthenticationPrincipal CurrentAdmin customAdmin, Model model) {
        Admin currentAdmin = customAdmin.getAdmin();
        model.addAttribute("plans", planService.findAllByAdmin(currentAdmin.getId()));
        return "app-schedules";
    }

    @GetMapping("/add")
    public String addPlanForm(@AuthenticationPrincipal CurrentAdmin customAdmin, Model model) {
        Admin currentAdmin = customAdmin.getAdmin();
        Plan plan = new Plan();
        plan.setAdmin(currentAdmin);
        model.addAttribute("plan", plan);
        return "app-add-schedule";
    }

    @PostMapping("/add")
    public String addPlanAction(@AuthenticationPrincipal CurrentAdmin customAdmin, @ModelAttribute @Valid Plan plan, BindingResult result) {
        Admin currentAdmin = customAdmin.getAdmin();
        plan.setAdmin(currentAdmin);
        plan.setCreated(LocalDate.now());
        planService.savePlan(plan);
        return "redirect:/app/plan/list";
    }

    @GetMapping("/edit/{planId}")
    public String editPlanForm(@AuthenticationPrincipal CurrentAdmin customAdmin,
                               @PathVariable Integer planId, Model model) {
        Admin currentAdmin = customAdmin.getAdmin();
        Plan planToEdit = planService.findById(planId);
        if (planId == null) {
            return "redirect:/app/plan/list";
        }
        model.addAttribute("planToEdit", planToEdit);
        return "app-edit-schedule";
    }

    @PostMapping("/edit")
    public String editPlanAction(@AuthenticationPrincipal CurrentAdmin customAdmin, @ModelAttribute @Valid Plan plan, BindingResult result) {
        if (result.hasErrors()) {
            return "app-edit-schedule";
        }
        Admin currentAdmin = customAdmin.getAdmin();
        if (plan.getCreated() == null) plan.setCreated(LocalDate.now());
        plan.setAdmin(currentAdmin);
        planService.savePlan(plan);
        return "redirect:/app/plan/list";
    }

    @GetMapping("/delete/{id}")
    public String delPlanConfirm(@PathVariable Integer id, Model model) {
        Plan plan = planService.findById(id);
        if (plan != null) {
            model.addAttribute("plan", plan);
            return "app-del-schedule-confirm";
        }
        return "redirect:/app/plan/list";
    }

    @GetMapping("/deleted/{id}")
    public String delPlanAction(@PathVariable Integer id) {
        Plan planCheck = planService.findById(id);
        if (planCheck != null) {
            planService.delete(planCheck);
        }
        return "redirect:/app/plan/list";
    }

    @RequestMapping("/details/{planId}")
    public String planDetails(@PathVariable Integer planId, Model model) {
        Plan plan = planService.findById(planId);
        List<PlanRecipe> temp = plan.getPlanRecipes();
        List<PlanRecipe> monday = new ArrayList<>();
        List<PlanRecipe> tuesday = new ArrayList<>();
        List<PlanRecipe> wednesday = new ArrayList<>();
        List<PlanRecipe> thursday = new ArrayList<>();
        List<PlanRecipe> friday = new ArrayList<>();
        List<PlanRecipe> saturday = new ArrayList<>();
        List<PlanRecipe> sunday = new ArrayList<>();
        for (PlanRecipe pr : temp) {
            if (pr.getDayName().getOrd() == 1) {
                monday.add(pr);
            } else if (pr.getDayName().getOrd() == 2) {
                tuesday.add(pr);
            } else if (pr.getDayName().getOrd() == 3) {
                wednesday.add(pr);
            } else if (pr.getDayName().getOrd() == 4) {
                thursday.add(pr);
            } else if (pr.getDayName().getOrd() == 5) {
                friday.add(pr);
            } else if (pr.getDayName().getOrd() == 6) {
                friday.add(pr);
            } else if (pr.getDayName().getOrd() == 7) {
                friday.add(pr);
            }
        }
        Collections.sort(monday, new PlanRecipeOrderComparator());
        Collections.sort(tuesday, new PlanRecipeOrderComparator());
        Collections.sort(wednesday, new PlanRecipeOrderComparator());
        Collections.sort(thursday, new PlanRecipeOrderComparator());
        Collections.sort(friday, new PlanRecipeOrderComparator());
        Collections.sort(saturday, new PlanRecipeOrderComparator());
        Collections.sort(sunday, new PlanRecipeOrderComparator());

        model.addAttribute("plan", plan);
        model.addAttribute("monday", monday);
        model.addAttribute("tuesday", tuesday);
        model.addAttribute("wednesday", wednesday);
        model.addAttribute("thursday", thursday);
        model.addAttribute("friday", friday);
        model.addAttribute("saturday", saturday);
        model.addAttribute("sunday", sunday);

        return "app-details-schedules";
    }
}