package com.sinosoft.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.Constants;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.util.SystemLogUtil;


/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve User objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *   Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 *   Extended to implement Acegi UserDetailsService interface by David Carter david@carter.net
 *   Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a> to work with 
 *   the new BaseDaoHibernate implementation that uses generics.
*/
@SuppressWarnings({"unchecked","deprecation"})
@Repository("userDao")
public class UserDaoHibernate extends GenericDaoHibernate<User, Long> implements UserDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public UserDaoHibernate() {
        super(User.class);
    }

    /**
     * {@inheritDoc}
     */
    public List<User> getUsers() {
        return getHibernateTemplate().find("from User u order by upper(u.username)");
    }

    /**
     * 
     * {@inheritDoc}
     */
    public User saveOrUpdateUser(User user) {
    	user = getHibernateTemplate().merge(user);
        return user;
    }
    
    /**
     * 保存用户
     */
    public void SaveUser(User user)
    {
    	getHibernateTemplate().save(user);
    }

    /** 
     * {@inheritDoc}
    */
	public User loadUserByUsername(String username){
        List users = getHibernateTemplate().find("from User where username=? and islocked="+Constants.USER_NOLOCK, username);
        if (users == null || users.isEmpty()) {
            return null;
        } else {
            return (User) users.get(0);
        }
    }

    /** 
     * {@inheritDoc}
    */
    public String getUserPassword(String username) {
        SimpleJdbcTemplate jdbcTemplate =
                new SimpleJdbcTemplate(SessionFactoryUtils.getDataSource(getSessionFactory()));
        Table table = AnnotationUtils.findAnnotation(User.class, Table.class);
        return jdbcTemplate.queryForObject(
                "select password from " + table.name() + " where username=?", String.class, username);

    }
    
	public User loadUserByUserid(long userid){
        List users = getHibernateTemplate().find("from User where id=?", userid);
        if (users == null || users.isEmpty()) {
            return null;
        } else {
            return (User) users.get(0);
        }
    }
	
	public int isUnique(String username, String email) {
//		final String sql = "select count(*) from zywx_user where username='"+username+"' or email='"+email+"'";
//		this.getSessionFactory().getCurrentSession().doWork(new Work() {
//			ResultSet rs = null;
//			Statement stmt = null;
//			public void execute(Connection connection) throws SQLException {
//				stmt = connection.createStatement(
//						ResultSet.TYPE_SCROLL_INSENSITIVE,
//						ResultSet.CONCUR_UPDATABLE);
//				rs = stmt.executeQuery(sql);
//				while(rs!=null && rs.next()){
//					count = rs.getInt(1);
//				}
//			}
//		});
		// 去点邮箱校验 lfl StringBuffer sql = new StringBuffer("select count(*) from trthr_user where( 1=1");
		StringBuffer sql = new StringBuffer("select count(*) from trthr_user where 1=1");
		//去掉用户邮箱校验 lfl sql.append(email!=null&&!email.isEmpty()?" and email='"+email+"')":")");
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		if(username!=null && !username.isEmpty())
		{
			//sql.append(username!=null&&!username.isEmpty()?" or username='"+username+"'":"");
			sql.append(username!=null&&!username.isEmpty()?" and username='"+username+"'":"");
		}
		Object obj = session.createSQLQuery(sql.toString()).uniqueResult();
		session.close();
		return Integer.parseInt(String.valueOf(obj));
	}
	
	public boolean removeUser(long userId) {
		List users = getHibernateTemplate().find("from User where id=?", userId);
		if(users != null && !users.isEmpty())
		{
			Connection conn=this.getHibernateTemplate().getSessionFactory().openSession().connection();
			User user = (User) users.get(0);
			if(user.getUsername().equals("admin"))
			{
				return false;
			}
			Statement stm = null;
            try {
            	stm = conn.createStatement();
            	stm.executeUpdate("delete from  trthr_user_roles where userid="+user.getId());
				stm.executeUpdate("delete from  trthr_user where userid="+user.getId());
			} catch (SQLException e1) {
				e1.printStackTrace();
				SystemLogUtil.saveError(Constants.LOG_ERROR, "UserDaoHibernate.removeUser======="+e1.getMessage());
			} 
			try {
				if(null != conn)
					conn.close();
				if(null != stm)
					stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	//用户查询
	public List<User> searchUserList(String hqls)
	{
		List<User> userlist = new ArrayList<User>();
		
		userlist = getHibernateTemplate().find(hqls.toString());
		return userlist;
	}
	

	public int getUserCount(String sql)
	{
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createSQLQuery(sql);
		int count = Integer.parseInt(query.list().get(0).toString());
		session.close();
		return count;
	}
	
	//根据条件和分页条件查询用户
	public List<User> getUserlistByPage(String hql,Map map,int first,int pagesize)
	{
		Session session =null;
		List<User> userlist = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			Iterator it = map.keySet().iterator();   
			while (it.hasNext())
			{
			    Object key = it.next();   
			    query.setParameter(key.toString(), map.get(key));   
			}
			userlist = query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return userlist;
	}
	
	/**
	 * 添加用户统计表信息
	 * @param sqls
	 * @return
	 */
	public int InsertUserCount(String sqls)
	{
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		SQLQuery query = session.createSQLQuery(sqls);
		int count = query.executeUpdate();
		session.close();
		return count;
	}
}
