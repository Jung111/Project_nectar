package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.Request_RestrDto;

import java.util.List;

@Repository
public class Request_RestrDaoImpl implements Request_RestrDao {
    @Autowired
    SqlSession session;
    private String namespace="project.nectar.repository.Request_RestrMapper.";


    @Override
    public List<Request_RestrDto> selectAll(){
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public Request_RestrDto select(Integer request_restr_NUM){
        return session.selectOne(namespace+"select",request_restr_NUM);
    }

    @Override
    public int insertAll(Request_RestrDto request_restrDto){
        return session.insert(namespace+"insertAll", request_restrDto);
    }

    @Override
    public int delete(Integer request_restr_NUM){
        return session.delete(namespace+"delete",request_restr_NUM);
    }


    @Override
    public int updateState(Request_RestrDto request_restrDto){
        return session.update(namespace + "updateState" , request_restrDto);
    }

    @Override
    public Request_RestrDto selectMyReqRestr(String Biz_email){
        return session.selectOne(namespace + "selectMyReqRestr" , Biz_email);
    }

}
