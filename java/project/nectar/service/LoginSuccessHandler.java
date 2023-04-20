package project.nectar.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;

@Service("loginSuccessHandler")
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        String auth = authentication.getAuthorities().toString();

        // 소셜 로그인, 로그인 후 세션 삭제
        session.removeAttribute("sns_email");
        session.removeAttribute("sns_pwd");


        //경우1 : 사용자가 직접 로그인 버튼을 누른 경우 (혹은 로그인에 동의한 경우)
        String URI = request.getContextPath();
        String prevPage = (String) request.getSession().getAttribute("prevPage");
        if(prevPage!=null) {
            request.getSession().removeAttribute("prevPage");
            URI = prevPage;
        }

        //경우2 : 로그인 인증을 위해 Spring Security 가 요청을 가로챈 경우
        RequestCache requestCache = new HttpSessionRequestCache();
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if(savedRequest!=null) {
            URI = savedRequest.getRedirectUrl();
        }

        response.sendRedirect(URI);
    }
}
