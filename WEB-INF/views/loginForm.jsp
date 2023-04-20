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
    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/css/navbarSearchX.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/loginform.css'/>"/>
    <%--  script --%>
    <script src="https://kit.fontawesome.com/43ede2213f.js" crossorigin="anonymous"></script>

    <style>
        #navbar.login{
            -webkit-box-shadow: 0px 4px 0px -200px rgba(189,189,189,1);
            -moz-box-shadow: 0px 4px 0px -200px rgba(189,189,189,1);
            box-shadow: 0px 4px 0px -200px rgba(189,189,189,1);
        }
    </style>

</head>
<body>

<section id="navbar" class="login">
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

<section id="background"
         style="background-image:  url('https://images.unsplash.com/photo-1476224203421-9ac39bcb3327?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjN8fGZvb2R8ZW58MHx8MHx8&auto=format&fit=crop&w=700&q=60') ;"></section>
<h1 class="h1">로그인</h1>
<section id="login">
    <div class="container">

        <form id="loginForm" action="<c:url value="/login/loginProcess"/>" method="post"
              onsubmit="return loginFormCheck(this);">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input name="user_email" type="text" placeholder="이메일을 입력하세요." value="${sessionScope.sns_email}">
            <input name="user_pwd" type="password" placeholder="패스워드를 입력하세요." value="${sessionScope.sns_pwd}">
            <button id="loginBtn">로그인</button>
            <div class="buttons">

                <button>
                    <a href="<c:url value="/register/addUser"/>">회원가입 </a>
                </button>
                <button>
                    <a href="<c:url value="/register/addBizz"/>">사업자 회원가입 </a>
                </button>
<%--                <button>--%>
<%--                    <a href="<c:url value=""/>">이메일찾기 </a>--%>
<%--                </button>--%>
                <button>
                    <a href="<c:url value="/register/findPwd"/>">비밀번호찾기 </a>
                </button>


            </div>
            <div class="socialLogin">
                <button type="button" class="google">
                    <a href="<c:url value='${google_url}'/>">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRu1PJmT_THldF0n5APcmt9p10utgu6KSw4cH2fQ5Xhpw&s"
                             alt="">
                    </a>
                </button>
                <button type="button" class="kakao">
                    <a href="<c:url value="${kakao_url}"/>">
                    <img src="https://i0.wp.com/forhappywomen.com/wp-content/uploads/2018/11/%EC%82%B0%EB%B6%80%EC%9D%B8%EA%B3%BC-%ED%8F%AC%ED%95%B4%ED%94%BC%EC%9A%B0%EB%A8%BC-%EB%AC%B8%EC%9D%98-%EC%B9%B4%EC%B9%B4%EC%98%A4%ED%94%8C%EB%9F%AC%EC%8A%A4%EC%B9%9C%EA%B5%AC-%EB%B2%84%ED%8A%BC.png?resize=586%2C586&ssl=1"
                         alt="">
                    </a>
                </button>
            </div>
        </form>
    </div>
</section>

<div id="msg">
    <c:if test="${LoginFailMessage!=null}">
        <p> Error : <c:out value="${LoginFailMessage}"/></p><br/>
    </c:if>
</div>


<script>
    function loginFormCheck(frm) {
        if (frm.user_email.value.length == 0) {
            setMessage("이메일을 입력해 주세요")
            return false;
        }
        if (frm.user_pwd.value.length == 0) {
            setMessage("비밀번호를 입력해 주세요.")
            return false;
        }
        return true;
    }

    function setMessage(msg) {
        document.getElementById("msg").innerHTML = `${'${msg}'}`;
    }

    if(${not empty sns_email}){
        document.getElementById("loginBtn").click();
    }




</script>

</body>
</html>
