package project.nectar.domain;

import java.util.Date;

public class HotdealPlusDto {

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
    private String payment_NUM;
    private String imp_uid;
    private String merchant_uid;
    private String user_email;       // 구매자
    private String pay_date;
    private String amount;           // 가격
    private String card_no;
    private String refund;
    private String bizAccount_email; // 판매자
    private Date payment_regdate;
    private Integer coupon_state_code; //   0 이면 결제 완료,  -1 이면 사용 완료

    public HotdealPlusDto() {
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

    public String getImp_uid() {
        return imp_uid;
    }

    public void setImp_uid(String imp_uid) {
        this.imp_uid = imp_uid;
    }

    public String getMerchant_uid() {
        return merchant_uid;
    }

    public void setMerchant_uid(String merchant_uid) {
        this.merchant_uid = merchant_uid;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund;
    }

    public String getBizAccount_email() {
        return bizAccount_email;
    }

    public void setBizAccount_email(String bizAccount_email) {
        this.bizAccount_email = bizAccount_email;
    }

    public Date getPayment_regdate() {
        return payment_regdate;
    }

    public void setPayment_regdate(Date payment_regdate) {
        this.payment_regdate = payment_regdate;
    }

    public String getPayment_NUM() {
        return payment_NUM;
    }

    public void setPayment_NUM(String payment_NUM) {
        this.payment_NUM = payment_NUM;
    }

    public Integer getCoupon_state_code() {
        return coupon_state_code;
    }

    public void setCoupon_state_code(Integer coupon_state_code) {
        this.coupon_state_code = coupon_state_code;
    }

    @Override
    public String toString() {
        return "HotdealPlusDto{" +
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
                ", payment_NUM='" + payment_NUM + '\'' +
                ", imp_uid='" + imp_uid + '\'' +
                ", merchant_uid='" + merchant_uid + '\'' +
                ", user_email='" + user_email + '\'' +
                ", pay_date='" + pay_date + '\'' +
                ", amount='" + amount + '\'' +
                ", card_no='" + card_no + '\'' +
                ", refund='" + refund + '\'' +
                ", bizAccount_email='" + bizAccount_email + '\'' +
                ", payment_regdate=" + payment_regdate +
                ", coupon_state_code=" + coupon_state_code +
                '}';
    }
}
