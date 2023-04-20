package project.nectar.repository;

import project.nectar.domain.LikelistDto;
import project.nectar.domain.RestrDto;

import java.util.List;

public interface LikelistDao {
    int count(Integer restr_NUM) throws Exception;

    List<LikelistDto> selectAll(String user_email) throws Exception;

    LikelistDto select(LikelistDto likelistDto) throws Exception;

    List<RestrDto> selectMyLikeList(String user_email) throws Exception;

    int insert(LikelistDto likelistDto) throws Exception;

    int deleteAll(String user_email) throws Exception;

    int delete(LikelistDto likelistDto) throws Exception;

    int deleteRestr(Integer restr_NUM) throws Exception;
}
