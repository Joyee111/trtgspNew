package com.sinosoft.authoriy;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;

@Repository
@SuppressWarnings({"unchecked","deprecation"})
public class AuthoriyDaoHibernate extends GenericDaoHibernate<Authoriy, Long> implements AuthoriyDao {
 
	public AuthoriyDaoHibernate() {
		super(Authoriy.class);
	}

	public Authoriy getAuthoriy(String pname) {
		List authoriy = getHibernateTemplate().find("from authoriy where authoriyname=?", pname);
        if (authoriy.isEmpty()) {
            return null;
        } else {
            return (Authoriy) authoriy.get(0);
        }
	}
	
	public void removeAuthoriy(long pid)
	{
		List ps = getHibernateTemplate().find("from Authoriy where authoriyid=?", pid);
		if(ps == null || ps.isEmpty())
		{
			
		}
		else
		{
			Connection conn=this.getHibernateTemplate().getSessionFactory().openSession().connection();
			Authoriy  pero = (Authoriy) ps.get(0);
			Statement stm = null;
            try {
            	stm = conn.createStatement();
            	stm.executeUpdate("delete from trthr_role_authoriy where authoriyid="+pero.getAuthoriyid());
				stm.executeUpdate("delete from trthr_authoriy where authoriyid="+pero.getAuthoriyid());
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
	
	/**
	 * 保存资源
	 */
	public Authoriy saveAuthoriy(Authoriy auth)
	{
		getHibernateTemplate().saveOrUpdate(auth);
		return auth;
	}

	public int getAuthoriyCount(String sql) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query c = session.createSQLQuery(sql);
		int count = Integer.parseInt(c.list().get(0).toString());
		session.close();
		return count;
	}
	
	public List<Authoriy> getAuthoriyList(Authoriy authoriy,int first,int pagesize)
	{
		Session session =null;
		List<Authoriy> authoriylist = null;
		session=this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria c = session.createCriteria(Authoriy.class);
		c.setFirstResult(first);
		c.setMaxResults(pagesize);
		String authoriyname = authoriy.getAuthoriyname();
		String description = authoriy.getDescription();
		if(authoriyname!=null&&!authoriyname.isEmpty())
		{
			c.add(Restrictions.like("authoriyname", "%"+authoriyname+"%"));
		}
		if(description!=null&&!description.isEmpty())
		{
			c.add(Restrictions.like("description", "%"+description+"%"));
		}
		c.addOrder(Order.desc("authoriyid"));
		authoriylist = c.list();
		session.close();
		return authoriylist;
	}
	
	public List<Authoriy> getParentAuthoriyList()
	{
		String sql = "from Authoriy where parentid=-1";
		List<Authoriy> parentlist = getHibernateTemplate().find(sql);
		return parentlist;
	}

    @Override
    public List<Authoriy> getAuthoriyListByParentId(Long parentId) {
        String sql = "from Authoriy where parentid="+parentId;
        List<Authoriy> childrenList = getHibernateTemplate().find(sql);
        return childrenList;
    }
}
