package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.model.Admin;
import pl.coderslab.model.CurrentAdmin;
import pl.coderslab.model.Role;

import java.util.HashSet;
import java.util.Set;

public class SpringDataAdminDetailsService implements UserDetailsService {

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Admin admin = adminService.findByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Role currentRole = admin.getRole();
        grantedAuthorities.add(new SimpleGrantedAuthority(currentRole.getName()));


        return new CurrentAdmin(admin.getUsername(), admin.getPassword(), grantedAuthorities, admin);
    }
}
