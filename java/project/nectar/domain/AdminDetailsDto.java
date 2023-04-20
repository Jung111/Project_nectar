package project.nectar.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AdminDetailsDto implements UserDetails {
    private String admin_email;
    private String admin_pwd;
    private String admin_name;
    private String admin_phone;
    private String admin_picture;
    private String admin_regdate;
    private String authority;
    private Integer enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority(authority));
        return authList;
    }

    @Override
    public String getPassword() {
        return admin_pwd;
    }

    @Override
    public String getUsername() {
        return admin_email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled==1?true:false;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }

    @Override
    public String toString() {
        return "AdminDetailsDto{" +
                "admin_email='" + admin_email + '\'' +
                ", admin_pwd='" + admin_pwd + '\'' +
                ", admin_name='" + admin_name + '\'' +
                ", admin_phone='" + admin_phone + '\'' +
                ", admin_picture='" + admin_picture + '\'' +
                ", admin_regdate='" + admin_regdate + '\'' +
                ", authority='" + authority + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
