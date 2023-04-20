<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nectar</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script
            src="https://kit.fontawesome.com/43ede2213f.js"
            crossorigin="anonymous"
    ></script>

    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/css/navbarSearchX.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/biz.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/qna.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/globalPage.css'/>"/>


</head>


<body>
<section id="navbar" class="biz">
    <div class="logo">
        <a href="<c:url value='/'/>"> <img src="<c:url value='/images/nectarLogo.png'/>" alt="" class="logo__img"/></a>
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

<br>
<br>
<%--  Global Page --%>

<section id="globalPage">
    <!-- Left Side -->
    <div class="sideMenu">
        <button class="tab index active">MyPage</button>
        <button class="tab index">회원정보</button>
        <button class="tab index">핫딜판매내역</button>
        <button class="tab index">매장등록</button>
        <button class="tab index">메뉴등록</button>
        <button class="tab index">핫딜등록</button>
        <button class="tab index">Q&A</button>
    </div>

    <!-- Right Side -->
    <div class="main">
        <div class="content index active">

            <h1>${bizAccountDto.bizAccount_name}님이 운영중인 레스토랑 🧑‍🍳</h1>
            <!--운영 중인 매장 無-->
            <c:if test="${empty restrDto}">
                <div class="msg__wrap">
                    <i class="fa-solid fa-circle-info"></i>
                    <h3>현재 운영중인 매장이 없습니다.</h3>
                </div>
            </c:if>

            <br>
            <!--운영 중인 매장 有-->
            <c:if test="${not empty restrDto}">
                <div class="container item">
                    <ul id="restrList">
                        <form id="restrForm" action="" method="">
                                <%--            --%>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <%--            --%>
                            <!-- 게시글 번호 data-restrNum 에 저장-->
                            <li class="restr" data-restrNum="${restrDto.restr_NUM}">
                                <div class="img_wrap">
                                    <img class="img"
                                         src="https://images.unsplash.com/photo-1677523875173-e1f7f5138b40?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHx0b3BpYy1mZWVkfDM2fHhqUFI0aGxrQkdBfHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60">
                                </div>
                                <div class="content_wrap">
                                    <div>
                                        <h1 class="content__title">${restrDto.restr_name}</h1>

                                    </div>
                                    <p class="content__location">${restrDto.restr_location}</p>
                                    <h1 class="content__restrTime">${restrDto.restr_time}</h1>
                                </div>
                            </li>
                        </form>

                    </ul>
                </div>
            </c:if>


            <h1>${bizAccountDto.bizAccount_name}님이 진행한 핫딜 🔥</h1>

            <!--진행한 핫딜이 없는 경우-->
            <c:if test="${empty hotdealDto}">
                <div class="msg__wrap">
                    <i class="fa-solid fa-circle-info"></i>
                    <h3>현재 진행중인 핫딜이 없습니다.</h3>
                </div>
            </c:if>

            <div class="container item">
                <c:forEach var="hotdealDto" items="${hotdealDto}">
                    <li class="restr" data-restrNum="${restrDto.restr_NUM}">
                        <div class="img_wrap">
                            <img class="img"
                                 src="https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8Zm9vZHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=600&q=60">
                        </div>
                        <div class="content_wrap">
                            <div>
                                <h1 class="content__title">${hotdealDto.restr_menu_food}</h1>
                            </div>
                            <p class="content__hotdealPrice"> ${hotdealDto.restr_menu_price} &#8361;</p>
                            <h1 class="content__menuPrice">  ${hotdealDto.hotdeal_price} &#8361;</h1>
                        </div>
                    </li>
                </c:forEach>
            </div>


        </div>     <!-- MyPage-->
        <div class="content index">
            <!-- 회원정보수정 -->
            <h1>회원정보수정</h1>
            <form action="" id="userInfoForm">
                <%--            --%>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <%--            --%>
                <div class="userInfo__box">
                    <div class="userInfo__profile">
                        <img
                                src="<c:url value='/uploadFile/${bizAccountDto.bizAccount_picture}'/>"
                                alt=""
                                class="user-profile"
                        />
                        <label
                                for="userPrflUpld"
                                class="updateUserProfile"
                                name="file"
                        >사진 업데이트</label
                        >
                        <input style="display: none" type="file" id="userPrflUpld" name="file"/>
                        <input type="hidden" name="bizAccount_picture" value="${bizAccountDto.bizAccount_picture}"
                               required/>
                    </div>
                    <div class="userInfo__items">
                        <div class="userNameId">
                            <div class="userNameId item">
                                <span class="details">이름</span>
                                <input type="text" name="bizAccount_name" readonly
                                       value="${bizAccountDto.bizAccount_name}" required/>
                            </div>
                            <div class="userNameId item">
                                <span class="details">휴대폰</span>
                                <input type="text" name="bizAccount_phone" readonly
                                       value="${bizAccountDto.bizAccount_phone}" required/>
                            </div>
                        </div>
                        <div class="userEmail">
                            <span class="details">이메일</span>
                            <input type="text" name="bizAccount_email" readonly
                                   value="${bizAccountDto.bizAccount_email}" required/>
                        </div>
                        <%--            --%>
                        <%--    userPwd로 고쳐야함        --%>
                        <div class="userEmail">
                            <span class="details">비밀번호</span>
                            <input type="hidden" name="bizAccount_pwd" readonly value="${bizAccountDto.bizAccount_pwd}"
                                   required/>
                            <input type="password" readonly value="" required/>
                        </div>

                    </div>
                </div>
                <div class="userInfo__btnWrap">
                    <button type="button" id="modifyBtn">프로필 수정</button>
                </div>
            </form>

            <h1 style="margin-top: 30px">계정탈퇴</h1>
            <div class="container item">
                <h3>회원 탈퇴 신청 시 아래 사항을 반드시 확인해주세요.</h3>
                <p> 1. 탈퇴 시 탈퇴 대기기간 없이 즉시 탈퇴가 완료되며, 계정 정보 및 개인 정보(이름, 생년월일 등)가 즉시 파기되어 복구할 수 없습니다. </p>
                <p> 2. 탈퇴 시에는 즉시 계정 정보 및 개인 정보(이름, 생년월일 등)가 파기되기 때문에 탈퇴 취소 신청이 불가능합니다. </p>

                <form id="userDelForm">
                    <button type="button" id="userDelBtn"> 탈퇴하기</button>
                </form>

            </div>
        </div>            <!-- 회원정보-->


        <div class="content index">
            <!--핫딜 판매 내역-->
            <div class="headerBox">
                <h1>핫딜 판매 내역 💸️</h1>
                <div class="HotdealSearchBox">
                    <form id="hotdealSearchForm" action="<c:url value=''/>" method="POST">
                        <input name="keyword">
                        <button type="submit">검색</button>
                    </form>

                </div>
            </div>

            <!--핫딜 판매 내역이 없는 경우-->
            <c:if test="${empty PaymentList}">
                <div class="msg__wrap">
                    <i class="fa-solid fa-circle-info"></i>
                    <h3> 현재 판매된 핫딜 제품이 없습니다. </h3>
                </div>
            </c:if>

            <!--핫딜 판매 내역이 있으면-->
            <c:if test="${not empty PaymentList}">
                <div class="userList">
                    <table>
                        <thead>
                        <tr>
                            <th>주문ID</th>
                            <th>상품ID</th>
                            <th>거래일자</th>
                            <th>메뉴</th>
                            <th>사용기간</th>
                            <th>이벤트기간</th>
                            <th>구매자</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="PaymentList" items="${PaymentList}">
                            <tr>
                                <td class="no"> ${PaymentList.imp_uid}</td>
                                <td class="qnaTitle"> ${PaymentList.merchant_uid}</td>
                                <td class="writer">${PaymentList.pay_date}</td>
                                <td class="writer"> ${PaymentList.restr_menu_food}</td>
                                <td class="writer">${PaymentList.hotdeal_eventDuration}</td>
                                <td class="writer">${PaymentList.hotdeal_useDate}</td>
                                <td class="writer"> ${PaymentList.user_email}</td>
                                <td class="writer"><button data-payment_num="${PaymentList.payment_NUM}" id="useCouponBtn">쿠폰사용</button></td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </c:if>
            <!--핫딜 판매 내역-->


            <br/>
            <h1>핫딜 환불 요청 💸️</h1>
            <!--환불 요청 내역이 없는 경우-->
            <c:if test="${empty refundDtoList}">
                <div class="msg__wrap">
                    <i class="fa-solid fa-circle-info"></i>
                    <h3> 현재 환불 요청이 없습니다. </h3>
                </div>
            </c:if>

            <%--환불 요청 내역이 있으면 --%>
            <c:if test="${not empty refundDtoList}">
            <div class="userList">
                <table>
                    <thead>
                    <tr>
                        <th>구매자</th>
                        <th>판매자</th>
                        <th>환불금액</th>
                        <th>예금주</th>
                        <th>은행</th>
                        <th>계좌</th>
                        <th>환불사유</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="refundDto" items="${refundDtoList}">
                        <tr>
                            <td class="no"> ${refundDto.user_email}</td>
                            <td class="qnaTitle"> ${refundDto.bizAccount_email}</td>
                            <td class="writer">${refundDto.refund_amount}</td>
                            <td class="writer"> ${refundDto.refund_holder}</td>
                            <td class="writer">${refundDto.refund_bank}</td>
                            <td class="writer">${refundDto.refund_account}</td>
                            <td class="writer"> ${refundDto.refund_reason}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            </c:if>
        </div>            <!-- 핫딜판매내역-->


        <div class="content index">

            <h1>매장 등록 심사 결과✏️</h1>
                <!--아직 매장 등록 요청을 안한 경우 -->
                <c:if test="${empty myReqRestrDto}">
                    <div class="msg__wrap">
                        <i class="fa-solid fa-circle-info"></i>
                        <h3> 아직 신규 매장을 등록하지 않았습니다.</h3>
                    </div>
                </c:if>


            <!--매장 등록 요청을 했으면 -->
            <c:if test="${not empty myReqRestrDto}">
                    <div class="userList">
                        <table>
                            <thead>
                            <tr>
                                <th>no</th>
                                <th>사업장</th>
                                <th>이메일</th>
                                <th>연락처</th>
                                <th>심사상태</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="no">${myReqRestrDto.request_restr_NUM}</td>
                                <td class="requestRestrName">${myReqRestrDto.request_restr_name} </td>
                                <td class="email">${myReqRestrDto.request_bizAccount_email}</td>
                                <td class="phone">${myReqRestrDto.request_restr_phone}</td>
                                <c:if test="${myReqRestrDto.evaluate_code == 0}">
                                    <td class="req">심사대기</td>
                                </c:if>
                                <c:if test="${myReqRestrDto.evaluate_code == 1}">
                                    <td class="permit">승인</td>
                                </c:if>
                                <c:if test="${myReqRestrDto.evaluate_code == -1}">
                                    <td class="deny">심사반려</td>
                                    <button id="retryBtn" type="submit">재심사요청</button>
                                </c:if>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </c:if>

            <br/>
            <h1>매장 등록 필수 정보 입력 ✏️</h1>
            <div class="container item">
                <form id="" action="<c:url value='/mypage/biz/reqRestr/write'/>" method="post"
                      enctype="multipart/form-data">
                    <%--            --%>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <%--            --%>
                    <input name="request_bizAccount_email" type="hidden" value="${bizAccountDto.bizAccount_email}">
                    <div class="user-details index">
                        <div class="wrap index">
                            <div class="input-box">
                                <span class="details">매장 이름</span>
                                <input
                                        type="text"
                                        name="request_restr_name"
                                        placeholder="매장 이름을 입력하세요"
                                        required
                                />
                            </div>
                            <div class="input-box">
                                <span class="details">매장 위치</span>
                                <input
                                        type="text"
                                        name="request_restr_location"
                                        placeholder="매장 위치를 입력하세요"
                                        required
                                />
                            </div>
                            <div class="input-box">
                                <span class="details">위치 태그</span>
                                <input
                                        type="text"
                                        name="request_restr_location_tag"
                                        placeholder="ex. 서울 강남역 강남 가로수길"
                                        required
                                />
                            </div>
                            <div class="input-box">
                                <span class="details">매장 전화 번호</span>
                                <input
                                        type="text"
                                        name="request_restr_phone"
                                        placeholder="매장 전화번호를 입력하세요"
                                        required
                                />
                            </div>
                            <div class="input-box">
                                <span class="details">매장 소개 하기</span>
                                <input name="request_restr_desc" placeholder="매장 소개를 입력하세요. 입력글자제한 200자">

                            </div>
                            <div class="input-box">
                                <span class="details">매장 운영 시간</span>
                                <input
                                        type="text"
                                        name="request_restr_time"
                                        placeholder="OPEN"
                                        required
                                />
                            </div>
                            <div class="input-box">
                                <span class="details">매장 사진 등록</span>
                                <input style="line-height: 45px;"
                                       id="file"
                                       type="file"
                                       name="file"
                                       required
                                />
                            </div>
                            <div class="input-box">
                                <span class="details">사업자 등록증 입력</span>
                                <input
                                        type="text"
                                        name="request_biz_reg_num"
                                        required
                                />
                            </div>
                            <div class="input-box">
                                <span class="details">태그 입력</span>
                                <input
                                        type="text"
                                        name="request_restr_tag"
                                        placeholder="노출을 원하는 태그를 입력하세요."
                                        required
                                />
                            </div>
                        </div>

                        <div class="wrap">
                            <div class="column-details">
                                <input type="radio" name="request_restr_cost" id="cost-1" value="만원미만"/>
                                <input type="radio" name="request_restr_cost" id="cost-2" value="1만원대"/>
                                <input type="radio" name="request_restr_cost" id="cost-3" value="2만원대"/>
                                <input type="radio" name="request_restr_cost" id="cost-4" value="3만원대"/>
                                <span class="menu-title">메뉴 평균 가격대 조사</span>
                                <div class="category">
                                    <label for="cost-1">
                                        <span class="dot one"></span>
                                        <span class="column" class="cost">만원미만</span>
                                    </label>
                                    <label for="cost-2">
                                        <span class="dot two"></span>
                                        <span class="column" class="cost">1만원대</span>
                                    </label>
                                    <label for="cost-3">
                                        <span class="dot three"></span>
                                        <span class="column" class="cost">2만원대</span>
                                    </label>
                                    <label for="cost-4">
                                        <span class="dot four"></span>
                                        <span class="column" class="cost">3만원대</span>
                                    </label>
                                </div>
                            </div>
                            <div class="column-details">
                                <input type="radio" name="request_restr_parking" id="parking-1" value="주차가능"/>
                                <input type="radio" name="request_restr_parking" id="parking-2" value="주차불가"/>
                                <span class="menu-title">주차 가능 여부</span>
                                <div class="category">
                                    <label for="parking-1">
                                        <span class="dot one"></span>
                                        <span class="column">주차가능</span>
                                    </label>
                                    <label for="parking-2">
                                        <span class="dot two"></span>
                                        <span class="column">주차불가</span>
                                    </label>
                                </div>
                            </div>
                            <div class="column-details">
                                <input type="radio" name="request_restr_foodType" id="food-1" value="한식"/>
                                <input type="radio" name="request_restr_foodType" id="food-2" value="중식"/>
                                <input type="radio" name="request_restr_foodType" id="food-3" value="일식"/>
                                <input type="radio" name="request_restr_foodType" id="food-4" value="양식"/>
                                <input type="radio" name="request_restr_foodType" id="food-5" value="세계음식"/>
                                <input type="radio" name="request_restr_foodType" id="food-6" value="뷔페"/>
                                <input type="radio" name="request_restr_foodType" id="food-7" value="카페"/>
                                <input type="radio" name="request_restr_foodType" id="food-8" value="주점"/>
                                <span class="menu-title">매장 음식 종류 선택</span>
                                <div class="category">
                                    <label for="food-1">
                                        <span class="dot a"></span>
                                        <span class="column">한식</span>
                                    </label>
                                    <label for="food-2">
                                        <span class="dot b"></span>
                                        <span class="column">중식</span>
                                    </label>
                                    <label for="food-3">
                                        <span class="dot c"></span>
                                        <span class="column">일식</span>
                                    </label>
                                    <label for="food-4">
                                        <span class="dot d"></span>
                                        <span class="column">양식</span>
                                    </label>
                                    <label for="food-5">
                                        <span class="dot e"></span>
                                        <span class="column">세계음식</span>
                                    </label>
                                    <label for="food-6">
                                        <span class="dot f"></span>
                                        <span class="column">뷔페</span>
                                    </label>
                                    <label for="food-7">
                                        <span class="dot g"></span>
                                        <span class="column">카페</span>
                                    </label>
                                    <label for="food-8">
                                        <span class="dot h"></span>
                                        <span class="column">주점</span>
                                    </label>
                                </div>
                            </div>
                        </div>

                        <button type="submit" id="regBtn"> 등록</button>
                    </div>
                </form>
            </div>
        </div>            <!-- 매장등록-->


        <div class="content index">
            <h2 class="h2" style="margin-bottom: 20px">메뉴 등록</h2>
            <div class="container item">
                <div class="menuWrap">
                    <form id="menuForm" action="<c:url value='/mypage/biz/restrMenu/write?tab=regMenu'/>" method="post">
                        <%--            --%>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <%--            --%>
                        <input name="restr_NUM" value="${restrDto.restr_NUM}" type="hidden">
                        <div class="input-box">
                            <label>메뉴이름</label>
                            <input name="restr_menu_food" type="text" placeholder="메뉴이름을 입력하세요.">
                        </div>
                        <div class="input-box">
                            <label>메뉴가격</label>
                            <input name="restr_menu_price" type="text" placeholder="메뉴가격을 입력하세요.">
                        </div>
                        <div class="input-box">
                            <label>메뉴설명</label>
                            <input name="restr_menu_desc" type="text" placeholder="메뉴에 대한 간단한 설명을 입력하세요.">
                        </div>
                        <button type="submit" class="restrMenuRegBtn">메뉴추가</button>
                    </form>
                </div>
            </div>

            <h2 class="h2" style="margin-bottom: 20px">메뉴 리스트</h2>
            <div class="container item menu">
                <h1 style="margin-bottom: 30px"> ㅡ MENU LIST ㅡ </h1>
                        <c:forEach var="restrMenuDto" items="${restrMenuDto}">
                                <form id="menuListForm"
                                      action="<c:url value='/mypage/biz/restrMenu/write?tab=regMenu'/>" method="post">
                                        <%--            --%>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <%--            --%>
                                    <input name="restr_NUM" value="${restrDto.restr_NUM}" type="hidden">
                                    <input name="restr_menu_NUM" type="hidden" value="${restrMenuDto.restr_menu_NUM}">
                                    <div class="menuBox">
                                        <div class="item first">
                                            <input name="restr_menu_food" type="text" placeholder="메뉴이름을 입력하세요." readonly
                                                   value=" ${restrMenuDto.restr_menu_food}">
                                            <input name="restr_menu_price" type="text" placeholder="메뉴가격을 입력하세요." readonly
                                                   value="${restrMenuDto.restr_menu_price}">
                                        </div>
                                        <div class="item second">
                                            <input name="restr_menu_desc" type="text" placeholder="메뉴에 대한 간단한 설명을 입력하세요."
                                                   readonly value=" ${restrMenuDto.restr_menu_desc}">
                                        </div>
                                        <div class="item third">
                                            <button type="button" id="menuModifyBtn"> 수정 </button>
                                            <button type="button" id="menuDeleteBtn"> 삭제 </button>
                                        </div>
                                    </div>
                                </form>
                        </c:forEach>
            </div>
        </div>            <!-- 메뉴등록 (레스토랑 심사에 통과한 경우에만 나타나게 한다.)-->


        <div class="content index">
            <h1>핫딜 이벤트 심사 결과 ✏️</h1>
            <!--아직 핫딜 이벤트 등록 요청을 안한 경우 -->
            <c:if test="${empty myReqHotdealDto}">
                <div class="msg__wrap">
                    <i class="fa-solid fa-circle-info"></i>
                    <h3> 아직 핫딜 이벤트를 등록하지 않았습니다.</h3>
                </div>
            </c:if>

            <!--핫딜 등록 요청을 했으면 -->
            <c:if test="${not empty myReqHotdealDto}">
                <div class="userList">
                    <table>
                        <thead>
                        <tr>
                            <th>no</th>
                            <th>사업장</th>
                            <th>메뉴</th>
                            <th>가격책정</th>
                            <th>심사상태</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="no">${myReqHotdealDto.request_restr_NUM}</td>
                            <td class="requestRestrName">${myReqHotdealDto.request_restr_name} </td>
                            <td class="writer">${myReqHotdealDto.request_restr_menu_food}</td>
                            <td class="writer">${myReqHotdealDto.request_restr_menu_price}</td>
                            <c:if test="${myReqHotdealDto.evaluate_code == 0}">
                                <td class="req">심사대기</td>
                            </c:if>
                            <c:if test="${myReqHotdealDto.evaluate_code == 1}">
                                <td class="permit">승인</td>
                            </c:if>
                            <c:if test="${myReqHotdealDto.evaluate_code == -1}">
                                <td class="deny">심사반려</td>
                                <button id="retryBtn" type="submit">재심사요청</button>
                            </c:if>

                        </tr>
                        </tbody>
                    </table>
                </div>
            </c:if>

