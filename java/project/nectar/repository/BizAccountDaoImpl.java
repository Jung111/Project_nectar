package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.BizAccountDetailsDto;
import project.nectar.domain.BizAccountDto;

import java.util.HashMap;
import java.util.List;

@Repository
public class BizAccountDaoImpl implements BizAccountDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "project.nectar.repository.BizAccountMapper.";



    @Override
    public List<BizAccountDto> SearchResultBizAccount(HashMap map) {
        return session.selectList(namespace + "SearchResultBizAccount", map);
    }

    @Override
    public BizAccountDto select(String bizAccount_email) {
        return session.selectOne(namespace + "select", bizAccount_email);
    }

    @Override
    public int insert(BizAccountDto bizAccountDto) {
        return session.insert(namespace + "insert", bizAccountDto);
    }

    @Override
    public int update(BizAccountDto bizAccountDto) {
        return session.update(namespace + "update", bizAccountDto);
    }

    @Override
    public int updateStateCode(BizAccountDto bizAccountDto) {
        return session.update(namespace + "updateStateCode", bizAccountDto);
    }

    @Override
    public int delete(String bizAccount_email) {
        return session.delete(namespace + "delete", bizAccount_email);
    }

    @Override
    public int deleteAll() {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int count() {
        return session.selectOne(namespace + "count");
    }


    @Override
    public BizAccountDetailsDto selectByUserEmail(String bizAccount_email) {
        return session.selectOne(namespace + "selectByUserEmail", bizAccount_email);
    }


}
