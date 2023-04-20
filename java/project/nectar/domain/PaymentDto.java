package project.nectar.domain;


import java.util.Date;

public class PaymentDto {
    private Integer payment_NUM;
    private String imp_uid;
    private String merchant_uid;
    private String user_email;       // 구매자
    private String pay_date;
    private String amount;           // 가격
    private String card_no;
    private String refund;
    private String bizAccount_email; // 판매자
    private Integer hotdeal_NUM;
    private Date payment_regdate;
    private Integer coupon_state_code; //   0 이면 결제 완료,  -1 이면 사용 완료



    public PaymentDto() {};

    public PaymentDto(String imp_uid, String merchant_uid, String user_email, String pay_date, String amount, String card_no, String refund, String bizAccount_email, Integer hotdeal_NUM) {
        this.imp_uid = imp_uid;
        this.merchant_uid = merchant_uid;
        this.user_email = user_email;
        this.pay_date = pay_date;
        this.amount = amount;
        this.card_no = card_no;
        this.refund = refund;
        this.bizAccount_email = bizAccount_email;
        this.hotdeal_NUM = hotdeal_NUM;
    }

    public Integer getPayment_NUM() {
        return payment_NUM;
    }

    public void setPayment_NUM(Integer payment_NUM) {
        this.payment_NUM = payment_NUM;
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

    public Integer getHotdeal_NUM() {
        return hotdeal_NUM;
    }

    public void setHotdeal_NUM(Integer hotdeal_NUM) {
        this.hotdeal_NUM = hotdeal_NUM;
    }

    public Date getPayment_regdate() {
        return payment_regdate;
    }

    public void setPayment_regdate(Date payment_regdate) {
        this.payment_regdate = payment_regdate;
    }

    public Integer getCoupon_state_code() {
        return coupon_state_code;
    }

    public void setCoupon_state_code(Integer coupon_state_code) {
        this.coupon_state_code = coupon_state_code;
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "payment_NUM=" + payment_NUM +
                ", imp_uid='" + imp_uid + '\'' +
                ", merchant_uid='" + merchant_uid + '\'' +
                ", user_email='" + user_email + '\'' +
                ", pay_date='" + pay_date + '\'' +
                ", amount='" + amount + '\'' +
                ", card_no='" + card_no + '\'' +
                ", refund='" + refund + '\'' +
                ", bizAccount_email='" + bizAccount_email + '\'' +
                ", hotdeal_NUM=" + hotdeal_NUM +
                ", payment_regdate=" + payment_regdate +
                ", coupon_state_code=" + coupon_state_code +
                '}';
    }
}
