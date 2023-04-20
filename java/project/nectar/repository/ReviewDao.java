package project.nectar.repository;

import project.nectar.domain.ReviewDto;
import project.nectar.domain.ReviewPlusDto;

import java.util.List;

public interface ReviewDao {
    int count(int restr_NUM) throws Exception;

    List<ReviewDto> selectAll(Integer restr_NUM) throws Exception;

    ReviewDto select(Integer review_NUM) throws Exception;

    List<ReviewPlusDto> selectMyReviews(String user_email)throws Exception;

    int insert(ReviewDto reviewDto) throws Exception;

    int deleteAll(Integer restr_NUM) throws Exception;

    int delete(ReviewDto reviewDto) throws Exception;

    int update(ReviewDto reviewDto) throws Exception;

    float getAvgStar(Integer restr_NUM) throws Exception;
}
