package com.yiting.imbiz.repository;


import com.yiting.imbiz.entity.User;
import org.springframework.stereotype.Repository;



/**
 * Created by Tony on 2/19/15.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByAccount(String account);

    User findByUin(long uin);

}
