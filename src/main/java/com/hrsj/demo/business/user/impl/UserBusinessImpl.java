
package com.hrsj.demo.business.user.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.hrsj.demo.business.user.IUserBusiness;
import com.hrsj.demo.commom.exception.BaseBusinessException;
import com.hrsj.demo.data.user.IUserData;
import com.hrsj.demo.domain.common.PagedResult;
import com.hrsj.demo.domain.common.Pager;
import com.hrsj.demo.domain.user.User;

@Named
public class UserBusinessImpl implements IUserBusiness
{
    @Inject
    private IUserData userData;

    @Override
    public User getUserById( Long userId ) throws BaseBusinessException
    {
        return userData.getUserById( userId );
    }

    @Override
    public PagedResult<List<User>> listUserByAge( int age, Pager pager )
            throws BaseBusinessException
    {
        return userData.listUsersPage( pager, age );
    }

}
