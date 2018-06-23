package com.sinosoft.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sinosoft.authoriy.Authoriy;
import com.sinosoft.base.Constants;
import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.frame.service.UserExistsException;
import com.sinosoft.role.Role;
import com.sinosoft.util.DateTimeUtils;


/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service
public class UserManagerImpl extends GenericManagerImpl<User, Long> implements UserManager {
    private UserDao userDao;


    @Autowired
    public void setUserDao(UserDao userDao) {
        this.dao = userDao;
        this.userDao = userDao;
    }

    /**
     * {@inheritDoc}
     */
    public User getUser(String userId) {
        return userDao.loadUserByUserid(new Long(userId));
    }

    /**
     * {@inheritDoc}
     */
    public List<User> getUsers() {
        return userDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    public User saveOrUpdateUser(User user) throws UserExistsException {
    	if(user!=null && user.getPassword()!=null && user.getPassword().length()<20)
    	{
    		String password = user.getPassword();
    		String shap = new Sha256Hash(password).toHex();
    		user.setPassword(shap);
    	}
        return userDao.saveOrUpdateUser(user);
    }
    
    public void SaveUser(User user)
    {
    	String password = user.getPassword();
		String shap = new Sha256Hash(password).toHex();
		
		user.setPassword(shap);
		user.setIslocked(new Long(Constants.USER_NOLOCK));
		user.setRegistertime(new Date());
    	userDao.SaveUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public boolean removeUser(String userId) {
        log.debug("removing user: " + userId);
        return userDao.removeUser(new Long(userId));
    }

    /**
     * {@inheritDoc}
     *
     * @param username the login name of the human
     * @return User the populated user object
     * @throws UsernameNotFoundException thrown when username not found
     */
    public User getUserByUsername(String username){
    	User user = userDao.loadUserByUsername(username);
    	Set<Role> roles = user.getRoles();
    	Map<Long,String> authoriymap = new HashMap<Long, String>();
    	for (Role role : roles) {
			Set<Authoriy> authoriys = role.getAuthoriy();
			for (Authoriy authoriy : authoriys) {
				authoriymap.put(authoriy.getAuthoriyid(), authoriy.getAuthoriyname());
			}
		}
    	user.setAuthoriy(authoriymap);
    	return user;
    }

    /**
     * {@inheritDoc}
     */
    public List<User> searchUser(User user) {
    	String name = user.getUsername();
    	String realname = user.getRealname();
    	String company = user.getCompany();
    	String territory = user.getTerritory();
    	String lawyername = user.getLawyername();
    	Long islocked = user.getIslocked();
    	String country = user.getCountry();
    	String province = user.getProvince();
    	String city = user.getCity();
    	String county = user.getCounty();
    	String starttime = user.getStarttime();
    	String endtime = user.getEndtime();
    	StringBuffer hqls = new StringBuffer("from User where 1=1");
		hqls.append(name!=null&&!"".equals(name)?" and username like '%"+name.trim()+"%'":"");
		hqls.append(realname!=null&&!"".equals(realname)?" and realname like '%"+realname.trim()+"%'":"");
		hqls.append(company!=null&&!"".equals(company)?" and company like '%"+company.trim()+"%'":"");
		hqls.append(territory!=null&&!"".equals(territory)?" and territory like '%"+territory.trim()+"%'":"");
		hqls.append(lawyername!=null&&!"".equals(lawyername)?" and lawyername like '%"+lawyername.trim()+"%'":"");
		hqls.append(islocked!=null&&islocked!=0?" and islocked = "+islocked+"":"");
		hqls.append(country!=null&&!"".equals(country)?" and country = '"+country.trim()+"'":"");
		hqls.append(province!=null&&!"".equals(province)?" and province = '"+province.trim()+"'":"");
		hqls.append(city!=null&&!"".equals(city)?" and city = '"+city.trim()+"'":"");
		hqls.append(county!=null&&!"".equals(county)?" and county = '"+county+"'":"");
		hqls.append(starttime!=null&&!"".equals(starttime)?" and registertime > to_date('"+starttime+"','yyyy-MM-dd HH24:mi:ss')":"");
		hqls.append(endtime!=null&&!"".equals(endtime)?" and registertime < to_date('"+endtime+"','yyyy-MM-dd HH24:mi:ss')":"");
        return userDao.searchUserList(hqls.toString());
    }
    
    public int getOrderInfoCount(User user)
    {
    	String name = user.getUsername();
    	String realname = user.getRealname();
    	String company = user.getCompany();
    	String territory = user.getTerritory();
    	String lawyername = user.getLawyername();
    	Long islocked = user.getIslocked();
    	String country = user.getCountry();
    	String province = user.getProvince();
    	String city = user.getCity();
    	String county = user.getCounty();
    	String starttime = user.getStarttime();
    	String endtime = user.getEndtime();
    	StringBuffer hqls = new StringBuffer("select count(*) from trthr_User where 1=1");
		hqls.append(name!=null&&!"".equals(name)?" and username like '%"+name.trim()+"%'":"");
		hqls.append(realname!=null&&!"".equals(realname)?" and realname like '%"+realname.trim()+"%'":"");
		hqls.append(company!=null&&!"".equals(company)?" and company like '%"+company.trim()+"%'":"");
		hqls.append(territory!=null&&!"".equals(territory)?" and territory like '%"+territory.trim()+"%'":"");
		hqls.append(lawyername!=null&&!"".equals(lawyername)?" and lawyername like '%"+lawyername.trim()+"%'":"");
		hqls.append(islocked!=null&&islocked!=0?" and islocked = "+islocked+"":"");
		hqls.append(country!=null&&!"".equals(country)?" and country = '"+country.trim()+"'":"");
		hqls.append(province!=null&&!"".equals(province)?" and province = '"+province.trim()+"'":"");
		hqls.append(city!=null&&!"".equals(city)?" and city = '"+city.trim()+"'":"");
		hqls.append(county!=null&&!"".equals(county)?" and county = '"+county+"'":"");
		hqls.append(starttime!=null&&!"".equals(starttime)?" and registertime >'"+starttime+"'":"");
		hqls.append(endtime!=null&&!"".equals(endtime)?" and registertime < '"+endtime+"'":"");
		hqls.append(" and company is NULL ");
        return userDao.getUserCount(hqls.toString());
    }
    
    @SuppressWarnings("unchecked")
	public List<User> getUserlistByPage(User user,int first,int pagesize)
    {
    	Map map = new HashMap();
    	StringBuffer queryHql = new StringBuffer();
    	queryHql.append("from User where 1=1");
    	String username = user.getUsername();//用户名
		String realname = user.getRealname();//真实姓名
		String lawyername = user.getLawyername();//公司法人
		String province = user.getProvince();//省
		String city = user.getCity();//市
		Long islock = user.getIslocked();//是否锁定
		String company = user.getCompany();//注册公司
		String starttime = user.getStarttime();//开始时间
		String endtime = user.getEndtime();//结束时间
		String territory = user.getTerritory();//应用领域
		String country = user.getCountry();//国家
		String county = user.getCounty();//县
		if(username!=null&&!username.isEmpty())
		{
			map.put("username", "%"+username+"%");
			queryHql.append(" and username like:username");
		}
		if(realname!=null&&!realname.isEmpty())
		{
			map.put("realname", "%"+realname+"%");
			queryHql.append(" and realname like:realname");
		}
		if(lawyername!=null&&!lawyername.equals(""))
		{
			map.put("lawyername", "%"+lawyername+"%");
			queryHql.append(" and lawyername like:lawyername");
		}
		if(province!=null&&!province.isEmpty())
		{
			map.put("province", province);
			queryHql.append(" and province=:province");
		}
		if(city != null && !city.isEmpty())
		{
			map.put("city", "%"+city+"%");
			queryHql.append(" and city like:city");
		}
		if(company != null && !company.isEmpty())
		{
			map.put("company", "1");
			queryHql.append(" and company  != :company");
		}
		if(islock != null && !islock.equals(""))
		{
			map.put("islock", islock);
			queryHql.append(" and islocked=:islock");
		}
		if(territory != null && !territory.isEmpty())
		{
			map.put("territory", territory);
			queryHql.append(" and territory=:territory");
		}
		if(country != null && !country.isEmpty())
		{
			map.put("country", country);
			queryHql.append(" and country=:country");
		}
		if(starttime != null && !starttime.isEmpty())
		{
			map.put("starttime", DateTimeUtils.StringToDate(starttime,"yyyy-MM-dd"));
			queryHql.append(" and registertime>:starttime");
		}
		if(endtime != null && !endtime.isEmpty())
		{
			map.put("endtime", DateTimeUtils.StringToDate(endtime,"yyyy-MM-dd"));
			queryHql.append(" and registertime<:endtime");
		}
		if(county != null && !county.isEmpty())
		{
			map.put("county", county);
			queryHql.append(" and county=:county");
		}
		//map.put("company", "1");
		queryHql.append(" and company is NULL ");
		queryHql.append(" order by registertime desc");
    	return userDao.getUserlistByPage(queryHql.toString(),map, first, pagesize);
    }

	public int isUnique(String username, String email) {
		return userDao.isUnique(username, email);
	}
}
