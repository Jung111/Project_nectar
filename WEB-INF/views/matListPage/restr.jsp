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
    <!-- Swiper Css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/css/restr.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/navbar.css'/>"/>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script src="https://kit.fontawesome.com/43ede2213f.js" crossorigin="anonymous"></script>

</head>
<body>

<section id="navbar">
    <div class="logo">
        <a href="<c:url value='/'/>"> <img src="<c:url value="/images/nectarLogo.png"/>" alt="" class="logo__img"/></a>
    </div>
    <div class="searchBar">
        <form action="" class="search-form" method="get">
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
<br>

<!-- Restaurant Detail Page -->

<!-- Title -->


<section id="restr-detail">
    <div class="title-box">
        <h3 class="title">
            ${restrDto.restr_name}
            <strong class="star">
                <fmt:formatNumber value="${restrDto.restr_star}" pattern=".0"></fmt:formatNumber>
            </strong>
        </h3>
        <ul class="reaction">
            <li class="reaction likeCnt">
                <i class="fa-regular fa-heart"></i>
                <span class="reaction restr__likeCnt">
                    ${restrDto.restr_likeCnt}</span
                >
            </li>
            <li class="reaction reviewCnt">
                <i class="fa-solid fa-pencil"></i>
                <span class="reaction restr_reviewCnt">
                    ${restrDto.restr_reviewCnt}</span
                >
            </li>
            <li class="reaction viewCnt">
                <i class="fa-regular fa-eye"></i>
                <span class="reaction restr__viewCnt">
                    ${restrDto.restr_viewCnt}</span
                >
            </li>
        </ul>
    </div>

    <!-- Review IMG Slider -->


    <!-- Review IMG Slider -->
    <!-- Swiper -->
    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
            <div class="swiper-slide">
                <img src="<c:url value='/uploadFile/${restrDto.restr_picture}'/>" alt=""/>
                <%--            </div>--%>
                <%--            <div class="swiper-slide">--%>
                <%--                <img src="<c:url value='/images/pizza.png'/>"/>--%>
                <%--            </div>--%>
                <%--            <div class="swiper-slide">--%>
                <%--                <img src="<c:url value='/images/pizza.png'/>"/>--%>
                <%--            </div>--%>
                <%--            <div class="swiper-slide">--%>
                <%--                <img src="<c:url value='/images/pizza.png'/>"/>--%>
                <%--            </div>--%>
                <%--            <div class="swiper-slide">--%>
                <%--                <img src="<c:url value='/images/pizza.png'/>"/>--%>
                <%--            </div>--%>
                <%--            <div class="swiper-slide">--%>
                <%--                <img src="<c:url value='/images/pizza.png'/>"/>--%>
                <%--            </div>--%>
            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-scrollbar"></div>
            <div class="swiper-pagination"></div>
        </div>

        <!-- Restaurant Information -->

        <div class="content">
            <section class="section-left">
                <div class="info">
                    <h4>지역</h4>
                    <p class="location-name">${restrDto.restr_name}</p>
                </div>
                <div class="info">
                    <h4>음식종류</h4>
                    <p class="location-name">${restrDto.restr_foodType}</p>
                </div>
                <div class="info">
                    <h4>매장소개</h4>
                    <p class="location-name">${restrDto.restr_desc}</p>
                </div>
                <div class="info">
                    <h4>메뉴</h4>

                        <ul class="menuList">
                            <c:forEach var="restrMenuDto" items="${restrMenuDto}">
                            <li class="menu">
                                <span class="food">${restrMenuDto.restr_menu_food}</span>
                                <span class="price">${restrMenuDto.restr_menu_price}원 </span>
                            </li>
                                    <%--     핫딜 이벤트 진행되는 매장의 해당 메뉴에는 "핫딜 진행중" 이라는 링크가 나타나고, 링크를 누르면 해당 핫딜 페이지로 넘어갑니다.--%>
                                    <%--     핫딜 이벤트가 진행중이라면 restr_menu_hotdeal_NUM  =  hotdeal_NUM (진행중인 핫딜의 Prime key)     --%>
                                    <%--     핫딜 이벤트를 하고있지 않으면  restr_menu_hotdeal_NUM  = -1, 진행중인 핫딜 없음을 의미       --%>
                                <c:if test="${restrMenuDto.restr_menu_hotdeal_NUM ne '-1'}">
                            <span class="hotdeal">
                                <a style="font-weight: 600;" href="<c:url value='/hotdeal/read?hotdeal_NUM=${restrMenuDto.restr_menu_hotdeal_NUM}'/>">
                                    🔥핫딜로 이동하기
                                </a>
                            </span>
                                </c:if>
                            </c:forEach>
                        </ul>

                </div>
            </section>
            <section class="section-right">
                <ul class="my-list">
                    <li class="myList restr-eval-like">
                        <!--로그인이 된 상태에서만-->
                        <form id="likeForm" action="" method="">
                            <button type="button" id="likeBtn">
                                <input type="hidden" name="restr_NUM" value="${restrDto.restr_NUM}">
                                <input type="hidden" name="user_email" value="${userDto.user_email}">


                                <%--            --%>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <%--            --%>

                                <%--  user가 이곳 레스토랑에 like를 눌렀던 기록이 있니--%>
                                <i class="fa-${not empty likelistDto.restr_NUM ? "solid" : "regular"} fa-heart"></i>

                            </button>
                        </form>

                    </li>

                </ul>
                <div class="tag__wrap">
                    <h4>이 매장 연관 태그</h4>
                    <ul class="tagList" data-tag="${restrDto.restr_tag}">
                        <li class="tag">

                        </li>
                    </ul>
                </div>
            </section>
        </div>

        <!-- Review Write Page -->


        <div class="review-box">
            <form id="form" action="<c:url value="/review/write"/>" method="post" enctype="multipart/form-data">
                <security:csrfInput/>
                <input type="hidden" name="restr_NUM" value="${restrDto.restr_NUM}">
                <input type="hidden" name="user_email" value="${userDto.user_email}">
                <input type="hidden" name="user_name" value="${userDto.user_name}">
                <input type="hidden" name="user_picture" value="${userDto.user_picture}">
                <%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>

                <div class="review__header">${restrDto.restr_name}</div>
                <span class="text">에 대한 솔직한 리뷰를 써주세요.</span>

                <div class="review__wrap">
                    <div class="review__wrap">
                        <fieldset class="rating">
                            <input type="radio" id="star5" name="review_star" value="5"/>
                            <label
                                    class="full"
                                    for="star5"
                                    title="rating5"
                            ></label>
                            <input
                                    type="radio"
                                    id="star4half"
                                    name="review_star"
                                    value="4.5"
                            /><label
                                class="half"
                                for="star4half"
                                title="rating4half"
                        ></label>
                            <input type="radio" id="star4" name="review_star" value="4"/><label
                                class="full"
                                for="star4"
                                title="rating4"
                        ></label>
                            <input
                                    type="radio"
                                    id="star3half"
                                    name="review_star"
                                    value="3.5"
                            /><label
                                class="half"
                                for="star3half"
                                title="rating3half"
                        ></label>
                            <input type="radio" id="star3" name="review_star" value="3"/><label
                                class="full"
                                for="star3"
                                title="rating3"
                        ></label>
                            <input
                                    type="radio"
                                    id="star2half"
                                    name="review_star"
                                    value="2.5"
                            /><label
                                class="half"
                                for="star2half"
                                title="rating2half"
                        ></label>
                            <input type="radio" id="star2" name="review_star" value="2"/><label
                                class="full"
                                for="star2"
                                title="rating2"
                        ></label>
                            <input
                                    type="radio"
                                    id="star1half"
                                    name="review_star"
                                    value="1.5"
                            /><label
                                class="half"
                                for="star1half"
                                title="rating1half"
                        ></label>
                            <input type="radio" id="star1" name="review_star" value="1"/><label
                                class="full"
                                for="star1"
                                title="rating1"
                        ></label>
                            <input
                                    type="radio"
                                    id="starhalf"
                                    name="review_star"
                                    value="0.5"
                            /><label
                                class="half"
                                for="starhalf"
                                title="rating0half"
                        ></label>
                        </fieldset>
                        <textarea
                                name="review_comment"
                                id="review-editor"
                                cols="30"
                                rows="10"
                                placeholder="${userDto.user_name} 님, 주문하신 메뉴는 어떠셨나요? 식당의 분위기와 서비스도 궁금해요!"
                        >${param.review_comment}</textarea>
                    </div>

                    ${param.review_picture}
                    ${param.review_star}

                    <div class="pictureUploadButtons_wrap">
                        <div class="review__pictureUpload">
                            <label class="reviewPicUploadBtn" for="reviewPicUpload">
                                <i class="fa-solid fa-upload"></i>
                            </label>
                            <input
                                    type="file"
                                    id="reviewPicUpload"
                                    name="file"
                                    accept="image/jpeg"
                                    required
                            />
                        </div>
                        <div class="buttons">
                            <button  id="submitBtn" class="uploadBtn">리뷰작성</button>
                        </div>
                    </div>

            </form>
        </div>

        <!-- Review Read Page -->

        <ul class="review-list">
            <c:forEach var="reviewDto" items="${reviewDto}">
                <li class="review">
                    <div class="review__user">
                        <div class="review__user__wrap">
                            <div class="review__picWrap">
                                <img src="<c:url value='/uploadFile/${reviewDto.user_picture}'/>" alt=""/>
                            </div>
                            <span class="reivew__userName">
                                    ${reviewDto.user_name}
                            </span>
                        </div>
                    </div>
                    <div class="review__content">
                        <div class="review__content__wrap">
          <span class="review__regdate">
              <fmt:formatDate value="${reviewDto.review_update}" pattern="yyyy-MM-dd"/>
