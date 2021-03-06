package com.sinosoft.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.compass.core.CompassHit;
import org.compass.core.support.search.CompassSearchCommand;
import org.compass.core.support.search.CompassSearchHelper;
import org.compass.core.support.search.CompassSearchResults;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>To register this class in your Spring context file, use the following XML.
 * <pre>
 *     &lt;bean id="userManager" class="com.sinosoft.zywx3.service.impl.GenericManagerImpl"&gt;
 *         &lt;constructor-arg&gt;
 *             &lt;bean class="com.sinosoft.zywx3.dao.hibernate.GenericDaoHibernate"&gt;
 *                 &lt;constructor-arg value="com.sinosoft.zywx3.model.User"/&gt;
 *                 &lt;property name="sessionFactory" ref="sessionFactory"/&gt;
 *             &lt;/bean&gt;
 *         &lt;/constructor-arg&gt;
 *     &lt;/bean&gt;
 * </pre>
 * <p/>
 * <p>If you're using iBATIS instead of Hibernate, use:
 * <pre>
 *     &lt;bean id="userManager" class="com.sinosoft.zywx3.service.impl.GenericManagerImpl"&gt;
 *         &lt;constructor-arg&gt;
 *             &lt;bean class="com.sinosoft.zywx3.dao.ibatis.GenericDaoiBatis"&gt;
 *                 &lt;constructor-arg value="com.sinosoft.zywx3.model.User"/&gt;
 *                 &lt;property name="dataSource" ref="dataSource"/&gt;
 *                 &lt;property name="sqlMapClient" ref="sqlMapClient"/&gt;
 *             &lt;/bean&gt;
 *         &lt;/constructor-arg&gt;
 *     &lt;/bean&gt;
 * </pre>
 *
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class GenericManagerImpl<T, PK extends Serializable> implements GenericManager<T, PK> {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * GenericDao instance, set by constructor of child classes
     */
    protected GenericDao<T, PK> dao;

    @Autowired
    private CompassSearchHelper compass;

    public GenericManagerImpl() {
    }

    public GenericManagerImpl(GenericDao<T, PK> genericDao) {
        this.dao = genericDao;
    }

    /**
     * {@inheritDoc}
     */
    public List<T> getAll() {
        return dao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    public T get(PK id) {
        return dao.get(id);
    }

    @Override
    public T load(T obj) {
        return dao.load(obj);
    }

    /**
     * {@inheritDoc}
     */
    public boolean exists(PK id) {
        return dao.exists(id);
    }

    /**
     * {@inheritDoc}
     */
    public T save(T object) {
        return dao.save(object);
    }

    public void saveOrUpdate(T object){
    	dao.saveOrUpdate(object);
    }
    /**
     * {@inheritDoc}
     */
    public void remove(PK id) {
        dao.remove(id);
    }

    @Override
    public void delete(T obj) {
        dao.delete(obj);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * Search implementation using Compass.
     */
    @SuppressWarnings("unchecked")
    public List<T> search(String q, Class clazz) {
        if (q == null || "".equals(q.trim())) {
            return getAll();
        }

        List<T> results = new ArrayList<T>();

        CompassSearchCommand command = new CompassSearchCommand(q);
        CompassSearchResults compassResults = compass.search(command);
        CompassHit[] hits = compassResults.getHits();

        if (log.isDebugEnabled() && clazz != null) {
            log.debug("Filtering by type: " + clazz.getName());
        }

        for (CompassHit hit : hits) {
            if (clazz != null) {
                if (hit.data().getClass().equals(clazz)) {
                    results.add((T) hit.data());
                }
            } else {
                results.add((T) hit.data());
            }
        }

        if (log.isDebugEnabled()) {
            log.debug("Number of results for '" + q + "': " + results.size());
        }

        return results;
    }
    
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams){
    	return dao.findByNamedQuery(queryName, queryParams);
    }

	public String getMaxcode(String columnTypeId) {
		return dao.getMaxcode(columnTypeId);
	}
	
	public int getRecordCount(String sql){
		return dao.getRecordCount(sql);
	}

	@Override
	public List<T> getAllByState(String hql, Map map) {
		// TODO Auto-generated method stub
		return dao.getAllByState(hql, map);
	}

	@Override
	public List<T> getListByPage(String hql, Map map, int first, int pagesize) {
		// TODO Auto-generated method stub
		return dao.getListByPage(hql, map, first, pagesize);
	}

	@Override
	public void update(T object) {
		
		
	}
}
