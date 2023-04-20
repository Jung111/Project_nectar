<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />

    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/css/navbarSearchX.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/successPage.css'/>"/>

</head>



<body>
<%--NAVBAR--%>

<section id="navbar">
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

<section id="info">
    <div class="box">
        <div class="box_item">
            <!-- <i class="fa-solid fa-circle-check"></i> -->
            <div class="emoji">✔️</div>
        </div>
        <h1>성공적으로 등록되었습니다!</h1>
        <p>
            문의를 처리하는 데 며칠 소요되며,  ${qnaDto.qna_name} 님의  이메일( ${qnaDto.qna_writer} )로 답변 드리겠습니다. Nectar를 이용해 주셔서 감사합니다.
        </p>
        <br>
        <br>

        <security:authorize access="hasRole('USER')">
            <button style="margin-top : 10px ; background-color: transparent; border: 0 ; font-weight: bold ; font-size: 16px" >  <a href="<c:url value='/mypage/user/main'/>">MY PAGE 로 이동</a></button>
        </security:authorize>
        <security:authorize access="hasRole('BIZ')">
            <button style="margin-top : 10px ;background-color: transparent; border: 0 ; font-weight: bold ; font-size: 16px" >  <a href="<c:url value='/mypage/biz/main'/>">MY PAGE 로 이동</a></button>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <button style="margin-top : 10px ; background-color: transparent; border: 0 ; font-weight: bold ; font-size: 16px" >  <a href="<c:url value='/mypage/admin/main'/>">MY PAGE 로 이동</a></button>
        </security:authorize>

    </div>
</section>

</body>
