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

    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/css/navbarSearchX.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/globalPage.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/admin.css'/>"/>

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


<section id="globalPage">
    <!-- Left Side -->
    <div class="sideMenu">
        <button class="tab index active">일반회원</button>
        <button class="tab index ">사업자회원</button>
        <button class="tab index">매장심사</button>
        <button class="tab index">핫딜심사</button>
        <button class="tab index">Q&A</button>
    </div>

    <!-- Right Side -->
    <div class="main">

        <div class="content index active">
            <h1> 회원 정보 ️</h1>
            <div class="container item">
                <form id="userInfoForm" action="<c:url value='/mypage/admin/main?option=${option}&keyword=${keyword}'/>">
                    <select class="user-search-option" name="option">
                        <option value="all">전체</option>
                        <option value="email">이메일</option>
                        <option value="name">이름</option>
                        <option value="stateCode">상태코드</option>
                    </select>
                    <input type="text" name="keyword" placeholder="검색" >
                    <button type="button" class="searchBtn_user">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </form>
            </div>                       <!--일반 회원 검색-->
            <c:if test="${empty SearchResultUserList}">           <!--초기 화면 이거나 검색 결과가 없는 경우 띄우는 창-->
                <div class="msg__wrap">
                    <i class="fa-solid fa-circle-info"></i>
                    <h3>검색 결과가 없습니다.</h3>
                </div>
            </c:if>
            <div class="container item">
                <div class="userList">
                    <c:if test="${not empty SearchResultUserList}">
                        <table>
                            <thead>
                            <tr>
                                <th class="title">이름</th>
                                <th>이메일</th>
<%--                                <th>연락처</th>--%>
                                <th>계정관리</th>
                                <th>회원등급변경</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="SearchResultUserList" items="${SearchResultUserList}">
                                <form action="<c:url value='/mypage/admin/accountManagement/user'/>" method="post" id="adminForm">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <tr>
                                        <td class="no"><input type="hidden" name="user_NUM"
                                                              value="${SearchResultUserList.user_name}">${SearchResultUserList.user_name}</td>
                                        <td class="writer"><input type="hidden" name="user_email"
                                                                  value="${SearchResultUserList.user_email}">${SearchResultUserList.user_email}</td>
<%--                                        <td class="phone">${SearchResultUserList.user_phone}</td>--%>
                                        <td>
                                            <select name="user_state_code">
                                                <option value="0">일반회원</option>
                                                <option value="-1">리뷰작성금지</option>
                                                <option value="-2">핫딜결제금지</option>
                                                <option value="-3">계정정지</option>
                                            </select>
                                        </td>
                                        <td>
                                            <input class="userBtn" type="submit" value="저장">
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>

                </div>
            </div>                       <!--회원 검색 리스트-->
        </div>      <!--일반회원-->
        <div class="content index">
            <h1> 사업자 회원 정보 </h1>
            <div class="container item">
                <form id="bizInfoForm" action="<c:url value='/mypage/admin/main?option=${option}&keyword=${keyword}'/>">
                    <select class="user-search-option" name="option">
                        <option value="all">전체</option>
                        <option value="email">이메일</option>
                        <option value="name">이름</option>
                        <option value="stateCode">상태코드</option>
                    </select>
                    <input type="text" name="keyword" placeholder="검색" >
                    <button type="button" class="searchBtn_biz">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </form>
            </div>                       <!--사업자 회원 검색-->
            <c:if test="${empty SearchResultBizAccountList}">           <!--초기 화면 이거나 검색 결과가 없는 경우 띄우는 창-->
                <div class="msg__wrap">
                    <i class="fa-solid fa-circle-info"></i>
                    <h3>검색 결과가 없습니다.</h3>
                </div>
            </c:if>
            <div class="container item">                          <!--사업자 회원 검색 리스트-->
                <div class="userList">
                    <c:if test="${not empty SearchResultBizAccountList}">
                        <table>
                            <thead>
                            <tr>
                                <th>사업주</th>
                                <th>이메일</th>
                                <th>계정관리</th>
                                <th>회원등급변경</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="SearchResultBizAccountList" items="${SearchResultBizAccountList}">
                                <form action="<c:url value='/mypage/admin/accountManagement/biz'/>" method="post"
                                      id="adminForm">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <tr>
                                        <td class="no"> ${SearchResultBizAccountList.bizAccount_name}</td>
                                        <td class="writer"> ${SearchResultBizAccountList.bizAccount_email}</td>
                                        <td>
                                            <select name="bizAccount_state_code">
                                                <option value="0">사업자회원</option>
                                                <option value="-4">매장게시정지</option>
                                                <option value="-5">핫딜등록금지</option>
                                                <option value="-3">계정정지</option>
                                            </select>
                                        </td>
                                        <td>
                                            <input class="userBtn" type="submit" value="저장">
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>

                </div>
            </div>                       <!--사업자 회원 검색 리스트-->

        </div>             <!--사업자회원-->
        <div class="content index">
            <h1> 매장심사 ✏️</h1>
            <div class="container item">
                <%-- 심사 요청 매장 리스트--%>
                <div class="userList">
                    <table>
                        <thead>
                        <tr>
                            <th>no</th>
                            <th>사업장</th>
                            <th>이메일</th>
                            <th>연락처</th>
                            <th>심사상태</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="request_restrDto" items="${request_restrDto}">

                            <tr>
                                <td >${request_restrDto.request_restr_NUM}</td>
                                <td class="title"><a
                                        href="<c:url value="/mypage/admin/reqRestr/read?request_restr_NUM=${request_restrDto.request_restr_NUM}"/>">
                                        ${request_restrDto.request_restr_name}
                                </a>
                                </td>
                                <td >${request_restrDto.request_bizAccount_email}</td>
                                <td >${request_restrDto.request_restr_phone}</td>
                                <c:if test="${request_restrDto.evaluate_code eq 0}">
                                    <td class="judge"><h4 class="eval">심사대기</h4>  </td>
                                </c:if>
                                <c:if test="${request_restrDto.evaluate_code eq 1}">
                                    <td class="judge"><h4 class="permit">승인</h4>  </td>
                                </c:if>
                                <c:if test="${request_restrDto.evaluate_code eq -1}">
                                    <td class="judge"><h4 class="deny">심사반려</h4>  </td>
                                </c:if>
