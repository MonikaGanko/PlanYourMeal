package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
    long countPlansByAdminId(int adminId);

    List<Plan> findAllByAdminIdOrderByCreatedAsc(int adminId);

    Plan findFirstByOrderByCreatedDesc();

    Plan findFirstByAdminIdOrderByCreatedDesc(int adminId);

    Plan findPLanById(int planId);

    void deleteById(Integer id);

}



