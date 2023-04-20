package project.nectar.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import project.nectar.auth.GoogleService;
import project.nectar.auth.SnsValue;
import project.nectar.repository.AdminDao;
import project.nectar.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.nectar.repository.BizAccountDao;
import project.nectar.repository.UserDao;
import project.nectar.auth.KakaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserDao userDao;
    @Autowired
    BizAccountDao bizAccountDao;
    @Autowired
    AdminDao adminDao;
    @Autowired(required = false)
    SnsValue googleSns;

    @Autowired(required = false)
    GoogleConnectionFactory googleConnectionFactory;

    @Autowired(required = false)
    OAuth2Parameters googleOAuth2Parameters;



    @GetMapping("/login")
    public String loginForm(Model m, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

        // 만약 로그인이 되어 있으면, 돌아가
        String referrer = request.getHeader("Referer"); // 이전 경로
        if (isAuthenticated()) {
            response.sendRedirect(referrer);
            System.out.println("로그인 되어 있으니까 원래 있던 페이지로 돌아가");
        }

        // loginForm 으로 이동하기 전에 머물러 있던 경로 기억 (로그인 이후 원래 있던 페이지로 이동하기 위해)
        if(session.getAttribute("prevPage")==null){
            session.setAttribute("prevPage",referrer);
        }



        // Google Code 발행을 위한 URL 생성
        OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
        String googleUrl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
        m.addAttribute("google_url", googleUrl);

        // Kakao Code 발행을 위한 URL 생성
        String kakaoUrl = KakaoService.getAuthorizationUrl();
        m.addAttribute("kakao_url", kakaoUrl);

        return "loginForm";
    }



    @PostMapping("/processing")
    public void login() {}



    @GetMapping("/auth/google/callback")
    public String snsLoginCallback(@RequestParam(value = "code", required = false) String code, HttpSession sn, Model m) throws Exception{


        GoogleService googleService = new GoogleService(googleSns);                        // google 소셜 로그인
        UserDto snsUser = googleService.getUserProfile(code);                              // code 를 이용해서 access_token 받기  >>>  access_token 을 이용해서 사용자 profile 정보 받아오기
        setSession(sn, snsUser);

        if (!isValidEmail(snsUser.getUser_email())) {                                      // 가입되어 있지 않은 email 이면, 회원가입 시키고 로그인
            m.addAttribute("userDto", snsUser);
            return "registerFormSNS";
        }
        return "redirect:/login/login";
    };


    @GetMapping("/auth/kakao/callback")
    public String kakaoCallback(@RequestParam(value = "code", required = false) String code, HttpSession sn, Model m) throws Exception {

        String access_Token = KakaoService.getReturnAccessToken(code);                      // Kakao 소셜 로그인
        UserDto snsUser = KakaoService.getUserInfo(access_Token);                           // code 를 이용해서 access_token 받기  >>>  access_token 을 이용해서 사용자 profile 정보 받아오기
        setSession(sn, snsUser);

        if (!isValidEmail(snsUser.getUser_email())) {                                       // 가입되어 있지 않은 email 이면, 회원가입 시키고 로그인
            m.addAttribute("userDto", snsUser);
            return "registerFormSNS";
        }
        return "redirect:/login/login";
    }



    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        System.out.println("logout complete");
        return "redirect:/";
    }



    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }


    private void setSession(HttpSession session, UserDto snsUser){
        session.setAttribute("sns_email",snsUser.getUser_email());
        session.setAttribute("sns_pwd",snsUser.getUser_pwd());    }


    private boolean isValidEmail(String email) {
        return userDao.select(email)!=null;
    }


}

