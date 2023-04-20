<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal.username" var="email"/>


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
    <link rel="stylesheet" href="<c:url value='/css/navbar.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/qnaForm.css'/>"/>

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


<%--board--%>

<section id="board">
    <form id="qnaForm">
        <header id="header">
            <h1>QNA</h1>
        </header>
        <section id="title">
            <%--        <h1 class="title">${qnaDto.qna_title}   </h1>--%>
            <input name="qna_title" ${mode == 'new' ? '' : 'readonly = "readonly"'} value="${qnaDto.qna_title}"
                   placeholder="제목을 입력해주세요.">
            <div class="user_info">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <c:if test="${not empty bizAccountDto}">
                    <input name="qna_NUM" type="hidden" value="${qnaDto.qna_NUM}">
                    <input name="qna_name" type="hidden" value="${bizAccountDto.bizAccount_name}">
                    <input name="qna_writer" type="hidden" value="${bizAccountDto.bizAccount_email}">
                    <span class="name">${mode == "new" ? bizAccountDto.bizAccount_name : qnaDto.qna_name}(${mode == "new" ? bizAccountDto.bizAccount_email :qnaDto.qna_writer})</span>
                    <span
                            class="date">${qnaDto.qna_regdate}</span>
                </c:if>

                <c:if test="${not empty userDto}">
                    <input name="qna_NUM" type="hidden" value="${qnaDto.qna_NUM}">
                    <input name="qna_name" type="hidden" value="${userDto.user_name}">
                    <input name="qna_writer" type="hidden" value="${userDto.user_email}">
                    <span class="name">${mode == "new" ? userDto.user_name : qnaDto.qna_name}(${mode == "new" ? userDto.user_email : qnaDto.qna_writer})</span>
                    <span
                            class="date">${qnaDto.qna_regdate}</span>
                </c:if>

                <c:if test="${not empty adminDto}">
                    <input name="qna_NUM" type="hidden" value="${qnaDto.qna_NUM}">
                    <input name="qna_name" type="hidden" value="${qnaDto.qna_name}">
                    <input name="qna_writer" type="hidden" value="${qnaDto.qna_writer}">
                    <span class="name">${qnaDto.qna_name}(${qnaDto.qna_writer})</span> <span
                        class="date">${qnaDto.qna_regdate}</span>
                </c:if>
            </div>
        </section>
        <section id="content">
            <textarea name="qna_content" ${mode == 'new' ? '' : 'readonly = "readonly"'} id="" cols="30" rows="10"
                      placeholder="문의글을 작성해주세요.">${qnaDto.qna_content}</textarea>
        </section>
    </form>


    <!--QNA 코멘트 (QNA Comment) -->

    <c:if test="${mode ne 'new'}">
        <div class="commentContainer">
            <h3 class="h3" style="margin-bottom: 20px">댓글</h3>
                <%--        <form id="commentForm" action="<c:url value="/mypage/admin/QNA/addComment"/>" method="post">--%>
            <form id="commentForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" name="qna_NUM" value="${qnaDto.qna_NUM}">
                <security:authorize access="hasRole('USER')">
                    <input type="hidden" name="qna_commenter" value="${userDto.user_email}">
                </security:authorize>
                <security:authorize access="hasRole('BIZ')">
                    <input type="hidden" name="qna_commenter" value="${bizAccountDto.bizAccount_email}">
                </security:authorize>
                <security:authorize access="hasRole('ADMIN')">
                    <input type="hidden" name="qna_commenter" value="${adminDto.admin_email}">
                </security:authorize>

                <textarea name="qna_comment" cols="30" rows="10" class="content" placeholder="댓글을 입력하세요.."></textarea>
                <button class="submitBtn" type="button">등록</button>

            </form>


            <c:forEach var="qnaCommentDto" items="${qnaCommentDto}">

                <div class="commentBox">
                    <form id="myComment">
                        <input name="qna_commenter" type="text" value="${qnaCommentDto.qna_commenter}" readonly>
                        <input name="qna_comment" type="text" value="${qnaCommentDto.qna_comment}" readonly>
                        <p>

                            <span>2023.04.05</span>

                            <security:authorize access="hasRole('ADMIN')">
                                <button id="cmtModBtn">수정</button>
                                <button id="cmtDelBtn">삭제</button>
                            </security:authorize>
                        </p>
                    </form>
                </div>
                <%--  댓글 삭제 BTN도 있어요. /mypage/admin/QNA/removeComment      --%>

            </c:forEach>

        </div>
    </c:if>


    <footer>


        <c:choose>
            <c:when test="${mode eq 'new'}">
                <security:authorize access="hasRole('USER')">
                    <button id="userwriteBtn">등록</button>
                </security:authorize>
                <security:authorize access="hasRole('BIZ')">
                    <button id="bizwriteBtn">등록</button>
                </security:authorize>
            </c:when>

            <c:otherwise>
                <div class="judge">
                    <security:authorize access="hasRole('USER')">
                        <button class="usermodifyBtn">수정</button>
                    </security:authorize>
                    <security:authorize access="hasRole('BIZ')">
                        <button class="bizmodifyBtn">수정</button>
                    </security:authorize>
                </div>

            </c:otherwise>

        </c:choose>

        <div class="judge">
            <security:authorize access="hasRole('USER')">
                <a href="<c:url value='/mypage/user/main'/>">
                    <button class="listBtn">목록</button>
                </a>
            </security:authorize>
            <security:authorize access="hasRole('BIZ')">
                <a href="<c:url value='/mypage/biz/main'/>">
                    <button class="listBtn">목록</button>
                </a>
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
                <a href="<c:url value='/mypage/admin/main'/>">
                    <button class="listBtn">목록</button>
                </a>
            </security:authorize>
        </div>


    </footer>


