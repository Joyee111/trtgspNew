package com.sinosoft.init;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sinosoft.authoriy.Authoriy;
import com.sinosoft.role.Role;

/**
 * Hibernate implementation of LookupDao.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@SuppressWarnings("unchecked")
@Repository
public class LookupDaoHibernate implements LookupDao {
    private Log log = LogFactory.getLog(LookupDaoHibernate.class);
    private HibernateTemplate hibernateTemplate;

    /**
     * Initialize LookupDaoHibernate with Hibernate SessionFactory.
     * @param sessionFactory
     */
    @Autowired
    public LookupDaoHibernate(final SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    /**
     * {@inheritDoc}
     */
    public List<Role> getRoles() {
        log.debug("Retrieving all role names...");

        return hibernateTemplate.find("from Role order by rolename");
    }
    
	public List<Authoriy> getAuthoriy()
    {
    	return hibernateTemplate.find("from Authoriy order by authoriyid");
    }
}
