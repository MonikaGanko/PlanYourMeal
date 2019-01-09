package pl.coderslab.model;

import pl.coderslab.model.Admin;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String description; // short description of what is inside

    @Column(columnDefinition = "TEXT")
    private String ingredients; // detailed ingredients descr.

    @Column(columnDefinition = "TEXT")
    private String preparation; // detalied way of preparation of the recipe

    private LocalDate created;

    private LocalDate updated;

    @Column(name = "preparationTime")
    @Min(0)
    private int preparationTime;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<PlanRecipe> planRecipes = new ArrayList<>();

    public Recipe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public List<PlanRecipe> getPlanRecipes() {
        return planRecipes;
    }

    public void setPlanRecipes(List<PlanRecipe> planRecipes) {
        this.planRecipes = planRecipes;
    }

}
