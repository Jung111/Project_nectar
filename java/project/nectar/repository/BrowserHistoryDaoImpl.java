package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import project.nectar.domain.BrowserHistoryDto;
import project.nectar.domain.LikelistDto;
import project.nectar.domain.RestrDto;

import java.util.List;

@Repository
public class BrowserHistoryDaoImpl implements BrowserHistoryDao {
    @Autowired
    SqlSession session;
    private String namespace = "project.nectar.repository.BrowserHistoryMapper.";


    @Override
    public List<BrowserHistoryDto> select_TopSearchKeyword() throws Exception {
        return session.selectList(namespace + "select_TopSearchKeyword");
    }   // TOP 검색 키워드 5개 select

    @Override
    public List<RestrDto> selectByJSESSIONID(BrowserHistoryDto browserHistoryDto) throws Exception {
        return session.selectList(namespace+"selectByJSESSIONID", browserHistoryDto);
    }   // 비 유저가 최근에 본 (레스토랑)게시물 select

    @Override
    public List<RestrDto> selectByUser_email(BrowserHistoryDto browserHistoryDto) throws Exception {
        return session.selectList(namespace+"selectByUser_email", browserHistoryDto);
    }   // 유저가 최근에 본 (레스토랑)게시물 select




    @Override
    public int insertKeyword(BrowserHistoryDto browserHistoryDto) throws Exception{
        return session.insert(namespace+"insertKeyword", browserHistoryDto);
    }   // 해당 keyword 로 검색했음을 저장

    @Override
    public int insertRestrNUM(BrowserHistoryDto browserHistoryDto) throws Exception{
        return session.insert(namespace+"insertRestrNUM",browserHistoryDto);
    }   // 레스토랑 게시물 조회 했음을 저장

    @Override
    public int insertHotdealNUM(BrowserHistoryDto browserHistoryDto) throws Exception{
        return session.insert(namespace+"insertHotdealNUM",browserHistoryDto);
    }   // 핫딜 게시물을 조회 했음을 저장


    @Override
    public int deleteUserEmail(String user_email) throws Exception{
        return session.delete(namespace+"deleteUserEmail", user_email);
    }

    @Override
    public int deleteJSESSIONID(String JSESSIONID) throws Exception{
        return session.delete(namespace+"deleteJSESSIONID", JSESSIONID);
    }


}
