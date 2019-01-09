package pl.coderslab.comparators;

import pl.coderslab.model.PlanRecipe;

import java.util.Comparator;

public class PlanRecipeOrderComparator implements Comparator<PlanRecipe> {
    @Override
    public int compare(PlanRecipe pR1, PlanRecipe pR2) {
        return pR1.getOrder() - pR2.getOrder();
    }
}
