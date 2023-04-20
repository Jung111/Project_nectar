package project.nectar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nectar.domain.ReviewDto;
import project.nectar.domain.ReviewPlusDto;
import project.nectar.repository.RestrDao;
import project.nectar.repository.ReviewDao;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    RestrDao restrDao;
    @Autowired
    ReviewDao reviewDao;


    @Override
    public int count(int restr_NUM) throws Exception {
        return reviewDao.count(restr_NUM);
    }

    @Override
    public List<ReviewDto> selectAll(int restr_NUM) throws Exception{
        return reviewDao.selectAll(restr_NUM);
    }

    @Override
    public ReviewDto select(int review_NUM) throws Exception {
        return reviewDao.select(review_NUM);
    }

    @Override
    public List<ReviewPlusDto> getMyReviews(String user_email) throws Exception{
         return reviewDao.selectMyReviews(user_email);
    }


    // Write() : 리뷰를 작성한다?
    //1. [review 테이블]에 방금 작성한 리뷰(content, star, .. )를 insert
    //2. [review 테이블]에서 리뷰의 총 개수 count(*)를  select
    //3. [restr 테이블]에 리뷰의 총 개수 count(*)를 upate
    //4. [review 테이블]에서 별점의 평균 avg(review_star)를 select
    //5. [restr 테이블]에 별점의 평균 avg(review_star)를 update

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int write(ReviewDto reviewDto) throws Exception {
        reviewDao.insert(reviewDto);
        int reviewCnt = reviewDao.count(reviewDto.getRestr_NUM());
        restrDao.updateReviewCnt(reviewDto.getRestr_NUM(), reviewCnt);
        float avgStar = reviewDao.getAvgStar(reviewDto.getRestr_NUM());
        return restrDao.updateStar(reviewDto.getRestr_NUM(), avgStar);
    }   //reviewCnt를 임의로 +1,-1 하던 방식에서  실제 reviewCnt 반영되도록 수정했어요.


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(ReviewDto reviewDto) throws Exception{
        reviewDao.delete(reviewDto);
        int reviewCnt = reviewDao.count(reviewDto.getRestr_NUM());
        restrDao.updateReviewCnt(reviewDto.getRestr_NUM(), reviewCnt);
        float avgStar = reviewDao.getAvgStar(reviewDto.getRestr_NUM());
        return restrDao.updateStar(reviewDto.getRestr_NUM(), avgStar);
    }   //reviewCnt를 임의로 +1,-1 하던 방식에서  실제 reviewCnt 반영되도록 수정했어요.


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int modify(ReviewDto reviewDto) throws Exception{
        reviewDao.update(reviewDto);
        float avgStar = reviewDao.getAvgStar(reviewDto.getRestr_NUM());
        return restrDao.updateStar(reviewDto.getRestr_NUM(), avgStar);
    }


}
