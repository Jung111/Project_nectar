package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.nectar.domain.*;
import project.nectar.repository.*;

import java.util.List;

// 이하 'Q&A 게시판'에 관한 모든 내용

@Controller
@RequestMapping("/mypage")
public class QNAController {
    @Autowired
    QNADao qnaDao;
    @Autowired
    QnaCommentDao qnaCommentDao;

    @Autowired
    BizAccountDao bizAccountDao;

    @Autowired
    UserDao userDao;

    @Autowired
    AdminDao adminDao;




    // user (일반회원)

    @GetMapping("/user/QNA/write")
    public String writeQNA_user(Model m,Authentication authentication){

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        String user_email = userDetails.getUsername();

        try {
            UserDto userDto = userDao.select(user_email);
            m.addAttribute("userDto",userDto);
            m.addAttribute("mode", "new");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  "mypage/qnaForm";
    }

    @PostMapping("/user/QNA/write")
    public String writeQNA_user(QNADto qnaDto, RedirectAttributes rattr, Model m){

        try {
            qnaDao.insert(qnaDto);
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","QNA_WRT_ERR");
            return "redirect:/mypage/user/main";
        }

        m.addAttribute("qnaDto",qnaDto);
        return "mypage/successPage/qnaWrtOk";
    }


    @GetMapping("/user/QNA/read")
    public String ReadQNA_user(Integer qna_NUM, Model m, Authentication auth, RedirectAttributes rattr) {
        UserDetails userDetails = (UserDetails)auth.getPrincipal();
        String user_email = userDetails.getUsername();

        try {

            UserDto userDto = userDao.select(user_email);
            m.addAttribute("userDto",userDto);
            // User(사용자회원) 에 대한 data

            QNADto qnaDto = qnaDao.selectByWriter(qna_NUM, getWriter(auth));
            m.addAttribute("qnaDto",qnaDto);
            // User 가 문의 한 Q&A 에 대한 data

            List<QNADto> qnaCommentDto = qnaCommentDao.selectAll(qna_NUM);
            m.addAttribute("qnaCommentDto",qnaCommentDto);
            // Admin 이 답변을 단 Q&A comment 에 대한 data

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","QNA_READ_ERR");
            return "redirect:/mypage/user/main";
        }
        return "mypage/qnaForm";
    }


    @GetMapping("/user/QNA/modify")
    public String modifyQNA_user(QNADto qnaDto, Model m){

        m.addAttribute("qnaDto", qnaDto);
        return "mypage/qnaForm";
    }

    @PostMapping("/user/QNA/modify")
    public String modifyQNA_user(QNADto qnaDto){
        System.out.println("qnaDto = " + qnaDto);
        qnaDao.update(qnaDto);
        return "redirect:/mypage/user/main";
    }




    // biz(사업자 회원)

    @GetMapping("/biz/QNA/write")
    public String writeQNA_biz(Model m, Authentication authentication){
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        String Biz_email = userDetails.getUsername();
        System.out.println("QNA WRITE 에서의 Biz_email = " + Biz_email);

        try {
            BizAccountDto bizAccountDto = bizAccountDao.select(Biz_email);
            m.addAttribute("bizAccountDto",bizAccountDto);
            m.addAttribute("mode", "new");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "mypage/qnaForm";
    }

    @PostMapping("/biz/QNA/write")
    public String writeQNA_biz(QNADto qnaDto, RedirectAttributes rattr, Model m){

        try {
            qnaDao.insert(qnaDto);
            m.addAttribute("mode", "new");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","QNA_WRT_ERR");
            return "redirect:/mypage/biz/main";

        }

        m.addAttribute("qnaDto",qnaDto);
        return "mypage/successPage/qnaWrtOk";
    }


    @GetMapping("/biz/QNA/modify")
    public String modifyQNA_biz(QNADto qnaDto, Model m){

        m.addAttribute("qnaDto", qnaDto);
        return "mypage/qnaForm";
    }

    @PostMapping("/biz/QNA/modify")
    public String modifyQNA_biz(QNADto qnaDto){
        System.out.println("qnaDto = " + qnaDto);
        qnaDao.update(qnaDto);
        return "redirect:/mypage/biz/main";
    }


    @GetMapping("/biz/QNA/read")
    public String ReadQNA_biz(Integer qna_NUM, Model m, Authentication auth, RedirectAttributes rattr) {

        UserDetails userDetails = (UserDetails)auth.getPrincipal();
        String Biz_email = userDetails.getUsername();

        try {

            BizAccountDto bizAccountDto = bizAccountDao.select(Biz_email);
            m.addAttribute("bizAccountDto",bizAccountDto);
            // Biz(사업자회원) 에 대한 data

            QNADto qnaDto = qnaDao.selectByWriter(qna_NUM, getWriter(auth));
            m.addAttribute("qnaDto",qnaDto);
            // BizAccount 가 문의 한 Q&A 에 대한 data

            List<QNADto> qnaCommentDto = qnaCommentDao.selectAll(qna_NUM);
            m.addAttribute("qnaCommentDto",qnaCommentDto);
            // Admin 이 답변을 단 Q&A comment 에 대한 data

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","QNA_READ_ERR");
            return "redirect:/mypage/biz/main";
        }

        return "mypage/qnaForm";
    }




    // admin (관리자)

    @GetMapping("/admin/QNA/read")
    public String ReadQNA_admin(Integer qna_NUM, Model m, Authentication authentication, RedirectAttributes rattr) {

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        String admin_email = userDetails.getUsername();

        try {

            AdminDto adminDto = adminDao.select(admin_email);
            m.addAttribute("adminDto",adminDto);
            // 관리자에 대한 data

            QNADto qnaDto = qnaDao.select(qna_NUM);
            m.addAttribute("qnaDto",qnaDto);
            // 웹사이트 이용자들이 문의/요청 한 Q&A 에 대한 data

            List<QNADto> qnaCommentDto = qnaCommentDao.selectAll(qna_NUM);
            m.addAttribute("qnaCommentDto",qnaCommentDto);
            // Admin 이 답변을 단 Q&A comment 에 대한 data

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","QNA_READ_ERR");
            return "redirect:/mypage/admin/main";
        }

        return "mypage/qnaForm";
    }



    public String getWriter(Authentication auth){
        UserDetails userDetail = (UserDetails)auth.getPrincipal();
        return userDetail.getUsername();
    }


}
