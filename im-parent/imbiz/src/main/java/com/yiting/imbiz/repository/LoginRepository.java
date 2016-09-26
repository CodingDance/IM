package com.yiting.imbiz.repository;


import com.yiting.imbiz.entity.Login;

/**
 * Created by Tony on 2/20/15.
 */
public interface LoginRepository extends CrudRepository<Login, Long> {

    Login findByUin(long uin);

}
