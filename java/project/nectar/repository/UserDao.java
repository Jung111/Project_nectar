package project.nectar.repository;

import project.nectar.domain.RestrDto;
import project.nectar.domain.UserDetailsDto;
import project.nectar.domain.UserDto;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    int insert(UserDto userDto);

    List<UserDto> SearchResultUser(HashMap map);

    UserDto select(String user_email);

    int update(UserDto userDto);

    int updateStateCode(UserDto userDto);

    int delete(String user_email);

    int deleteAll();

    int count();

    UserDetailsDto selectByUserEmail(String user_email);
}
