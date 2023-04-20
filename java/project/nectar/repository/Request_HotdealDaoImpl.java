package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.Request_HotdealDto;

import java.util.List;

@Repository
public class Request_HotdealDaoImpl implements Request_HotdealDao {
    @Autowired
    SqlSession session;
    private String namespace="project.nectar.repository.Request_HotdealMapper.";


    @Override
    public List<Request_HotdealDto> selectAll(){
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public Request_HotdealDto select(Integer request_hotdeal_NUM){
        return session.selectOne(namespace+"select", request_hotdeal_NUM);
    }

    @Override
    public int insert(Request_HotdealDto request_hotdealDto){
        return session.insert(namespace+"insert", request_hotdealDto);
    }

    @Override
    public int delete(Integer request_hotdeal_NUM){
        return session.delete(namespace+"delete",request_hotdeal_NUM);
    }

    @Override
    public int updateState(Request_HotdealDto request_hotdealDto){
        return session.update(namespace + "updateState" , request_hotdealDto);
    }

    @Override
    public Request_HotdealDto selectMyReqHotdeal(String Biz_email){
        return session.selectOne(namespace + "selectMyReqHotdeal" , Biz_email);
    }

}