<%--                                <td class="judge"> <h4 class="${request_restrDto.evaluate_code eq 0 ? "eval" : "deny"}">${request_restrDto.evaluate_code eq 0 ? "심사대기" : "심사반려"}</h4> </td>--%>

                            </tr>

                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>             <!--매장심사-->
        <div class="content index">           <!--핫딜심사-->
            <h1> 핫딜심사 ✏️</h1>
            <div class="container item">
                <%-- 핫딜 요청 매장 리스트--%>
                <div class="userList">

                    <table>
                        <thead>
                        <tr>
                            <th>no</th>
                            <th>사업장</th>
                            <th>메뉴</th>
                            <th>가격책정</th>
                            <th>심사상태</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="request_hotdealDto" items="${request_hotdealDto}">
                            <tr>
                                <td class="no">${request_hotdealDto.request_restr_NUM}</td>
                                <td class="requestRestrName"><a
                                        href="<c:url value="/mypage/admin/reqHotdeal/read?request_hotdeal_NUM=${request_hotdealDto.request_hotdeal_NUM}"/>">${request_hotdealDto.request_restr_name}</a>
                                </td>
                                <td class="writer">${request_hotdealDto.request_restr_menu_food}</td>
                                <td class="writer">${request_hotdealDto.request_restr_menu_price}</td>
                                <c:if test="${request_hotdealDto.evaluate_code eq 0}">
                                    <td class="judge"><h4 class="eval">심사대기</h4>  </td>
                                </c:if>
                                <c:if test="${request_hotdealDto.evaluate_code eq 1}">
                                    <td class="judge"><h4 class="permit">승인</h4>  </td>
                                </c:if>
                                <c:if test="${request_hotdealDto.evaluate_code eq -1}">
                                    <td class="judge"><h4 class="deny">심사반려</h4>  </td>
                                </c:if>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>             <!--핫딜심사-->
        <div class="content index">
            <h1> Q&A✏️</h1>
            <div class="container item">
                <div class="userList">
                    <table>
                        <thead>
                        <tr>
                            <th>no</th>
                            <th>제목</th>
                            <th>이름</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="QNADto" items="${QNADto}">
                            <tr>
                                <td class="no"> ${QNADto.qna_NUM}</td>
                                <td class="qnaTitle"><a
                                        href="<c:url value="/mypage/admin/QNA/read?qna_NUM= ${QNADto.qna_NUM}"/>">  ${QNADto.qna_title}</a>
                                </td>
                                <td class="writer">${QNADto.qna_name}</td>

                            </tr>


                        </c:forEach>

                        </tbody>
                    </table>
                </div>


            </div>
        </div>             <!--F&Q-->

    </div>
</section>




<script>
    $(document).ready(() => {

        // TAB 기능 //

        const tabs = document.querySelectorAll("button.tab");
        const contents = document.querySelectorAll(".content");

        tabs.forEach((tab, idx) => {
            tab.addEventListener("click", (e) => {

                contents.forEach((content) => {
                    content.classList.remove('active')
                })

                tabs.forEach((tab) => {
                    tab.classList.remove('active')
                })

                tabs[idx].classList.add('active')
                contents[idx].classList.add('active')
            });
        });

        // TAB 기능 //


    }) // ready()



</script>


</body>
</html>

