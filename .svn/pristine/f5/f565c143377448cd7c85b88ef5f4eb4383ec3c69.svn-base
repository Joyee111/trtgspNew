package com.sinosoft.drugState.outcheck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.outcheck.dao.OutCheckItemDao;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.outcheck.service.OutCheckItemMng;

@Service
public class OutCheckItemMngImpl implements OutCheckItemMng{
	
	@Autowired
	private OutCheckItemDao outCheckItemDao;
	
	
	@Override
	public void save(OutboundCheckItem ch) {
		outCheckItemDao.savech(ch);
	}

	@Override
	public void del(List<?> receItem) {
		
		for(int i=0;i<receItem.size();i++){
			outCheckItemDao.del(receItem.get(i).toString());
		}
		
	}

	@Override
	public OutboundCheckItem findById(String id) {
		return outCheckItemDao.findById(id);
	}


}