<%--            <c:if test="${empty myReqHotdealDto}">--%>
            <br/>
            <h1>핫딜 이벤트 메뉴 등록 ✏️</h1>
                    <div class="user-details">
                        <div class="column-details">
                            <c:forEach var="restrMenuDto" items="${restrMenuDto}" varStatus="status">
                                <form id="hotdealRegForm" method="post" enctype="multripart/form-data">
                                        <%--            --%>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <%--            --%>
                                    <input class="restr_menu_food" type="radio" name="request_restr_menu_food"
                                           value="${restrMenuDto.restr_menu_food}"
                                           id="dot-<c:out value='${status.count}'/>"/>
                                    <div class="category">
                                        <label for="dot-${status.count}">
                                            <span class="dot data-${status.count}"></span>
                                            <span class="column">${restrMenuDto.restr_menu_food}</span>
                                        </label>
                                    </div>
                                    <input type="hidden" name="request_restr_NUM" value="${restrDto.restr_NUM}">
                                    <input type="hidden" name="request_restr_name" value="${restrDto.restr_name}">
                                    <input type="hidden" name="request_restr_menu_NUM"
                                           value="${restrMenuDto.restr_menu_NUM}">
                                    <input type="hidden" name="request_restr_category_loc"
                                           value=" ${restrDto.restr_category_loc}">
                                    <input type="hidden" name="request_hotdeal_desc"
                                           value="${restrMenuDto.restr_menu_desc}">
                                    <input type="hidden" name="request_bizAccount_email"
                                           value="${bizAccountDto.bizAccount_email}">
                                    <input type="hidden" name="request_hotdeal_discountRate" value="10">
                                    <input type="hidden" name="request_hotdeal_salesVolume" value="0">

                                    <div class="wrap hotdeal">
                                        <div class="input-box">
                                            <span class="details">정상가</span>
                                            <input name="request_restr_menu_price" value="${restrMenuDto.restr_menu_price}"
                                                   readonly>
                                        </div>
                                        <div class="input-box">
                                            <span class="details">할인가</span>
                                            <input name="request_hotdeal_price" placeholder="핫딜 가격을 입력하세요" required>
                                        </div>
                                        <div class="input-box">
                                            <span class="details">핫딜 이벤트 기간</span>
                                            <input name="request_hotdeal_useDate" type="text"
                                                   placeholder="ex. 2023-03-15 ~ 2023-04-01"
                                                   required>
                                        </div>
                                        <div class="input-box">
                                            <span class="details">핫딜 쿠폰 사용 기간</span>
                                            <input name="request_hotdeal_eventDuration" type="text"
                                                   placeholder="ex. 90(일)"
                                                   required>
                                        </div>
                                        <div class="input-box">
                                            <span class="details">한정 판매 개수</span>
                                            <input name="request_hotdeal_MaxSalesVolume"
                                                   type="text"
                                                   placeholder="ex. 100(개) 단, 숫자만 입력"
                                                   required>
                                        </div>
                                        <div class="input-box">
                                            <span class="details">사진 등록</span>
                                            <input
                                                    style="line-height: 45px;"
                                                    id="pic"
                                                    name="file"
                                                    type="file"
                                                    accept="image/jpeg"
                                                    required>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>
                            <button type="button" id="hotdealRegBtn"> 등록</button>
                        </div>
                    </div>
