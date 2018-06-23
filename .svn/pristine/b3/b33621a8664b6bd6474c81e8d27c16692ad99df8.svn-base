package com.sinosoft.drugState.acceptance.dao.impl;



import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.acceptance.dao.AcceptanceItemDao;
import com.sinosoft.drugState.acceptance.model.CheckacceptItem;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.ireportDTO.EntryTicket;

@Repository("AcceptanceItemDao")
public class AcceptanceItemDaoImpl extends GenericDaoHibernate<CheckacceptItem, Long> implements AcceptanceItemDao{

	public AcceptanceItemDaoImpl() {
		super(CheckacceptItem.class);
	}

	@Override
	public CheckacceptItem savech(CheckacceptItem ch) {
		return this.getHibernateTemplate().merge(ch);
	}

	@Override
	public void del(String string) {
		CheckacceptItem ch = findById(string);
		this.getHibernateTemplate().delete(ch);
	}

	@Override
	public CheckacceptItem findById(String id) {
//		String hql="from CheckacceptItem t where t.id="+Long.parseLong(id);
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		CheckacceptItem chit=(CheckacceptItem) query.list().get(0);
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		CheckacceptItem chit = null;
		try{ 
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			chit = (CheckacceptItem) session.get(CheckacceptItem.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return chit;
	}

	@Override
	public List<EntryTicket> findCheckAndAcceptByBatchNumber(String batchNumber) {
		Session session = null;
		List<EntryTicket> list = null;
		String[] strs = batchNumber.split(",");
		
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			StringBuffer hqlBuffer  = new StringBuffer("select new com.sinosoft.ireportDTO.EntryTicket(cn.id,qm.supplyUnit.customerName,'',cn.number,qm.medicinalNo,qm.commonname,qm.dosageforms.formName,");
			hqlBuffer.append("qm.specifications,qm.unit,cast(ci.quantity as string),'','',qm.licensenumber,ci.batchProduction,ci.endTime, mp.pack_rate,cast(round(cast(ci.quantity as float)/cast(mp.pack_rate as float),2) as string),qm.produceno.customerName,'','','','','','','','','',qm.departmentId");
			hqlBuffer.append(") from ");
			hqlBuffer.append(" PurchaseOrder cn , PurchaseOrderItem ci ,QualityMidicine qm , MedcPrice mp ");
		//	hqlBuffer.append(", ctable ( select  po.user,poi.taxPrice,poi.batchProduction from PurchaseOrder po,PurchaseOrderItem poi where po.id = poi.purchaseOrderId) ");
			hqlBuffer.append(" where cn.id = ci.purchaseOrderId  and ci.qualifiedMedicineId = qm.id  and cn.status = '2' and cn.useFlag='0' and qm.medicinalNo = mp.medc_no ");
			//hqlBuffer.append(" and ci.batchProduction = ctable.batchProduction ");
			hqlBuffer.append(" and ci.batchProduction=:batchProduction and cn.id=:id");
			Query query = session.createQuery(hqlBuffer.toString());
			query.setParameter("batchProduction", strs[1]);
			query.setParameter("id", Long.valueOf(strs[0]));
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace(); 
		}finally{
			if(session!=null ){
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<CheckacceptItem> findysdItemJson() {//此方法作废
		String hql =" select q from CheckAcceptNote rn, CheckacceptItem q where 1=1 and rn.id=q.receivingId and rn.reviewStatus='3' and q.qualifiedMedicineId not in  (select cn.medc_id from QualifiedMedcJH cn) and q.batchProduction = '16012454' ";

		Session session = null;
		List<CheckacceptItem> list = null;
		try{ 
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
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
	public List<PurchaseOrderItem> findysdItemJsonByBatchSize(String batch) {
		Session session = null;
		List<PurchaseOrderItem> list = null;
		StringBuffer hql = new StringBuffer("select q from PurchaseOrder rn, PurchaseOrderItem q where 1=1 and rn.id=q.purchaseOrderId ");
		hql.append(" and rn.status='2' and rn.useFlag='0' and q.qualifiedMedicineId not in  (select cn.medc_id from QualifiedMedcJH cn)  ");
		if(batch != null && !"".equals(batch.trim()) ){
			if(batch.trim().length() < 3){
				return list;
			}else{
				hql.append(" and q.batchProduction like '%"+batch+"%' ");
			}
		
		}
		//hql.append(" and len(q.batchProduction) >= 7 ");
		hql.append(" order by q.batchProduction ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
//			query.setParameter("batchProduction", batch);
			query.setFirstResult(0);
			query.setMaxResults(20);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public List<Map<String,Object>> findysdItemJsonByBatchSize2(String batch) {
		Session session = null;
		List<Map<String,Object>> list = null;
		StringBuffer sql = new StringBuffer(" select * from ( "
				+ " SELECT "
				+ "     O.id AS poId "
				+ "    ,O.department_id "
				+ "    ,O.modifier "
				+ "    ,O.modify_date "
				+ "    ,O.number "
				+ "    ,O.season "
				+ "    ,O.qualifiedSupplierId_id "
				+ "    ,O.user_USERID "
				+ "    ,O.status "
				+ "    ,O.reject_flag "
				+ "    ,O.use_flag "
				+ "    ,O.reason "
				+ "    ,O.check_accept_date "
				+ "    ,O.accepter_ID1 "
				+ "    ,O.accepter_ID2 "
				+ "    ,I.id AS poiId "
				+ "    ,I.batch_production AS batch "
				+ "    ,I.common_name "
				+ "    ,I.dosage_forms "
				+ "    ,I.end_time "
				+ "    ,I.license_number "
				+ "    ,I.money "
				+ "    ,I.produce_no "
				+ "    ,I.purchase_order_id "
				+ "    ,I.qualified_medicine_id "
				+ "    ,I.quantity "
				+ "    ,I.rate "
				+ "    ,I.specifications "
				+ "    ,I.tax_price "
				+ "    ,I.flag "
				+ "    ,I.tkdat "
				+ "    ,I.erp_flag "
				+ "    ,I.actual_received_quantity "
				+ " FROM "
				+ "     dbo.t_purchase_order O "
				+ "     LEFT JOIN dbo.t_purchase_order_item I ON I.purchase_order_id = O.id "
				+ "     LEFT JOIN dbo.t_medc_jh J ON J.medc_id = I.qualified_medicine_id "
				+ " WHERE "
				+ "     O.status = '2' "
				+ "     AND O.use_flag = '0' "
				+ "     AND J.id IS NULL "
				+ " UNION ALL "
				+ " SELECT "
				+ "     O.id AS poId "
				+ "    ,O.department_id "
				+ "    ,O.modifier "
				+ "    ,O.modify_date "
				+ "    ,O.number "
				+ "    ,O.season "
				+ "    ,O.qualifiedSupplierId_id "
				+ "    ,O.user_USERID "
				+ "    ,O.status "
				+ "    ,O.reject_flag "
				+ "    ,O.use_flag "
				+ "    ,O.reason "
				+ "    ,O.check_accept_date "
				+ "    ,O.accepter_ID1 "
				+ "    ,O.accepter_ID2 "
				+ "    ,I.id AS poiId "
				+ "    ,I.batch_production AS batch "
				+ "    ,I.common_name "
				+ "    ,I.dosage_forms "
				+ "    ,I.end_time "
				+ "    ,I.license_number "
				+ "    ,I.money "
				+ "    ,I.produce_no "
				+ "    ,I.purchase_order_id "
				+ "    ,I.qualified_medicine_id "
				+ "    ,I.quantity "
				+ "    ,I.rate "
				+ "    ,I.specifications "
				+ "    ,I.tax_price "
				+ "    ,I.flag "
				+ "    ,I.tkdat "
				+ "    ,I.erp_flag "
				+ "    ,I.actual_received_quantity "
				+ " FROM "
				+ "     dbo.t_purchase_order O "
				+ "     LEFT JOIN dbo.t_purchase_order_item I ON I.purchase_order_id = O.id "
				+ "     LEFT JOIN dbo.t_medc_jh J ON J.medc_id = I.qualified_medicine_id "
				+ " WHERE "
				+ "     O.status = '2' "
				+ "     AND O.use_flag = '0' "
				+ "     AND J.id IS NOT NULL "
				+ "     AND CONVERT(DATE, O.modify_date, 120) >= CONVERT(DATE, :time, 120) "
				+ " ) q WHERE 1=1  ");
		if(batch != null && !"".equals(batch.trim()) ){
			if(batch.trim().length() < 3){
				return list;
			}else{
				sql.append(" AND q.batch like :batch ");
			}
		
		}
		//hql.append(" and len(q.batchProduction) >= 7 ");
		sql.append(" order by q.batch ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql.toString());
//			query.setParameter("batchProduction", batch);
			query.setParameter("time", "2017-09-01");
			query.setParameter("batch", "%"+batch+"%");
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	

}
