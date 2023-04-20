package project.nectar.service;

import project.nectar.domain.AdminDto;
import project.nectar.domain.BizAccountDto;
import project.nectar.domain.UserDto;

public interface UserService {
    // 회원이 입력한 pwd 를 암호화해서 db에 저장
    int RegisterUser(UserDto userDto) throws Exception;

    int RegisterBiz(BizAccountDto bizAccountDto) throws Exception;

    int RegisterAdmin(AdminDto adminDto) throws Exception;
}