<%--            2023. 03. 06--%>
          </span>

                            <!--🍎리뷰 수정🍎-->
                            <div class="review__text">
                                <form id="reviewModifyForm" action="" method="post">
                                        <%--            --%>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <%--            --%>
                                    <input name="review_NUM" type="hidden" value="${reviewDto.review_NUM}"/>
                                    <input name="review_star" type="hidden" value="${reviewDto.review_star}"/>
                                    <input name="restr_NUM" type="hidden" value="${restrDto.restr_NUM}"/>
                                    <input name="user_email" type="hidden" value="${reviewDto.user_email}"/>
                                    <textarea name="review_comment" readonly>${reviewDto.review_comment}</textarea>
                                </form>
                            </div>

                            <!--🍎리뷰 수정 끝🍎-->
                        </div>
                        <ul class="review__picture__list">
                            <li class="review__picture">
                                <div class="review__picture__wrap">
                                    <img src="<c:url value='/uploadFile/${reviewDto.review_picture}'/>" alt=""
                                         class="reviewPicture"/>
                                </div>
                            </li>
                        </ul>
                    </div>


                    <div class="alignContainer">
                        <div class="review__rating" data-star="${reviewDto.review_star}">


                        </div>
                        <div class="rvButtons">
                            <c:if test="${reviewDto.user_email == userDto.user_email}">
                                <button id="reviewModifyBtn">수정</button>
                                <button id="reviewDelBtn">삭제</button>
                            </c:if>
                        </div>
                    </div>
                </li>
                <div class="underline"></div>
            </c:forEach>

        </ul>
