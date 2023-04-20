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
  <link rel="stylesheet" href="<c:url value='/css/registerForm_hb.css'/>"/>

  <style>
    body{
      overflow: hidden;
    }
  </style>

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


<%-- New Register Form --%>

<section id="register">
  <div class="container">
    <h1 class="h1">회원가입</h1>
    <form name="frm" action="<c:url value="/register/addBiz"/>" id="registerForm" method="post">
      <%--            --%>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <%--            --%>

      <div class="inputBox">
        <span id="result">이메일</span>
        <input type="email" name="bizAccount_email" onkeyup="return emailChk()" required/>
      </div>

      <div class="inputBox">
        <span>이름</span>
        <input type="text" name="bizAccount_name" required/>
      </div>
      <div class="inputBox">
        <span>핸드폰</span>
        <input type="text" name="bizAccount_phone" required/>
      </div>
      <div class="inputBox">
        <span id="passResult">비밀번호 - 대문자 혹은 소문자와 숫자를 합해 6자리 이상 12자리 이하</span>
        <input type="password" name="bizAccount_pwd" pattern="^(?=.*[a-zA-z])(?=.*[0-9]).{6,12}$" required/>
      </div>
      <div class="inputBox">
        <span>비밀번호 확인</span>
        <input type="password" class="biz_pwd_check" pattern="^(?=.*[a-zA-z])(?=.*[0-9]).{6,12}$" onkeyup="passChk()" required/>
      </div>

      <button type="submit" id="registerBtn">회원가입</button>

    </form>
  </div>
</section>

<%-- / Global Page--%>


<%--<div id="MyRestrantlist">--%>
<%--    <h3>BIZ가 운영중인 레스토랑 </h3>--%>
<%--    ${restrDto.restr_NUM} </br>--%>
<%--    ${restrDto.restr_name}</br>--%>
<%--    ${restrDto.restr_location}</br>--%>
<%--    ${restrDto.restr_phone}</br>--%>
<%--    ${restrDto.restr_time}</br>--%>
<%--    ${restrDto.restr_star}</br>--%>
<%--    ${restrDto.restr_foodType}</br>--%>
<%--    ${restrDto.restr_cost}</br>--%>
<%--    ${restrDto.restr_parking}</br>--%>
<%--    ${restrDto.restr_tag}</br>--%>
<%--    ${restrDto.restr_menu}</br>--%>
<%--    ${restrDto.restr_cost}</br>--%>
<%--    ${restrDto.restr_menu}</br>--%>
<%--    ${restrDto.restr_picture}</br>--%>
<%--    ${restrDto.restr_viewCnt}</br>--%>
<%--    ${restrDto.restr_reviewCnt}</br>--%>
<%--    ${restrDto.restr_likeCnt}</br>--%>
<%--    ----------------------------------</br>--%>
<%--</div>--%>


<%--<br id="BIZ_info">--%>
<%--<h3>BIZ 에 대한 정보 </h3>--%>
<%--${bizAccountDto.bizAccount_email}--%>
<%--${bizAccountDto.bizAccount_pwd}--%>
<%--${bizAccountDto.bizAccount_name}--%>
<%--${bizAccountDto.bizAccount_phone}--%>
<%--${bizAccountDto.bizAccount_picture}--%>
<%--${bizAccountDto.bizAccount_regdate}--%>
<%--${bizAccountDto.bizAccount_state_code} </br>--%>
<%--</div>--%>


<%-- QNA TEST    --%>
<%--<h2>QNA TEST</h2>--%>
<%--<form id="form" action="<c:url value="/mypage/biz/QNA/write"/>" method="post">--%>
<%--    <input class="detail" type="text" name="qna_title" value="나에게 질문하는 것을 두려워 말라" autofocus>--%>
<%--    <input class="detail" type="text" name="qna_content" value="인태 최고" autofocus>--%>
<%--    <input class="detail" type="text" name="qna_picture" value="핵 깜찍한 인태 사진" autofocus>--%>
<%--    <input class="detail" type="text" name="qna_writer" value="Biz_1@google.com"--%>
<%--           autofocus> &lt;%&ndash;qna_writer = ${bizAccountDto.bizAccount_email}}&ndash;%&gt;--%>
<%--    <input class="detail" type="text" name="qna_name" value="name1"--%>
<%--           autofocus> &lt;%&ndash;qna_name   = ${bizAccountDto.bizAccount_name}}&ndash;%&gt;--%>
<%--    <button id="loginBtn">QNA 등록</button>--%>
<%--</form>--%>
<%--    --%>


<script>
  let passCheck = true;
  let emailCheck = true;

  function emailChk() {
    const email = document.frm.bizAccount_email.value;
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
    const pass = document.frm.bizAccount_pwd.value
    const passChk = document.querySelector(".biz_pwd_check").value;
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
</html>
