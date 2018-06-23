package com.sinosoft.role;

import java.util.List;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface RoleManager{
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	List getRoles(Role role);

    /**
     * {@inheritDoc}
     */
    Role getRole(String rolename);

    /**
     * {@inheritDoc}
     */
    Role saveRole(Role role);

    /**
     * {@inheritDoc}
     */
    void removeRole(long rolename);
    
    List<Role> searchRolelistByRolename(String searchTerm);
    
    Role getRoleById(Long id);
    
    public List<Role> getRolelistByPage(String rolename,int first,int pagesize);
    
    public int getRolelistByPageCount(String rolename);
}
