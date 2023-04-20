package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.RestrMenuDto;

import java.util.List;

@Repository
public class RestrMenuDaoImpl implements RestrMenuDao {
    @Autowired
    SqlSession session;
    private String namespace="project.nectar.repository.RestrMenuMapper.";

    @Override
    public List<RestrMenuDto> selectAllMenu(Integer restr_NUM) throws Exception{
        return session.selectList(namespace+"selectAllMenu", restr_NUM);
    }

    @Override
    public int insert(RestrMenuDto restrMenuDto) throws Exception{
        return session.insert(namespace+"insert", restrMenuDto);
    }

    @Override
    public int deleteAll(Integer restr_NUM) throws Exception{
        return session.delete(namespace+"deleteAll", restr_NUM);
    }

    @Override
    public int delete(Integer restr_menu_NUM) throws Exception{
        return session.delete(namespace+"delete",restr_menu_NUM);
    }

    @Override
    public int update(RestrMenuDto restrMenuDto) throws Exception{
        return session.update(namespace+"update",restrMenuDto);
    }

    @Override
    public int updateHotdeal(RestrMenuDto restrMenuDto) throws Exception{
        return session.update(namespace+"updateHotdeal", restrMenuDto);
    }

}
