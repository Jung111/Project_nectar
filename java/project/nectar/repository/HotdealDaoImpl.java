package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.HotdealDto;

import java.util.List;

@Repository
public class HotdealDaoImpl implements HotdealDao {
    @Autowired
    SqlSession session;
    private String namespace="project.nectar.repository.HotdealMapper.";

    @Override
    public List<HotdealDto> selectMyHotdeals(String bizAccount_email) throws Exception{
        return session.selectList(namespace+"selectMyHotdeals" ,bizAccount_email);
    }

    @Override
    public List<HotdealDto> selectAll() throws Exception{
        return session.selectList(namespace+"selectAll");
    }
    @Override
    public HotdealDto select(Integer hotdeal_NUM) throws Exception{
        return session.selectOne(namespace+"select", hotdeal_NUM);
    }

    @Override
    public int delete(Integer hotdeal_NUM) throws Exception{
        return session.delete(namespace+"delete", hotdeal_NUM);
    }

    @Override
    public int update(HotdealDto hotdealDto) throws Exception{
        return session.update(namespace+"update", hotdealDto);
    }

    @Override
    public int updateSalesVolume(Integer hotdeal_NUM, Integer hotdeal_salesVolume) throws Exception{
        HotdealDto hotdealDto = new HotdealDto();
        hotdealDto.setHotdeal_NUM(hotdeal_NUM);
        hotdealDto.setHotdeal_salesVolume(hotdeal_salesVolume);
        return session.update(namespace+"updateSalesVolume", hotdealDto);
    }

    @Override
    public int insert(HotdealDto hotdealDto) throws Exception{
        return session.insert(namespace+"insert", hotdealDto);
    }


}
