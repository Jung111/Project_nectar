package project.nectar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nectar.domain.BrowserHistoryDto;
import project.nectar.domain.HotdealDto;
import project.nectar.domain.Request_HotdealDto;
import project.nectar.repository.BrowserHistoryDao;
import project.nectar.repository.HotdealDao;
import project.nectar.repository.Request_HotdealDao;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class HotdealServiceImpl implements HotdealService {
    @Autowired
    HotdealDao hotdealDao;
    @Autowired
    BrowserHistoryDao browserHistoryDao;
    @Autowired
    Request_HotdealDao request_hotdealDao;

    HttpSession session;



    @Override
    public List<HotdealDto> selectMyHotdeals(String bizAccount_email) throws Exception{
        return hotdealDao.selectMyHotdeals(bizAccount_email);
    }

    @Override
    public List<HotdealDto> selectAll() throws Exception{
        return hotdealDao.selectAll();
    }



    // read() : 게시글물을 들어가서 본다?(조회한다)
    //1. [browser history 테이블]에 조회한 게시물 번호(hotdeal_NUM)를 insert
    //2. [hotdeal 테이블]에서 (restr_NUM)번에 해당하는 레스토랑 정보를 select

    @Override
    @Transactional(rollbackFor = Exception.class)
    public HotdealDto read(Integer hotdeal_NUM, BrowserHistoryDto browserHistoryDto) throws Exception{
        browserHistoryDao.insertHotdealNUM(browserHistoryDto);
        return hotdealDao.select(hotdeal_NUM);
    }


    @Override
    public int delete(Integer hotdeal_NUM) throws Exception{
        return hotdealDao.delete(hotdeal_NUM);
    }

    @Override
    public int update(HotdealDto hotdealDto) throws Exception{
        return hotdealDao.update(hotdealDto);
    }



    // insert() : 핫딜 게시물을 등록한다?
    // 1. request_hotdeal 테이블의 (request_hotdeal)의 심사코드(evaluate code)를 승인 상태(1) 로 만든다.
    // 2. hotdeal 테이블에 승인 판정 받은 data 를 insert

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(HotdealDto hotdealDto) throws Exception{
        return hotdealDao.insert(hotdealDto);
    }


}
