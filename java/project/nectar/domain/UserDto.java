package project.nectar.domain;

import java.util.Date;
import java.util.Objects;

public class UserDto {
    private String user_email;
    private String user_pwd;
    private String user_name;
    private String user_phone;
    private String user_picture;
    private Date user_regdate;
    private String user_state_code;
                                    //  일반회원 : user_state_code
                                    //  0 : 일반회원. 사이트 모든 기본 기능 사용 가능(default)
                                    // -1 : 리뷰작성 금지
                                    // -2 : 핫딜결제 금지
                                    // -3 : 계정 정지
    private String authority;       // 페이지 접근 권한; ROLE_USER
    private Integer enabled;

    public UserDto(){};
    public UserDto(String user_email, String user_pwd, String user_name, String user_phone, String user_picture) {
        this.user_email = user_email;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_picture = user_picture;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
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

    public String getUser_picture() {
        return user_picture;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    public Date getUser_regdate() {
        return user_regdate;
    }

    public void setUser_regdate(Date user_regdate) {
        this.user_regdate = user_regdate;
    }

    public String getUser_state_code() {
        return user_state_code;
    }

    public void setUser_state_code(String user_state_code) {
        this.user_state_code = user_state_code;
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
        UserDto userDto = (UserDto) o;
        return Objects.equals(user_email, userDto.user_email) && Objects.equals(user_pwd, userDto.user_pwd) && Objects.equals(user_name, userDto.user_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_email, user_pwd, user_name);
    }

    @Override
    public String toString() {
        return "UserDto{" +
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
