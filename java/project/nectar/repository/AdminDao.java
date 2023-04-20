package project.nectar.repository;

import project.nectar.domain.AdminDetailsDto;
import project.nectar.domain.AdminDto;

public interface AdminDao {
    int insert(AdminDto adminDto);

    AdminDto select(String admin_email);

    int update(AdminDto adminDto);

    int delete(String admin_email);

    int deleteAll();

    int count();

    AdminDetailsDto selectByUserEmail(String admin_email);
}
