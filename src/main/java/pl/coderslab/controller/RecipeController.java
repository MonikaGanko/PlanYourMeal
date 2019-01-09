package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.service.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/app/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    @Autowired
    AdminService adminService;
    @Autowired
    DayNameService dayNameService;
    @Autowired
    PlanService planService;
    @Autowired
    PlanRecipeService planRecipeService;

    // #### List all RECIPES of current USER
    @GetMapping("/list")
    public String recipeListAll(@AuthenticationPrincipal CurrentAdmin customAdmin, Model model) {
        Admin currentAdmin = customAdmin.getAdmin();
        Recipe recipe = new Recipe();
        recipe.setAdmin(currentAdmin);
        List<Recipe> recipes = recipeService.findAllByAdmin_Id(currentAdmin.getId());
        model.addAttribute("currentAdmin", currentAdmin);
        model.addAttribute("recipes", recipes);
        return "app-recipes";
    }

    // #### add RECIPE of current USER - form
    @GetMapping("/add")
    public String recipeAddForm(@AuthenticationPrincipal CurrentAdmin customAdmin, Model model) {
        Admin currentAdmin = customAdmin.getAdmin();
        Recipe recipe = new Recipe();
        recipe.setAdmin(currentAdmin);
        model.addAttribute("recipe", recipe);
        return "app-add-recipe";
    }

    // #### add RECIPE of current USER - action
    @PostMapping("/add")
    public String recipeAddAction(@AuthenticationPrincipal CurrentAdmin customAdmin,
                                  @ModelAttribute @Valid Recipe recipe, BindingResult result) {
        if (result.hasErrors()) {
            return "app-add-recipe";
        }
        // to recipe we bound current admin
        Admin currentAdmin = customAdmin.getAdmin();
        recipe.setAdmin(currentAdmin);
        // if data created id null we set created date
        // if data created is not null - we set updated date
        if (recipe.getCreated() == null) recipe.setCreated(LocalDate.now());
        else recipe.setUpdated(LocalDate.now());
        recipeService.addRecipe(recipe);
        return "redirect:/app/recipe/list";
    }

    // #### show RECIPE details.
    @GetMapping("/details/{id}")
    public String recipeDetails(Model model, @PathVariable Integer id) {
        Recipe recipe = recipeService.findById(id);
        if (recipe == null) {
            return "redirect:/app/recipe/list";
        }
        model.addAttribute("recipe", recipe);
        return "app-recipe-details";
    }

    // #### add RECIPE of current USER to the Plan- FORM
    @GetMapping("/plan/add")
    public String recipeAddToPlanForm(@AuthenticationPrincipal CurrentAdmin customAdmin, Model model) {
        PlanRecipe planRecipe = new PlanRecipe();
        Admin currentAdmin = customAdmin.getAdmin();
        List<Plan> plans = planService.findAllByAdmin(currentAdmin.getId());
        List<DayName> days = dayNameService.findAll();
        List<Recipe> recipes = recipeService.findAllByAdmin_Id(currentAdmin.getId());
        model.addAttribute("planRecipe", planRecipe);
        model.addAttribute("plans", plans);
        model.addAttribute("days", days);
        model.addAttribute("recipes", recipes);
        return "app-schedules-meal-recipe";
    }

    // #### add RECIPE of current USER to the Plan- ACTION
    @PostMapping("/plan/added")
    public String recipeAddToPlanAction(@ModelAttribute @Valid PlanRecipe planRecipe, BindingResult result) {
        if (result.hasErrors()) {
            return "app-schedules-meal-recipe";
        }
        planRecipeService.save(planRecipe);
        return "redirect:/app/recipe/plan/add";
    }

    // ########### EDIT recipe ACTION
    @GetMapping("/edit/{idRecipe}")
    public String editRecipe(@AuthenticationPrincipal CurrentAdmin customAdmin,
                             @PathVariable Integer idRecipe, Model model) {
        Recipe recipe = recipeService.findById(idRecipe);
        if (recipe == null) {
            return "redirect:/app/recipe/list";
        }
        Admin currentAdmin = customAdmin.getAdmin();
        if (currentAdmin.getId() == recipe.getAdmin().getId()) {
            model.addAttribute("recipe", recipe);
        } else {
            return "redirect:/app/recipe/list";
        }
        return "app-add-recipe";
    }

    @GetMapping("/delete/{planRecipeId}/{planId}")
    public String deleteRecipeFromPlan(@PathVariable Integer planRecipeId, @PathVariable Integer planId) {
        return "app-delete-recipe";
    }

    @PostMapping("/delete/{planRecipeId}/{planId}")
    public String deleteRecipeFromPlanConfirmed(@PathVariable Integer planRecipeId, @PathVariable Integer planId, @RequestParam boolean toDelete) {
        if (toDelete) {
            planRecipeService.delete(planRecipeId);
            return "redirect:/app/plan/details/" + planId;
        } else {
            return "redirect:/app/plan/details/" + planId;
        }
    }

    // ########### DELETE recipe CONFIRMATION
    @GetMapping("/delete/{recipeId}")
    public String delRecipeConfirm(@AuthenticationPrincipal CurrentAdmin customAdmin,
                                   @PathVariable Integer recipeId, Model model) {
        Recipe recipe = recipeService.findById(recipeId);
        if (recipe != null) {
            model.addAttribute("recipe", recipe);
            return "app-del-recipe-confirm";
        }
        return "redirect:/app/recipe/list";
    }

    // ########### DELETE recipe ACTION
    @GetMapping("/deleted/{recipeId}")
    public String delRecipeAction(@AuthenticationPrincipal CurrentAdmin customAdmin,
                                  @PathVariable Integer recipeId) {
        Recipe recipe = recipeService.findById(recipeId);
        if (recipe != null) {
            // we - just in case - check if it is admin's recipe if so we delete - if not - go back to recipe list
            Admin currentAdmin = customAdmin.getAdmin();
            if (currentAdmin.getId() == recipe.getAdmin().getId()) {
                recipeService.delete(recipeId);
            }
        }
        return "redirect:/app/recipe/list";
    }
}