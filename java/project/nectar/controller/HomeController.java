package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.nectar.domain.BrowserHistoryDto;
import project.nectar.domain.HotdealDto;
import project.nectar.domain.UserDto;
import project.nectar.repository.BrowserHistoryDao;
import project.nectar.service.HotdealService;

import javax.servlet.http.HttpSession;
import java.util.List;
// 이하 HOME page 에 대한 모든 내용
@Controller
public class HomeController {
    @Autowired
    BrowserHistoryDao browserHistoryDao;
    @Autowired
    HotdealService hotdealService;


    @RequestMapping("/")
    public String home(Model m) {

        try {
            List<BrowserHistoryDto> topSearchKeywordList = browserHistoryDao.select_TopSearchKeyword();
            m.addAttribute("topSearchKeywordList", topSearchKeywordList);
            // 인기 검색어에 대한 data

            List<HotdealDto> hotdealDto = hotdealService.selectAll();
            m.addAttribute("hotdealDto",hotdealDto);
            // 핫딜 게시물에 대한 data


        } catch (Exception e) {
            e.printStackTrace();
//            return "redirect:/errpage";
            return "matListPage/restrList";
        }

        return "home";
    }

    @RequestMapping("/pageAccessDenied")
    public String pageAccessDenied(){
        return "pageAccessDenied";
    }




}
