package com.yiting.imbiz.repository;

import com.yiting.imbiz.entity.UserStatus;
import org.springframework.stereotype.Repository;

/**
 * Created by James on 2015/11/12 0012.
 */

@Repository
public interface UserStatusRepository  extends CrudRepository<UserStatus, Long> {

    UserStatus findByAccount(String account);

}
