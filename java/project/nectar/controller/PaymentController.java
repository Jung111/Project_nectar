package project.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.nectar.domain.HotdealPlusDto;
import project.nectar.domain.PaymentDto;
import project.nectar.domain.RefundDto;
import project.nectar.domain.UserDto;
import project.nectar.repository.PaymentDao;
import project.nectar.repository.RefundDao;
import project.nectar.repository.UserDao;
import project.nectar.service.PaymentService;

import java.util.List;


@Controller
@RequestMapping("/pay")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Autowired
    PaymentDao paymentDao;
    @Autowired
    UserDao userDao;
    @Autowired
    RefundDao refundDao;



    @PostMapping("/process")
//    @ResponseBody
    public String pay(@RequestBody PaymentDto paymentDto) {

        try {
            paymentService.insert(paymentDto);

        } catch (Exception e) {
            e.printStackTrace();
            return "hotdealPage/paymentFail";
        }

        return "hotdealPage/paymentComplete";
    }




    @GetMapping("/cancel")
    public String cancel(String user_email, Integer payment_NUM, Model m) {

        try {
        UserDto userDto = userDao.select(user_email);
        m.addAttribute("userDto",userDto);
        // 사용자(User)에 대한 data

        HotdealPlusDto PaymentDto = paymentDao.select_PaymentInfo_byPayment_NUM(payment_NUM);
        m.addAttribute("PaymentDto",PaymentDto);
        // 사용자(User)가 환불요청한 핫딜 결제정보 대한 data

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }

        return "hotdealPage/refundForm";
    }




    @PostMapping("/cancel")
    public String cancel(PaymentDto paymentDto, RefundDto refundDto, Model m) {
        System.out.println("여기까지옴");
        System.out.println("paymentDto = " + paymentDto);
        System.out.println("refundDto = " + refundDto);
        try {
            refundDao.insert(refundDto);            // 환불 요청 insert
            paymentService.delete(paymentDto);      // 결제 정보 delete
            m.addAttribute("paymentDto",paymentDto);

        } catch (Exception e) {
            e.printStackTrace();
            return "hotdealPage/refundFail";
        }

        return "hotdealPage/refundComplete";
    }


    @GetMapping("/useCoupon")
    public String useCoupon(Integer payment_NUM){

        return "/";
    }



}
