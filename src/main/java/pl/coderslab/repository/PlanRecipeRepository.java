package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.PlanRecipe;

import java.util.List;

public interface PlanRecipeRepository extends JpaRepository<PlanRecipe, Integer> {
    List<PlanRecipe> findAllByPlanId(int planId);

    PlanRecipe findById(Integer id);

}
