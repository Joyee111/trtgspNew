/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.sinosoft.role;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sinosoft.authoriy.Authoriy;

/**
 * Model object that represents a security role.
 */
@SuppressWarnings("serial")
@Entity
@Table(name="trthr_roles")
@Cache(usage= CacheConcurrencyStrategy.TRANSACTIONAL)
public class Role implements Serializable{

    private Long roleid;
    private String rolename;
    private String description;
    private Date createtime;
	private String createuser;

    private Set<Authoriy> authoriy = new HashSet<Authoriy>();

    public Role()
    {
    	
    }
    
    public Role(String rolename) {
        this.rolename = rolename;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ROLEID")
    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    @Basic(optional=false)
    @Column(name="rolename",length=100)
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Basic(optional=false)
    @Column(name="description",length=255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @ManyToMany(
            targetEntity=com.sinosoft.authoriy.Authoriy.class,
            cascade={CascadeType.ALL},
            fetch=FetchType.EAGER
        )
    @JoinTable(name="TRTHR_ROLE_AUTHORIY",joinColumns={@JoinColumn(name="roleid")},inverseJoinColumns={@JoinColumn(name="authoriyid")})
    public Set<Authoriy> getAuthoriy() {
        return authoriy;
    }

    public void setAuthoriy(Set<Authoriy> authoriy) {
        this.authoriy = authoriy;
    }
    
    @Column(name="CREATETIME")
    public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name="CREATEUSER",length=16)
	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
}


