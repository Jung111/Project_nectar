package project.nectar.domain;

import java.util.Date;
import java.util.Objects;

public class ReviewDto {
    private Integer review_NUM;
    private Integer restr_NUM;
    private String user_email;
    private String user_name;
    private String user_picture;
    private String review_comment;
    private String review_picture;
    private float review_star;
    private Date review_regdate;
    private Date review_update;

    public ReviewDto(){this(455,"User_157@google.com", "홍혜빈","user_pic" , "내 리뷰를 이용하라","asdf123",3.0f);}
    public ReviewDto(Integer restr_NUM, String user_email, String user_name, String user_picture, String review_comment, String review_picture, float review_star) {
            this.restr_NUM = restr_NUM;
            this.user_email = user_email;
            this.user_name = user_name;
            this.user_picture = user_picture;
            this.review_comment = review_comment;
            this.review_picture = review_picture;
            this.review_star = review_star;
        }

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
        ReviewDto reviewDto = (ReviewDto) o;
        return Objects.equals(review_NUM, reviewDto.review_NUM) && Objects.equals(restr_NUM, reviewDto.restr_NUM) && Objects.equals(user_email, reviewDto.user_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review_NUM, restr_NUM, user_email);
    }

    @Override
    public String toString() {
        return "ReviewDto{" +
                "review_NUM=" + review_NUM +
                ", restr_NUM=" + restr_NUM +
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
