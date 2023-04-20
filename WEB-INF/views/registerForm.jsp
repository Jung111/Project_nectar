<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
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
</head>

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

<%-- New Register Form --%>

<section id="register">
    <div class="container">


        <h1 class="h1">회원가입</h1>
        <form name="frm" action="" id="registerForm" method="post">
            <%--            --%>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <%--            --%>

            <div class="inputBox">
                <span id="result">이메일</span>
                <input type="email" name="user_email" onkeyup="return emailChk()" required/>
            </div>

            <div class="inputBox">
                <span>이름</span>
                <input type="text" name="user_name" required/>
            </div>
            <div class="inputBox">
                <span>핸드폰</span>
                <input type="text" name="user_phone" required/>
            </div>
            <div class="inputBox">
                <span id="passResult">비밀번호 - 대문자 혹은 소문자와 숫자를 합해 6자리 이상 12자리 이하</span>
                <input type="password" name="user_pwd" pattern="^(?=.*[a-zA-z])(?=.*[0-9]).{6,12}$" required/>
            </div>
            <div class="inputBox">
                <span>비밀번호 확인</span>
                <input type="password" class="user_pwd_check" pattern="^(?=.*[a-zA-z])(?=.*[0-9]).{6,12}$" onkeyup="passChk()" required/>
            </div>

            <button type="submit" id="registerBtn">회원가입</button>

        </form>
    </div>
</section>



<script>

    let passCheck = true;
    let emailCheck = true;

    function emailChk() {
        const email = document.frm.user_email.value;
        console.log(email)
        let resultText = document.querySelector("#result");

        if (email.indexOf('@') != -1 && email.indexOf('.com') != -1) {

            <security:authorize access="isAnonymous()">
            $.ajax({
                type: 'POST',
                <%--url:'${pageContext.request.contextPath}/member/readId',--%>
                url: '<c:url value='/register/readEmail'/>',
                header: {"Content-Type": "application/json"},
                dateType: 'json',
                data: {email: email},
                success: function (result) {
                    console.log("result = " + result)
                    if (result == true) {
                        resultText.style.color = 'red'
                        resultText.innerHTML = '중복되는 이메일'
                        emailCheck = true
                        inputCheck()
                    } else {
                        resultText.style.color = 'blue'
                        resultText.innerHTML = '사용가능한 이메일'
                        emailCheck = false
                        inputCheck()
                    }
                }
            })
        } else {
            result.style.color = 'red'
            result.innerHTML = '일치하지 않는 형식'
        }
        </security:authorize>
    }

    function inputCheck() {
        if (emailCheck == false) {
            const submit = document.querySelector("#registerBtn");
            submit.disabled = false;
        } else {
            submit.disabled = true;
        }
    }

    function passChk() {
        const pass = document.frm.user_pwd.value
        const passChk = document.querySelector(".user_pwd_check").value;
        console.log(passChk);
        let result = document.querySelector("#passResult")

        if(pass == passChk){
            result.style.color = 'blue'
            result.innerHTML = '일치하는 비밀번호'
            passCheck = false
            inputCheck()

        } else {
            result.style.color = 'red'
            result.innerHTML = '일치하지 않는 비밀번호'

            passCheck = true
            inputCheck()
        }
    }


</script>


</body>
</html>

