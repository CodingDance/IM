package com.yiting.imbiz.service;

import com.yiting.imbiz.entity.Login;
import com.yiting.imbiz.entity.User;

/**
 * Created by Tony on 2/20/15.
 */
public interface UserService {

    public Login login(String account, String password);

    public boolean authenticate(Long uin, String token);
        
    User findByUin(long uin);

}
