package pl.coderslab.service;

import pl.coderslab.model.Plan;

import java.util.List;

public interface PlanService<P> {
    void savePlan(P p);

    void deleteById(Integer id);

    long countPlansByAdmin(int adminId);

    List<P> findAllByAdmin(int adminId);

    Plan findLatest();

    Plan findLatestByAdmin(int adminId);

    Plan findById(int planId);

    void delete(Plan plan);
}
