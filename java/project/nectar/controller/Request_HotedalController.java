package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.nectar.domain.HotdealDto;
import project.nectar.domain.Request_HotdealDto;
import project.nectar.repository.Request_HotdealDao;
import project.nectar.service.HotdealService;

import java.io.File;

// 이하 '핫딜 이벤트등록' 심사 요청에 관한 모든 내용
@Controller
@RequestMapping("/mypage")
public class Request_HotedalController {
    @Autowired
    Request_HotdealDao request_hotdealDao;
    @Autowired
    HotdealService hotdealService;



    // biz (사업자 회원)

    @PostMapping("/biz/reqHotdeal/write")
    public String request_Hotdeal_registration(Request_HotdealDto request_hotdealDto, RedirectAttributes rattr, Model m, MultipartHttpServletRequest req){

        MultipartFile mf = req.getFile("file");
        String path = "C:\\Users\\pc\\Desktop\\nectar\\project.nectar\\src\\main\\webapp\\resources\\uploadFile\\";
        String originFileName = mf.getOriginalFilename(); // 원본 파일 명

        if(mf.isEmpty()){   // 첨부 파일이 없으면
            originFileName = "default_review.jpg";
        }
        request_hotdealDto.setRequest_hotdeal_picture(originFileName);

        try {
            String safeFile = path + originFileName;
            mf.transferTo(new File(safeFile));                      // path에 FileName의 파일을 저장
            request_hotdealDao.insert(request_hotdealDto);          // 핫딜 정보 작성 후 (관리자에게) 심사요청
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "Hotdeal_WRT_ERR");
            return "redirect:/mypage/biz/main";
        }

        m.addAttribute("request_hotdealDto",request_hotdealDto);
        return "mypage/successPage/hotdealWrtOk";
    }

    @GetMapping("/biz/reqHotdeal/retrial")
    public String apply_for_retrial(Integer request_hotdeal_NUM, RedirectAttributes rattr){

        try {
            // 앞선 심사 요청에서 '심사반려' 판정을 받고,
            // 재심 요청 시
            // request_hotdeal 테이블의 (request_hotdeal)의 심사코드(evaluate code)를 심사대기 상태(0) 로 만든다.
            Request_HotdealDto request_hotdealDto = request_hotdealDao.select(request_hotdeal_NUM);
            request_hotdealDto.setEvaluate_code(0);
            request_hotdealDao.updateState(request_hotdealDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","RETRIAL_ERR");
            return "redirect:/mypage/biz/main";
        }

        return "mypage/successPage/hotdealWrtOk";
    }




    // admin (관리자)

    @GetMapping("/admin/reqHotdeal/read")
    public  String read_reqHotdeal(Integer request_hotdeal_NUM, Model m) {

        Request_HotdealDto request_hotdealDto = request_hotdealDao.select(request_hotdeal_NUM);
        m.addAttribute("request_hotdealDto",request_hotdealDto);
        // 사업자가 등록 요청한 핫딜 대한 data

        return "mypage/hotdealReqForm";

    }


    @PostMapping("/admin/reqHotdeal/register")
    public String register_Permitted(Request_HotdealDto request_hotdealDto, HotdealDto hotdealDto,  RedirectAttributes rattr) {

        try {
            // 심사 '승인'
            // 요청한 핫딜 등록이 승인되어 정상적으로 웹사이트에 게시됨
//            hotdealService.insert(hotdealDto);

            // request_hotdeal 테이블의 (request_hotdeal)의 심사코드(evaluate code)를 심사승인 상태(+1) 로 만든다.
            request_hotdealDto.setEvaluate_code(1);
            request_hotdealDto.setEvaluate_msg("심사통과");
            request_hotdealDto.setEvaluate_msg(request_hotdealDto.getEvaluate_msg());
            request_hotdealDao.updateState(request_hotdealDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","PERMIT_ERR");
            return "redirect:/mypage/admin/main";
        }

        return "redirect:/mypage/admin/main";
    }

    @PostMapping("/admin/reqHotdeal/deny")
    public String register_Denied(Request_HotdealDto request_hotdealDto, RedirectAttributes rattr) {

        try {
            // 심사 '반려'
            // request_hotdeal 테이블의 (request_hotdeal)의 심사코드(evaluate code)를 심사반려 상태(-1) 로 만든다.
            request_hotdealDto.setEvaluate_code(-1);
            request_hotdealDto.setEvaluate_msg(request_hotdealDto.getEvaluate_msg());
            request_hotdealDao.updateState(request_hotdealDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DENY_ERR");
            return "redirect:/mypage/admin/main";
        }

        return "redirect:/mypage/admin/main";
    }




}
