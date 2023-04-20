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
    <link rel="stylesheet" href="<c:url value='/css/hotdealList.css'/>"/>
    <%--  script --%>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script
            src="https://kit.fontawesome.com/43ede2213f.js"
            crossorigin="anonymous"
    ></script>

</head>
<body>

<%--navbar--%>
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


<!-- Main -->

<section id="hotdeal">
    <ul class="hotdealList">
        <c:forEach var="hotdealDto" items="${hotdealDto}">
            <li class="hotdealRestr">
                <a href="<c:url value='/hotdeal/read?hotdeal_NUM=${hotdealDto.hotdeal_NUM}'/>" class="hotdealRestr_wrap">
                    <div class="hotdealRest__imgDesc">
                        <div class="hotdealRestr__imgContainer">
                            <img
                                    src="<c:url value='/uploadFile/${hotdealDto.hotdeal_picture}'/>"
                                    alt=""
                                    class="hotdealRestr__img"
                            />
                        </div>
                        <div class="hotdealRestr__imgDeem">
                            <div class="left">
                                <div class="left__item-new">
                                    <span>NEW</span>
                                </div>
                                <div class="left__item-discountRate">
                                    <p>${hotdealDto.hotdeal_discountRate}%</p>
                                </div>
                            </div>
                            <div class="right">
                                <div class="right__item-menuPrice">${hotdealDto.restr_menu_price} 원</div>
                                <div class="right__item-hotdealPrice">${hotdealDto.hotdeal_price} 원</div>
                            </div>
                        </div>
                    </div>
                    <div class="hotdealRestr__info">
                        <div class="info__head">
                            <h1>[${hotdealDto.restr_category_loc}] ${hotdealDto.restr_name}</h1>


                            <c:if test="${hotdealDto.hotdeal_salesVolume == hotdealDto.hotdeal_MaxSalesVolume}">
                                <h2 style="color:red"> 준비한 쿠폰이 모두 소진되어 판매가 종료되었습니다. </h2>
                            </c:if>


                        </div>
                        <div class="info__hotdealMenu">
                            <p>${hotdealDto.restr_menu_food}</p>
                        </div>
                        <div class="info__hotdealDesc">
                            <div class="hotdealDesc__wrap">
                                <p>${hotdealDto.hotdeal_desc}</p>
                            </div>
                        </div>
                    </div>
                </a>
            </li>
        </c:forEach>

    </ul>
</section>

</body>
</html>

