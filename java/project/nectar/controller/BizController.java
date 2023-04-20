package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import project.nectar.repository.*;
import project.nectar.service.HotdealService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
// 이하 MYPAGE 의 BIZ(사업자회원) 에 관한 모든 내용
@Controller
@RequestMapping("/mypage/biz")
public class BizController {
    @Autowired
    RestrDao restrDao;
    @Autowired
    HotdealService hotdealService;
    @Autowired
    BizAccountDao bizAccountDao;
    @Autowired
    QNADao qnaDao;
    @Autowired
    Request_RestrDao request_restrDao;
    @Autowired
    Request_HotdealDao request_hotdealDao;
    @Autowired
    RestrMenuDao restrMenuDao;
    @Autowired
    PaymentDao paymentDao;
    @Autowired
    RefundDao refundDao;



    @GetMapping("/main")
    public String BizMyPage(Model m, Authentication authentication, RedirectAttributes rattr){

            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            String Biz_email = userDetails.getUsername();


        try {
            RestrDto restrDto = restrDao.selectByBiz_email(Biz_email);
            m.addAttribute("restrDto",restrDto);
            // 사업자(BizAccount)가 운영중인 레스토랑에 대한 data

            List<HotdealDto> hotdealDto = hotdealService.selectMyHotdeals(Biz_email);
            m.addAttribute("hotdealDto",hotdealDto);
            // 사업자가 진행한 모든 핫딜에 대한 data

            List<RestrMenuDto> restrMenuDto = restrMenuDao.selectAllMenu(restrNum(Biz_email));
            m.addAttribute("restrMenuDto",restrMenuDto);
            // 사업자가 운영중인 레스토랑 메뉴에 대한 data

            BizAccountDto bizAccountDto = bizAccountDao.select(Biz_email);
            m.addAttribute("bizAccountDto",bizAccountDto);
            // 사업자에 대한 data

            List<HotdealPlusDto> PaymentList = paymentDao.select_PaymentInfo_byBiz(Biz_email);
            m.addAttribute("PaymentList",PaymentList);
            // 사업자가 진행한 핫딜의 결제정보(payment)에 대한 data

            List<RefundDto> refundDtoList = refundDao.selectAll(Biz_email);
            m.addAttribute("refundDtoList",refundDtoList);
            // 사업자가 진행한 핫딜의 환불요청에 대한 data

            Request_RestrDto Request_restrDto = request_restrDao.selectMyReqRestr(Biz_email);
            m.addAttribute("myReqRestrDto", Request_restrDto);
            // 사업자가 심사 요청한 레스토랑에 대한 data

            Request_HotdealDto Request_hotdealDto = request_hotdealDao.selectMyReqHotdeal(Biz_email);
            m.addAttribute("myReqHotdealDto", Request_hotdealDto);
            // 사업자가 심사 요청한 핫딜에 대한 data

            List<QNADto> QNADto = qnaDao.selectAllByWriter(Biz_email);
            m.addAttribute("QNADto",QNADto);
            // 사업자가 요청/문의한 QNA 에 대한 data


        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","Mypage_main_ERR");
            return "redirect:/";
        }

        return "mypage/biz";
    }




    @PostMapping("/profile/modify")
    public String modifyProfile(BizAccountDto bizAccountDto, MultipartHttpServletRequest req, RedirectAttributes rattr){

        MultipartFile mf = req.getFile("file");
        String path = "C:\\Users\\pc\\Desktop\\nectar\\project.nectar\\src\\main\\webapp\\resources\\uploadFile\\";
        String originFileName = mf.getOriginalFilename(); // 원본 파일 명

        if(mf.isEmpty()){   // 첨부 파일이 없으면
            originFileName = "default_profile.jpg";
        }
        bizAccountDto.setBizAccount_picture(originFileName);

        try{
            String safeFile = path + originFileName;
            mf.transferTo(new File(safeFile));          // path에 FileName의 파일을 저장
            bizAccountDao.update(bizAccountDto);
        } catch (Exception e){
            e.printStackTrace();
            rattr.addFlashAttribute("msg","MOD_ERR");
            return "redirect:/mypage/biz/main";
        }
        return "redirect:/mypage/biz/main";
    }


    @PostMapping("/profile/delete")
    public String deleteProfile(String email, HttpSession session){
        bizAccountDao.delete(email);  // 계정 삭제
        session.invalidate();         // 세션 종료
        return "redirect:/";
    }



    private Integer restrNum(String bizEmail) throws Exception {
        RestrDto restrDto = restrDao.selectByBiz_email(bizEmail);
        return restrDto !=null? restrDto.getRestr_NUM() : -1;
    }


}
