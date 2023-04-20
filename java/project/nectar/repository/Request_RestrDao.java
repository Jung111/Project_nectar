package project.nectar.repository;

import project.nectar.domain.Request_RestrDto;
import project.nectar.domain.RestrDto;

import java.util.List;

public interface Request_RestrDao {
    List<Request_RestrDto> selectAll();

    Request_RestrDto select(Integer request_restr_NUM);

    int insertAll(Request_RestrDto request_restrDto);

    int delete(Integer request_restr_NUM);

    int updateState(Request_RestrDto request_restrDto);

    Request_RestrDto selectMyReqRestr(String Biz_email);
}
