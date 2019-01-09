package pl.coderslab.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentAdmin extends User {

    private final Admin admin;

    public CurrentAdmin(String username, String password, Collection<? extends GrantedAuthority> authorities, Admin admin) {
        super(username, password, authorities);
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }
}
