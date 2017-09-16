
package com.hrsj.demo.action.user.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.hrsj.demo.action.user.IUserAction;
import com.hrsj.demo.domain.common.PagedResult;
import com.hrsj.demo.domain.common.Pager;
import com.hrsj.demo.domain.common.ServiceResponse;
import com.hrsj.demo.domain.user.User;
import com.hrsj.demo.facade.user.IUserFacade;
import com.idea.it.core.permission.annotation.IdeaOperation;
import com.idea.it.core.permission.annotation.IdeaResource;
import com.idea.it.core.permission.enume.Policy;

@Named
@IdeaResource( code = "demo.user", desc = "用户模块" )
public class UserActionImpl implements IUserAction
{

    @Inject
    private IUserFacade userFacade;

    @Override
    @IdeaOperation( policy = Policy.Required, code = "getUserById", desc = "根据id查询用户" )
    public ServiceResponse<User> getUserById( Long userId )
    {
        return userFacade.getUserById( userId );
    }

    @Override
    @IdeaOperation( policy = Policy.Required, code = "listUserByAge", desc = "根据年龄分页查询用户" )
    public ServiceResponse<PagedResult<List<User>>> listUserByAge( int age,
            Pager pager )
    {

        return userFacade.listUserByAge( age, pager );
    }

    @Override
    public Response downloadPDF()
    {
        File file = new File( "D:\\Adobe Photoshop CS6中文版经典教程.pdf" );
        long fileLength = file.length();
        ResponseBuilder responseBuilder = Response.ok( file );
        responseBuilder.type( "application/pdf" );

        try
        {
            responseBuilder
                    .header( "Content-Disposition",
                            "inline; filename=" + URLEncoder.encode(
                                    "1Adobe Photoshop CS6中文版经典教程.pdf",
                                    "UTF-8" ) );
        } catch ( UnsupportedEncodingException e )
        {
            e.printStackTrace();
        }
        responseBuilder.header( "Content-Length", Long.toString( fileLength ) );
        Response response = responseBuilder.build();
        return response;
    }

}
