package project.nectar.repository;

import project.nectar.domain.BizAccountDetailsDto;
import project.nectar.domain.BizAccountDto;

import java.util.HashMap;
import java.util.List;

public interface BizAccountDao {
    int insert(BizAccountDto bizAccountDto);

    List<BizAccountDto> SearchResultBizAccount(HashMap map);

    BizAccountDto select(String bizAccount_email);

    int update(BizAccountDto bizAccountDto);

    int updateStateCode(BizAccountDto bizAccountDto);

    int delete(String bizAccount_email);

    int deleteAll();

    int count();

    BizAccountDetailsDto selectByUserEmail(String bizAccount_email);
}
