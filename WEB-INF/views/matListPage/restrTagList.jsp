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
  <link rel="stylesheet" href="<c:url value='/css/tagFilter.css'/>"/>
  <%--  script --%>
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
  <script
          src="https://kit.fontawesome.com/43ede2213f.js"
          crossorigin="anonymous"
  ></script>

</head>
<body>


<%-- NAVBAR--%>
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



<!-- Tag Filter -->
<div class="sub_title">
  <h1>믿고 먹는 맛집 리스트 💕</h1>
</div>
<div class="tagFilter">
  <div class="tag item1">
    <a href="<c:url value='/restr/search?option=tagFilter&tag=인스타그램'/>">
      <img
              src="https://images.unsplash.com/photo-1562147458-0c12e8d29f50?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1740&q=80"
              alt=""
      />
      <div class="background">
        <span class="text">#인스타그램</span>
      </div>
    </a>
  </div>
  <div class="tag item">
    <a href="<c:url value='/restr/search?option=tagFilter&tag=데이트'/>">
      <img
              src="https://images.unsplash.com/photo-1559620192-032c4bc4674e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=858&q=80"
              alt=""
      />
      <div class="background">
        <span class="text">#데이트</span>
      </div>
    </a>
  </div>
  <div class="tag item">
    <a href="<c:url value='/restr/search?option=tagFilter&tag=분위기 좋은곳'/>">
      <img
              src="https://images.unsplash.com/photo-1517957096399-3a4e3d34d95e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"
              alt=""
      />
      <div class="background">
        <span class="text">#분위기 좋은 곳</span>
      </div>
    </a
    >
  </div>
  <div class="tag item">
    <a href="<c:url value='/restr/search?option=tagFilter&tag=핫플'/>">
      <img
              src="https://images.unsplash.com/photo-1583953623787-ada99d338235?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
              alt=""
      />
      <div class="background">
        <span class="text">#핫플</span>
      </div>
    </a
    >
  </div>
  <div class="tag item">
    <a href="<c:url value='/restr/search?option=tagFilter&tag=가로수길'/>">
      <img
              src="https://images.unsplash.com/photo-1565958011703-44f9829ba187?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=930&q=80"
              alt=""
      />
      <div class="background">
        <span class="text">#가로수길</span>
      </div>
    </a
    >
  </div>
  <div class="tag item">
    <a href="<c:url value='/restr/search?option=tagFilter&tag=커플'/>">
      <img
              src="https://images.unsplash.com/photo-1609951651556-5334e2706168?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"
              alt=""
      />
      <div class="background">
        <span class="text">#커플</span>
      </div>
    </a
    >
  </div>
  <div class="tag item">
    <a href="<c:url value='/restr/search?option=tagFilter&tag=예쁜'/>">
      <img
              src="https://images.unsplash.com/photo-1560180474-e8563fd75bab?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"
              alt=""
      />
      <div class="background">
        <span class="text">#예쁜</span>
      </div>
    </a
    >
  </div>
  <div class="tag item">
    <a href="<c:url value='/restr/search?option=tagFilter&tag=셀카'/>">
      <img
              src="https://images.unsplash.com/photo-1543573852-1a71a6ce19bc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1740&q=80"
              alt=""
      />
      <div class="background">
        <span class="text">#셀카</span>
      </div>
    </a
    >
  </div>
  <div class="tag item">
    <a href="<c:url value='/restr/search?option=tagFilter&tag=예쁜'/>">
      <img
              src="https://images.unsplash.com/photo-1509042239860-f550ce710b93?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"
              alt=""
      />
      <div class="background">
        <span class="text">#크레아</span>
      </div>
    </a
    >
  </div>
</div>


</body>
</html>
