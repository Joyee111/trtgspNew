package com.sinosoft.drugState.purchaseNote.dao.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrder;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItemVO;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderVO;
import com.sinosoft.drugState.purchaseNote.dao.PurchaseNoteDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

@Repository("PurchaseNoteDao")
public class PurchaseNoteDaoImpl extends GenericDaoHibernate<PurchaseOrder, Long> implements PurchaseNoteDao{

	public PurchaseNoteDaoImpl() {
		super(PurchaseOrder.class);
	}

	@Override
	public List<PurchaseOrder> getPage(PurchaseOrder re, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer();
			if((re.getModifyDate()!=null && !"".equals(re.getModifyDate()))|| (re.getSeason()!=null && !"".equals(re.getSeason()))){
				hql=new StringBuffer(" select t from PurchaseOrder t,PurchaseOrderItem p where t.id=p.purchaseOrderId and 1=1 " );
				if(re.getSeason()!=null && !"".equals(re.getSeason())){
					hql.append(" and p.qualifiedMedicineId ="+re.getSeason());
				}if(re.getModifyDate()!=null && !"".equals(re.getModifyDate())){
					hql.append(" and p.batchProduction like '%"+re.getModifyDate()+"%'");
					}
			}else{
				hql=new StringBuffer("from PurchaseOrder where 1=1 " );
			}
			hql.append(" order by number desc ");
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		List<PurchaseOrder> res = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
			Session session = null;
			List<PurchaseOrder> res = null;
			try{
				session = this.getHibernateTemplate().getSessionFactory().openSession();
				Query query = session.createQuery(hql.toString());
				query.setFirstResult(i);
				query.setMaxResults(pagesize);
				res = query.list();
			}catch (RuntimeException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw e;
			}finally{
				if(session!=null)
					session.close();
			}
		return res;
	}
	@Override
	public int getTotalCount(PurchaseOrder re) {
		StringBuffer hql = new StringBuffer();
//		if(re!=null){
//			if(re.getCheckConclusion()==null || "".equals(re.getCheckConclusion())){
//				hql=new StringBuffer("select count(*) from PurchaseOrder t where 1=1" );
//				if(re.getDeliveryDate()!=null && !"".equals(re.getDeliveryDate())){
//					hql.append(" and t.deliveryDate like '%"+re.getDeliveryDate()+"%'");
//				}
//			}else{
//				hql=new StringBuffer("select count(*) from PurchaseOrder t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId " );
//				hql.append(" and q.customerName like '%"+re.getCheckConclusion()+"%' ");
//				if(re.getDeliveryDate()!=null && !"".equals(re.getDeliveryDate())){
//					hql.append(" and t.deliveryDate like '%"+re.getDeliveryDate()+"%'");
//				}
//			}
//		}else{
//			hql=new StringBuffer("select count(*) from PurchaseOrder t where 1=1" );
//		}
		if((re.getModifyDate()!=null && !"".equals(re.getModifyDate()))|| (re.getSeason()!=null && !"".equals(re.getSeason()))){
			hql=new StringBuffer(" select count(*) from PurchaseOrder t,PurchaseOrderItem p where t.id=p.purchaseOrderId and 1=1 " );
			if(re.getSeason()!=null && !"".equals(re.getSeason())){
				hql.append(" and p.qualifiedMedicineId ="+re.getSeason());
			}if(re.getModifyDate()!=null && !"".equals(re.getModifyDate())){
				hql.append(" and p.batchProduction like '%"+re.getModifyDate()+"%'");
				}
		}else{
			hql=new StringBuffer("select count(*) from PurchaseOrder where 1=1" );
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		int  a = Integer.parseInt(query.list().get(0).toString());
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		int a = 0;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			a = Integer.parseInt(query.list().get(0).toString());
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return a;
	}
	@Override
	public PurchaseOrder findById(String id) {
		Session session =null;
		PurchaseOrder purchaseOrder = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			purchaseOrder = (PurchaseOrder)session.get(PurchaseOrder.class, Long.parseLong(id));
			Hibernate.initialize(purchaseOrder.getQualifiedSupplierId().getAccessories());
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return purchaseOrder;
	}
	@Override
	public List<PurchaseOrderItem> findYp(Long id) {
		/*String hql = "select t from PurchaseOrderItem t where purchaseOrderId ="+id;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<PurchaseOrderItem> list= query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select t from PurchaseOrderItem t where purchaseOrderId =:id";
		Session session = null;
		List<PurchaseOrderItem> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			list= query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	@Override
	public PurchaseOrder saveReceivingNote(PurchaseOrder re) {
		PurchaseOrder res=getHibernateTemplate().merge(re);
		return res;
	}
	@Override
	public void  saveOrUpdateNote(PurchaseOrder re) {
		this.getHibernateTemplate().saveOrUpdate(re);
	}
	@Override
	public void del(String id) {
		PurchaseOrder re=findById(id);
		getHibernateTemplate().delete(re);
	}
	@Override
	public List<?> findAllId(String s) {
			/*String hql = "select t.id from PurchaseOrderItem t where purchaseOrderId ="+s;
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			List<?> list= query.list();
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		String hql = "select t.id from PurchaseOrderItem t where purchaseOrderId ="+s;
		Session session = null;
		List<?> list = null; 
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list= query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
			return list;
	}

	@Override
	public QualifiedSuppliers findByIdSy(String purchaseNoteMng) {
		Session session = null;
		QualifiedSuppliers quSuppliers = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			quSuppliers = (QualifiedSuppliers)session.get(QualifiedSuppliers.class, Long.parseLong(purchaseNoteMng));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return quSuppliers;
	}

	@Override
	public List<PurchaseOrderItem> findYPBybn(String id) {
		/*String hql = "select t from PurchaseOrderItem t where batchProduction ='"+id+"'";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<PurchaseOrderItem> list= query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		List<PurchaseOrderItem> list = new ArrayList<PurchaseOrderItem>();
		PurchaseOrderItem  orderItem = new PurchaseOrderItem();
	//	String hql = "select t from PurchaseOrderItem t where batchProduction =:id";
	//	List<PurchaseOrderItem> list=  null;
		Session session = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			orderItem = (PurchaseOrderItem) session.get(PurchaseOrderItem.class, Long.parseLong(id));
			list.add(orderItem);
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findPurchaseOrderByBathcNumer(
			String batchNumber) {
		List<Map<String, Object>> list = null;
		Session session = null;
		String[] strs = batchNumber.split(","); 
		try{
//			String sql = "select top 1 tax_price ,realname,modify_date from t_purchase_order p ,t_purchase_order_item i,TRTHR_USER u  where p.id = i.purchase_order_id  and p.user_USERID= u.USERID and i.batch_production=?";
			/*String sql = "SELECT TOP 1 i.tax_price,u.realname,cn.check_accept_date as modify_date,ci.end_time as enddate " +
					"FROM t_purchase_order p ,t_purchase_order_item i,t_check_accept_note cn,t_checkaccept_item ci ,TRTHR_USER u " +
					"WHERE p.id = i.purchase_order_id AND cn.id = ci.receiving_id AND p.user_USERID= u.USERID AND ci.batch_production = i.batch_production AND ci.quantity = i.quantity AND ci.qualified_medicine_id = i.qualified_medicine_id " +
					"AND p.id=? ";*/
			String sql = "SELECT TOP 1 i.tax_price,u.realname,i.end_time as enddate,p.check_accept_date as modify_date,i.erp_check,i.erp_receiver  " +
			"FROM t_purchase_order p ,t_purchase_order_item i,TRTHR_USER u " +
			"WHERE p.id = i.purchase_order_id AND p.user_USERID= u.USERID " +
			"AND p.id=? ";
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			query.setParameter(0, strs[0]);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
		return list;
	}

	@Override
	public List<Map<String, Object>> findOpeatorNameByBatchNumber(
			String batchNumber) {
		List<Map<String, Object>> list = null;
		Session session = null;
		String[] strs = batchNumber.split(",");
		try{
//			String sql = "select prTable.REALNAME as yanshouren,auTable.REALNAME as shenheren from t_check_accept_note cn ,t_checkaccept_item ci ,(select tcn.id ,tu.REALNAME from t_check_accept_note tcn ,TRTHR_USER tu where tcn.proposer_ID = tu.USERID) prTable,(select ttcn.id ,ttu.REALNAME from t_check_accept_note ttcn ,TRTHR_USER ttu where ttcn.accepterID = ttu.USERID) auTable where cn.id = ci.receiving_id and cn.id=prTable.id and cn.id = auTable.id and ci.batch_production=?";
			/*String sql = "SELECT u1.REALNAME as yanshouren,u2.REALNAME  as yanshouren2" +
				" FROM  t_checkaccept_item ci,t_check_accept_note cn LEFT JOIN dbo.TRTHR_USER u1 ON cn.proposer_ID = u1.USERID LEFT JOIN dbo.TRTHR_USER u2 ON cn.accepterID = u2.USERID " +
				" WHERE cn.id = ci.receiving_id AND cn.id = ? and ci.batch_production =? ";*/
			/*String sql = "SELECT u.REALNAME as yanshouren,u.REALNAME  as yanshouren2 " +
			"FROM t_purchase_order p ,t_purchase_order_item i,t_check_accept_note cn,t_checkaccept_item ci ,TRTHR_USER u " +
			"WHERE p.id = i.purchase_order_id AND cn.id = ci.receiving_id AND p.user_USERID= u.USERID AND ci.batch_production = i.batch_production AND ci.quantity = i.quantity AND ci.qualified_medicine_id = i.qualified_medicine_id " +
			"AND p.id=? and i.batch_production=? ";*/
			
			String sql = "SELECT u.REALNAME as yanshouren,u.REALNAME  as yanshouren2 " +
			"FROM t_purchase_order p ,t_purchase_order_item i,TRTHR_USER u " +
			"WHERE p.id = i.purchase_order_id AND p.user_USERID= u.USERID " +
			"AND p.id=? and i.batch_production=? ";
			
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			query.setParameter(0, strs[0]);
			query.setParameter(1, strs[1]);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return list;
	}
	

	//嘉和药品生成入库单数据
	@Override
	public List<Map<String, Object>> findPurchaseOrderJHByBathcNumer(
			String batchNumber) {
		List<Map<String, Object>> list = null;
		Session session = null;
		String[] strs = batchNumber.split(",");
		try{
//			String sql = "select top 1 tax_price ,realname,modify_date from t_purchase_order p ,t_purchase_order_item i,TRTHR_USER u  where p.id = i.purchase_order_id  and p.user_USERID= u.USERID and i.batch_production=?";
			String sql = "SELECT TOP 1 cn.tax_price,cn.purchaser as realname,cn.check_accept_date as modify_date,ci.end_time as enddate " +
					"FROM t_check_accept_note_jh cn,t_checkaccept_item_jh ci  " +
					"WHERE cn.id = ci.receiving_id AND cn.id=? ";
					
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			query.setParameter(0, strs[0]);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
		return list;
	}

	//嘉和药品生成入库单数据
	@Override
	public List<Map<String, Object>> findOpeatorNameJHByBatchNumber(
			String batchNumber) {
		List<Map<String, Object>> list = null;
		Session session = null;
		String[] strs = batchNumber.split(",");
		try{
			String sql = "SELECT u1.REALNAME as yanshouren,u2.REALNAME  as yanshouren2" +
			" FROM  t_checkaccept_item_jh ci,t_check_accept_note_jh cn LEFT JOIN dbo.TRTHR_USER u1 ON cn.proposer_ID = u1.USERID LEFT JOIN dbo.TRTHR_USER u2 ON cn.accepterID = u2.USERID " +
			" WHERE cn.id = ci.receiving_id AND cn.id = ? and ci.batch_production =? ";
		session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setParameter(0, strs[0]);
		query.setParameter(1, strs[1]);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return list;
	}
	@Override
	public List<PurchaseOrderVO> findPurchaseOrderVOByCondition(
			String commonName, String batchNumber, int first, int pagesize) {
		Session session = null;
		List<PurchaseOrderVO> orderVOList = null;
		StringBuffer hqlBuffer = new StringBuffer("select new com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderVO(a,b,c) from ");
		hqlBuffer.append("PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id ");
		if(commonName!=null&& !"".equals(commonName)){
			hqlBuffer.append(" and b.qualifiedMedicineId =:qualifiedMedicineId ");
		}
		if(batchNumber!=null && !"".equals(batchNumber)){
			hqlBuffer.append(" and b.batchProduction like :batchNumber ");
		}
		hqlBuffer.append(" and len(b.batchProduction) > 7 and b.quantity > 0 ");
		hqlBuffer.append(" order by a.id DESC ,a.number DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			if(commonName!=null&& !"".equals(commonName)){
				query.setParameter("qualifiedMedicineId", Long.parseLong(commonName));
			}
			if(batchNumber!=null && !"".equals(batchNumber)){
				query.setParameter("batchNumber", "%"+batchNumber+"%");
			}
			orderVOList =query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return orderVOList;   
	}

	@Override
	public int countPurchaseOrderVOByCondition(String commonName,
			String batchNumber) {
		Session session = null;
		String count = "0";
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from ");
		hqlBuffer.append("PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id ");
		if(commonName!=null&& !"".equals(commonName)){
			hqlBuffer.append(" and b.qualifiedMedicineId =:qualifiedMedicineId ");
		}
		if(batchNumber!=null && !"".equals(batchNumber)){
			hqlBuffer.append(" and b.batchProduction like :batchNumber ");
		}
		hqlBuffer.append(" and len(b.batchProduction) > 7 and b.quantity > 0 ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName!=null&& !"".equals(commonName)){
				query.setParameter("qualifiedMedicineId", Long.parseLong(commonName));
			}
			if(batchNumber!=null && !"".equals(batchNumber)){
				query.setParameter("batchNumber", "%"+batchNumber+"%");
			}
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(count);   
	}

	@Override
	public int countPurchaseOrderVOByStatusNew(String commonName,String orderNumber, String modityDate,
			 String department, String isfood,String status) {
		Session session = null;
		//List<PurchaseOrderVO> orderList = null;
		String count = "0";
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from ");
		hqlBuffer.append("PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id ");
	
		//2014年8月之后的安牛不显示
		hqlBuffer.append("  AND a.id not IN(select a.id FROM PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  "+
				" where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id  AND c.medicinalNo  IN ('02002612', "+
				" '02002602','02002603','02002606','02002607','02002608','02002608','40100112','40100113','40100114', "+
				" '40100116','40100117','40100119','40100119','40100103','40100104','40100105') AND a.modifyDate > '2014-07-31' ) ");
		
		if(commonName != null && !"".equals(commonName)){
			hqlBuffer.append(" and b.qualifiedMedicineId =:qualifiedMedicineId ");
		}
		/*if(batchNumber != null && !"".equals(batchNumber)){
			hqlBuffer.append(" and b.batchProduction like :batchNumber ");
		}*/
		
		if(orderNumber != null && !"".equals(orderNumber)){
			hqlBuffer.append(" and a.number like :orderNumber ");
		}
		if(modityDate != null && !"".equals(modityDate)){
			hqlBuffer.append(" and a.modifyDate like :modityDate ");
		}
		if(department != null && !"".equals(department) ){
			hqlBuffer.append(" and a.departmentId = :department");
		}
		if(isfood != null && !"".equals(isfood) ){
			hqlBuffer.append(" and c.isfood = :isfood");
		}
		if(status != null && !"".equals(status)){
			hqlBuffer.append(" and a.status =:status ");
		}
		hqlBuffer.append(" and len(b.batchProduction) > 7 and b.quantity > 0 and a.useFlag = 0 ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName != null && !"".equals(commonName)){
				query.setParameter("qualifiedMedicineId", Long.parseLong(commonName));
			}
			/*if(batchNumber != null && !"".equals(batchNumber)){
				query.setParameter("batchNumber", "%"+batchNumber+"%");
			}*/
			if(orderNumber != null && !"".equals(orderNumber)){
				query.setParameter("orderNumber", orderNumber.trim());
			}
			if(modityDate != null && !"".equals(modityDate)){
				query.setParameter("modityDate", modityDate.trim());
			}
			if(department != null && !"".equals(department)){
				query.setParameter("department", department);
			}
			if(isfood != null && !"".equals(isfood)){
				query.setParameter("isfood", isfood);
			}
			if(status != null && !"".equals(status)){
				query.setParameter("status",status);
			}
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return Integer.valueOf(count);
	}

	@Override
	public List<PurchaseOrderVO> findPurchseOrderVOByStatusNew(String commonName,
			String orderNumber, String modityDate, String department,String isfood, String status, int first, int pagesize) {
		Session session = null;
		List<PurchaseOrderVO> orderList = null; 
		StringBuffer hqlBuffer = new StringBuffer("select new com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderVO(a,b,c) from ");
		hqlBuffer.append("PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id ");
		//2014年8月之后的安牛不显示
		hqlBuffer.append("  AND a.id not IN(select a.id FROM PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  "+
				" where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id  AND c.medicinalNo  IN ('02002612', "+
				" '02002602','02002603','02002606','02002607','02002608','02002608','40100112','40100113','40100114', "+
				" '40100116','40100117','40100119','40100119','40100103','40100104','40100105') AND a.modifyDate > '2014-07-31' ) ");
		
		if(commonName != null && !"".equals(commonName)){
			hqlBuffer.append(" and b.qualifiedMedicineId =:qualifiedMedicineId ");
		}
		/*if(batchNumber != null && !"".equals(batchNumber)){
			hqlBuffer.append(" and b.batchProduction like :batchNumber ");
		}*/
		if(orderNumber != null && !"".equals(orderNumber)){
			hqlBuffer.append(" and a.number like :orderNumber ");
		}
		if(modityDate != null && !"".equals(modityDate)){
			hqlBuffer.append(" and a.modifyDate like :modityDate ");
		}
		if(department != null && !"".equals(department)){
			hqlBuffer.append(" and a.departmentId = :department");
		}
		if(isfood != null && !"".equals(isfood)){
			hqlBuffer.append(" and c.isfood = :isfood");
		}
		if(status != null && !"".equals(status)){
			hqlBuffer.append(" and a.status =:status ");
		}
		//hqlBuffer.append(" and len(b.batchProduction) > 7  and b.quantity > 0 and a.useFlag = 0 ");
		hqlBuffer.append(" and b.quantity > 0 and a.useFlag = 0 ");
		hqlBuffer.append(" order by a.id DESC ,a.number DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName != null && !"".equals(commonName)){
				query.setParameter("qualifiedMedicineId", Long.parseLong(commonName));
			}
			/*if(batchNumber != null && !"".equals(batchNumber)){
				query.setParameter("batchNumber", "%"+batchNumber+"%");
			}*/
			
			if(orderNumber != null && !"".equals(orderNumber)){
				query.setParameter("orderNumber", orderNumber.trim());
			}
			if(modityDate != null && !"".equals(modityDate)){
				query.setParameter("modityDate", modityDate.trim());
			}
			if(department != null && !"".equals(department)){
				query.setParameter("department", department);
			}
			if(isfood != null && !"".equals(isfood)){
				query.setParameter("isfood", isfood);
			}
			if(status != null && !"".equals(status)){
				query.setParameter("status",status);
			}
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			orderList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return orderList;
	}
	@Override
	public List<PurchaseOrderItemVO> findPurchaseOrderItemVOByOrderId(
			Long orderId) {
		Session session = null;
		List<PurchaseOrderItemVO> itemVOList = null;
		StringBuffer hql = new StringBuffer("select new com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItemVO(b,c) from PurchaseOrder a, PurchaseOrderItem b,QualityMidicine c  ");
		hql.append(" where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id and a.id =:orderId ");
		try{
			session  = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setParameter("orderId", orderId);
			itemVOList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null ){
				session.close(); 
			}
		}
		return itemVOList;
	}

	@Override
	public List<PurchaseOrderVO> findPurchseOrderVOByStatus(String commonName,
			String orderNumber, String modityDate, String department, String isfood,String useFlag,
			String status, int first, int pagesize) {
		Session session = null;
		List<PurchaseOrderVO> orderList = null;
		StringBuffer hqlBuffer = new StringBuffer("select new com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderVO(a,b,c) from ");
		hqlBuffer.append("PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id ");
		
		//2014年8月之后的安牛不显示
		hqlBuffer.append("  AND a.id not IN(select a.id FROM PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  "+
				" where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id  AND c.medicinalNo  IN ('02002612', "+
				" '02002602','02002603','02002606','02002607','02002608','02002608','40100112','40100113','40100114', "+
				" '40100116','40100117','40100119','40100119','40100103','40100104','40100105') AND a.modifyDate > '2014-07-31' ) ");
		
		if(commonName != null && !"".equals(commonName)){
			hqlBuffer.append(" and b.qualifiedMedicineId =:qualifiedMedicineId ");
		}
		/*if(batchNumber != null && !"".equals(batchNumber)){
			hqlBuffer.append(" and b.batchProduction like :batchNumber ");
		}*/
		if(orderNumber != null && !"".equals(orderNumber)){
			hqlBuffer.append(" and a.number like :orderNumber ");
		}
		if(modityDate != null && !"".equals(modityDate)){
			hqlBuffer.append(" and a.modifyDate like :modityDate ");
		}
		
		if(department != null && !"".equals(department)){
			hqlBuffer.append(" and a.departmentId = :department");
		}
		if(isfood != null && !"".equals(isfood)){
			hqlBuffer.append(" and c.isfood = :isfood");
		}
		if(status != null && !"".equals(status)){
			hqlBuffer.append(" and a.status =:status ");
		}
		if(useFlag != null && !"".equals(useFlag)){
			hqlBuffer.append(" and a.useFlag =:useFlag");
		}
		//hqlBuffer.append(" and len(b.batchProduction) > 7  and b.quantity > 0 ");
		hqlBuffer.append("  and b.quantity > 0 ");
		hqlBuffer.append(" order by a.id DESC ,a.number DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName != null && !"".equals(commonName)){
				query.setParameter("qualifiedMedicineId", Long.parseLong(commonName));
			}
			/*if(batchNumber != null && !"".equals(batchNumber)){
				query.setParameter("batchNumber", "%"+batchNumber+"%");
			}*/
			if(orderNumber != null && !"".equals(orderNumber)){
				query.setParameter("orderNumber", orderNumber.trim());
			}
			if(modityDate != null && !"".equals(modityDate)){
				query.setParameter("modityDate", modityDate.trim());
			}
			if(department != null && !"".equals(department)){
				query.setParameter("department", department);
			}
			if(isfood != null && !"".equals(isfood)){
				query.setParameter("isfood", isfood);
			}
			if(status != null && !"".equals(status)){
				query.setParameter("status",status);
			}
			if(useFlag != null && !"".equals(useFlag)){
				query.setParameter("useFlag", useFlag);
			}
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			orderList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return orderList;
	}

	@Override
	public int countPurchaseOrderVOByStatus(String commonName,
			String orderNumber, String modityDate, String department,String isfood, String useFlag, String status) {
		Session session = null;
		//List<PurchaseOrderVO> orderList = null;
		String count = "0";
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from ");
		hqlBuffer.append("PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id ");
		
		//2014年8月之后的安牛不显示
		hqlBuffer.append("  AND a.id not IN(select a.id FROM PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  "+
				" where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id  AND c.medicinalNo  IN ('02002612', "+
				" '02002602','02002603','02002606','02002607','02002608','02002608','40100112','40100113','40100114', "+
				" '40100116','40100117','40100119','40100119','40100103','40100104','40100105') AND a.modifyDate > '2014-07-31' ) ");
		
		if(commonName != null && !"".equals(commonName)){
			hqlBuffer.append(" and b.qualifiedMedicineId =:qualifiedMedicineId ");
		}
		/*if(batchNumber != null && !"".equals(batchNumber)){
			hqlBuffer.append(" and b.batchProduction like :batchNumber ");
		}*/
		if(orderNumber != null && !"".equals(orderNumber)){
			hqlBuffer.append(" and a.number like :orderNumber ");
		}
		if(modityDate != null && !"".equals(modityDate)){
			hqlBuffer.append(" and a.modifyDate like :modityDate ");
		}
		
		if(department != null && !"".equals(department) ){
			hqlBuffer.append(" and a.departmentId = :department");
		}
		if(isfood != null && !"".equals(isfood) ){
			hqlBuffer.append(" and c.isfood = :isfood");
		}
		if(status != null && !"".equals(status)){
			hqlBuffer.append(" and a.status =:status ");
		}
		if(useFlag != null && !"".equals(useFlag)){
			hqlBuffer.append(" and a.useFlag = :useFlag ");
		}
		hqlBuffer.append(" and b.quantity > 0 ");
		//hqlBuffer.append(" and len(b.batchProduction) > 7  and b.quantity > 0 ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName != null && !"".equals(commonName)){
				query.setParameter("qualifiedMedicineId", Long.parseLong(commonName));
			}
			/*if(batchNumber != null && !"".equals(batchNumber)){
				query.setParameter("batchNumber", "%"+batchNumber+"%");
			}*/
			
			if(orderNumber != null && !"".equals(orderNumber)){
				query.setParameter("orderNumber", orderNumber.trim());
			}
			if(modityDate != null && !"".equals(modityDate)){
				query.setParameter("modityDate", modityDate.trim());
			}
			if(department != null && !"".equals(department)){
				query.setParameter("department", department);
			}
			if(isfood != null && !"".equals(isfood)){
				query.setParameter("isfood", isfood);
			}
			if(status != null && !"".equals(status)){
				query.setParameter("status",status);
			}
			if(useFlag != null && !"".equals(useFlag)){
				query.setParameter("useFlag", useFlag);
			}
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return Integer.valueOf(count);
	}

	@Override
	public boolean isAlreadyReceiving(Long orderId) {
		Session session = null;
		String count = "0";
		String sql = "select count(*) from t_receiving_note where purchase_number = :purchase_number";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql);
			query.setParameter("purchase_number", String.valueOf(orderId));
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return (Integer.parseInt(count)>0)?true:false;
	}

	@Override
	public int countQuant(String batchNumber) {
		Session session = null;
		String count = "0";
		String sql = "SELECT SUM(b.quantity) "+
		  "FROM t_purchase_order a,t_purchase_order_item b,dbo.t_qualified_medicine c "+
		  "WHERE a.id = b.purchase_order_id AND b.qualified_medicine_id = c.id and b.batch_production = :batch_production" +
		  " and a.status in ('0','1','2')";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql);
			query.setParameter("batch_production", batchNumber);
			Object obj = query.uniqueResult();
			if(obj == null){
				count = "0";
			}else{
				count = obj.toString();
			}
			
//			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(count);
	}

