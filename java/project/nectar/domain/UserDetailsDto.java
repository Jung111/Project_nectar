package project.nectar.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@SuppressWarnings("serial")
public class UserDetailsDto implements UserDetails {

    private String user_email;
    private String user_pwd;
    private String user_name;
    private String user_phone;
    private String user_picture;
    private Date user_regdate;
    private String user_state_code;
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
        return user_pwd;
    }

    @Override
    public String getUsername() {
        return user_email;
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


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_state_code() {
        return user_state_code;
    }

    public void setUser_state_code(String user_state_code) {
        this.user_state_code = user_state_code;
    }

    @Override
    public String toString() {
        return "UserDetailsDto{" +
                "user_email='" + user_email + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_picture='" + user_picture + '\'' +
                ", user_regdate=" + user_regdate +
                ", user_state_code='" + user_state_code + '\'' +
                ", authority='" + authority + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
