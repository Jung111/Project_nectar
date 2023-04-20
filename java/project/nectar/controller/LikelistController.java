package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.nectar.domain.LikelistDto;
import project.nectar.service.LikelistService;

@Controller
@RequestMapping("/likelist")
public class LikelistController {
    @Autowired
    LikelistService likelistService;

    @PostMapping("/add")
    public String addLike(LikelistDto likelistDto, RedirectAttributes rattr) {
        try {
            likelistService.addLike(likelistDto);
            return "redirect:/restr/read?restr_NUM=" + likelistDto.getRestr_NUM();

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","Like_ADD_ERR");
            return "redirect:/restr/read?restr_NUM=" + likelistDto.getRestr_NUM();
        }
    }


    @PostMapping("/cancel")
    public String cancelLike(LikelistDto likelistDto, RedirectAttributes rattr) {

        try {
            likelistService.cancelLike(likelistDto);
            return "redirect:/restr/read?restr_NUM=" + likelistDto.getRestr_NUM();

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","Like_DEL_ERR");
            return "redirect:/restr/read?restr_NUM=" + likelistDto.getRestr_NUM();
        }
    }

    @GetMapping("/cancelAll")
    public String removeMyLikeList(String user_email, RedirectAttributes rattr){

        try {
            likelistService.removeMyLikeList(user_email);
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","Like_DEL_ERR");
            return "redirect:/mypage/user/main";
        }

        return "redirect:/mypage/user/main";
    }



}