	@Override
	public int countPurchaseOrderVOByUseflag(String commonName,
			String orderNumber,String modityDate, String department) {
		Session session = null;
		//List<PurchaseOrderVO> orderList = null;
		String count = "0";
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from ");
		hqlBuffer.append("PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id ");
		if(commonName != null && !"".equals(commonName)){
			hqlBuffer.append(" and b.qualifiedMedicineId =:qualifiedMedicineId ");
		}
		/*if(batchNumber != null && !"".equals(batchNumber)){
			hqlBuffer.append(" and b.batchProduction like :batchNumber ");
		}*/
		if(orderNumber != null && !"".equals(orderNumber)){
			hqlBuffer.append(" and a.number like :orderNumber ");
		}
		if(modityDate != null && !"".equals(modityDate)){
			hqlBuffer.append(" and a.modifyDate like :modityDate ");
		}
		
		if(department != null && !"".equals(department) ){
			hqlBuffer.append(" and a.departmentId = :department");
		}
		hqlBuffer.append(" and a.useFlag = 1  ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName != null && !"".equals(commonName)){
				query.setParameter("qualifiedMedicineId", Long.parseLong(commonName));
			}
			/*if(batchNumber != null && !"".equals(batchNumber)){
				query.setParameter("batchNumber", "%"+batchNumber+"%");
			}*/
			if(orderNumber != null && !"".equals(orderNumber)){
				query.setParameter("orderNumber", orderNumber.trim());
			}
			if(modityDate != null && !"".equals(modityDate)){
				query.setParameter("modityDate", modityDate.trim());
			}
			if(department != null && !"".equals(department)){
				query.setParameter("department", department);
			}
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return Integer.valueOf(count);
	}

