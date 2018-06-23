package com.sinosoft.varietyManger.firstVarietyManger.serivice;


import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;

public interface QualifiedmedcstoreReMng {
	public QualifiedmedcstoreRe updatequ(QualifiedmedcstoreRe qu);
	public QualifiedmedcstoreRe findReById(String id);
	public QualifiedmedcstoreRe save(QualifiedmedcstoreRe qu);
}
