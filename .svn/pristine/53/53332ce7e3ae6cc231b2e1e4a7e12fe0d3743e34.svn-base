package com.sinosoft.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.authoriy.Authoriy;
import com.sinosoft.frame.model.LabelValue;
import com.sinosoft.role.Role;


/**
 * Implementation of LookupManager interface to talk to the persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("lookupManager")
public class LookupManagerImpl implements LookupManager {
    @Autowired
    LookupDao dao;

    /**
     * {@inheritDoc}
     */
    public List<LabelValue> getAllRoles() {
        List<Role> roles = dao.getRoles();
        List<LabelValue> list = new ArrayList<LabelValue>();

        for (Role role1 : roles) {
            list.add(new LabelValue(role1.getRoleid()+"", role1.getRolename()));
        }

        return list;
    }
    
    public List<LabelValue> getAllAuthoriy() {
        List<Authoriy> permis = dao.getAuthoriy();
        List<LabelValue> list = new ArrayList<LabelValue>();

        for (Authoriy p : permis) {
            list.add(new LabelValue(p.getAuthoriyname(), p.getDescription()));
        }

        return list;
    }

	public List<Authoriy> getAllAuthoriyList() {
		List<Authoriy> permis = dao.getAuthoriy();
        return permis;
	}

	public List<Role> getAllRolesList() {
		List<Role> roles = dao.getRoles();
        return roles;
	}
}
