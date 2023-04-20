package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.AdminDetailsDto;
import project.nectar.domain.AdminDto;

@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "project.nectar.repository.AdminMapper.";

    @Override
    public int insert(AdminDto adminDto) {
        return session.insert(namespace + "insert", adminDto);
    }

    @Override
    public AdminDto select(String admin_email) {
        return session.selectOne(namespace + "select", admin_email);
    }

    @Override
    public int update(AdminDto adminDto) {
        return session.update(namespace + "update", adminDto);
    }

    @Override
    public int delete(String admin_email) {
        return session.delete(namespace + "delete", admin_email);
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
    public AdminDetailsDto selectByUserEmail(String admin_email) {
        return session.selectOne(namespace + "selectByUserEmail", admin_email);
    }


}
