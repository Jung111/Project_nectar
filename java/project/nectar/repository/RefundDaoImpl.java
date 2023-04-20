package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.RefundDto;

import java.util.List;

@Repository
public class RefundDaoImpl implements RefundDao {
    @Autowired
    SqlSession session;
    private String namespace="project.nectar.repository.RefundMapper.";


    @Override
    public List<RefundDto> selectAll(String bizAccount_email) throws Exception{
        return session.selectList(namespace+"selectAll", bizAccount_email);
    }

    @Override
    public RefundDto select(Integer refund_NUM) throws Exception{
        return session.selectOne(namespace+"select", refund_NUM);
    }

    @Override
    public int insert(RefundDto refundDto) throws Exception {
        return session.insert(namespace+"insert", refundDto);
    }

}
