package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.nectar.domain.RestrMenuDto;
import project.nectar.repository.RestrMenuDao;

@Controller
@RequestMapping("/mypage/biz/restrMenu")
public class RestrMenuController {
    @Autowired
    RestrMenuDao restrMenuDao;

    @PostMapping("/write")
    public String register_RestrMenu(RestrMenuDto restrMenuDto, RedirectAttributes rattr){

        try {
            restrMenuDao.insert(restrMenuDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","MENU_WRT_ERR");
            return "redirect:/mypage/biz/main";
        }

        return "redirect:/mypage/biz/main";
    } // 레스토랑 메뉴 등록


    @PostMapping("/modify")
    public String modify_RestrMenu(RestrMenuDto restrMenuDto, RedirectAttributes rattr){

        try {
            restrMenuDao.update(restrMenuDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","MENU_MOD_ERR");
            return "redirect:/mypage/biz/main";
        }

        return "redirect:/mypage/biz/main";
    }   // 레스토랑 메뉴 수정


    @PostMapping("/delete")
    public String delete_RestrMenu(Integer restr_menu_NUM, RedirectAttributes rattr){
        try {
            restrMenuDao.delete(restr_menu_NUM);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","MENU_DEL_ERR");
            return "redirect:/mypage/biz/main";
        }

        return "redirect:/mypage/biz/main";
    }   // 레스토랑 메뉴 삭제



}
