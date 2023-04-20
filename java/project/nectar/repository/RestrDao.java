package project.nectar.repository;

import project.nectar.domain.RestrDto;
import project.nectar.domain.SearchCondition;

import java.util.List;

public interface RestrDao {
    int searchResultCnt(SearchCondition sc) throws Exception;

    List<RestrDto> SearchResultPage(SearchCondition sc) throws Exception;

    RestrDto select(Integer restr_NUM) throws Exception;

    RestrDto selectByBiz_email(String bizAccount_email) throws Exception;

    int delete(Integer restr_NUM) throws Exception;

    int insertAll(RestrDto restrDto) throws Exception;

    int update(RestrDto restrDto) throws Exception;

    int updateViewCnt(Integer restr_NUM) throws Exception;

    int updateReviewCnt(Integer restr_NUM, Integer reviewCnt) throws Exception;

    int updateLikeCnt(Integer restr_NUM, Integer likeCnt) throws Exception;

    int updateStar(Integer restr_NUM, float avgStar) throws Exception;

    int sync_ReviewCnt(RestrDto restrDto) throws Exception;

    int updateHotdeal(RestrDto restrDto) throws Exception;
}
