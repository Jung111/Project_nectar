package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.nectar.domain.*;
import project.nectar.repository.LikelistDao;
import project.nectar.repository.PaymentDao;
import project.nectar.repository.QNADao;
import project.nectar.repository.UserDao;
import project.nectar.service.ReviewService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

// 이하 MYPAGE 의 USER(일반회원) 에 관한 모든 내용
@Controller
@RequestMapping("/mypage/user")
public class UserController {
    @Autowired
    ReviewService reviewService;
    @Autowired
    LikelistDao likelistDao;
    @Autowired
    UserDao userDao;
    @Autowired
    QNADao qnaDao;
    @Autowired
    PaymentDao paymentDao;


    @GetMapping("/main")
    public String UserMyPage(HttpSession session, Model m, Authentication authentication, RedirectAttributes rattr){

            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            String user_email = userDetails.getUsername();


        try {
            List<ReviewPlusDto> reviewDto = reviewService.getMyReviews(user_email);
            m.addAttribute("reviewDto",reviewDto);
            // 사용자(User)가 작성한 모든 리뷰에 데한 data

            List<RestrDto> MyLikeList = likelistDao.selectMyLikeList(user_email);
            m.addAttribute("MyLikeList",MyLikeList);
            // 사용자(User)가 like 눌렀던 모든 게시물(레스토랑)에 대한 data

            UserDto userDto = userDao.select(user_email);
            m.addAttribute("userDto",userDto);
            // 사용자(User)에 대한 data

            List<HotdealPlusDto> MyPaymentList = paymentDao.select_PaymentInfo_byUser(user_email);
            m.addAttribute("MyPaymentList",MyPaymentList);
            // 사용자(User)가 구매한 핫딜 결제정보(구매내역) 대한 data

            List<QNADto> QNADto = qnaDao.selectAllByWriter(user_email);
            m.addAttribute("QNADto",QNADto);
            // 사용자(User)가 요청/문의한 QNA 에 대한 data

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","Mypage_main_ERR");
            return "redirect:/";
        }

        return "mypage/user";
    }

    @PostMapping("/profile/modify")
    public String modifyProfile(UserDto userDto, MultipartHttpServletRequest req, RedirectAttributes rattr){


        MultipartFile mf = req.getFile("file");
        String path = "C:\\Users\\pc\\Desktop\\nectar\\project.nectar\\src\\main\\webapp\\resources\\uploadFile\\";
        String originFileName = mf.getOriginalFilename(); // 원본 파일 명

        if(mf.isEmpty()){   // 첨부 파일이 없으면
            originFileName = "default_review.jpg";
        }
        userDto.setUser_picture(originFileName);

        try {
            String safeFile = path + originFileName;
            mf.transferTo(new File(safeFile));          // path에 FileName의 파일을 저장
            userDao.update(userDto);
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","MOD_ERR");
            return "redirect:/mypage/user/main";
        }
        return "redirect:/mypage/user/main";
    }


    @PostMapping("/profile/delete")
    public String deleteProfile(String email, HttpSession session){
        userDao.delete(email);  // 계정 삭제
        session.invalidate();   // 세션 종료
        return "redirect:/";
    }


}

