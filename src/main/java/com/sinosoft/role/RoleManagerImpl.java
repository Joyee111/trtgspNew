package com.sinosoft.role;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of RoleManager interface.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
@Service("roleManager")
public class RoleManagerImpl implements RoleManager {
    RoleDao roleDao;

    @Autowired
    public RoleManagerImpl(RoleDao roleDao) {
//        super(roleDao);
        this.roleDao = roleDao;
    }

    /**
     * {@inheritDoc}
     */
    public List<Role> getRoles(Role role) {
        return roleDao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    public Role getRole(String rolename) {
        return roleDao.getRoleByName(rolename);
    }

    /**
     * {@inheritDoc}
     */
    public Role saveRole(Role role) {
    	Date date = new Date();
    	role.setCreatetime(date);
        return roleDao.saveRole(role);
    }

    /**
     * {@inheritDoc}
     */
    public void removeRole(long roldid) {
        roleDao.removeRole(roldid);
    }
    
    /**
     * {@inheritDoc}
     */
    public List<Role> searchRolelistByRolename(String searchTerm) {
        return roleDao.searchRolelistByRolename(searchTerm);
    }

	public Role getRoleById(Long id) {
		return roleDao.getRoleById(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getRolelistByPage(String rolename,int first,int pagesize)
    {
		Map map = new HashMap();
		StringBuffer sql = new StringBuffer("from Role where 1 = 1 ");
		if(rolename!=null&&!rolename.isEmpty())
		{
			map.put("rolename", "%"+rolename+"%");
			sql.append(" and rolename like:rolename");
		}
		sql.append(" order by roleid desc");
    	return roleDao.getRolelistByPage(sql.toString(),map,first, pagesize);
    }
	
	public int getRolelistByPageCount(String rolename)
	{
		StringBuffer queryHql = new StringBuffer();
    	queryHql.append("select count(*) from trthr_roles where 1=1");
    	queryHql.append((rolename!=null && !rolename.isEmpty())?" and rolename='"+rolename+"'":"");
    	return roleDao.getRolelistByPageCount(queryHql.toString());
	}
}