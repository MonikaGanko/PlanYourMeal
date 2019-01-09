package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.comparators.PlanRecipeOrderComparator;
import pl.coderslab.model.Admin;
import pl.coderslab.model.CurrentAdmin;
import pl.coderslab.model.Plan;
import pl.coderslab.model.PlanRecipe;
import pl.coderslab.service.PlanRecipeService;
import pl.coderslab.service.PlanService;
import pl.coderslab.service.RecipeService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    PlanService planService;

    @Autowired
    PlanRecipeService planRecipeService;

    @RequestMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal CurrentAdmin customAdmin, Model model) {

        Admin currentAdmin = customAdmin.getAdmin();
        int currentAdminId = currentAdmin.getId();
        long counterRecipes = recipeService.countRecipesByAdmin(currentAdminId);
        model.addAttribute("counterRecipes", counterRecipes);
        long counterPlans = planService.countPlansByAdmin(currentAdminId);
        model.addAttribute("counterPlans", counterPlans);
        Plan recentPlan = planService.findLatestByAdmin(currentAdminId);
        model.addAttribute("recentPlan", recentPlan);
        List<PlanRecipe> lastPlanRecipes = planRecipeService.findAllByPlanId(recentPlan.getId());
        model.addAttribute("lastPlanRecipes", lastPlanRecipes);
        Plan plan = new Plan();
        plan.setAdmin(currentAdmin);
        model.addAttribute("plan", plan);

        List<PlanRecipe> temp = recentPlan.getPlanRecipes();
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
                saturday.add(pr);
            } else if (pr.getDayName().getOrd() == 7) {
                saturday.add(pr);
            }
        }

        Collections.sort(monday, new PlanRecipeOrderComparator());
        Collections.sort(tuesday, new PlanRecipeOrderComparator());
        Collections.sort(wednesday, new PlanRecipeOrderComparator());
        Collections.sort(thursday, new PlanRecipeOrderComparator());
        Collections.sort(friday, new PlanRecipeOrderComparator());
        Collections.sort(saturday, new PlanRecipeOrderComparator());
        Collections.sort(sunday, new PlanRecipeOrderComparator());

        model.addAttribute("monday", monday);
        model.addAttribute("tuesday", tuesday);
        model.addAttribute("wednesday", wednesday);
        model.addAttribute("thursday", thursday);
        model.addAttribute("friday", friday);
        model.addAttribute("saturday", saturday);
        model.addAttribute("sunday", sunday);

        return "dashboard";
    }
}
