package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.RestrDto;
import project.nectar.domain.SearchCondition;

import java.util.List;


@Repository
public class RestrDaoImpl implements RestrDao {
    @Autowired
    SqlSession session;
    private String namespace="project.nectar.repository.RestrMapper.";

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception{
        return session.selectOne(namespace+"searchResultCnt",sc);
    }

    @Override
    public List<RestrDto> SearchResultPage(SearchCondition sc) throws Exception{
        return session.selectList(namespace+"SearchResultPage",sc);
    }

    @Override
    public RestrDto select(Integer restr_NUM) throws Exception{
        return session.selectOne(namespace+"select", restr_NUM);
    }



    @Override
    public RestrDto selectByBiz_email(String bizAccount_email) throws Exception{
        return session.selectOne(namespace+"selectByBiz_email", bizAccount_email);
    }



    @Override
    public int delete(Integer restr_NUM) throws Exception{
        return session.delete(namespace+"delete", restr_NUM);
    }

    @Override
    public int insertAll(RestrDto restrDto) throws Exception{
        return session.insert(namespace+"insertAll",restrDto);
    }

    @Override
    public int update(RestrDto restrDto) throws Exception{
        return session.update(namespace+"update",restrDto);
    }

    @Override
    public int updateViewCnt(Integer restr_NUM) throws Exception{
        return session.update(namespace+"updateViewCnt", restr_NUM);
    }

    @Override
    public int updateReviewCnt(Integer restr_NUM, Integer reviewCnt) throws Exception{
        RestrDto restrDto = new RestrDto();
        restrDto.setRestr_NUM(restr_NUM);
        restrDto.setRestr_reviewCnt(reviewCnt);
        return session.update(namespace+"updateReviewCnt", restrDto);
    }

    @Override
    public int updateLikeCnt(Integer restr_NUM, Integer likeCnt) throws Exception{
        RestrDto restrDto = new RestrDto();
        restrDto.setRestr_NUM(restr_NUM);
        restrDto.setRestr_likeCnt(likeCnt);
        return session.update(namespace+"updateLikeCnt", restrDto);
    }

    @Override
    public int updateStar(Integer restr_NUM, float avgStar) throws Exception{
        RestrDto restrDto = new RestrDto();
        restrDto.setRestr_NUM(restr_NUM);
        restrDto.setRestr_star(avgStar);
        return session.update(namespace+"updateStar",restrDto);
    }

    @Override
    public int sync_ReviewCnt(RestrDto restrDto) throws Exception{
        return session.update(namespace+"sync_ReviewCnt", restrDto);
    }


    @Override
    public int updateHotdeal(RestrDto restrDto) throws Exception{
        return session.update(namespace+"updateHotdeal", restrDto);
    }
}
