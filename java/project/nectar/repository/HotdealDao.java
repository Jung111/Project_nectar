package project.nectar.repository;

import project.nectar.domain.HotdealDto;

import java.util.List;

public interface HotdealDao {
    List<HotdealDto> selectMyHotdeals(String bizAccount_email) throws Exception;

    List<HotdealDto> selectAll() throws Exception;

    HotdealDto select(Integer hotdeal_NUM) throws Exception;

    int delete(Integer hotdeal_NUM) throws Exception;

    int update(HotdealDto hotdealDto) throws Exception;

    int updateSalesVolume(Integer hotdeal_NUM, Integer hotdeal_salesVolume) throws Exception;

    int insert(HotdealDto hotdealDto) throws Exception;
}
