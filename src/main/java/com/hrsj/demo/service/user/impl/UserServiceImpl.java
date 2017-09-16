
package com.hrsj.demo.service.user.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.hrsj.demo.business.user.IUserBusiness;
import com.hrsj.demo.commom.exception.BaseBusinessException;
import com.hrsj.demo.commom.util.ParameterCheckUtil;
import com.hrsj.demo.domain.common.PagedResult;
import com.hrsj.demo.domain.common.Pager;
import com.hrsj.demo.domain.user.User;
import com.hrsj.demo.service.user.IUserService;

@Named
public class UserServiceImpl implements IUserService
{
    @Inject
    private IUserBusiness userBusiness;

    @Override
    public User getUserById( Long userId ) throws BaseBusinessException
    {
        // 入参简单校验
        ParameterCheckUtil.checkPameterNotNull( userId, "userId" );

        return userBusiness.getUserById( userId );
    }

    @Override
    public PagedResult<List<User>> listUserByAge( int age, Pager pager )
            throws BaseBusinessException
    {
        return userBusiness.listUserByAge( age, pager );
    }

}
