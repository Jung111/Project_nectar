package project.nectar.domain;

import java.util.Date;
import java.util.Objects;

public class Request_HotdealDto{                // 핫딜을 요청하는 Dto ; 기존의 HotdealDto 의 모든 칼럼 이름 앞에 request_만 추가함
    private Integer request_hotdeal_NUM;
    private Integer request_restr_NUM;
    private String request_restr_name;
    private String request_restr_category_loc;
    private Integer request_restr_menu_NUM;
    private String  request_restr_menu_food;
    private Integer request_restr_menu_price;
    private Integer request_hotdeal_price;
    private Integer request_hotdeal_discountRate;
    private String request_hotdeal_desc;
    private String request_hotdeal_picture;
    private String request_hotdeal_useDate;
    private String request_hotdeal_eventDuration;
    private Date request_hotdeal_regdate;
    private Date request_hotdeal_update;
    private Integer request_hotdeal_salesVolume;
    private Integer request_hotdeal_MaxSalesVolume;
    private String request_bizAccount_email;
    private String evaluate_msg;        // 심사를 진행한 관리자의 메세지
    private Integer evaluate_code;      // 심사 코드  0 : 심사 대기
                                        // 심사 코드  1 :     승인
                                        // 심사 코드 -1 :     반려

    public Request_HotdealDto(){}
    public Request_HotdealDto(Integer request_hotdeal_NUM) {
        this.request_hotdeal_NUM = request_hotdeal_NUM;
    }

    public Integer getRequest_hotdeal_NUM() {
        return request_hotdeal_NUM;
    }

    public void setRequest_hotdeal_NUM(Integer request_hotdeal_NUM) {
        this.request_hotdeal_NUM = request_hotdeal_NUM;
    }

    public Integer getRequest_restr_NUM() {
        return request_restr_NUM;
    }

    public void setRequest_restr_NUM(Integer request_restr_NUM) {
        this.request_restr_NUM = request_restr_NUM;
    }

    public String getRequest_restr_name() {
        return request_restr_name;
    }

    public void setRequest_restr_name(String request_restr_name) {
        this.request_restr_name = request_restr_name;
    }

    public String getRequest_restr_category_loc() {
        return request_restr_category_loc;
    }

    public void setRequest_restr_category_loc(String request_restr_category_loc) {
        this.request_restr_category_loc = request_restr_category_loc;
    }

    public Integer getRequest_restr_menu_NUM() {
        return request_restr_menu_NUM;
    }

    public void setRequest_restr_menu_NUM(Integer request_restr_menu_NUM) {
        this.request_restr_menu_NUM = request_restr_menu_NUM;
    }

    public String getRequest_restr_menu_food() {
        return request_restr_menu_food;
    }

    public void setRequest_restr_menu_food(String request_restr_menu_food) {
        this.request_restr_menu_food = request_restr_menu_food;
    }

    public Integer getRequest_restr_menu_price() {
        return request_restr_menu_price;
    }

    public void setRequest_restr_menu_price(Integer request_restr_menu_price) {
        this.request_restr_menu_price = request_restr_menu_price;
    }

    public Integer getRequest_hotdeal_price() {
        return request_hotdeal_price;
    }

    public void setRequest_hotdeal_price(Integer request_hotdeal_price) {
        this.request_hotdeal_price = request_hotdeal_price;
    }

    public Integer getRequest_hotdeal_discountRate() {
        return request_hotdeal_discountRate;
    }

    public void setRequest_hotdeal_discountRate(Integer request_hotdeal_discountRate) {
        this.request_hotdeal_discountRate = request_hotdeal_discountRate;
    }

    public String getRequest_hotdeal_desc() {
        return request_hotdeal_desc;
    }

    public void setRequest_hotdeal_desc(String request_hotdeal_desc) {
        this.request_hotdeal_desc = request_hotdeal_desc;
    }

    public String getRequest_hotdeal_picture() {
        return request_hotdeal_picture;
    }

