package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.nectar.repository.QnaCommentDao;

@Controller
@RequestMapping("/mypage")
public class QNACommentController{
    @Autowired
    QnaCommentDao qnaCommentDao;



    // user (일반회원)

    @PostMapping("/user/QNA/addComment")
    public String addComment_user(Integer qna_NUM, String qna_comment, String qna_commenter, RedirectAttributes rattr){

        try {
            qnaCommentDao.insertComment(qna_NUM,qna_comment, qna_commenter);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","COMMENT_WRT_ERR");
            return "redirect:/mypage/user/main";
        }
        return "redirect:/mypage/user/QNA/read?qna_NUM="+qna_NUM;
    };


    @PostMapping("/user/QNA/removeComment")
    public String removeComment_user(Integer qna_NUM, Integer qna_comment_NUM, String qna_commenter, RedirectAttributes rattr){

        try {
            qnaCommentDao.deleteComment(qna_comment_NUM, qna_commenter);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","COMMENT_REMOVE_ERR");
            return "redirect:/mypage/user/main";
        }
        return "redirect:/mypage/user/QNA/read?qna_NUM="+qna_NUM;

    }





    // biz (사업자회원)

    @PostMapping("/biz/QNA/addComment")
    public String addComment_biz(Integer qna_NUM, String qna_comment, String qna_commenter, RedirectAttributes rattr){

        try {
            qnaCommentDao.insertComment(qna_NUM,qna_comment, qna_commenter);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","COMMENT_WRT_ERR");
            return "redirect:/mypage/biz/main";
        }
        return "redirect:/mypage/biz/QNA/read?qna_NUM="+qna_NUM;
    };


    @PostMapping("/biz/QNA/removeComment")
    public String removeComment_biz(Integer qna_NUM, Integer qna_comment_NUM, String qna_commenter, RedirectAttributes rattr){

        try {
            qnaCommentDao.deleteComment(qna_comment_NUM, qna_commenter);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","COMMENT_REMOVE_ERR");
            return "redirect:/mypage/biz/main";
        }
        return "redirect:/mypage/biz/QNA/read?qna_NUM="+qna_NUM;

    }



    // admin (관리자)

    @PostMapping("/admin/QNA/addComment")
    public String addComment_admin(Integer qna_NUM, String qna_comment, String qna_commenter, RedirectAttributes rattr){
        System.out.println("댓글 추가 시 넘어온 qna_commenter = " + qna_commenter);
        try {
            qnaCommentDao.insertComment(qna_NUM,qna_comment, qna_commenter);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","COMMENT_WRT_ERR");
            return "redirect:/mypage/admin/main";
        }
        return "redirect:/mypage/admin/QNA/read?qna_NUM="+qna_NUM;
    };


    @PostMapping("/admin/QNA/removeComment")
    public String removeComment_admin(Integer qna_NUM, Integer qna_comment_NUM, String qna_commenter, RedirectAttributes rattr){

        try {
            qnaCommentDao.deleteComment(qna_comment_NUM, qna_commenter);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","COMMENT_REMOVE_ERR");
            return "redirect:/mypage/biz/main";
        }
        return "redirect:/mypage/admin/QNA/read?qna_NUM="+qna_NUM;

    }


}
