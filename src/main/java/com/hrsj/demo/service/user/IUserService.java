
package com.hrsj.demo.service.user;

import java.util.List;

import com.hrsj.demo.commom.exception.BaseBusinessException;
import com.hrsj.demo.domain.common.PagedResult;
import com.hrsj.demo.domain.common.Pager;
import com.hrsj.demo.domain.user.User;

public interface IUserService
{
    /**
     * 根据用户id查询用户信息
     * 
     * @param userId
     * @return
     * @throws BaseBusinessException
     */
    User getUserById( Long userId ) throws BaseBusinessException;

    PagedResult<List<User>> listUserByAge( int age, Pager pager )
            throws BaseBusinessException;

}