    public void setRequest_hotdeal_picture(String request_hotdeal_picture) {
        this.request_hotdeal_picture = request_hotdeal_picture;
    }

    public String getRequest_hotdeal_useDate() {
        return request_hotdeal_useDate;
    }

    public void setRequest_hotdeal_useDate(String request_hotdeal_useDate) {
        this.request_hotdeal_useDate = request_hotdeal_useDate;
    }

    public String getRequest_hotdeal_eventDuration() {
        return request_hotdeal_eventDuration;
    }

    public void setRequest_hotdeal_eventDuration(String request_hotdeal_eventDuration) {
        this.request_hotdeal_eventDuration = request_hotdeal_eventDuration;
    }

    public Date getRequest_hotdeal_regdate() {
        return request_hotdeal_regdate;
    }

    public void setRequest_hotdeal_regdate(Date request_hotdeal_regdate) {
        this.request_hotdeal_regdate = request_hotdeal_regdate;
    }

    public Date getRequest_hotdeal_update() {
        return request_hotdeal_update;
    }

    public void setRequest_hotdeal_update(Date request_hotdeal_update) {
        this.request_hotdeal_update = request_hotdeal_update;
    }

    public Integer getRequest_hotdeal_salesVolume() {
        return request_hotdeal_salesVolume;
    }

    public void setRequest_hotdeal_salesVolume(Integer request_hotdeal_salesVolume) {
        this.request_hotdeal_salesVolume = request_hotdeal_salesVolume;
    }

    public Integer getRequest_hotdeal_MaxSalesVolume() {
        return request_hotdeal_MaxSalesVolume;
    }

    public void setRequest_hotdeal_MaxSalesVolume(Integer request_hotdeal_MaxSalesVolume) {
        this.request_hotdeal_MaxSalesVolume = request_hotdeal_MaxSalesVolume;
    }

    public String getRequest_bizAccount_email() {
        return request_bizAccount_email;
    }

    public void setRequest_bizAccount_email(String request_bizAccount_email) {
        this.request_bizAccount_email = request_bizAccount_email;
    }

    public String getEvaluate_msg() {
        return evaluate_msg;
    }

    public void setEvaluate_msg(String evaluate_msg) {
        this.evaluate_msg = evaluate_msg;
    }

    public Integer getEvaluate_code() {
        return evaluate_code;
    }

    public void setEvaluate_code(Integer evaluate_code) {
        this.evaluate_code = evaluate_code;
    }

    @Override
    public String toString() {
        return "Request_HotdealDto{" +
                "request_hotdeal_NUM=" + request_hotdeal_NUM +
                ", request_restr_NUM=" + request_restr_NUM +
                ", request_restr_name='" + request_restr_name + '\'' +
                ", request_restr_category_loc='" + request_restr_category_loc + '\'' +
                ", request_restr_menu_NUM=" + request_restr_menu_NUM +
                ", request_restr_menu_food='" + request_restr_menu_food + '\'' +
                ", request_restr_menu_price=" + request_restr_menu_price +
                ", request_hotdeal_price=" + request_hotdeal_price +
                ", request_hotdeal_discountRate=" + request_hotdeal_discountRate +
                ", request_hotdeal_desc='" + request_hotdeal_desc + '\'' +
                ", request_hotdeal_picture='" + request_hotdeal_picture + '\'' +
                ", request_hotdeal_useDate='" + request_hotdeal_useDate + '\'' +
                ", request_hotdeal_eventDuration='" + request_hotdeal_eventDuration + '\'' +
                ", request_hotdeal_regdate=" + request_hotdeal_regdate +
                ", request_hotdeal_update=" + request_hotdeal_update +
                ", request_hotdeal_salesVolume=" + request_hotdeal_salesVolume +
                ", request_hotdeal_MaxSalesVolume=" + request_hotdeal_MaxSalesVolume +
                ", request_bizAccount_email='" + request_bizAccount_email + '\'' +
                ", evaluate_msg='" + evaluate_msg + '\'' +
                ", evaluate_code=" + evaluate_code +
                '}';
    }
}
