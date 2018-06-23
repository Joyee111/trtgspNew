package com.sinosoft.user;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.base.GenericDao;

/**
 * User Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface UserDao extends GenericDao<User, Long> {

    /**
     * Gets users information based on login name.
     * @param username the user's username
     * @return userDetails populated userDetails object
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException thrown when user not
     * found in database
     */
    @Transactional
    User loadUserByUsername(String username);

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of users
     */
    List<User> getUsers();

    /**
     * Saves a user's information.
     * @param user the object to be saved
     * @return the persisted User object
     */
    User saveOrUpdateUser(User user);

    /**
     * Retrieves the password in DB for a user
     * @param username the user's username
     * @return the password in DB, if the user is already persisted
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    String getUserPassword(String username);
    
    @Transactional
    User loadUserByUserid(long userid);
    
    boolean removeUser(long userId);
    
    int isUnique(String username,String email);
    
    List<User> searchUserList(String hqls);
    
    public void SaveUser(User user);
    /**
     * 根据sql语句查询用户总数量
     * @param sql
     * @return
     */
    public int getUserCount(String sql);
    
    /**
     * 根据条件和分页条件查询用户
     * @param user
     * @param first
     * @param pagesize
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<User> getUserlistByPage(String hql,Map map,int first,int pagesize);
    
    /**
     * 添加用户统计信息
     * @param sqls
     * @return
     */
    public int InsertUserCount(String sqls);
}
