package pl.coderslab.model;

import pl.coderslab.model.Admin;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 45)
    private String name;

    private String description;

    private LocalDate created;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "plan", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<PlanRecipe> planRecipes = new ArrayList<>();


    public Plan() {
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<PlanRecipe> getPlanRecipes() {
        return planRecipes;
    }

    public void setPlanRecipes(List<PlanRecipe> planRecipes) {
        this.planRecipes = planRecipes;
    }

}