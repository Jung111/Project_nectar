package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.nectar.domain.AdminDto;
import project.nectar.domain.BizAccountDto;
import project.nectar.domain.UserDto;
import project.nectar.repository.BizAccountDao;
import project.nectar.repository.UserDao;
import project.nectar.service.UserService;

import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;
    @Autowired
    BizAccountDao bizAccountDao;


    @GetMapping("/addUser")
    public String registerForm_User() {return "registerForm";
    }

    @PostMapping("/addUser")

    public String register_User(UserDto userDto, HttpSession session) throws Exception {

//        // 아이디 중복 체크 하기
        if (!duplicateCheck(userDto)) {
            String msg = URLEncoder.encode("duplicated id", "utf-8");

            return "redirect:/register/add?msg=" + msg;
        }


        System.out.println("RegisterController, 방금 여기 지나감");
        System.out.println("userDto = " + userDto);
        userService.RegisterUser(userDto);
        System.out.println("Register complete");

        if(session.getAttribute("sns_email")!=null){        // 소셜 로그인 유저의 회원가입이면, 가입 후 자동 로그인
            return "redirect:/login/login";
        }

        return "registerComplete";
    }



    @GetMapping("/addBizz")
    public String registerForm_Biz() {
        return "registerFormBiz";
    }

    @PostMapping("/addBiz")
    public String register_Biz(String id, String pwd, BizAccountDto bizAccountDto, Model m) throws Exception {


        // 아이디 중복 체크 하기
        if (!duplicateCheck(bizAccountDto)) {
            String msg = URLEncoder.encode("중복이메일", "utf-8");
            return "redirect:/register/addUser?msg=" + msg;

        }
        System.out.println("RegisterController, 방금 여기 지나감");
        System.out.println("userDto = " + bizAccountDto);
        userService.RegisterBiz(bizAccountDto);
        return "registerComplete";

    }


//    //관리자용 회원가입//
//    @PostMapping("/addBiz")
//
//    public String register_Admin(String id, String pwd, AdminDto adminDto, Model m) throws Exception {
//
//
//        System.out.println("RegisterController, 방금 여기 지나감");
////        userDto.setAuthority("ROLE_USER");
////        userDto.setAuthority("ROLE_USER, ROLE_BIZ, ROLE_ADMIN");
//        System.out.println("adminDto = " + adminDto);
//        userService.RegisterAdmin(adminDto);
//        return "redirect:/";
//
//
//    }



    private boolean duplicateCheck(UserDto userDto) {

        UserDto user = userDao.select(userDto.getUser_email());
        System.out.println("user = " + user);

        return user==null||user.getUser_email().equals("");
    }

    private boolean duplicateCheck(BizAccountDto bizAccountDto) {

        BizAccountDto biz = bizAccountDao.select(bizAccountDto.getBizAccount_email());
        System.out.println("biz = " + biz);

        return biz==null||biz.getBizAccount_email().equals("");
    }



    @PostMapping("/readEmail")
    @ResponseBody
    public Boolean readEmail(String user_email, String bizAccount_email) {
        boolean chk = true;

        System.out.println("user_email = " + user_email);
        if (user_email != null) {
            try {
                UserDto user = userDao.select(user_email);
                chk = user == null ? false : true;
                return chk;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (bizAccount_email != null) {
            try {
                BizAccountDto biz = bizAccountDao.select(bizAccount_email);
                chk = biz == null ? false : true;
                return chk;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return chk;
    }







}
