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
    <%--    <link rel="stylesheet" href="<c:url value='/css/globalPage.css'/>"/>--%>
    <link rel="stylesheet" href="<c:url value='/css/reqForm.css'/>"/>

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

<section id="req">
    <div class="container">
        <h1 class="title">핫딜심사</h1>
        <form action="" id="form">
            <div class="boxes">
                <%--            --%>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <%--            --%>
<%--                    <input type="hidden" name="hotdeal_NUM" value="${request_hotdealDto.request_hotdeal_NUM}">--%>
                    <input type="hidden" name="request_hotdeal_NUM" value="${request_hotdealDto.request_hotdeal_NUM}">
                <div class="inputBox">
                    <span class="item name">매장명</span>
                    <input readonly name="restr_name" type="text" class="item input"
                           value="${request_hotdealDto.request_restr_name}">
                </div>
                <div class="inputBox">
                    <span class="item name">이메일</span>
                    <input readonly name="bizAccount_email" type="text" class="item input"
                           value="${request_hotdealDto.request_bizAccount_email}">
                </div>
                <div class="inputBox">
                    <span class="item name">핫딜메뉴</span>
                    <input readonly name="restr_menu_food" type="text" class="item input"
                           value="${request_hotdealDto.request_restr_menu_food}"/></div>

                <div class="inputBox">
                    <span class="item name">기존메뉴</span>
                    <input readonly name="restr_menu_price" type="text" class="item input"
                           value="${request_hotdealDto.request_restr_menu_price}원"/></div>
                <div class="inputBox">
                    <span class="item name">핫딜가격</span>
                    <input readonly name="hotdeal_price" type="text" class="item input"
                           value="${request_hotdealDto.request_hotdeal_price}원"/></div>
                <div class="inputBox">
                    <span class="item name">할인률</span>
                    <input readonly name="hotdeal_discountRate" type="text" class="item input"
                           value="${request_hotdealDto.request_hotdeal_discountRate}%"/></div>
                <div class="inputBox">
                    <span class="item name">메뉴설명</span>
                    <input readonly name="hotdeal_desc" type="text" class="item input"
                           value="${request_hotdealDto.request_hotdeal_desc}"/></div>
                <div class="inputBox">
                    <span class="item name">이벤트기간</span>
                    <input readonly name="hotdeal_useDate" type="text" class="item input"
                           value="${request_hotdealDto.request_hotdeal_useDate}"/></div>
                <div class="inputBox">
                    <span class="item name">사용기간</span>
                    <input readonly name="hotdeal_eventDuration" type="text" class="item input"
                           value=" 구매일로부터 ${request_hotdealDto.request_hotdeal_eventDuration}"/></div>
            </div>

            <div class="imgContainer">
                <input type="hidden" name="hotdeal_picture" value="${request_hotdealDto.request_hotdeal_picture}">
                <img src="<c:url value='/uploadFile/${request_hotdealDto.request_hotdeal_picture}'/>" alt=""
                     class="reviewPicture"/>
            </div>
        </form>
        <div class="buttons">
            <button type="button"  id="denyBtn">심사반려</button>
            <button type="button"  id="registerBtn">승인</button>
<%--            <button type="button" id="listBtn">목록</button>--%>
        </div>
    </div>
</section>


<script>
    $(document).ready(function () {
        let formCheck = function () {
            let form = document.getElementById("form");
            if (form.title.value == "") {
                alert("제목을 입력해주세요.");
                form.title.focus();
                return false;
            }
            if (form.content.value == "") {
                alert("제목을 입력해주세요.");
                form.title.focus();
                return false;
            }
            return true;
        }

        $("#listBtn").on("click", function () {
            location.href = "<c:url value='/mypage/admin/main'/>";
        });



        $("#registerBtn").on("click", function () {
            if (!confirm("핫딜 등록 요청을 완료 하시겠습니까?")) return;
            let form = $("#form");
            form.attr("action", "<c:url value='/mypage/admin/reqHotdeal/register'/>");
            form.attr("method", "post");
            form.submit();
        });


        $("#denyBtn").on("click", function () {
            if (!confirm("핫딜 등록 요청을 반려하시겠습니까?")) return;
            let form = $("#form");
            form.attr("action", "<c:url value='/mypage/admin/reqHotdeal/deny'/>");
            form.attr("method", "post");
            form.submit();

        });

    })
</script>

</body>
</html>
