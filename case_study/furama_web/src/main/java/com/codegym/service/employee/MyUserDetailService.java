package com.codegym.service.employee;

import com.codegym.model.employee.MyUserDetail;
import com.codegym.model.employee.User;
import com.codegym.repository.employee.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = iUserRepository.findByUsername(username);
       if (user == null) {
           throw new UsernameNotFoundException("Không tìm thấy tài khoản");
       }
        return new MyUserDetail(user);
    }
}
