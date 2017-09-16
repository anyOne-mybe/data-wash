
package com.hrsj.demo.facade.user.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.hrsj.demo.commom.util.ExceptionHandler;
import com.hrsj.demo.domain.common.PagedResult;
import com.hrsj.demo.domain.common.Pager;
import com.hrsj.demo.domain.common.ServiceResponse;
import com.hrsj.demo.domain.user.User;
import com.hrsj.demo.facade.user.IUserFacade;
import com.hrsj.demo.service.user.IUserService;

@Named
public class UserFacadeImpl implements IUserFacade
{

    @Inject
    private IUserService userService;

    @Override
    public ServiceResponse<User> getUserById( Long userId )
    {
        ServiceResponse<User> response = new ServiceResponse<User>();

        try
        {
            User data = userService.getUserById( userId );
            response.setData( data );
        } catch ( Exception e )
        {
            ExceptionHandler.handleException( response, e );
        }

        return response;
    }

    @Override
    public ServiceResponse<PagedResult<List<User>>> listUserByAge( int age,
            Pager pager )
    {
        ServiceResponse<PagedResult<List<User>>> response = new ServiceResponse<PagedResult<List<User>>>();

        try
        {
            PagedResult<List<User>> data = userService.listUserByAge( age,
                    pager );
            response.setData( data );
        } catch ( Exception e )
        {
            ExceptionHandler.handleException( response, e );
        }

        return response;
    }

}
