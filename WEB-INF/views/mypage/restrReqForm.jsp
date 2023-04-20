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
    <link rel="stylesheet" href="<c:url value='/css/navbarHome.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/reqForm.css'/>"/>
    <%--    <link rel="stylesheet" href="<c:url value='/css/globalPage.css'/>"/>--%>


</head>


<body>

<div id="menu">
    <ul>
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
</div>


<section id="req">
    <div class="container">
        <h1 class="title">매장심사</h1>
        <form action="" id="form">
            <div class="boxes">
                <%--            --%>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <%--            --%>
                <input name="request_restr_NUM" type="hidden" value="${request_restrDto.request_restr_NUM}"/>
                <div class="inputBox">
                    <span class="item name">이메일</span>
                    <input type="text" readonly name="bizAccount_email" class="item input"
                           value="${request_restrDto.request_bizAccount_email}">
                </div>
                <div class="inputBox">
                    <span class="item name">매장이름</span>
                    <input readonly name="restr_name" type="text" class="item input"
                           value="${request_restrDto.request_restr_name}"/></div>
                <div class="inputBox">
                    <span class="item name">연락처</span>
                    <input readonly name="restr_phone" type="text" class="item input"
                           value="${request_restrDto.request_restr_phone}"/></div>
                <div class="inputBox">
                    <span class="item name">위치</span>
                    <input readonly name="restr_location" type="text" class="item input"
                           value="${request_restrDto.request_restr_location}"/></div>
                <div class="inputBox">
                    <span class="item name">운영시간</span>
                    <input readonly name="restr_time" type="text" class="item input"
                           value="${request_restrDto.request_restr_time}"/></div>
                <div class="inputBox">
                    <span class="item name">연관태그</span>
                    <input readonly name="restr_tag" type="text" class="item input"
                           value="${request_restrDto.request_restr_tag}"/></div>
                <div class="inputBox">
                    <span class="item name">위치태그</span>
                    <input readonly name="restr_location_tag" type="text" class="item input"
                           value="${request_restrDto.request_restr_location_tag}"/></div>
                <div class="inputBox">
                    <span class="item name">음식종류</span>
                    <input readonly name="restr_foodType" type="text" class="item input"
                           value="${request_restrDto.request_restr_foodType}"/></div>
                <div class="inputBox">
                    <span class="item name">가격대</span>
                    <input readonly name="restr_cost" type="text" class="item input"
                           value="${request_restrDto.request_restr_cost}"/></div>
                <div class="inputBox">
                    <span class="item name">주차여부</span>
                    <input readonly name="restr_parking" type="text" class="item input"
                           value="${request_restrDto.request_restr_parking}"/></div>
                <div class="inputBox">
                    <span class="item name">등록증</span>
                    <input readonly name="biz_reg_num" type="text" class="item input"
                           value="${request_restrDto.request_biz_reg_num}"/></div>
                <div class="inputBox">
                    <span class="item name">설명</span>
                    <input readonly name="restr_desc" type="text" class="item input"
                           value="${request_restrDto.request_restr_desc}"/></div>
            </div>

            <div class="imgContainer">
                <input type="hidden" name="restr_picture" value="${request_restrDto.request_restr_picture}">
                <img src="<c:url value='/uploadFile/${request_restrDto.request_restr_picture}'/>" alt=""
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
        }); // 목록으로 이동

        $("#registerBtn").on("click", function () {
            if (!confirm("매장 등록 요청을 허가하시겠습니까?")) return;
            console.log($(this));
            let form = $("#form");
            form.attr("action", "<c:url value='/mypage/admin/reqRestr/register'/>");
            form.attr("method", "post");
            form.submit();
        }); // 심사완료

        $("#denyBtn").on("click", function () {
            if (!confirm("매장 등록 요청을 반려하시겠습니까?")) return;
            let form = $("#form");
            form.attr("action", "<c:url value='/mypage/admin/reqRestr/deny'/>");
            form.attr("method", "post");
            form.submit();

        });

    })
</script>

</body>
</html>
