package project.nectar.domain;

import java.util.Date;
import java.util.Objects;

public class HotdealDto {
    private Integer hotdeal_NUM;
    private Integer restr_NUM;
    private String restr_name;
    private String restr_category_loc;
    private Integer restr_menu_NUM;
    private String  restr_menu_food;
    private Integer restr_menu_price;
    private Integer hotdeal_price;
    private Integer hotdeal_discountRate;
    private String hotdeal_desc;
    private String hotdeal_picture;
    private String hotdeal_useDate;
    private String hotdeal_eventDuration;
    private Date hotdeal_regdate;
    private Date hotdeal_update;
    private Integer hotdeal_salesVolume;
    private Integer hotdeal_MaxSalesVolume;
    private String bizAccount_email;

    public HotdealDto() {this(1,"맛집1","신사/압구정",1,"김치찌게",6000,3000,50,"파격세일. 빨리사라","no pic","90일","2023/03/14 ~ 2023/03/27",0,100,"Biz_1@google.com");}

    public HotdealDto(Integer restr_NUM, String restr_name, String restr_category_loc, Integer restr_menu_NUM,String restr_menu_food, Integer restr_menu_price, Integer hotdeal_price, Integer hotdeal_discountRate, String hotdeal_desc, String hotdeal_picture, String hotdeal_useDate, String hotdeal_eventDuration, Integer hotdeal_salesVolume, Integer hotdeal_MaxSalesVolume, String bizAccount_email) {
        this.restr_NUM = restr_NUM;
        this.restr_name = restr_name;
        this.restr_category_loc = restr_category_loc;
        this.restr_menu_NUM = restr_menu_NUM;
        this.restr_menu_food = restr_menu_food;
        this.restr_menu_price = restr_menu_price;
        this.hotdeal_price = hotdeal_price;
        this.hotdeal_discountRate = hotdeal_discountRate;
        this.hotdeal_desc = hotdeal_desc;
        this.hotdeal_picture = hotdeal_picture;
        this.hotdeal_useDate = hotdeal_useDate;
        this.hotdeal_eventDuration = hotdeal_eventDuration;
        this.hotdeal_salesVolume = hotdeal_salesVolume;
        this.hotdeal_MaxSalesVolume = hotdeal_MaxSalesVolume;
        this.bizAccount_email = bizAccount_email;
    }

    public Integer getHotdeal_NUM() {
        return hotdeal_NUM;
    }

    public void setHotdeal_NUM(Integer hotdeal_NUM) {
        this.hotdeal_NUM = hotdeal_NUM;
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

    public String getRestr_category_loc() {
        return restr_category_loc;
    }

    public void setRestr_category_loc(String restr_category_loc) {
        this.restr_category_loc = restr_category_loc;
    }

    public Integer getRestr_menu_NUM() {
        return restr_menu_NUM;
    }

    public void setRestr_menu_NUM(Integer restr_menu_NUM) {
        this.restr_menu_NUM = restr_menu_NUM;
    }


    public String getRestr_menu_food() {
        return restr_menu_food;
    }

    public void setRestr_menu_food(String restr_menu_food) {
        this.restr_menu_food = restr_menu_food;
    }

    public Integer getRestr_menu_price() {
        return restr_menu_price;
    }

    public void setRestr_menu_price(Integer restr_menu_price) {
        this.restr_menu_price = restr_menu_price;
    }

    public Integer getHotdeal_price() {
        return hotdeal_price;
    }

    public void setHotdeal_price(Integer hotdeal_price) {
        this.hotdeal_price = hotdeal_price;
    }

    public Integer getHotdeal_discountRate() {
        return hotdeal_discountRate;
    }

    public void setHotdeal_discountRate(Integer hotdeal_discountRate) {
        this.hotdeal_discountRate = hotdeal_discountRate;
    }

    public String getHotdeal_desc() {
        return hotdeal_desc;
    }

    public void setHotdeal_desc(String hotdeal_desc) {
        this.hotdeal_desc = hotdeal_desc;
    }

    public String getHotdeal_picture() {
        return hotdeal_picture;
    }

    public void setHotdeal_picture(String hotdeal_picture) {
        this.hotdeal_picture = hotdeal_picture;
    }

    public String getHotdeal_useDate() {
        return hotdeal_useDate;
    }

    public void setHotdeal_useDate(String hotdeal_useDate) {
        this.hotdeal_useDate = hotdeal_useDate;
    }

    public String getHotdeal_eventDuration() {
        return hotdeal_eventDuration;
    }

    public void setHotdeal_eventDuration(String hotdeal_eventDuration) {
        this.hotdeal_eventDuration = hotdeal_eventDuration;
    }

    public Date getHotdeal_regdate() {
        return hotdeal_regdate;
    }

    public void setHotdeal_regdate(Date hotdeal_regdate) {
        this.hotdeal_regdate = hotdeal_regdate;
    }

    public Date getHotdeal_update() {
        return hotdeal_update;
    }

    public void setHotdeal_update(Date hotdeal_update) {
        this.hotdeal_update = hotdeal_update;
    }

    public Integer getHotdeal_salesVolume() {
        return hotdeal_salesVolume;
    }

    public void setHotdeal_salesVolume(Integer hotdeal_salesVolume) {
        this.hotdeal_salesVolume = hotdeal_salesVolume;
    }

    public Integer getHotdeal_MaxSalesVolume() {
        return hotdeal_MaxSalesVolume;
    }

    public void setHotdeal_MaxSalesVolume(Integer hotdeal_MaxSalesVolume) {
        this.hotdeal_MaxSalesVolume = hotdeal_MaxSalesVolume;
    }

    public String getBizAccount_email() {
        return bizAccount_email;
    }

    public void setBizAccount_email(String bizAccount_email) {
        this.bizAccount_email = bizAccount_email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotdealDto that = (HotdealDto) o;
        return Objects.equals(hotdeal_NUM, that.hotdeal_NUM) && Objects.equals(restr_NUM, that.restr_NUM) && Objects.equals(restr_menu_NUM, that.restr_menu_NUM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotdeal_NUM, restr_NUM, restr_menu_NUM);
    }

    @Override
    public String toString() {
        return "HotdealDto{" +
                "hotdeal_NUM=" + hotdeal_NUM +
                ", restr_NUM=" + restr_NUM +
                ", restr_name='" + restr_name + '\'' +
                ", restr_category_loc='" + restr_category_loc + '\'' +
                ", restr_menu_NUM=" + restr_menu_NUM +
                ", restr_menu_food='" + restr_menu_food + '\'' +
                ", restr_menu_price=" + restr_menu_price +
                ", hotdeal_price=" + hotdeal_price +
                ", hotdeal_discountRate=" + hotdeal_discountRate +
                ", hotdeal_desc='" + hotdeal_desc + '\'' +
                ", hotdeal_picture='" + hotdeal_picture + '\'' +
                ", hotdeal_useDate='" + hotdeal_useDate + '\'' +
                ", hotdeal_eventDuration='" + hotdeal_eventDuration + '\'' +
                ", hotdeal_regdate=" + hotdeal_regdate +
                ", hotdeal_update=" + hotdeal_update +
                ", hotdeal_salesVolume=" + hotdeal_salesVolume +
                ", hotdeal_MaxSalesVolume=" + hotdeal_MaxSalesVolume +
                ", bizAccount_email='" + bizAccount_email + '\'' +
                '}';
    }
}
