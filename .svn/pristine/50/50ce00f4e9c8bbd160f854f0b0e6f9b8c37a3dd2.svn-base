package com.sinosoft.role;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.Constants;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.util.SystemLogUtil;


/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Role objects.
 *
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a> 
 */
@SuppressWarnings("unchecked")
@Repository
public class RoleDaoHibernate extends GenericDaoHibernate<Role, Long> implements RoleDao {

    /**
     * Constructor to create a Generics-based version using Role as the entity
     */
    public RoleDaoHibernate() {
        super(Role.class);
    }

    /**
     * {@inheritDoc}
     */
	public Role getRoleByName(String rolename) {
        List roles = getHibernateTemplate().find("from Role where rolename=?", rolename);
        if (roles.isEmpty()) {
            return null;
        } else {
            return (Role) roles.get(0);
        }
    }
    
    

    @SuppressWarnings("deprecation")
	public void removeRole(long rid)
	{
		List rs = getHibernateTemplate().find("from Role where roleid=?", rid);
		if(rs == null || rs.isEmpty())
		{
			
		}
		else
		{
			Connection conn=this.getHibernateTemplate().getSessionFactory().openSession().connection();
			Role  role = (Role) rs.get(0);
			Statement stm = null;
            try {
            	stm = conn.createStatement();
            	stm.executeUpdate("delete from trthr_user_roles where rolesid="+role.getRoleid());
				stm.executeUpdate("delete from  trthr_role_authoriy where roleid="+role.getRoleid());
				stm.executeUpdate("delete from trthr_roles where roleid="+role.getRoleid());
			} catch (SQLException e1) {
				e1.printStackTrace();
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
	}
    
    public Role saveRole(Role role)
    {
    	getHibernateTemplate().saveOrUpdate(role);
    	return role;
    }

    /**
     * 
     */
	public List<Role> searchRolelistByRolename(String rolename) {
		List<Role> rolelist = null;
		String hqls = "";
		if(rolename != null && !"".equals(rolename))
		{
			hqls = "from Role where rolename like '%"+rolename+"%' order by createtime desc";
		}
		else
		{
			hqls = "from Role order by createtime desc";
		}
		rolelist = getHibernateTemplate().find(hqls);
		return rolelist;
	}

	public Role getRoleById(Long id) {
		String hqls = "from Role where roleid="+id;
		List<Role> rolelist = getHibernateTemplate().find(hqls);
		return rolelist!=null?rolelist.get(0):null;
	}
	
	/**
	 * 角色翻页查询
	 * sql查询语句
	 * map条件集合
	 * first开始下标
	 * pagesize页面显示数量
	 * @return 
	 */
	public List<Role> getRolelistByPage(String sql,Map map,int first,int pagesize)
	{
		List<Role> rolelist = new ArrayList<Role>();
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			Query query = session.createQuery(sql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			Iterator it = map.keySet().iterator();   
			while (it.hasNext())
			{
			    Object key = it.next();   
			    query.setParameter(key.toString(), map.get(key));   
			}
			rolelist = query.list();
		} catch (Exception e) {
			SystemLogUtil.saveError(Constants.LOG_ERROR, e.getMessage());
		}
		finally{
			session.close();
		}
		return rolelist;
	}
	
	/**
	 * 查询角色数量
	 * sql语句
	 * @return 返回角色数量
	 */
	public int getRolelistByPageCount(String sql)
	{
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		int count = 0;
		try {
			Query c = session.createSQLQuery(sql);
			Object obj = c.uniqueResult();
			count = (obj==null || "".equals(obj))?0:Integer.parseInt(obj.toString());
		} catch (Exception e) {
			SystemLogUtil.saveError(Constants.LOG_ERROR, e.getMessage());
		}
		finally
		{
			session.close();
		}
		return count;
	}
}
