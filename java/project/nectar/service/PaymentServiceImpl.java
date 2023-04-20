package project.nectar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nectar.domain.HotdealDto;
import project.nectar.domain.PaymentDto;
import project.nectar.domain.RestrDto;
import project.nectar.domain.RestrMenuDto;
import project.nectar.repository.HotdealDao;
import project.nectar.repository.PaymentDao;
import project.nectar.repository.RestrDao;
import project.nectar.repository.RestrMenuDao;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;
    @Autowired
    HotdealDao hotdealDao;
    @Autowired
    RestrDao restrDao;
    @Autowired
    RestrMenuDao restrMenuDao;





    // Insert() : 결제를 한다?
    //1. [payment 테이블]에서 해당 결제 내역을 insert
    //2. [payment 테이블]에 (hotdeal_NUM)번에 해당하는 총 결제 수 count(*)를 select
    //    핫딜의 총 결제 수(count(*)) = 핫딜 총 판매량(salesVolume)
    //3. [hotdeal 테이블]에 핫딜 총 판매량(salesVolume)을 update

    //4.  (만약, 핫딜 총 판매량 == 핫딜 최대 판매량 일 경우)
    //  4.1 [restr 테이블]에 restr_hotdeal_NUM= -1 로 update          >> restrList.jsp 에서 '핫딜 진행중'이라는 알림이 사라진다.
    //  4.2 [restr_menu 테이블]에 restr_menu_hotdeal_NUM = -1 로 update   >> restr.jsp 에서 '핫딜로 이동하기'라는 알림이 사라진다.

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(PaymentDto paymentDto) throws Exception {
        int hotdeal_NUM = paymentDto.getHotdeal_NUM();;

        int insert = paymentDao.insert(paymentDto);
        int salesVolume = paymentDao.count(paymentDto);
        hotdealDao.updateSalesVolume(hotdeal_NUM, salesVolume);

        HotdealDto hotdealDto = hotdealDao.select(hotdeal_NUM);
        if(hotdealDto.getHotdeal_salesVolume() == hotdealDto.getHotdeal_MaxSalesVolume()){
            restrDao.updateHotdeal(new RestrDto(hotdealDto.getRestr_NUM(),-1));
            restrMenuDao.updateHotdeal(new RestrMenuDto(hotdealDto.getRestr_menu_NUM(),-1));
        };

        return insert;
    }




    // Delete() : 결제를 취소한다(환불요청)?
    //1  (만약, 핫딜 총 판매량 == 핫딜 최대 판매량 일 경우)
    //   1.1 [restr 테이블]의  칼럼 restr_hotdeal_NUM 을 'hotdeal_NUM'으로 로 update       >> restrList.jsp 에서 '핫딜 진행중'이라는 알림이 생긴다.
    //   1.2 [restr_menu 테이블]에 restr_menu_hotdeal_NUM = 'hotdeal_NUM' 으로 update       >> restr.jsp 에서 '핫딜로 이동하기'라는 알림이 생긴다.

    //2. [payment 테이블]에서 해당 결제 내역을 delete
    //3. [payment 테이블]에 (hotdeal_NUM)번에 해당하는 총 결제 수 count(*)를 select
    //    핫딜의 총 결제 수(count(*)) = 핫딜 총 판매량(salesVolume)
    //4. [hotdeal 테이블]에 핫딜 총 판매량(salesVolume)을 update

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(PaymentDto paymentDto) throws Exception{
        int hotdeal_NUM = paymentDto.getHotdeal_NUM();;

        HotdealDto hotdealDto = hotdealDao.select(hotdeal_NUM);
        if(hotdealDto.getHotdeal_salesVolume() == hotdealDto.getHotdeal_MaxSalesVolume()){
            restrDao.updateHotdeal(new RestrDto(hotdealDto.getRestr_NUM(),hotdeal_NUM));
            restrMenuDao.updateHotdeal(new RestrMenuDto(hotdealDto.getRestr_menu_NUM(),hotdeal_NUM));
        };

        int delete = paymentDao.delete(paymentDto);
        int salesVolume = paymentDao.count(paymentDto);
        hotdealDao.updateSalesVolume(paymentDto.getHotdeal_NUM(), salesVolume);

        return delete;
    }


}