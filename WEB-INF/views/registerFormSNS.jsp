<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>

    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/css/navbarSearchX.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/registerForm_hb.css'/>"/>

    <!-- JQUERY -->
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>

    <style>

        body{
            overflow: hidden;
        }

    </style>
</head>>
<body>


<!-- NAVBAR -->
<section id="navbar" class="register">
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
<!-- Register Form -->

<div class="container">
    <div class="title">Registration</div>
    <div class="content">
        <form action="<c:url value="/register/addUser"/>" method="post" >

            <h3> 전체 동의하기</h3></br>
            ${userDto.user_email}
            <p>NECTAR 서비스 제공을 위해 회원번호와 함께 개인정보가 제공됩니다.
            보다 자세한 개인정보 제공항목은 동의 내용에서 확인하실 수 있습니다.
            해당 정보는 동의 철회 또는 서비스 탈퇴 시 지체없이 파기됩니다.</p>
            </br>
            <p>
                [필수] 구글 개인정보 제3자 제공 동의     보기
            </br>
                구글 계정(이메일), 닉네임
            </br>
            </br>
            </br>
                '보기 누르면 펼쳐짐'
                NECTAR 서비스 내 이용자 식별, 회원관리 및 서비스 제공을 위해 회원번호와 함께 ${userDto.user_email} 님의 개인정보를 제공합니다. 해당 정보는 동의 철회 또는 서비스 탈퇴 시 지체없이 파기됩니다. 아래 동의를 거부 할 권리가 있으며, 필수 동의를 거부할 경우 서비스 이용이 제한됩니다. 선택 동의를 거부할 경우 기재된 목적의 일부 서비스 이용이 제한될 수 있습니다.

                [제공 받는 자]
                NECTAR
                [필수 제공 항목]
                구글계정(이메일), 닉네임
                [선택 제공 항목]
                프로필 사진
                [제공 목적]
                NECTAR 아카데미 서비스 내 이용자 식별, 회원관리 및 서비스 제공
                [보유 기간]
                동의 철회 또는 서비스 탈퇴 시 지체없이 파기
            </p>
            </br>
            </br>
            </br>
            <p>
                [선택] 구글 개인정보 제3자 제공 동의     보기
                </br>
                프로필 사진
                </br>
                </br>
                </br>
                '보기 누르면 펼쳐짐'
                NECTAR 서비스 내 이용자 식별, 회원관리 및 서비스 제공을 위해 회원번호와 함께 ${userDto.user_email} 님의 개인정보를 제공합니다. 해당 정보는 동의 철회 또는 서비스 탈퇴 시 지체없이 파기됩니다. 아래 동의를 거부 할 권리가 있으며, 필수 동의를 거부할 경우 서비스 이용이 제한됩니다. 선택 동의를 거부할 경우 기재된 목적의 일부 서비스 이용이 제한될 수 있습니다.

                [제공 받는 자]
                NECTAR
                [필수 제공 항목]
                구글계정(이메일), 닉네임
                [선택 제공 항목]
                프로필 사진
                [제공 목적]
                NECTAR 서비스 내 이용자 식별, 회원관리 및 서비스 제공
                [보유 기간]
                동의 철회 또는 서비스 탈퇴 시 지체없이 파기
            </p>
            </br>
            </br>



                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="hidden" name="user_email" value="${userDto.user_email}" />
                <input type="hidden" name="user_pwd" value="${userDto.user_pwd}" />
                <input type="hidden" name="user_name" value="${userDto.user_name}" />
                <input type="hidden" name="user_phone" value="${userDto.user_phone}" />
                <input type="hidden" name="user_picture" value="${userDto.user_picture}" />

                <div class="button">
                    <input type="submit" value="동의하고 계속하기" />
                </div>
        </form>
    </div>
</div>




<script>

</script>




</body>
</html>

