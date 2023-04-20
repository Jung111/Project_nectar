<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nectar</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/css/navbar.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/hotdeal.css'/>"/>
    <%--  script --%>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script
            src="https://kit.fontawesome.com/43ede2213f.js"
            crossorigin="anonymous"
    ></script>
    <!-- 제이쿼리 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>
    <!-- 아임포트 -->
    <script src ="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>

</head>

<body>
<%--NAVBAR--%>

<section id="navbar">
    <div class="logo">
        <a href="<c:url value='/'/>">  <img src="<c:url value="/images/nectarLogo.png"/>" alt="" class="logo__img" /></a>
    </div>
    <div class="searchBar">
        <form action="<c:url value="/restr/search"/>" class="search-form" method="get">
            <button type="button" class="searchBtn" value="검색">
                <i class="fa-solid fa-magnifying-glass"></i>
            </button>
            <input type="hidden" name="option" value="searchEngine" />
            <input
                    type="text"
                    name="keyword"
                    class="search-input"
                    value="${ph.sc.keyword}"
                    placeholder="지역, 식당 또는 음식"
            />
            <button type="submit" class="search-button" value="검색">
                <i class="fa-solid fa-magnifying-glass"></i>
            </button>
        </form>
    </div>
    <ul class="menu">
        <li class="menu item">
            <a href="<c:url value='/hotdeal/list'/>">HOTDEAL</a>
        </li>
        <li class="menu item">
            <a href="<c:url value='/restr/list'/>">맛집리스트</a>
        </li>
        <li class="menu item">
            <security:authorize access="isAnonymous()">
                <a href="<c:url value='/login/login'/>"><span> | &nbsp;  로그인</span><i class="fa-solid fa-user"></i></a>
            </security:authorize>
            <security:authorize access="hasRole('USER')">
                <div>
                    <a href="<c:url value='/login/logout'/>"><span> | &nbsp; 로그아웃</span></a>
                    <a href="<c:url value='/mypage/user/main'/>"><i class="fa-solid fa-user"></i></a>
                </div>
            </security:authorize>
            <security:authorize access="hasRole('BIZ')">
                <div>
                    <a href="<c:url value='/login/logout'/>"><span> | &nbsp; 로그아웃</span></a>
                    <a href="<c:url value='/mypage/biz/main'/>"><i class="fa-solid fa-user-tie"></i></a>
                </div>

            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
                <div>
                    <a href="<c:url value='/login/logout'/>"><span> | &nbsp; 로그아웃</span></a>
                    <a href="<c:url value='/mypage/admin/main'/>"><i class="fa-solid fa-user-secret"></i></a>
                </div>
            </security:authorize>
        </li>
    </ul>
</section>


