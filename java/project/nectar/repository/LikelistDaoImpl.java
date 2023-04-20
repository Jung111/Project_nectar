package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.LikelistDto;
import project.nectar.domain.RestrDto;

import java.util.List;

@Repository
public class LikelistDaoImpl implements LikelistDao {
    @Autowired
    SqlSession session;
    private String namespace="project.nectar.repository.LikelistMapper.";

    @Override
    public int count(Integer restr_NUM) throws Exception{
        return session.selectOne(namespace+"count",restr_NUM);
    }

    @Override
    public List<LikelistDto> selectAll(String user_email) throws Exception{
        return session.selectList(namespace+"selectAll",user_email);
    }

    @Override
    public LikelistDto select(LikelistDto likelistDto) throws Exception{
        return session.selectOne(namespace+"select",likelistDto);
    }
    

    @Override
    public List<RestrDto> selectMyLikeList(String user_email) throws Exception{
        return session.selectList(namespace+"selectMyLikeList",user_email);
    }

    @Override
    public int insert(LikelistDto likelistDto) throws Exception{
        return session.insert(namespace+"insert", likelistDto);
    }

    @Override
    public int deleteAll(String user_email) throws Exception{
        return session.delete(namespace+"deleteAll", user_email);
    }

    @Override
    public int delete(LikelistDto likelistDto) throws Exception {
        return session.delete(namespace + "delete", likelistDto);
    }

    @Override
    public int deleteRestr(Integer restr_NUM) throws Exception {
        return session.delete(namespace + "deleteRestr", restr_NUM);
    }
}
