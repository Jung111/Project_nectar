package project.nectar.domain;

import java.util.Objects;

public class AdminDto {
    private String admin_email;
    private String admin_pwd;
    private String admin_name;
    private String admin_phone;
    private String admin_picture;
    private String admin_regdate;
    private String authority;
    private Integer enabled;

    public AdminDto(){}
    public AdminDto(String admin_email, String admin_pwd, String admin_name, String admin_phone, String admin_picture) {
        this.admin_email = admin_email;
        this.admin_pwd = admin_pwd;
        this.admin_name = admin_name;
        this.admin_phone = admin_phone;
        this.admin_picture = admin_picture;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_pwd() {
        return admin_pwd;
    }

    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd;
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

    public String getAdmin_picture() {
        return admin_picture;
    }

    public void setAdmin_picture(String admin_picture) {
        this.admin_picture = admin_picture;
    }

    public String getAdmin_regdate() {
        return admin_regdate;
    }

    public void setAdmin_regdate(String admin_regdate) {
        this.admin_regdate = admin_regdate;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDto adminDto = (AdminDto) o;
        return Objects.equals(admin_email, adminDto.admin_email) && Objects.equals(admin_pwd, adminDto.admin_pwd) && Objects.equals(admin_name, adminDto.admin_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(admin_email, admin_pwd, admin_name);
    }

    @Override
    public String toString() {
        return "AdminDto{" +
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
