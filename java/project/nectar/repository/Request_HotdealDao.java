package project.nectar.repository;

import project.nectar.domain.HotdealDto;
import project.nectar.domain.Request_HotdealDto;

import java.util.List;

public interface Request_HotdealDao {
    List<Request_HotdealDto> selectAll();

    Request_HotdealDto select(Integer request_hotdeal_NUM);

    int insert(Request_HotdealDto request_hotdealDto);

    int delete(Integer request_hotdeal_NUM);

    int updateState(Request_HotdealDto request_hotdealDto);

    Request_HotdealDto selectMyReqHotdeal(String Biz_email);
}