</section>

</body>
</html>


<!-- Swiper JS -->
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>


<!-- JavaScript -->
<script src="<c:url value='/js/script.js'/>"></script>


<%--JQuery--%>
<script>
    $(document).ready(() => {
        $("#review-editor").on("click", () => {

            <security:authorize access="isAnonymous()">            // 로그인 안했니?
            if (!confirm("로그인을 해야 좋아요를 남길 수 있습니다.. 로그인 하시겠습니까?")) return;
            location.href = "<c:url value='/login/login'/> ";
            </security:authorize>

            <security:authorize access="hasRole('ROLE_USER')">     // 로그인 했니?
            if(${userDto.user_state_code==-1}){                    // 리뷰작성 금지 당한 유저니?
                alert("회원님은 리뷰를 남길 수 없습니다.");
            }else{
                return;
            }
            </security:authorize>

        }); // review-edtior


        $("#submitBtn").on("click", () => {

            let form = $("#form");
            // alert("btn clicked")
            <%--form.attr("action", "<c:url value='/review/write?${_csrf.parameterName}=${_csrf.token}'/>")--%>
            form.attr("action", "<c:url value='/review/write'/>")
            form.attr("method", "post")
            form.attr("enctype", "multipart/form-data")
            form.submit();


        }); // submit


        // });

        $("#reviewModifyBtn", ".review").on("click", function () {
            let buttons = $(this).parent();
            let alignContainer = buttons.parent();
            let li = alignContainer.parent();
            let form = $("#reviewModifyForm", li);
            let isReadOnly = $("textarea[name=review_comment]", li).attr("readonly");


            // 읽기상태 -> 수정상태
            if (isReadOnly == "readonly") {
                $("textarea[name=review_comment]", li).attr('readonly', false);
                console.log($(this));
                $(this)[0].innerText = "리뷰등록";
                return;
            }

            // 리뷰등록

            form.attr("action", "<c:url value="/review/modify"/>");
            form.attr("method", "post");
            form.submit();


        }) //리뷰(review) 수정




        $("#likeBtn").on("click", function (e) {

            <security:authorize access="isAnonymous()">     // 로그인 안했니?
            if (!confirm("로그인을 해야 좋아요를 남길 수 있습니다.. 로그인 하시겠습니까?")) return;
            location.href = "<c:url value='/login/login'/> ";
            return;
            </security:authorize>


            let form = $("#likeForm");
            let heartState = $("i", $(this)).attr("class");  // "fa-regular fa-heart"

            //  하트가 비워져 있는 상태 (fa-regular fa-heart) 면 ❤️ 상태로 바꾸기

            if (heartState == "fa-regular fa-heart") {
                $("i", $(this)).attr("class", "fa-solid fa-heart");
                form.attr("action", "<c:url value="/likelist/add"/>");
                form.attr("method", "post")
                form.submit();
                return;
            } //

            // 좋아요를 해지하면 삭제 요청하기
            $("i", $(this)).attr("class", "fa-regular fa-heart");
            form.attr("action", "<c:url value="/likelist/cancel?restr_num=${restr_NUM}"/>");
            form.attr("method", "post")
            form.submit(); //

        })


        const starRatings = document.querySelectorAll(".review__rating");
        starRatings.forEach(starRating => {
            let score = starRating.dataset.star;
            let int = Math.floor(score);
            let decimal = score - int;

            for(let i = 0 ; i < int ; i++){

                    const div = document.createElement("div");
                    div.setAttribute("class", "imgWrap");

                    const img = document.createElement("img");
                    img.setAttribute("src", "<c:url value="/images/star.png"/>");

                    div.appendChild(img);
                    starRating.append(div);


            } // 별점(star.png) 삽입

            if(decimal!=0){
                const div = document.createElement("div");
                div.setAttribute("class", "imgWrap");

                const img = document.createElement("img");
                img.setAttribute("src", "<c:url value="/images/half.png"/>");

                div.appendChild(img);
                starRating.append(div);
            }  // 별점(half.png) 삽입

        }); // 별점 보여주기 starRatings.forEach()

       const tagList = document.querySelector(".tagList");
       const tagStr = tagList.dataset.tag;
       const arr = tagStr.split(" ");
       const li = document.querySelector(".tag");
       arr.forEach(item =>{
           if(item === "") return;
           const a = document.createElement("a");
           a.setAttribute("class", "tagname");
           a.setAttribute("href", "<c:url value='/restr/search?option=tagFilter&tag='/>") // ✔️
           a.innerHTML = item;
           li.append(a);

       })// arr.forEach() [이 매장 연관 태그]

    }); // ready()
</script>

