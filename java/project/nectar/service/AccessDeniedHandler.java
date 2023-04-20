package project.nectar.service;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service("accessFailHandler")
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {


            if(accessDeniedException instanceof AccessDeniedException) {
                request.setAttribute("LoginFailMessage", "접근 권한이 없는 계정입니다.");
            }
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pageAccessDenied");
            System.out.println("페이지 접근실패");
            request.setAttribute("LoginFailMessage", "페이지 접근 실패. 접근 권한이 없는 계정입니다.");

            dispatcher.forward(request, response);
    }

}
