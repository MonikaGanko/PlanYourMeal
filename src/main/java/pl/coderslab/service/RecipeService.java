package pl.coderslab.service;

import pl.coderslab.model.Recipe;

import java.util.List;

public interface RecipeService<R> {
    void addRecipe(R r);

    long countRecipesByAdmin(int adminId);

    List<Recipe> findAll();

    Recipe findById(Integer id);

    List<Recipe> findAllByAdmin_Id(Integer adminId);

    void delete(Integer recipeId);

}
