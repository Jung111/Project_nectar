package project.nectar.repository;

import project.nectar.domain.RestrMenuDto;

import java.util.List;

public interface RestrMenuDao {
    List<RestrMenuDto> selectAllMenu(Integer restr_NUM) throws Exception;

    int insert(RestrMenuDto restrMenuDto) throws Exception;

    int deleteAll(Integer restr_NUM) throws Exception;

    int delete(Integer restr_menu_NUM) throws Exception;

    int update(RestrMenuDto restrMenuDto) throws Exception;

    int updateHotdeal(RestrMenuDto restrMenuDto) throws Exception;
}
