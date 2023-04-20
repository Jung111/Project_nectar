package project.nectar.domain;

import java.util.Date;
import java.util.Objects;

public class ReviewPlusDto {
    private Integer review_NUM;
    private Integer restr_NUM;
    private String restr_name;         //추가
    private String restr_location;     //추가
    private String restr_phone;        //추가
    private String restr_picture;      //추가
    private String user_email;
    private String user_name;
    private String user_picture;
    private String review_comment;
    private String review_picture;
    private float review_star;
    private Date review_regdate;
    private Date review_update;

    public ReviewPlusDto() {}

    public Integer getReview_NUM() {
        return review_NUM;
    }

    public void setReview_NUM(Integer review_NUM) {
        this.review_NUM = review_NUM;
    }

    public Integer getRestr_NUM() {
        return restr_NUM;
    }

    public void setRestr_NUM(Integer restr_NUM) {
        this.restr_NUM = restr_NUM;
    }

    public String getRestr_name() {
        return restr_name;
    }

    public void setRestr_name(String restr_name) {
        this.restr_name = restr_name;
    }

    public String getRestr_location() {
        return restr_location;
    }

    public void setRestr_location(String restr_location) {
        this.restr_location = restr_location;
    }

    public String getRestr_phone() {
        return restr_phone;
    }

    public void setRestr_phone(String restr_phone) {
        this.restr_phone = restr_phone;
    }

    public String getRestr_picture() {
        return restr_picture;
    }

    public void setRestr_picture(String restr_picture) {
        this.restr_picture = restr_picture;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_picture() {
        return user_picture;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
    }

    public String getReview_picture() {
        return review_picture;
    }

    public void setReview_picture(String review_picture) {
        this.review_picture = review_picture;
    }

    public float getReview_star() {
        return review_star;
    }

    public void setReview_star(float review_star) {
        this.review_star = review_star;
    }

    public Date getReview_regdate() {
        return review_regdate;
    }

    public void setReview_regdate(Date review_regdate) {
        this.review_regdate = review_regdate;
    }

    public Date getReview_update() {
        return review_update;
    }

    public void setReview_update(Date review_update) {
        this.review_update = review_update;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewPlusDto that = (ReviewPlusDto) o;
        return Objects.equals(review_NUM, that.review_NUM) && Objects.equals(restr_NUM, that.restr_NUM) && Objects.equals(user_email, that.user_email) && Objects.equals(review_comment, that.review_comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review_NUM, restr_NUM, user_email, review_comment);
    }

    @Override
    public String toString() {
        return "ReviewPlusDto{" +
                "review_NUM=" + review_NUM +
                ", restr_NUM=" + restr_NUM +
                ", restr_name='" + restr_name + '\'' +
                ", restr_location='" + restr_location + '\'' +
                ", restr_phone='" + restr_phone + '\'' +
                ", restr_picture='" + restr_picture + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_picture='" + user_picture + '\'' +
                ", review_comment='" + review_comment + '\'' +
                ", review_picture='" + review_picture + '\'' +
                ", review_star=" + review_star +
                ", review_regdate=" + review_regdate +
                ", review_update=" + review_update +
                '}';
    }
}
