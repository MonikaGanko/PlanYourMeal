package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "plan_recipe")
public class PlanRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 245)
    private String mealName;

    private int ord;

    @ManyToOne
    private Recipe recipe;

    @ManyToOne
    DayName dayName;

    @ManyToOne
    Plan plan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getOrder() {
        return ord;
    }

    public void setOrder(int order) {
        this.ord = order;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public DayName getDayName() {
        return dayName;
    }

    public void setDayName(DayName dayName) {
        this.dayName = dayName;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }
}
