package project.nectar.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.nectar.domain.ReviewDto;
import project.nectar.service.ReviewService;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;



    @PostMapping("/write")
    public String write(ReviewDto reviewDto, MultipartHttpServletRequest req, RedirectAttributes rattr) throws IOException {

        MultipartFile mf = req.getFile("file");
        String path = "C:\\Users\\pc\\Desktop\\nectar\\project.nectar\\src\\main\\webapp\\resources\\uploadFile\\";
        String originFileName = mf.getOriginalFilename(); // 원본 파일 명

        if(mf.isEmpty()){   // 첨부 파일이 없으면
            originFileName = "default_review.jpg";
        }
        reviewDto.setReview_picture(originFileName);

        try {
            String safeFile = path + originFileName;
            mf.transferTo(new File(safeFile));          // path에 FileName의 파일을 저장
            reviewService.write(reviewDto);

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","WRT_ERR");

            //에러가 떠서 다시 리뷰작성 화면으로 돌아가도, 작성했던 Review 양식들 보존
            String comment = URLEncoder.encode(reviewDto.getReview_comment(),"utf-8");
            String queryString = "?restr_NUM="+reviewDto.getRestr_NUM()+"&review_comment="+comment
                    +"&review_picture="+reviewDto.getReview_picture()+"&review_star="+reviewDto.getReview_star();

            return "redirect:/restr/read"+queryString;
        }

        return  "redirect:/restr/read?restr_NUM="+reviewDto.getRestr_NUM();
    }



    @PostMapping("/delete")
    public String delete(ReviewDto reviewDto, RedirectAttributes rattr){

        try {
            reviewService.delete(reviewDto);
            return "redirect:/restr/read?restr_NUM="+reviewDto.getRestr_NUM();

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DEL_ERR");
            return "redirect:/restr/read?restr_NUM="+reviewDto.getRestr_NUM();
        }
    }




    @PostMapping("/modify")
    public String modify(ReviewDto reviewDto, RedirectAttributes rattr) throws UnsupportedEncodingException {
        try {
            reviewService.modify(reviewDto);
            return  "redirect:/restr/read?restr_NUM="+reviewDto.getRestr_NUM();

        } catch (Exception e) {
            rattr.addFlashAttribute("msg","MOD_ERR");
            String comment = URLEncoder.encode(reviewDto.getReview_comment(),"utf-8");
            String queryString = "?restr_NUM="+reviewDto.getRestr_NUM()+"&review_comment="+comment
                    +"&review_picture="+reviewDto.getReview_picture()+"&review_star="+reviewDto.getReview_star();
            return "redirect:/restr/read"+queryString;
        }
    }

}

