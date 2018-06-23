package com.sinosoft.drugState.outcheck.dao;


import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;

public interface OutCheckItemDao {

	void savech(OutboundCheckItem ch);

	void del(String id);
	
	OutboundCheckItem findById( String id);


}
