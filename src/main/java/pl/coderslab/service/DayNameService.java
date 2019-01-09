package pl.coderslab.service;

import pl.coderslab.model.DayName;

import java.util.List;

public interface DayNameService {
    void save(DayName dayName);

    void update(DayName dayName);

    void delete(Integer id);

    DayName findById(Integer id);

    List<DayName> findAll();
}
