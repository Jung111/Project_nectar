package project.nectar.domain;

import java.util.Objects;

public class LikelistDto {
    private Integer likelist_NUM;
    private Integer restr_NUM;
    private String user_email;

    public LikelistDto(){this(10,"");}
    public LikelistDto(Integer restr_NUM, String user_email) {
        this.restr_NUM = restr_NUM;
        this.user_email = user_email;
    }

    public Integer getLikelist_NUM() {
        return likelist_NUM;
    }

    public void setLikelist_NUM(Integer likelist_NUM) {
        this.likelist_NUM = likelist_NUM;
    }

    public Integer getRestr_NUM() {
        return restr_NUM;
    }

    public void setRestr_NUM(Integer restr_NUM) {
        this.restr_NUM = restr_NUM;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String toString() {
        return "LikelistDto{" +
                "likelist_NUM=" + likelist_NUM +
                ", restr_NUM=" + restr_NUM +
                ", user_email='" + user_email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikelistDto that = (LikelistDto) o;
        return Objects.equals(likelist_NUM, that.likelist_NUM) && Objects.equals(restr_NUM, that.restr_NUM) && Objects.equals(user_email, that.user_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(likelist_NUM, restr_NUM, user_email);
    }
}
