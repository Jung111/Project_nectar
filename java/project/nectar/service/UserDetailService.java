package project.nectar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.nectar.domain.AdminDetailsDto;
import project.nectar.domain.BizAccountDetailsDto;
import project.nectar.domain.UserDetailsDto;
import project.nectar.repository.AdminDao;
import project.nectar.repository.BizAccountDao;
import project.nectar.repository.UserDao;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BizAccountDao bizAccountDao;
    @Autowired
    private AdminDao adminDao;




    @Override
    public UserDetails loadUserByUsername(String user_email) throws UsernameNotFoundException {
        AdminDetailsDto adminDetailsDto = adminDao.selectByUserEmail(user_email);
        if (adminDetailsDto != null) {
            return adminDetailsDto;
        }
        BizAccountDetailsDto bizAccountDetailsDto = bizAccountDao.selectByUserEmail(user_email);
        if (bizAccountDetailsDto != null) {
            return bizAccountDetailsDto;
        }
        UserDetailsDto userDetailsDto = userDao.selectByUserEmail(user_email);
        if (userDetailsDto == null) {
            throw new UsernameNotFoundException("username" + user_email + " not found");
        }

        return userDetailsDto;


    }
}
