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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.nectar.domain.*;
import project.nectar.repository.BrowserHistoryDao;
import project.nectar.repository.RestrMenuDao;
import project.nectar.repository.UserDao;
import project.nectar.service.LikelistService;
import project.nectar.service.RestrService;
import project.nectar.service.ReviewService;

import javax.servlet.http.HttpSession;
import java.util.List;

// 이하 맛집리스트 에 관한 모든 내용
@Controller
@RequestMapping("/restr")
public class RestrController {
    @Autowired
    RestrService restrService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    LikelistService likelistService;
    @Autowired
    UserDao userDao;
    @Autowired
    RestrMenuDao restrMenuDao;
    @Autowired
    BrowserHistoryDao browserHistoryDao;


    @GetMapping("/list")
    public String list() {
        return "matListPage/restrTagList";
    }


    @GetMapping("/search")
    public String SearchResult(Model m, SearchCondition sc, HttpSession session) {

        String searchKeyword = (sc.getKeyword()!=""? sc.getKeyword() : ( sc.getFoodType())!=""? sc.getFoodType() : sc.getTag() );
        BrowserHistoryDto bh = new BrowserHistoryDto(session.getId(), (String)session.getAttribute("User_email"),searchKeyword);

        try {
            int totalCnt = restrService.SearchResultCnt(sc);
            PageHandler pageHandler = new PageHandler(sc,totalCnt);
            m.addAttribute("ph", pageHandler);
            // 페이징에 대한 data

            List<RestrDto> restrDto = restrService.SearchResultPage(sc, bh);
            m.addAttribute("restrDto", restrDto);
            // 검색 조건에 해당하는 레스토랑 대한 data

            List<RestrDto> viewBrowserHistoryList = browserHistoryDao.selectByJSESSIONID(bh);
            m.addAttribute("viewBrowserHistoryList",viewBrowserHistoryList);
            //최근에 본 게시물(레스토랑) 에 대한 data


        } catch (Exception e) {
            e.printStackTrace();
            return "searchERR";

        }

        return "matListPage/restrList";
    }


    @GetMapping("/read")
    public String read(LikelistDto likeDto, Integer restr_NUM, SearchCondition sc, Model m, HttpSession session, Authentication authentication){

        String user_email= "";
        if(isAuthenticated()){       // 로그인이(인증)이 된 경우
            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            user_email = userDetails.getUsername();
        }

        BrowserHistoryDto bh = new BrowserHistoryDto(session.getId(), user_email,restr_NUM);
        likeDto.setUser_email(user_email);

        try {
            RestrDto restrDto = restrService.read(restr_NUM, bh);
            m.addAttribute("restrDto", restrDto);
            // 레스토랑에 대한 data

            List<RestrMenuDto> restrMenuDto = restrMenuDao.selectAllMenu(restr_NUM);
            m.addAttribute("restrMenuDto",restrMenuDto);
            // 레스토랑 메뉴에 대한 data

            List<ReviewDto> reviewDto = reviewService.selectAll(restr_NUM);
            m.addAttribute("reviewDto", reviewDto);
            // 리뷰에 대한 data

            LikelistDto likelistDto = likelistService.select(likeDto);
            m.addAttribute("likelistDto",likelistDto);
            // 로그인 했다면, 로그인 계정(유저)가 누른 좋아요에 대한 data

            UserDto userDto = userDao.select(user_email);
            m.addAttribute("userDto",userDto);
            // 로그인 했다면, 로그인 계정(유저)에 대한 data

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/restr/search"+sc.getQueryString();
        }

        return "matListPage/restr";
    }




    @PostMapping("/delete")
    public String delete(Integer restr_NUM, RedirectAttributes rattr, SearchCondition sc){
        try {
            restrService.delete(restr_NUM);
//            throw new Exception("delete failed");

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DEL_ERR"); //
            return "redirect:/";
        }

        return "redirect:/restr/search"+sc.getQueryString();
    }



    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }


}