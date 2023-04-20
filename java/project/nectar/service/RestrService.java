package project.nectar.service;

import project.nectar.domain.BrowserHistoryDto;
import project.nectar.domain.RestrDto;
import project.nectar.domain.SearchCondition;

import java.util.List;

public interface RestrService {
    int SearchResultCnt(SearchCondition sc) throws Exception;

    List<RestrDto> SearchResultPage(SearchCondition sc, BrowserHistoryDto browserHistoryDto) throws Exception;

    RestrDto read(Integer restr_NUM, BrowserHistoryDto browserHistoryDto) throws Exception;

    int delete(Integer restr_NUM) throws Exception;

    int insertAll(RestrDto restrDto) throws Exception;

    int update(RestrDto restrDto) throws Exception;
}
