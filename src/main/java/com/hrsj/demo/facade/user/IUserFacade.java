
package com.hrsj.demo.facade.user;

import java.util.List;

import com.hrsj.demo.domain.common.PagedResult;
import com.hrsj.demo.domain.common.Pager;
import com.hrsj.demo.domain.common.ServiceResponse;
import com.hrsj.demo.domain.user.User;

public interface IUserFacade
{

    ServiceResponse<User> getUserById( Long userId );

    ServiceResponse<PagedResult<List<User>>> listUserByAge( int age,
            Pager pager );

}
