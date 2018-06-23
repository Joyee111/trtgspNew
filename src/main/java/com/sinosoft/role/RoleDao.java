package com.sinosoft.role;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericDao;

/**
 * Role Data Access Object (DAO) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface RoleDao extends GenericDao<Role, Long> {
    /**
     * Gets role information based on rolename
     * @param rolename the rolename
     * @return populated role object
     */
    Role getRoleByName(String rolename);

    /**
     * Removes a role from the database by name
     * @param rolename the role's rolename
     */
    void removeRole(long rid);
    
    Role saveRole(Role role);
    
    List<Role> searchRolelistByRolename(String rolename);
    
    Role getRoleById(Long id);
    
    @SuppressWarnings("unchecked")
	public List<Role> getRolelistByPage(String sql,Map map,int first,int pagesize);
    
    public int getRolelistByPageCount(String sql);
}
