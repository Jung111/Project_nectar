package project.nectar.domain;

import java.util.Objects;

public class BizAccountDto {
    private String bizAccount_email;
    private String bizAccount_pwd;
    private String bizAccount_name;
    private String bizAccount_phone;
    private String bizAccount_picture;
    private String bizAccount_regdate;
    private String bizAccount_state_code;
                                            // 사업자 회원 : bizAccount_state_code
                                            //  0 : 사업자회원. 사이트 모든 기본 기능 사용 가능(default)
                                            // -4 : 매장게시정지
                                            // -5 : 핫딜등록금지
                                            // -3 : 계정 정지
    private String bizAccount_regNum;
    private String authority;
    private Integer enabled;

    public BizAccountDto(){}
    public BizAccountDto(String bizAccount_email, String bizAccount_pwd, String bizAccount_name, String bizAccount_phone, String bizAccount_picture, String bizAccount_regNum) {
        this.bizAccount_email = bizAccount_email;
        this.bizAccount_pwd = bizAccount_pwd;
        this.bizAccount_name = bizAccount_name;
        this.bizAccount_phone = bizAccount_phone;
        this.bizAccount_picture = bizAccount_picture;
        this.bizAccount_regNum = bizAccount_regNum;
    }

    public String getBizAccount_email() {
        return bizAccount_email;
    }

    public void setBizAccount_email(String bizAccount_email) {
        this.bizAccount_email = bizAccount_email;
    }

    public String getBizAccount_pwd() {
        return bizAccount_pwd;
    }

    public void setBizAccount_pwd(String bizAccount_pwd) {
        this.bizAccount_pwd = bizAccount_pwd;
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

    public String getBizAccount_picture() {
        return bizAccount_picture;
    }

    public void setBizAccount_picture(String bizAccount_picture) {
        this.bizAccount_picture = bizAccount_picture;
    }

    public String getBizAccount_regdate() {
        return bizAccount_regdate;
    }

    public void setBizAccount_regdate(String bizAccount_regdate) {
        this.bizAccount_regdate = bizAccount_regdate;
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
        BizAccountDto that = (BizAccountDto) o;
        return Objects.equals(bizAccount_email, that.bizAccount_email) && Objects.equals(bizAccount_pwd, that.bizAccount_pwd) && Objects.equals(bizAccount_name, that.bizAccount_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizAccount_email, bizAccount_pwd, bizAccount_name);
    }

    @Override
    public String toString() {
        return "BizAccountDto{" +
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