	@Override
	public List<PurchaseOrderVO> findPurchseOrderVOByUseflag(String commonName,
			String orderNumber,String modityDate, String department, int first, int pagesize) {
		Session session = null;
		List<PurchaseOrderVO> orderList = null;
		StringBuffer hqlBuffer = new StringBuffer("select new com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderVO(a,b,c) from ");
		hqlBuffer.append("PurchaseOrder a, PurchaseOrderItem b, QualityMidicine c  where b.purchaseOrderId = a.id and b.qualifiedMedicineId = c.id ");
		if(commonName != null && !"".equals(commonName)){
			hqlBuffer.append(" and b.qualifiedMedicineId =:qualifiedMedicineId ");
		}
		/*if(batchNumber != null && !"".equals(batchNumber)){
			hqlBuffer.append(" and b.batchProduction like :batchNumber ");
		}*/
		
		if(orderNumber != null && !"".equals(orderNumber)){
			hqlBuffer.append(" and a.number like :orderNumber ");
		}
		if(modityDate != null && !"".equals(modityDate)){
			hqlBuffer.append(" and a.modifyDate like :modityDate ");
		}
		if(department != null && !"".equals(department)){
			hqlBuffer.append(" and a.departmentId = :department");
		}
		hqlBuffer.append(" and a.useFlag = 1  ");
		hqlBuffer.append(" order by a.id DESC ,a.number DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName != null && !"".equals(commonName)){
				query.setParameter("qualifiedMedicineId", Long.parseLong(commonName));
			}
			/*if(batchNumber != null && !"".equals(batchNumber)){
				query.setParameter("batchNumber", "%"+batchNumber+"%");
			}*/
			if(orderNumber != null && !"".equals(orderNumber)){
				query.setParameter("orderNumber", orderNumber.trim());
			}
			if(modityDate != null && !"".equals(modityDate)){
				query.setParameter("modityDate", modityDate.trim());
			}
			if(department != null && !"".equals(department)){
				query.setParameter("department", department);
			}
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			orderList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return orderList;
	}
	
	
	
	public List<Map<String,Object>> findAllBySql(String sql,Map<String,Object> params) throws Exception{
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createSQLQuery(sql.toString());
		query.setProperties(params);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

}