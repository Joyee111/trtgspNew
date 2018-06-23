package com.sinosoft.authoriy;

import java.util.List;

import com.sinosoft.base.GenericDao;

public interface AuthoriyDao extends GenericDao<Authoriy, Long>{
	Authoriy getAuthoriy(String pname);
	
	void removeAuthoriy(long pid);
	
	Authoriy saveAuthoriy(Authoriy auth);
	
	int getAuthoriyCount(String sql);
	
	public List<Authoriy> getAuthoriyList(Authoriy authoriy,int first,int pagesize);
	
	/**
	 * 查询父资源列表
	 * @return
	 */
	public List<Authoriy> getParentAuthoriyList();

    List<Authoriy> getAuthoriyListByParentId(Long parentId);
}
