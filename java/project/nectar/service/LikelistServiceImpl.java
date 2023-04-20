package project.nectar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nectar.domain.LikelistDto;
import project.nectar.repository.LikelistDao;
import project.nectar.repository.RestrDao;

import java.util.List;

@Service
public class LikelistServiceImpl implements LikelistService {
    @Autowired
    LikelistDao likelistDao;
    @Autowired
    RestrDao restrDao;

    @Override
    public LikelistDto select(LikelistDto likelistDto) throws Exception{
        return likelistDao.select(likelistDto);
    } // 유저가 로그인 해서 게시물(restr.jsp)에 들어갔을 때, 좋아요 누른 가게인지 확인용


    // removeMyLikeList() : 내가 좋아요 눌렀던 '모든' 가게의 like 를 취소
    // 1. [likelist 테이블]에서 (user_email)에 해당하는 모든 레스토랑을 select
    // 2. 위에서 select 한 data를 list에 담고, for문을 이용해 list를 하나씩 읽으면서 cancelLike()를 실행.
    // 3. cancelLike() : 내가 좋아요 눌렀던 가게의 like를 취소
    //     3.1. [likelist 테이블]에서 (restr_NUM)번, (user_email)에 해당하는 like를 delete
    //     3.2. [likelist 테이블]에서 (restr_NUM)번에 해당하는 레스토랑의 like의 총 개수 count() 를 select
    //     3.3. [restr 테이블]에 like의 총 개수를 insert

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeMyLikeList(String user_email) throws Exception {
        List<LikelistDto> getRestrList = likelistDao.selectAll(user_email);
        for(LikelistDto likelistDto :getRestrList){
            cancelLike(likelistDto);
        }
    } // MyPage 에서 removeMyLikeList 하면 내가 좋아요 누른 모든 가게가 모두 삭제


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addLike(LikelistDto likelistDto) throws Exception{
        likelistDao.insert(likelistDto);
        int likeCnt = likelistDao.count(likelistDto.getRestr_NUM());
        return restrDao.updateLikeCnt(likelistDto.getRestr_NUM(),likeCnt);
    }   //likeCnt를 임의로 +1,-1 하던 방식에서  실제 likeCnt 반영되도록 수정했어요.


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int cancelLike(LikelistDto likelistDto) throws Exception{
        likelistDao.delete(likelistDto);
        int likeCnt = likelistDao.count(likelistDto.getRestr_NUM());
        return restrDao.updateLikeCnt(likelistDto.getRestr_NUM(),likeCnt);
    }   //likeCnt를 임의로 +1,-1 하던 방식에서  실제 likeCnt 반영되도록 수정했어요.




    // likelistMapper에서 위의 deleteAll()은 쓰이지 않음.
}
