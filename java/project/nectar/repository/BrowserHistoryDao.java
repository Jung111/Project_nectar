package project.nectar.repository;

import project.nectar.domain.BrowserHistoryDto;
import project.nectar.domain.RestrDto;

import java.util.List;

public interface BrowserHistoryDao {
    List<BrowserHistoryDto> select_TopSearchKeyword() throws Exception   // TOP 검색 키워드 5개 select
    ;

    List<RestrDto> selectByJSESSIONID(BrowserHistoryDto browserHistoryDto) throws Exception   // 비 유저가 최근에 본 (레스토랑)게시물 select
    ;

    List<RestrDto> selectByUser_email(BrowserHistoryDto browserHistoryDto) throws Exception   // 유저가 최근에 본 (레스토랑)게시물 select
    ;

    int insertKeyword(BrowserHistoryDto browserHistoryDto) throws Exception   // 해당 keyword 로 검색했음을 저장
    ;

    int insertRestrNUM(BrowserHistoryDto browserHistoryDto) throws Exception   // 레스토랑 게시물 조회 했음을 저장
    ;

    int insertHotdealNUM(BrowserHistoryDto browserHistoryDto) throws Exception   // 핫딜 게시물을 조회 했음을 저장
    ;

    int deleteUserEmail(String user_email) throws Exception;

    int deleteJSESSIONID(String JSESSIONID) throws Exception;
}
