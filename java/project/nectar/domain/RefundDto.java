package project.nectar.domain;

import java.util.Date;

public class RefundDto {
    Integer refund_NUM;
    Integer payment_NUM;
    String user_email;      // 구매자 (환불 요청)
    String bizAccount_email;    // 판매자
    Integer refund_amount;  // 환불 금액
    String refund_holder;   // 예금 주
    String refund_bank;     // 은행
    String refund_account; // 계좌
    String refund_reason;   // 환불 사유
    Date refund_regdate;

    RefundDto(){}

    public Integer getRefund_NUM() {
        return refund_NUM;
    }

    public void setRefund_NUM(Integer refund_NUM) {
        this.refund_NUM = refund_NUM;
    }

    public Integer getPayment_NUM() {
        return payment_NUM;
    }

    public void setPayment_NUM(Integer payment_NUM) {
        this.payment_NUM = payment_NUM;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getBizAccount_email() {
        return bizAccount_email;
    }

    public void setBizAccount_email(String bizAccount_email) {
        this.bizAccount_email = bizAccount_email;
    }

    public Integer getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(Integer refund_amount) {
        this.refund_amount = refund_amount;
    }

    public String getRefund_holder() {
        return refund_holder;
    }

    public void setRefund_holder(String refund_holder) {
        this.refund_holder = refund_holder;
    }

    public String getRefund_bank() {
        return refund_bank;
    }

    public void setRefund_bank(String refund_bank) {
        this.refund_bank = refund_bank;
    }

    public String getRefund_account() {
        return refund_account;
    }

    public void setRefund_account(String refund_account) {
        this.refund_account = refund_account;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public Date getRefund_regdate() {
        return refund_regdate;
    }

    public void setRefund_regdate(Date refund_regdate) {
        this.refund_regdate = refund_regdate;
    }

    @Override
    public String toString() {
        return "RefundDto{" +
                "refund_NUM=" + refund_NUM +
                ", payment_NUM=" + payment_NUM +
                ", user_email='" + user_email + '\'' +
                ", bizAccount_email='" + bizAccount_email + '\'' +
                ", refund_amount=" + refund_amount +
                ", refund_holder='" + refund_holder + '\'' +
                ", refund_bank='" + refund_bank + '\'' +
                ", refund_account=" + refund_account +
                ", refund_reason='" + refund_reason + '\'' +
                ", refund_regdate=" + refund_regdate +
                '}';
    }
}
