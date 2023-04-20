package project.nectar.domain;

import java.util.Objects;

public class Request_RestrDto {
    private Integer request_restr_NUM;
    private String request_restr_name;
    private double request_restr_latitude;
    private double request_restr_longitude;
    private String request_restr_location;
    private String request_restr_location_tag;
    private String request_restr_phone;
    private String request_restr_time;
    private float request_restr_star;
    private String request_restr_foodType;
    private String request_restr_cost;
    private String request_restr_parking;
    private String request_restr_tag;
    private String request_restr_menu;
    private String request_restr_desc;
    private String request_restr_picture;
    private String request_restr_category_loc; // 레스토랑 주소의 카테고리
    private String request_bizAccount_email;   // 점주의 사업자 계정
    private String request_biz_reg_num;        // 점주의 사업자 등록번호
    private Integer request_restr_hotdeal_NUM; // 평상시 : -1 ,  핫딜 이벤트 진행시 : hotdeal_NUM
    private Integer request_restr_viewCnt;
    private Integer request_restr_reviewCnt;
    private Integer request_restr_likeCnt;
    private String evaluate_msg;        // 심사를 진행한 관리자의 메세지
    private Integer evaluate_code;      // 심사 코드  0 : 심사 대기
                                        // 심사 코드  1 :     승인
                                        // 심사 코드 -1 :     반려


