package com.sinosoft.drugState.acceptanceJH.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.acceptanceJH.dao.AcceptanceItemJHDao;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptItemJH;
import com.sinosoft.ireportDTO.EntryTicket;

@Repository("AcceptanceItemJHDao")
public class AcceptanceItemJHDaoImpl extends GenericDaoHibernate<CheckAcceptItemJH, Long> implements AcceptanceItemJHDao{
	public AcceptanceItemJHDaoImpl() {
		super(CheckAcceptItemJH.class);
	}

	@Override
	public void del(String string) {
		CheckAcceptItemJH ch = findById(string);
		this.getHibernateTemplate().delete(ch);
		
	}

	@Override
	public CheckAcceptItemJH findById(String id) {
		Session session = null;
		CheckAcceptItemJH chit = null;
		try{ 
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			chit = (CheckAcceptItemJH) session.get(CheckAcceptItemJH.class, Long.parseLong(id));
		}catch (RuntimeException e) {
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
			hqlBuffer.append("qm.specifications,qm.unit,cast(ci.quantity as string),cn.taxPrice,'',qm.licensenumber,ci.batchProduction,ci.endTime, mp.pack_rate,cast(round(cast(ci.quantity as float)/cast(mp.pack_rate as float),2) as string),qm.produceno.customerName,'','','',cn.proposer,'','','','','',qm.departmentId");
			hqlBuffer.append(") from ");
			hqlBuffer.append(" CheckAcceptNoteJH cn , CheckAcceptItemJH ci ,QualityMidicine qm , MedcPrice mp ");
		//	hqlBuffer.append(", ctable ( select  po.user,poi.taxPrice,poi.batchProduction from PurchaseOrder po,PurchaseOrderItem poi where po.id = poi.purchaseOrderId) ");
			hqlBuffer.append(" where cn.id = ci.receivingId  and ci.qualityMidicine = qm.id  and cn.reviewStatus = 3 and qm.medicinalNo = mp.medc_no ");
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
	public CheckAcceptItemJH savech(CheckAcceptItemJH ch) {
		return this.getHibernateTemplate().merge(ch);
	}

	@Override
	public List<CheckAcceptItemJH> findysdItemJHJson() {
		String hql =" select q from CheckAcceptNoteJH rn, CheckAcceptItemJH q where 1=1 and rn.id=q.receivingId and rn.reviewStatus='3' and q.qualifiedMedicineId in  (select cn.medc_id from QualifiedMedcJH cn) ";

		Session session = null;
		List<CheckAcceptItemJH> list = null;
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
	public List<CheckAcceptItemJH> findysdItemJsonByBatchSize(String batch) {
		Session session = null;
		List<CheckAcceptItemJH> list = null;
		StringBuffer hql = new StringBuffer("select q from CheckAcceptNoteJH rn, CheckAcceptItemJH q where 1=1 and rn.id=q.receivingId ");
		if(batch != null && !"".equals(batch.trim()) ){
			if(batch.trim().length() < 3){
				return list;
			}
		
			hql.append(" and rn.reviewStatus='3' ");
			hql.append(" and q.batchProduction like '%"+batch+"%' ");
			hql.append(" order by q.batchProduction ");
			try{
				session = getHibernateTemplate().getSessionFactory().openSession();
				Query query = session.createQuery(hql.toString());
//				query.setParameter("batchProduction", batch);
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
		}else{
			return list;
		}
		
		return list;
	}
}
