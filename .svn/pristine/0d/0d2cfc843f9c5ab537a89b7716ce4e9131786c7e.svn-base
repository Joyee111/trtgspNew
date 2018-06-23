package com.sinosoft.authoriy;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;

@Service
public class AuthoriyManagerImpl extends GenericManagerImpl<Authoriy, Long> implements AuthoriyManager {
	AuthoriyDao pdao;
	
	@Autowired
	public AuthoriyManagerImpl(AuthoriyDao pdao)
	{
		super(pdao);
		this.pdao = pdao;
	}
	
	public Authoriy getAuthoriy(String pname) {
		return pdao.getAuthoriy(pname);
	}

	public List<Authoriy> search(String searchTerm) {
		return super.search(searchTerm, Authoriy.class);
	}

	public void removeAuthoriy(long pid)
	{
		pdao.removeAuthoriy(pid);
	}
	
	public Authoriy saveAuthoriy(Authoriy auth)
	{
		auth.setCreatetime(new Date());
		if(auth.getParentid()==null || auth.getParentid().equals(""))
		{
			auth.setParentid(new Long(-1));
		}
		return pdao.saveAuthoriy(auth);
	}

	public int getAuthoriyCount(Authoriy authoriy) {
		String name = authoriy.getAuthoriyname();
		String description = authoriy.getDescription();
		StringBuffer sql =  new StringBuffer("select count(*) from trthr_authoriy where 1=1");
		sql.append(name!=null&&!"".equals(name)?" and authoriyname like '%"+name+"%'":"");
		sql.append(description!=null&&!"".equals(description)?" and description like '%"+description+"%'":"");
		return pdao.getAuthoriyCount(sql.toString());
	}
	
	public List<Authoriy> getAuthoriyList(Authoriy authoriy,int pagesize,int page)
	{
		return pdao.getAuthoriyList(authoriy, pagesize,page);
	}
	
	public List<Authoriy> getParentAuthoriyList()
	{
		return pdao.getParentAuthoriyList();
	}

    @Override
    public List<Authoriy> getAuthoriyListByParentId(Long parentId) {
        return pdao.getAuthoriyListByParentId(parentId);
    }
}