    public Request_RestrDto(){}
    public Request_RestrDto(Integer request_restr_NUM) {
        this.request_restr_NUM = request_restr_NUM;
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

    public double getRequest_restr_latitude() {
        return request_restr_latitude;
    }

    public void setRequest_restr_latitude(double request_restr_latitude) {
        this.request_restr_latitude = request_restr_latitude;
    }

    public double getRequest_restr_longitude() {
        return request_restr_longitude;
    }

    public void setRequest_restr_longitude(double request_restr_longitude) {
        this.request_restr_longitude = request_restr_longitude;
    }

    public String getRequest_restr_location() {
        return request_restr_location;
    }

    public void setRequest_restr_location(String request_restr_location) {
        this.request_restr_location = request_restr_location;
    }

    public String getRequest_restr_location_tag() {
        return request_restr_location_tag;
    }

    public void setRequest_restr_location_tag(String request_restr_location_tag) {
        this.request_restr_location_tag = request_restr_location_tag;
    }

    public String getRequest_restr_phone() {
        return request_restr_phone;
    }

    public void setRequest_restr_phone(String request_restr_phone) {
        this.request_restr_phone = request_restr_phone;
    }

    public String getRequest_restr_time() {
        return request_restr_time;
    }

    public void setRequest_restr_time(String request_restr_time) {
        this.request_restr_time = request_restr_time;
    }

    public float getRequest_restr_star() {
        return request_restr_star;
    }

    public void setRequest_restr_star(float request_restr_star) {
        this.request_restr_star = request_restr_star;
    }

    public String getRequest_restr_foodType() {
        return request_restr_foodType;
    }

    public void setRequest_restr_foodType(String request_restr_foodType) {
        this.request_restr_foodType = request_restr_foodType;
    }

    public String getRequest_restr_cost() {
        return request_restr_cost;
    }

    public void setRequest_restr_cost(String request_restr_cost) {
        this.request_restr_cost = request_restr_cost;
    }

    public String getRequest_restr_parking() {
        return request_restr_parking;
    }

    public void setRequest_restr_parking(String request_restr_parking) {
        this.request_restr_parking = request_restr_parking;
    }

    public String getRequest_restr_tag() {
        return request_restr_tag;
    }

    public void setRequest_restr_tag(String request_restr_tag) {
        this.request_restr_tag = request_restr_tag;
    }

    public String getRequest_restr_menu() {
        return request_restr_menu;
    }

    public void setRequest_restr_menu(String request_restr_menu) {
        this.request_restr_menu = request_restr_menu;
    }

    public String getRequest_restr_desc() {
        return request_restr_desc;
    }

    public void setRequest_restr_desc(String request_restr_desc) {
        this.request_restr_desc = request_restr_desc;
    }

    public String getRequest_restr_picture() {
        return request_restr_picture;
    }

    public void setRequest_restr_picture(String request_restr_picture) {
        this.request_restr_picture = request_restr_picture;
    }

    public String getRequest_restr_category_loc() {
        return request_restr_category_loc;
    }

    public void setRequest_restr_category_loc(String request_restr_category_loc) {
        this.request_restr_category_loc = request_restr_category_loc;
    }

    public String getRequest_bizAccount_email() {
        return request_bizAccount_email;
    }

    public void setRequest_bizAccount_email(String request_bizAccount_email) {
        this.request_bizAccount_email = request_bizAccount_email;
    }

    public String getRequest_biz_reg_num() {
        return request_biz_reg_num;
    }

    public void setRequest_biz_reg_num(String request_biz_reg_num) {
        this.request_biz_reg_num = request_biz_reg_num;
    }

    public Integer getRequest_restr_hotdeal_NUM() {
        return request_restr_hotdeal_NUM;
    }

    public void setRequest_restr_hotdeal_NUM(Integer request_restr_hotdeal_NUM) {
        this.request_restr_hotdeal_NUM = request_restr_hotdeal_NUM;
    }

    public Integer getRequest_restr_viewCnt() {
        return request_restr_viewCnt;
    }

    public void setRequest_restr_viewCnt(Integer request_restr_viewCnt) {
        this.request_restr_viewCnt = request_restr_viewCnt;
    }

    public Integer getRequest_restr_reviewCnt() {
        return request_restr_reviewCnt;
    }

    public void setRequest_restr_reviewCnt(Integer request_restr_reviewCnt) {
        this.request_restr_reviewCnt = request_restr_reviewCnt;
    }

    public Integer getRequest_restr_likeCnt() {
        return request_restr_likeCnt;
    }

    public void setRequest_restr_likeCnt(Integer request_restr_likeCnt) {
        this.request_restr_likeCnt = request_restr_likeCnt;
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
        return "Request_RestrDto{" +
                "request_restr_NUM=" + request_restr_NUM +
                ", request_restr_name='" + request_restr_name + '\'' +
                ", request_restr_latitude=" + request_restr_latitude +
                ", request_restr_longitude=" + request_restr_longitude +
                ", request_restr_location='" + request_restr_location + '\'' +
                ", request_restr_location_tag='" + request_restr_location_tag + '\'' +
                ", request_restr_phone='" + request_restr_phone + '\'' +
                ", request_restr_time='" + request_restr_time + '\'' +
                ", request_restr_star=" + request_restr_star +
                ", request_restr_foodType='" + request_restr_foodType + '\'' +
                ", request_restr_cost='" + request_restr_cost + '\'' +
                ", request_restr_parking='" + request_restr_parking + '\'' +
                ", request_restr_tag='" + request_restr_tag + '\'' +
                ", request_restr_menu='" + request_restr_menu + '\'' +
                ", request_restr_desc='" + request_restr_desc + '\'' +
                ", request_restr_picture='" + request_restr_picture + '\'' +
                ", request_restr_category_loc='" + request_restr_category_loc + '\'' +
                ", request_bizAccount_email='" + request_bizAccount_email + '\'' +
                ", request_biz_reg_num='" + request_biz_reg_num + '\'' +
                ", request_restr_hotdeal_NUM=" + request_restr_hotdeal_NUM +
                ", request_restr_viewCnt=" + request_restr_viewCnt +
                ", request_restr_reviewCnt=" + request_restr_reviewCnt +
                ", request_restr_likeCnt=" + request_restr_likeCnt +
                ", evaluate_msg='" + evaluate_msg + '\'' +
                ", evaluate_code=" + evaluate_code +
                '}';
    }
}
