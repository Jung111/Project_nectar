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
  <!-- CSS -->
  <link rel="stylesheet" href="<c:url value='/css/navbar.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/css/restrList.css'/>"/>
  <%--  script --%>
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
  <script
          src="https://kit.fontawesome.com/43ede2213f.js"
          crossorigin="anonymous"
  ></script>
  <script defer src="<c:url value="/restr/list"/>"></script>
  <script
          defer
          src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDGgEEcmo8EbPKj8kwDcpC8W18nIZvnq2U&callback=initMap"
  ></script>

</head>
<body>

<section id="navbar">
  <div class="logo">
    <a href="<c:url value='/'/>"> <img src="<c:url value="/images/nectarLogo.png"/>" alt="" class="logo__img"/></a>
  </div>
  <div class="searchBar">
    <form action="<c:url value="/restr/search"/>" class="search-form" method="get">
      <button type="button" class="searchBtn" value="검색">
        <i class="fa-solid fa-magnifying-glass"></i>
      </button>
      <input type="hidden" name="option" value="searchEngine"/>
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
        <a href="<c:url value='/login/login'/>">LOGIN</a>
      </security:authorize>
      <security:authorize access="hasRole('USER')">
        <a href="<c:url value='/mypage/user/main'/>"><i class="fa-solid fa-user"></i></a>
      </security:authorize>
      <security:authorize access="hasRole('BIZ')">
        <a href="<c:url value='/mypage/biz/main'/>"><i class="fa-solid fa-user-tie"></i></a>
      </security:authorize>
      <security:authorize access="hasRole('ADMIN')">
        <a href="<c:url value='/mypage/admin/main'/>"><i class="fa-solid fa-user-secret"></i></a>
      </security:authorize>
    </li>
  </ul>
</section>


<div id="msg">
  <c:if test="${LoginFailMessage!=null}">
    <p> Error : <c:out value="${LoginFailMessage}"/> </p><br/>
  </c:if>
</div>



</body>
</html>