</section>


<script>

    $(document).ready(() => {

        $("#userwriteBtn").on("click", function () {
            let form = $("#qnaForm");
            form.attr("action", "<c:url value='/mypage/user/QNA/write'/>");
            form.attr("method", "post");
            form.submit();

        })// 문의글 남기기

        $("#bizwriteBtn").on("click", function () {
            let form = $("#qnaForm");
            form.attr("action", "<c:url value='/mypage/biz/QNA/write'/>");
            form.attr("method", "post");
            form.submit();
        }) // 문의글 남기기

        $(".usermodifyBtn").on("click", function () {
            let form = $("#qnaForm");
            let isReadOnly = $("input[name=qna_title]").attr("readonly");
            console.log($(this));
            if (isReadOnly == "readonly") {
                $("input[name=qna_title]").attr("readonly", false);
                $("textarea[name=qna_content]").attr("readonly", false);
                $(this)[0].innerText = "등록";
                return;
            }

            form.attr("action", "<c:url value='/mypage/user/QNA/modify'/>");
            form.attr("method", "post");
            form.submit();

        }) // 문의글 수정하기

        $(".bizmodifyBtn").on("click", function () {
            let form = $("#qnaForm");
            let isReadOnly = $("input[name=qna_title]").attr("readonly");
            console.log($(this));

            if (isReadOnly == "readonly") {
                $("input[name=qna_title]").attr("readonly", false);
                $("textarea[name=qna_content]").attr("readonly", false);
                $(this)[0].innerText = "등록";
                return;
            }

            form.attr("action", "<c:url value='/mypage/biz/QNA/modify'/>");
            form.attr("method", "post");
            form.submit();

        }) // 문의글 수정하기


        $(".submitBtn").on("click",function (){
            let form = $("#commentForm");
            <security:authorize access="hasRole('ADMIN')">
            form.attr("action", "<c:url value="/mypage/admin/QNA/addComment"/>");
            form.attr("method", "post");
            </security:authorize>

            <security:authorize access="hasRole('BIZ')">
            form.attr("action", "<c:url value="/mypage/biz/QNA/addComment"/>");
            form.attr("method", "post");
            </security:authorize>

            <security:authorize access="hasRole('USER')">
            form.attr("action", "<c:url value="/mypage/user/QNA/addComment"/>");
            form.attr("method", "post");
            </security:authorize>
            form.submit();
        }) // 댓글 등록버튼


    }) // ready()


</script>


</body>
</html>
