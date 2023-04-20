<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
    <title>환불페이지</title>
    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/css/refundForm.css'/>"/>

</head>


<body>


<%--<form  action="<c:url value="/pay/cancel"/>" method="post">--%>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

<%--    <input name="payment_NUM" type="hidden" value="${PaymentDto.payment_NUM}">--%>
<%--    <input name="merchant_uid" type="hidden" value="${PaymentDto.merchant_uid}">--%>
<%--    <input name="pay_date" type="hidden" value="${PaymentDto.pay_date}">--%>
<%--    <input name="hotdeal_NUM" type="hidden" value="${PaymentDto.hotdeal_NUM}">--%>

<%--    <input name="user_email" type="text" value="${PaymentDto.user_email}">--%>
<%--    <input name="bizAccount_email" type="text" value="${PaymentDto.bizAccount_email}">--%>
<%--    <input name="refund_amount" type="text" value="${PaymentDto.amount}" readonly="readonly">--%>
<%--    <input name="refund_holder" type="text" placeholder="환불 계좌 예금주">--%>
<%--    <input name="refund_bank" type="text" placeholder="환불 계좌 은행(ex 신한은행)">--%>
<%--    <input name="refund_account" type="text" placeholder="환불 계좌 번호">--%>
<%--    <input name="refund_reason" type="text" placeholder="환불 사유">--%>

<%--    <button id="refundBtn">환불요청</button>--%>
<%--</form>--%>


<section id="container">
    <div class="box">
        <h1>${PaymentDto.user_email} 님의 환불예정금액 </h1>
        <div class="item cancel">
            <span> 취소 상품 총 금액 합계 </span>
            <span> ${PaymentDto.amount} 원</span>
        </div>

    </div>
    <div class="box">
        <h1> 환불안내 </h1>
        <br>
        <div class="item">
            <form id="refundForm" method="post">
                <input name="user_email" type="hidden" value="${PaymentDto.user_email}">
                <input name="bizAccount_email" type="hidden" value="${PaymentDto.bizAccount_email}">
                <input name="refund_amount" type="hidden" value="${PaymentDto.amount}" readonly="readonly">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input name="payment_NUM" type="hidden" value="${PaymentDto.payment_NUM}">
                <input name="merchant_uid" type="hidden" value="${PaymentDto.merchant_uid}">
                <input name="pay_date" type="hidden" value="${PaymentDto.pay_date}">
                <input name="hotdeal_NUM" type="hidden" value="${PaymentDto.hotdeal_NUM}">

                <input name="refund_reason" type="text" placeholder="환불 사유를 입력하세요">
                <input name="refund_bank" type="text" placeholder="은행명">
                <input name="refund_holder" type="text" placeholder="예금주">
                <input name="refund_account" type="text" placeholder="계좌번호">
            </form>
        </div>
        <div class="btnwrap">
            <button id="refundBtn">환불요청</button>
        </div>
    </div>

</section>


<%--<form >--%>
<%--    <input>   //주문번호--%>
<%--    <input>   // amount 환불금액--%>
<%--    <input>   // reason 환불사유--%>
<%--    <input>   // holder [계좌 환불시 필수입력] 환불 계좌 예금주--%>
<%--    <input>   // bank [계좌 환불시 필수입력] 환불 계좌 은행(ex 신한은행)--%>
<%--    <input>   // account [계좌 환불시 필수입력] 환불 계좌 번호--%>


<%--<input> //   where merchant_uid = #{merchant_uid} AND user_email = #{user_email} AND pay_date = #{pay_date}--%>
<%--<input> // hotdeal_NUM--%>

<%--</form>--%>

<script>


    $(document).ready(() => {
        $("#refundBtn").on("click", function (){
            let form = $("#refundForm");
            form.attr("action", "<c:url value="/pay/cancel"/>");
            form.attr("method", "POST");
            form.submit();
        });

    }) // ready()


</script>

</body>
</html>
