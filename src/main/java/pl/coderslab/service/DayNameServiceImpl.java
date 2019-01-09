package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.DayName;
import pl.coderslab.repository.DayNameRepository;

import java.util.List;

@Service
@Transactional
public class DayNameServiceImpl implements DayNameService {

    @Autowired
    DayNameRepository dayNameRepository;

    @Override
    public void save(DayName dayName) {
        dayNameRepository.save(dayName);
    }

    @Override
    public void update(DayName dayName) {
        dayNameRepository.save(dayName);
    }

    @Override
    public void delete(Integer id) {
        dayNameRepository.delete(id);
    }

    @Override
    public DayName findById(Integer id) {
        return dayNameRepository.findOne(id);
    }

    @Override
    public List<DayName> findAll() {
        return dayNameRepository.findAll();
    }
}
