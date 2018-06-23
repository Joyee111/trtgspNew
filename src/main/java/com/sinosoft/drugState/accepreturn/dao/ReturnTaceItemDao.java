package com.sinosoft.drugState.accepreturn.dao;

import com.sinosoft.drugState.accepreturn.model.ReturncheckItem;

public interface ReturnTaceItemDao {
	
	void savech(ReturncheckItem ch);

	void del(String string);

	ReturncheckItem findById(String id);

}
