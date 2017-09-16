
package com.hrsj.demo.action.user;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hrsj.demo.domain.common.PagedResult;
import com.hrsj.demo.domain.common.Pager;
import com.hrsj.demo.domain.common.ServiceResponse;
import com.hrsj.demo.domain.user.User;

@Path( "/user" )
@Produces( MediaType.APPLICATION_JSON )
public interface IUserAction
{

    /**
     * 根据用户id查询用户信息
     * 
     * @param userId
     * @return
     */
    @GET
    @Path( "/userInfo/{userId}" )
    ServiceResponse<User> getUserById( @PathParam( "userId" ) Long userId );

    /**
     * 根据年龄查询用户列表
     * 
     * @param age
     * @return
     */
    @GET
    @Path( "/listUserPage/{currentPage}/{pageSize}" )
    ServiceResponse<PagedResult<List<User>>> listUserByAge(
            @QueryParam( "age" ) int age, @PathParam( "" ) Pager pager );

    /**
     * 文件下载
     * 
     * @return
     */
    @GET
    @Path( "/pdf" )
    @Produces( MediaType.APPLICATION_OCTET_STREAM )
    Response downloadPDF();
}
