package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.ReviewDto;
import project.nectar.domain.ReviewPlusDto;

import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao {
    @Autowired
    SqlSession session;
    private String namespace="project.nectar.repository.ReviewMapper.";

    @Override
    public int count(int restr_NUM) throws Exception{
        return session.selectOne(namespace+"count",restr_NUM);
    }

    @Override
    public List<ReviewDto> selectAll(Integer restr_NUM) throws Exception{
        return session.selectList(namespace+"selectAll",restr_NUM);
    }

    @Override
    public ReviewDto select(Integer review_NUM) throws Exception{
        return session.selectOne(namespace+"select",review_NUM);
    }

    @Override
    public List<ReviewPlusDto> selectMyReviews(String user_email)throws Exception{
        return session.selectList(namespace+"selectMyReviews",user_email);
    }

    @Override
    public int insert(ReviewDto reviewDto) throws Exception{
        return session.insert(namespace+"insert",reviewDto);
    }

    @Override
    public int deleteAll(Integer restr_NUM) throws Exception{
        return session.delete(namespace+"delete",restr_NUM);
    }

    @Override
    public int delete(ReviewDto reviewDto) throws Exception{
        return session.delete(namespace+"delete", reviewDto);
    }

    @Override
    public int update(ReviewDto reviewDto) throws Exception{
        return session.update(namespace+"update", reviewDto);
    }

    @Override
    public float getAvgStar(Integer restr_NUM) throws Exception{
        return session.selectOne(namespace+"getAvgStar", restr_NUM);
    }

}
