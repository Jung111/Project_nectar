package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.nectar.domain.*;
import project.nectar.repository.*;
import project.nectar.service.HotdealService;
import project.nectar.service.RestrService;

import java.util.HashMap;
import java.util.List;
// 이하 MYPAGE 의 ADMIN(관리자) 에 관한 모든 내용
@Controller
@RequestMapping("/mypage/admin")
public class AdminController {
    @Autowired
    UserDao userDao;
    @Autowired
    BizAccountDao bizAccountDao;
    @Autowired
    Request_RestrDao request_restrDao;
    @Autowired
    Request_HotdealDao request_hotdealDao;
    @Autowired
    QNADao qnaDao;
    @Autowired
    RestrService restrService;
    @Autowired
    RestrMenuDao restrMenuDao;
    @Autowired
    HotdealService hotdealService;
    @Autowired
    QnaCommentDao qnaCommentDao;


    @GetMapping("/main")
    public String AdminMyPage(Model m, String option, String keyword){
        HashMap map = new HashMap();
        map.put("option",option);
        map.put("keyword",keyword);

        try {
            List<UserDto> SearchResultUserList = userDao.SearchResultUser(map);
            m.addAttribute("SearchResultUserList",SearchResultUserList);
            // 사용자(User)에 대한 data

            List<BizAccountDto> SearchResultBizAccountList = bizAccountDao.SearchResultBizAccount(map);
            m.addAttribute("SearchResultBizAccountList",SearchResultBizAccountList);
            // 사업자(bizAccountDao)에 대한 data

            List<Request_RestrDto> request_restrDto = request_restrDao.selectAll();
            m.addAttribute("request_restrDto",request_restrDto);
            // 사업자가 등록 요청한 레스토랑에 대한 data

            List<Request_HotdealDto> request_hotdealDto = request_hotdealDao.selectAll();
            m.addAttribute("request_hotdealDto",request_hotdealDto);
            // 사업자가 등록 요청한 핫딜에 대한 data

            List<QNADto> QNADto = qnaDao.selectAll();
            m.addAttribute("QNADto",QNADto);
            // 요청/문의사항을 담은 QNA 에 대한 data


            //ADMIN도 결제 정보에 대한 DATA를 가지고 있어야할 듯

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }

        return "mypage/admin";
    }



    @PostMapping("/profile/delete")
    public String deleteAccount(String user_email){
        userDao.delete(user_email);                 // 계정 삭제. 강퇴
        return "redirect:/mypage/admin/main";
    }



    //  일반회원 의 계정상태  : user_state_code
    //  0 : 일반회원. 사이트 모든 기본 기능 사용 가능(default)
    // -1 : 리뷰작성 금지
    // -2 : 핫딜결제 금지
    // -3 : 계정 정지
    @PostMapping("/accountManagement/user")
    public String accountManagement_user(UserDto userDto){
        System.out.println("userDto = " + userDto);
        userDao.updateStateCode(userDto);
        return "redirect:/mypage/admin/main";
    }



    // 사업자회원 의 계정상태 : bizAccount_state_code
    //  0 : 사업자회원. 사이트 모든 기본 기능 사용 가능(default)
    // -4 : 매장게시정지
    // -5 : 핫딜등록금지
    // -3 : 계정 정지
    @PostMapping("/accountManagement/biz")
    public String accountManagement(BizAccountDto bizAccountDto){
        System.out.println("bizAccountDto = " + bizAccountDto);
        bizAccountDao.updateStateCode(bizAccountDto);
        return "redirect:/mypage/admin/main";
    }



    @PostMapping("/hotdeal/register")
    public String register(HotdealDto hotdealDto, Request_HotdealDto request_hotdealDto, Integer request_hotdeal_NUM, RedirectAttributes rattr) {

        try {
            // 핫딜 이벤트 등록 요청을 승인, 웹사이트에 핫딜 이벤트를 게시한다.
            // 심사 요청한 핫딜 테이블(request_hotdeal)의 심사상태(request_hotdeal_state_code)를 승인상태(+1) 로 만든다.
            hotdealService.insert(hotdealDto);
            request_hotdealDto.setEvaluate_code(1);
            request_hotdealDao.updateState(request_hotdealDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","REG_ERR");
            return "redirect:/mypage/admin/main";

        }

        return "redirect:/mypage/admin/main";
    }


    @PostMapping("/hotdeal/deny")
    public String HotdealDenied(Request_HotdealDto request_hotdealDto, RedirectAttributes rattr) {

        try {
            // 핫딜 이벤트 등록 요청을 거절
            // 심사 요청한 핫딜 테이블(request_hotdeal)의 심사상태(request_hotdeal_state_code)를 반려상태(-1) 로 만든다.
            request_hotdealDto.setEvaluate_code(-1);
            request_hotdealDao.updateState(request_hotdealDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DENY_ERR");
            return "redirect:/mypage/admin/main";

        }

        return "redirect:/mypage/admin/main";
    }


    @PostMapping("/restr/register")
    public String register(RestrDto restrDto, Integer request_restr_NUM, Request_RestrDto request_restrDto, RedirectAttributes rattr) {

        try {
            // 신규 매장 등록 요청을 승인, 웹사이트에 매장을 게시한다.
            // 심사 요청한 핫딜 테이블(request_hotdeal)의 심사상태(request_hotdeal_state_code)를 승인상태(+1) 로 만든다.
            restrService.insertAll(restrDto); // Service 에서 TX 묶어서 처리해야함
            request_restrDto.setEvaluate_code(1);
            request_restrDao.updateState(request_restrDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","REG_ERR");
            return "redirect:/mypage/admin/main";
        }

        return "redirect:/mypage/admin/main";
    }


    @PostMapping("/restr/deny")
    public String RestrDenied(Request_RestrDto request_restrDto, RedirectAttributes rattr) {

        try {
            // 신규 매장 등록 요청을 거절
            // 심사 요청한 핫딜 테이블(request_hotdeal)의 심사상태(request_hotdeal_state_code)를 반려상태(-1) 로 만든다.
            request_restrDto.setEvaluate_code(-1);
            request_restrDao.updateState(request_restrDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DENY_ERR");
            return "redirect:/mypage/admin/main";
        }

        return "redirect:/mypage/admin/main";
    }


}


