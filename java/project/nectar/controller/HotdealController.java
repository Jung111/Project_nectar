package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.nectar.domain.BrowserHistoryDto;
import project.nectar.domain.HotdealDto;
import project.nectar.domain.UserDto;
import project.nectar.repository.UserDao;
import project.nectar.service.HotdealService;

import javax.servlet.http.HttpSession;
import java.util.List;
// 이하 Hotdeal page 에 대한 모든 내용
@Controller
@RequestMapping("/hotdeal")
public class HotdealController {
    @Autowired
    HotdealService hotdealService;
    @Autowired
    UserDao userDao;

    @GetMapping("/list")
    public String list(Model m){

        try {
            List<HotdealDto> hotdealDto = hotdealService.selectAll();
            m.addAttribute("hotdealDto",hotdealDto);
            // 핫딜 게시물에 대한 data

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }

        return "hotdealPage/hotdealList";
    }


    @GetMapping("/read")
    public String read(Integer hotdeal_NUM, Model m, HttpSession session){
        String User_email = (String) session.getAttribute("User_email");
        BrowserHistoryDto bh = new BrowserHistoryDto(session.getId(), User_email,null, null, hotdeal_NUM);


        try {
            HotdealDto hotdealDto = hotdealService.read(hotdeal_NUM, bh);
            m.addAttribute("hotdealDto", hotdealDto);
            // 선택한 핫딜 게시물에 대한 data

            UserDto userDto = userDao.select((String) session.getAttribute("User_email"));
            m.addAttribute("UserDto",userDto);
            // 로그인 했다면, 로그인 계정(유저)에 대한 data

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/hotdeal/list";
        }

        return "hotdealPage/hotdeal";
    }


    @PostMapping("/delete")
    public String delete(Integer hotdeal_NUM, RedirectAttributes rattr){

        try {
            hotdealService.delete(hotdeal_NUM);
//            throw new Exception("delete failed");

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DEL_ERR"); //
            return "redirect:/";
        }

        return "redirect:/hotdeal/list";
    }

}