<%--            </c:if>--%>
        </div>            <!-- 핫딜등록-->


        <div class="content index">
            <h1>문의 남기기 ✏️</h1>
            <div class="userList">
                <table>
                    <thead>
                    <tr>
                        <th>no</th>
                        <th>제목</th>
                        <th>이름</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="QNADto" items="${QNADto}">
                        <tr>
                            <td class="no"> ${QNADto.qna_NUM}</td>
                            <td class="qnaTitle"><a
                                    href="<c:url value="/mypage/biz/QNA/read?qna_NUM= ${QNADto.qna_NUM}"/>"> ${QNADto.qna_title}</a>
                            </td>
                            <td class="writer">${QNADto.qna_name}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

                <button id="writeBtn"> 문의 남기기</button>


            </div>
        </div>            <!-- 문의남기기-->
    </div>


</section>


<script>

    $(document).ready(() => {

        // TAB 기능 //

        const tabs = document.querySelectorAll("button.tab");
        const contents = document.querySelectorAll(".content");

        tabs.forEach((tab, idx) => {
            tab.addEventListener("click", (e) => {

                contents.forEach((content) => {
                    content.classList.remove('active')
                })

                tabs.forEach((tab) => {
                    tab.classList.remove('active')
                })

                tabs[idx].classList.add('active')
                contents[idx].classList.add('active')
            });
        });

        // TAB 기능 //


        $("#bizDelBtn").on("click", $(".buttons"), (e) => {

            let form = $("#bizAccountInfoForm");
            form.attr("action", "<c:url value="/mypage/biz/profile/delete"/>");
            form.attr("method", "post");
            form.submit();

        }); // 사업자 계정 탈퇴


        $("#bizUpdateBtn").on("click", $(".buttons"), (e) => {
            let form = $("#bizAccountInfoForm");
            let isReadOnly = $("input[name=bizAccount_name]").attr("readonly");

            // 읽기상태 -> 수정상태
            if (isReadOnly == "readonly") {
                $("input[name=bizAccount_name]").attr('readonly', false);
                // $("input[name=bizAccount_pwd]").attr('readonly', false);
                $("input[name=bizAccount_phone]").attr('readonly', false);
                e.target.innerHTML = "수정완료";
                return;
            }


            form.attr("action", "<c:url value="/mypage/biz/profile/modify"/>");
            form.attr("method", "post");
            form.submit();


        }); // 사업자 계정 수정


        $("#hotdealRegBtn").on("click", (e) => {

            if(${bizAccountDto.bizAccount_state_code==-5}){     // 핫딜등록 금지당한 사업자회원이니?
                alert("회원님은 핫딜이벤트 등록을 할 수 없습니다.");
                return;
            }


            // 선택된 라디오 태그의 폼 태그를 포스트요청으로 보낸다.
            let radio = $("input[type=radio][name=request_restr_menu_food]:checked");
            let form = radio[0].form;

            form.action = "<c:url value='/mypage/biz/reqHotdeal/write'/>";
            form.method = "post";
            form.submit();

        }); // 핫딜 등록


        <%--$("#hotdealRegBtn").on("click", (e) => {--%>

        <%--    // 선택된 라디오 태그의 폼 태그를 포스트요청으로 보낸다.--%>
        <%--    let radio = $("input[type=radio][name=request_restr_menu_food]:checked");--%>
        <%--    let form = radio[0].form;--%>

        <%--    form.action = "<c:url value='/mypage/biz/reqHotdeal/write'/>";--%>
        <%--    form.method = "post";--%>
        <%--    form.submit();--%>

        <%--}); // 레스토랑 등록--%>


        $("#modifyBtn").on("click", (e) => {
            let form = $("#userInfoForm");
            let name = $("input[name=bizAccount_name]");

            let isReadOnly = name.attr("readonly");

            if (isReadOnly == "readonly") {

                $("input[name=bizAccount_name]").attr('readonly', false);
                // $("input[name=user_email]").attr('readonly', false);
                $("input[name=bizAccount_phone]").attr('readonly', false);
                // $("input[name=user_pwd]").attr('readonly', false);
                $("#modifyBtn").html("변경사항저장");

                return;
            }  // 읽기상태 -> 수정상태

            form.attr("action", "<c:url value="/mypage/biz/profile/modify"/>");
            form.attr("method", "post");
            form.attr("enctype", "multipart/form-data")
            form.submit();

        });  // 회원 프로필 수정


        $("#menuModifyBtn", ".item.third").on("click", function (e) {
            let itemThird = $(this).parent();
            let menuBox = itemThird.parent();
            let form = menuBox.parent();



            let isReadOnly = $("input[name=restr_menu_food]", ".item.first").attr("readonly");


            if (isReadOnly == "readonly") {
                $("input[name=restr_menu_food]").attr('readonly', false);
                $("input[name=restr_menu_price]").attr('readonly', false);
                $("input[name=restr_menu_desc]").attr('readonly', false);
                $(this)[0].innerText = "등록";
                return;
            }

            console.log(form)
            form.attr("action", "<c:url value='/mypage/biz/restrMenu/modify'/>");
            form.attr("method", "post");
            form.submit();

        }) // 레스토랑 메뉴 수정


        $("#menuDeleteBtn", ".item.third").on("click", function () {
            let itemThird = $(this).parent();
            let menuBox = itemThird.parent();
            let form = menuBox.parent();

            form.attr("action", "<c:url value='/mypage/biz/restrMenu/delete'/>");
            form.attr("method", "post");
            form.submit();

        }) // 레스토랑 메뉴 삭제


        $("#writeBtn").on("click", function () {
            location.href = "<c:url value='/mypage/biz/QNA/write'/>";
        }) // 문의글 남기기

        $("#useCouponBtn").on("click", function (){
            let payment_NUM = $(this)[0].dataset.payment_num;
            location.href = "<c:url value='/pay/useCoupon?payment_NUM='/>" + payment_NUM;

        }) // 쿠폰 사용



    }) // ready()


</script>


</body>

<!-- Swiper JS -->
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

<!-- Initialize Swiper -->
<script>
    var swiper = new Swiper(".mySwiper", {
        width: 330,
        slidesPerView: "auto",
        centeredSlides: false,
        spaceBetween: 30,
        grabCursor: true,
        pagination: {
            el: ".swiper-pagination",
            clickable: true
        },

    });
</script>
</html>


