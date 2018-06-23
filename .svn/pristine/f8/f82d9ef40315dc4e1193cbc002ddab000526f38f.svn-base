package com.sinosoft.drugState.accepreturn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.accepreturn.dao.ReturnTaceItemDao;
import com.sinosoft.drugState.accepreturn.model.ReturncheckItem;
import com.sinosoft.drugState.accepreturn.service.ReturnTaceItemMng;

@Service
public class ReturnTaceItemMngImpl implements ReturnTaceItemMng{
	
	
	@Autowired
	private ReturnTaceItemDao returnTaceItemDao;
	
	@Override
	public void save(ReturncheckItem ch) {
		returnTaceItemDao.savech(ch);
	}

	@Override
	public void del(List<?> receItem) {
		
		for(int i=0;i<receItem.size();i++){
			returnTaceItemDao.del(receItem.get(i).toString());
		}
		
	}

	@Override
	public ReturncheckItem findById(String id) {
		return returnTaceItemDao.findById(id);
	}
}
