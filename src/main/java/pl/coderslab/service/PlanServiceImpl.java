package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Plan;
import pl.coderslab.repository.PlanRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PlanServiceImpl implements PlanService<Plan> {

    @Autowired
    PlanRepository planRepository;

    @Override
    public void savePlan(Plan plan) {
        plan.setCreated(LocalDate.now());
        planRepository.save(plan);
    }

    @Override
    public void deleteById(Integer id) {
        planRepository.deleteById(id);
    }

    @Override
    public long countPlansByAdmin(int adminId) {
        return planRepository.countPlansByAdminId(adminId);
    }

    @Override
    public List<Plan> findAllByAdmin(int adminId) {
        return planRepository.findAllByAdminIdOrderByCreatedAsc(adminId);
    }

    @Override
    public Plan findLatest() {
        return planRepository.findFirstByOrderByCreatedDesc();
    }

    @Override
    public Plan findLatestByAdmin(int adminId) {
        return planRepository.findFirstByAdminIdOrderByCreatedDesc(adminId);
    }


    @Override
    public Plan findById(int planId) {
        return planRepository.findPLanById(planId);
    }

    @Override
    public void delete(Plan plan) {
        planRepository.delete(plan);
    }
}