<!-- Main -->
<section id="hotdeal">


    <div class="hotdeal__container">
        <div class="hotdeal__imgContainer">
            <img
                    src="<c:url value='/uploadFile/${hotdealDto.hotdeal_picture}'/>"
                    alt=""
                    class="hotdeal__img"
            />
        </div>
        <div class="hotdeal__content">
            <div class="hotdeal__head">
                <div class="head__restrName">
                    <a href="<c:url value='/restr/read?restr_NUM=${hotdealDto.restr_NUM}'/>"><h1>🔥[${hotdealDto.restr_category_loc}] ${hotdealDto.restr_name} 🔥</h1></a>
                    <a href=""><h4>식당정보보기</h4></a>
                </div>
                <div class="head__event">
                    <div class="head__event menu">${hotdealDto.restr_menu_food}
                    </div>
                    <div class="head__event useDate">
                        사용기간 : ${hotdealDto.hotdeal_eventDuration}
                        <span>  ${hotdealDto.hotdeal_useDate}  </span>
                    </div>
                </div>
                <div class="head__priceInfo">
                    <div class="head__priceInfo menuPrice">&#8361 ${hotdealDto.restr_menu_price}</div>
                    <div class="head__priceInfo-wrap">
                        <div class="head__priceInfo discountRate">${hotdealDto.hotdeal_discountRate}%</div>
                        <div class="head__priceInfo eventPrice">&#8361 ${hotdealDto.hotdeal_price}</div>
                    </div>
                </div>
            </div>

            <div class="hotdeal__Info">
                <div class="info">
                    <h4 class="location">매장소개</h4>
                    <p class="location-nmae">
                        ${hotdealDto.hotdeal_desc}
                    </p>
                </div>
                <div class="info">
                    <h4 class="location">지역</h4>
                    <p class="location-name">${hotdealDto.restr_category_loc}</p>
                </div>
                <div class="info">
                    <h4 class="foodtype">음식종류</h4>
                    <p class="food-name">일식</p>
                </div>
                <div class="info">
                    <h4 class="notice">유의사항 (꼭! 확인해주세요)</h4>
                    <ul class="noticeList">
                        <li class="notice__item">
                            사용 기간: 구매 시점으로부터 93일
                        </li>
                        <li class="notice__item">
                            양도 및 재판매 불가합니다.
                        </li>
                        <li class="notice__item">
                            구매 전 전용 지점을 꼭 확인해주세요.
                        </li>
                        <li class="notice__item">
                            방문 전 영업시간 및 휴무일 확인을 부탁드립니다.
                        </li>
                        <li class="notice__item">
                            테이블 당 1매만 사용 가능합니다.
                        </li>
                        <li class="notice__item">
                            HOTDEAL 외에 다른 쿠폰 및 딜과 중복 사용 불가합니다.
                        </li>
                    </ul>
                </div>
                <div class="info">
                    <h4 class="notice">사용 방법</h4>
                    <ul class="noticeList">
                        <li class="notice__item">
                            구매하신 HOTDEAL은 넥타르홈 > MyPage > 나의쿠폰함  을 통해 확인할 수 있습니다.
                        </li>
                        <li class="notice__item">
                            결제 시 넥타르 홈 > MyPage > 나의쿠폰함 > 구매한 HOTDEAL을 선택하여 직원에게 제시해 주세요.
                        </li>
                        <li class="notice__item">
                            쿠폰 사용에 차질이 있을 시 매장 직원에게 화면 하단 12자리 UID 숫자 코드를 보여주세요.
                        </li>
                        <li class="notice__item">
                            사용 처리가 완료된 HOTDEAL은 재사용 및 환불 불가합니다.
                        </li>
                    </ul>
                </div>
                <div class="info">
                    <h4 class="foodtype">문의</h4>
                    <p class="food-name">넥타르 홈 > MyPage > Q&A 게시판 을 통해 문의주세요.</p>
                </div>
            </div>
        </div>
        <c:choose>
            <c:when test="${hotdealDto.hotdeal_salesVolume == hotdealDto.hotdeal_MaxSalesVolume}">
                <button type="button" id="soldOut" class="buyBtn">
                    <span>매진</span>
                </button>
            </c:when>
            <c:otherwise>
                <button type="button" id="buy" class="buyBtn">
                    <span>구입하기</span>
                </button>
            </c:otherwise>
        </c:choose>
    </div>


</section>
<script type="text/javascript">
    $(document).ready(function(){

        $("#buy").click(function(e){

            <security:authorize access="isAnonymous()">     // 로그인 안했니?
                if (!confirm("결재를 진행하기 위해서 로그인이 필요합니다. 로그인 하시겠습니까?")) return;
                location.href = "<c:url value='/login/login'/> ";
                return;
            </security:authorize>

            <security:authorize access="hasRole('ROLE_USER')">     // 로그인 했니?
            if(${userDto.user_state_code==-2}){                    // 핫딜결제 금지 당한 유저니?
                alert("회원님은 핫딜쿠폰을 구매할 수 없습니다.");
                return;
            }
            </security:authorize>



            var IMP = window.IMP;
            var code = "imp12875231"; //가맹점 식별코드
            IMP.init(code);

            //결제요청
            IMP.request_pay({
                pg : 'kakaopay',
                pay_method: 'card',
                merchant_uid : 'merchant_' + new Date().getTime(),
                name : '${hotdealDto.restr_menu_food}', // 상품명
                amount : ${hotdealDto.hotdeal_price},       // 가격
                buyer_email : '${UserDto.user_email}',
                buyer_name : '${UserDto.user_name}',
                buyer_tel : '${UserDto.user_phone}',  //필수항목
                // m_redirect_url : 'https://localhost:8080/nectar/pay/process' //
            }, function(rsp){
                if(rsp.success){//결제 성공시
                    console.log(rsp)
                    var msg = '결제가 완료되었습니다';
                    var result = {
                        "imp_uid" : rsp.imp_uid,
                        "merchant_uid" : rsp.merchant_uid,
                        "user_email" : '${UserDto.user_email}',
                        "pay_date" : new Date().getTime(),
                        "amount" : rsp.paid_amount,
                        "card_no" : rsp.apply_num,
                        "refund" : 'payed'
                    }
                    console.log("결제성공 콘솔 : " + msg);
                    console.log("result " + result);

                    $.ajax({
                        type :'POST',
                        contentType:'application/json;charset=utf-8',
                        url : '<c:url value= '/pay/process?${_csrf.parameterName}=${_csrf.token}'/>',
                        data : JSON.stringify(result),
                        dataType: 'json'
                    }) //ajax
                }
                else{//결제 실패시
                    var msg = '결제에 실패했습니다';
                    msg += '에러 : ' + rsp.error_msg
                }
                console.log(msg);
            });//pay
        });
    }); //doc.ready
</script>

</body>
</html>

