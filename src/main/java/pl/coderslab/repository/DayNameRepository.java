package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.DayName;

import java.util.List;

public interface DayNameRepository extends JpaRepository<DayName, Integer> {
    public DayName findById(Integer id);

    public List<DayName> findAll();
}
