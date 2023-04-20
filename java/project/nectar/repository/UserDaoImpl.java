package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.UserDetailsDto;
import project.nectar.domain.UserDto;

import java.util.HashMap;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "project.nectar.repository.UserMapper.";


    @Override
    public List<UserDto> SearchResultUser(HashMap map) {
        return session.selectList(namespace + "SearchResultUser", map);
    }

    @Override
    public UserDto select(String user_email) {
        return session.selectOne(namespace + "select", user_email);
    }

    @Override
    public int insert(UserDto userDto) {
        return session.insert(namespace + "insert", userDto);
    }

    @Override
    public int update(UserDto userDto) {
        return session.update(namespace + "update", userDto);
    }

    @Override
    public int updateStateCode(UserDto userDto) {
        return session.update(namespace + "updateStateCode", userDto);
    }

    @Override
    public int delete(String user_email) {
        return session.delete(namespace + "delete", user_email);
    }

    @Override
    public int deleteAll() {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int count() {
        return session.selectOne(namespace + "count");
    }

    @Override
    public UserDetailsDto selectByUserEmail(String user_email) {
        return session.selectOne(namespace + "selectByUserEmail", user_email);
    }






}
