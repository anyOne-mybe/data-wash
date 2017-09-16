
package com.hrsj.demo.data.user;
/**  
* 类说明   
*  
* @author ****  
* @date 2017年8月4日  新建  
*/

import java.util.List;

import com.hrsj.demo.domain.common.PagedResult;
import com.hrsj.demo.domain.common.Pager;
import com.hrsj.demo.domain.user.User;

public interface IUserData
{
    /**
     * 根据用户id查询用户
     * 
     * @param userId
     * @return
     */
    User getUserById( Long userId );

    /**
     * 批量查询用户
     * 
     * @param userIds
     * @return
     */
    List<User> getUserByIds( List<Long> userIds );

    /**
     * 分页查询用户
     * 
     * @param pager
     * @param age
     * @return
     */
    PagedResult<List<User>> listUsersPage( Pager pager, int age );
}
