package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    long countRecipesByAdminId(int adminId);

    Recipe findRecipeById(Integer id);

    List<Recipe> findAllByAdmin_Id(Integer adminId);
}
