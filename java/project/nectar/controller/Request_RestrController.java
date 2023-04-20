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
import project.nectar.domain.Request_RestrDto;
import project.nectar.domain.RestrDto;
import project.nectar.repository.Request_RestrDao;
import project.nectar.service.RestrService;

import java.io.File;

// 이하 '신규 매장(레스토랑)등록' 심사 요청에 관한 모든 내용

@Controller
@RequestMapping("/mypage")
public class Request_RestrController {
    @Autowired
    Request_RestrDao request_restrDao;
    @Autowired
    RestrService restrService;




    // biz (사업자 회원)

    @PostMapping("/biz/reqRestr/write")
    public String request_Restaurant_registration(Request_RestrDto request_restrDto, MultipartHttpServletRequest req, RedirectAttributes rattr, Model m){

        MultipartFile mf = req.getFile("file");
        String path = "C:\\Users\\pc\\Desktop\\nectar\\project.nectar\\src\\main\\webapp\\resources\\uploadFile\\";
        String originFileName = mf.getOriginalFilename(); // 원본 파일 명

        if(mf.isEmpty()){   // 첨부 파일이 없으면
            originFileName = "default_review.jpg";
        }
        request_restrDto.setRequest_restr_picture(originFileName);

        try {
            String safeFile = path + originFileName;
            mf.transferTo(new File(safeFile));                      // path에 FileName의 파일을 저장
            request_restrDao.insertAll(request_restrDto);           // 레스토랑 정보 작성 후 (관리자에게) 심사요청

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "RESTR_WRT_ERR");
            return "redirect:/mypage/biz/main";
        }

        m.addAttribute("restrDto",request_restrDto);
        return "mypage/successPage/restrWrtOk";
    }

    @GetMapping("/biz/reqRestr/retrial")
    public String apply_for_retrial(Integer request_restr_NUM, RedirectAttributes rattr){

        try {
            // 재심 요청 시
            // request_restr 테이블의 (request_restr)의 심사코드(evaluate code)를 심사대기 상태(0) 로 만든다.
            Request_RestrDto request_restrDto = request_restrDao.select(request_restr_NUM);
            request_restrDto.setEvaluate_code(0);
            request_restrDao.updateState(request_restrDto);

        } catch (Exception e) {
        e.printStackTrace();
        rattr.addFlashAttribute("msg","RETRIAL_ERR");
            return "redirect:/mypage/biz/main";
        }

        return "mypage/successPage/hotdealWrtOk";
    }




    // admin (관리자)

    @GetMapping("/admin/reqRestr/read")
    public String read_reqRestr(Integer request_restr_NUM, Model m){

        Request_RestrDto request_restrDto = request_restrDao.select(request_restr_NUM);
        m.addAttribute("request_restrDto",request_restrDto);
        // 사업자가 등록 요청한 레스토랑에 대한 data

        return "mypage/restrReqForm";
    }


    @PostMapping("/admin/reqRestr/register")
    public String register_Permitted(RestrDto restrDto, Request_RestrDto request_restrDto, RedirectAttributes rattr){

        try {
            // 심사 '승인'
            // 요청한 매장 등록이 승인되어 정상적으로 웹사이트에 게시됨
            restrService.insertAll(restrDto);

            // request_restr 테이블의 (request_restr)의 심사코드(evaluate code)를 승인상태(+1) 로 만든다.
            request_restrDto.setEvaluate_code(1);
            request_restrDto.setEvaluate_msg("심사통과");
            request_restrDto.setEvaluate_msg(request_restrDto.getEvaluate_msg());
            request_restrDao.updateState(request_restrDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","PERMIT_ERR");
            return "redirect:/mypage/admin/main";
        }

        return "redirect:/mypage/admin/main";
    }


    @PostMapping("/admin/reqRestr/deny")
    public String register_Denied(Request_RestrDto request_restrDto, RedirectAttributes rattr){

        try {
            // 심사 '반려'
            // request_restr 테이블의 (request_restr)의 심사코드(evaluate code)를 반려상태(-1) 로 만든다.
            request_restrDto.setEvaluate_code(-1);
            request_restrDto.setEvaluate_msg(request_restrDto.getEvaluate_msg());
            request_restrDao.updateState(request_restrDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DENY_ERR");
            return "redirect:/mypage/admin/main";
        }

        return "redirect:/mypage/admin/main";
    }



}
