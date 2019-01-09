package pl.coderslab.service;

import pl.coderslab.model.Admin;

import java.util.List;

public interface AdminService {
    void save(Admin admin);

    void update(Admin admin);

    void deleteById(Integer id);

    Admin findById(Integer id);

    List<Admin> findAll();

    Admin findByEmail(String email);

    Admin findByUsername(String username);
}
