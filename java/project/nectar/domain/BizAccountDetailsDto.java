package project.nectar.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class BizAccountDetailsDto implements UserDetails {

    private String bizAccount_email;
    private String bizAccount_pwd;
    private String bizAccount_name;
    private String bizAccount_phone;
    private String bizAccount_picture;
    private String bizAccount_regdate;
    private String bizAccount_state_code;
    private String bizAccount_regNum;
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
        return bizAccount_pwd;
    }

    @Override
    public String getUsername() {
        return bizAccount_email;
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

    public String getBizAccount_name() {
        return bizAccount_name;
    }

    public void setBizAccount_name(String bizAccount_name) {
        this.bizAccount_name = bizAccount_name;
    }

    public String getBizAccount_phone() {
        return bizAccount_phone;
    }

    public void setBizAccount_phone(String bizAccount_phone) {
        this.bizAccount_phone = bizAccount_phone;
    }

    public String getBizAccount_state_code() {
        return bizAccount_state_code;
    }

    public void setBizAccount_state_code(String bizAccount_state_code) {
        this.bizAccount_state_code = bizAccount_state_code;
    }

    public String getBizAccount_regNum() {
        return bizAccount_regNum;
    }

    public void setBizAccount_regNum(String bizAccount_regNum) {
        this.bizAccount_regNum = bizAccount_regNum;
    }

    @Override
    public String toString() {
        return "BizAccountDetailsDto{" +
                "bizAccount_email='" + bizAccount_email + '\'' +
                ", bizAccount_pwd='" + bizAccount_pwd + '\'' +
                ", bizAccount_name='" + bizAccount_name + '\'' +
                ", bizAccount_phone='" + bizAccount_phone + '\'' +
                ", bizAccount_picture='" + bizAccount_picture + '\'' +
                ", bizAccount_regdate='" + bizAccount_regdate + '\'' +
                ", bizAccount_state_code='" + bizAccount_state_code + '\'' +
                ", bizAccount_regNum='" + bizAccount_regNum + '\'' +
                ", authority='" + authority + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
