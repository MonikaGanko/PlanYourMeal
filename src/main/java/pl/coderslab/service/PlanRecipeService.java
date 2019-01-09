package pl.coderslab.service;

import pl.coderslab.model.PlanRecipe;

import java.util.List;

public interface PlanRecipeService {
    void save(PlanRecipe planRecipe);

    void update(PlanRecipe planRecipe);

    void delete(Integer id);

    PlanRecipe findById(Integer id);

    List<PlanRecipe> findAllByPlanId(int planId);
}
