package com.sinosoft.base;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>To register this class in your Spring context file, use the following XML.
 * <pre>
 *      &lt;bean id="fooDao" class="com.sinosoft.zywx3.dao.hibernate.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="com.sinosoft.zywx3.model.Foo"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 *
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */
public class GenericDaoHibernate<T extends Serializable, PK extends Serializable> implements GenericDao<T, PK> {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());
    private Class<T> persistentClass;
    private HibernateTemplate hibernateTemplate;
    private SessionFactory sessionFactory;

    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing.
     *
     * @param persistentClass the class type you'd like to persist
     */
    public GenericDaoHibernate(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    /**
     * Constructor that takes in a class and sessionFactory for easy creation of DAO.
     *
     * @param persistentClass the class type you'd like to persist
     * @param sessionFactory  the pre-configured Hibernate SessionFactory
     */
    public GenericDaoHibernate(final Class<T> persistentClass, SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public HibernateTemplate getHibernateTemplate() {
        return this.hibernateTemplate;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @Autowired
    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    /**
     * {@inheritDoc}
     */
    public List<T> getAll() {
        return hibernateTemplate.loadAll(this.persistentClass);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<T> getAllDistinct() {
        Collection result = new LinkedHashSet(getAll());
        return new ArrayList(result);
    }

    /**
     * {@inheritDoc}
     */
    public T get(PK id) {
        T entity = (T) hibernateTemplate.get(this.persistentClass, id);

        if (entity == null) {
            log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(this.persistentClass, id);
        }

        return entity;
    }

    @Override
    public T load(T obj) {
        T entity = (T) hibernateTemplate.get(this.persistentClass, obj);
        if (entity == null) {
            log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + obj + "' not found...");
            throw new ObjectRetrievalFailureException(this.persistentClass, obj);
        }
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exists(PK id) {
        T entity = (T) hibernateTemplate.get(this.persistentClass, id);
        return entity != null;
    }

    /**
     * {@inheritDoc}
     */
    public T save(T object) {
        return (T) hibernateTemplate.merge(object);
    }
    
    public void saveOrUpdate(T object){
    	hibernateTemplate.saveOrUpdate(object);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(PK id) {
        hibernateTemplate.delete(this.get(id));
    }

    @Override
    public void delete(T obj) {
        hibernateTemplate.delete(obj);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        String[] params = new String[queryParams.size()];
        Object[] values = new Object[queryParams.size()];
        
        int index = 0;
        for (String s : queryParams.keySet()) {
            params[index] = s;
            values[index++] = queryParams.get(s);
        }

        return hibernateTemplate.findByNamedQueryAndNamedParam(queryName, params, values);
    }
    
    
    
    

	public List<T> getListByPage(String hql,Map map,int first,int pagesize)
	{
		Session session =null;
		List<T> list = null;
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
			list = query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return list;
	}
    
	public int getRecordCount(String sql)
	{
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createSQLQuery(sql);
		int count = Integer.parseInt(query.list().get(0).toString());
//		int count = (Integer)query.uniqueResult();
		session.close();
		
		return count;
	}

	@SuppressWarnings("deprecation")
	public String getMaxcode(String columnTypeId) {
		String sql = "select MAX(code) as maxCode from BaseColumn where columnTypeId='"
			+ columnTypeId + "'";
		Connection conn = this.getHibernateTemplate().getSessionFactory()
				.openSession().connection();
		Statement stm;
		ResultSet rs;
		String maxCode = "";
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				maxCode = rs.getString("maxCode");
			}
			if (null != conn)
				conn.close();
			if (null != stm)
				stm.close();
		} catch (SQLException e) {
			
		}
		String code ="";
		Date date = new Date();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyyMMdd");
		String str = sdf.format(date);
		if (null==maxCode) {
			code = str + "_"+ columnTypeId+"_"+"01";
			return code;
		}

		String[] str1= maxCode.split("_");
		String str2 = str1[2];
		String str3="";
		int shu = Integer.valueOf(str2);
		shu=shu+1;
		if (shu<10) {
			 str3= "0"+shu;
		}
		else {
			str3 = ""+shu;
		}
		code = str + "_"+ columnTypeId+"_"+str3;
		return code;
	}
	@Override
	public List<T> getAllByState(String hql, Map map) {
		Session session = null;
		List<T> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			Iterator it = map.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
			}
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public void update(T object) {
		hibernateTemplate.update(object);
		
	}
}
