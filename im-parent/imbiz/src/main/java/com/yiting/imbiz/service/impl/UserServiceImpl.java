package com.yiting.imbiz.service.impl;

import com.yiting.imbiz.entity.Login;
import com.yiting.imbiz.entity.User;
import com.yiting.imbiz.repository.LoginRepository;
import com.yiting.imbiz.repository.UserRepository;
import com.yiting.imbiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;

    /**
     * 登录
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public Login login(String account, String password) {
        User user = userRepository.findByAccount(account);
        if (user != null && password != null && user.getPassword().equals(password)) {
            Login login = loginRepository.findByUin(user.getUin());
            if (login == null) {
                login = new Login();
            }
            login.setUin(user.getUin());
            login.setAuthToken(UUID.randomUUID().toString());
            login.setActiveTime(System.currentTimeMillis());
            loginRepository.save(login);
            return login;
        }
        return null;
    }

    @Override
    public User findByUin(long uin) {
        return userRepository.findByUin(uin);
    }

    /**
     * 验证 Token
     *
     * @param uin
     * @param token
     * @return
     */
    @Override
    public boolean authenticate(Long uin, String token) {
        Login login = loginRepository.findByUin(uin);
        if (login != null && token != null) {
            return login.getAuthToken().equals(token);
        }
        return false;
    }


}
