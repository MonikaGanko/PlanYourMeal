package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.PlanRecipe;
import pl.coderslab.repository.PlanRecipeRepository;

import java.util.List;

@Service
@Transactional
public class PlanRecipeServiceImpl implements PlanRecipeService {

    @Autowired
    PlanRecipeRepository planRecipeRepository;

    @Override
    public void save(PlanRecipe planRecipe) {
        planRecipeRepository.save(planRecipe);
    }

    @Override
    public void update(PlanRecipe planRecipe) {
        planRecipeRepository.save(planRecipe);
    }

    @Override
    public void delete(Integer id) {
        planRecipeRepository.delete(id);
    }

    @Override
    public PlanRecipe findById(Integer id) {
        return planRecipeRepository.findById(id);
    }

    @Override
    public List<PlanRecipe> findAllByPlanId(int planId) {
        return planRecipeRepository.findAllByPlanId(planId);
    }
}
