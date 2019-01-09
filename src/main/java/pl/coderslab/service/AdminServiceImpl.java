package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Role;
import pl.coderslab.repository.AdminRepository;
import pl.coderslab.repository.RoleRepository;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminServiceImpl(AdminRepository adminRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        //public AdminServiceImpl(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public void save(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setEnable(true);
        Role role = roleRepository.findByName("ROLE_USER");
        admin.setRole(role);
        adminRepository.save(admin);
    }

    @Override
    public void update(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void deleteById(Integer id) {
        adminRepository.delete(id);
    }

    @Override
    public Admin findById(Integer id) {
        return adminRepository.findOne(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
