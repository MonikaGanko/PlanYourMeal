package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Recipe;
import pl.coderslab.repository.RecipeRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService<Recipe> {

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public void addRecipe(Recipe recipe) {
        recipe.setCreated(LocalDate.now());
        recipeRepository.save(recipe);
    }

    @Override
    public long countRecipesByAdmin(int adminId) {
        return recipeRepository.countRecipesByAdminId(adminId);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Integer id) {
        return recipeRepository.findRecipeById(id);
    }

    @Override
    public List<Recipe> findAllByAdmin_Id(Integer adminId) {
        return recipeRepository.findAllByAdmin_Id(adminId);
    }

    @Override

    public void delete(Integer recipeId) {
        recipeRepository.delete(recipeId);
    }
}
