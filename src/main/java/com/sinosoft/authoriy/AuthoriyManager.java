package com.sinosoft.authoriy;

import java.util.List;

import com.sinosoft.base.GenericManager;

public interface AuthoriyManager extends GenericManager<Authoriy, Long>{
	Authoriy getAuthoriy(String pname);
	
	List<Authoriy> search(String searchTerm);
	
	void removeAuthoriy(long pid);
	
	Authoriy saveAuthoriy(Authoriy auth);
	
	int getAuthoriyCount(Authoriy authoriy);
	
	public List<Authoriy> getAuthoriyList(Authoriy authoriy,int pagesize,int page);
	
	/**
	 * 查询父资源列表
	 * @return
	 */
	public List<Authoriy> getParentAuthoriyList();
	public List<Authoriy> getAuthoriyListByParentId(Long parentId);
}
