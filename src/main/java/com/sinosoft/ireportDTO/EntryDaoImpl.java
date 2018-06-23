package com.sinosoft.ireportDTO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;

@Repository("entryTicketDao")
public class EntryDaoImpl extends GenericDaoHibernate<EntryTicket, Long> implements EntryTicketDao {

	public EntryDaoImpl() {
		super(EntryTicket.class);
	}
	/**
	 *  根据验收单ID查询入库票
	 */
	public EntryTicket getEntryTicketByAcceptanceId(String id) {
		List<EntryTicket> entryTicketList = null;
		Session session =null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria  criteria = session.createCriteria(EntryTicket.class);
			criteria.add(Restrictions.eq("acceptanceId", Long.parseLong(id)));
			entryTicketList = criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return (entryTicketList!=null && entryTicketList.size()>0)?entryTicketList.get(0):null;
	}
	@Override
	public List<EntryTicket> getPage(EntryTicket et, int i, int pagesize,String batch) {
		StringBuffer hql = new StringBuffer("");
		hql =new StringBuffer("select t from EntryTicket t where 1 = 1 ");
		if(batch != null && !"".equals(batch)){
			hql.append(" and t.scph like '%"+batch+"%'");
		}
		hql.append(" order by t.id desc");
//		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber()) && mc.getDepartment()!=null && !"".equals(mc.getDepartment())){
//			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualifiedPurchaseUnits q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedSupplierId and t.reviewStatus=0 ");
//			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
//				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
//			}
//			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
//				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
//			}
//			if(mc.getDepartment() != null && !"".equals(mc.getDepartment())){
//				hql.append(" and m.departmentId ='"+mc.getDepartment()+"' ");
//			}
//		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
//			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualifiedPurchaseUnits q where q.id=t.qualifiedSupplierId and t.reviewStatus=0 ");
//			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
//				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
//			}
//		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
//			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
//			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
//				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
//			}
//		}else if(mc.getDepartment() != null &&!"".equals(mc.getDepartment())){
//			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
//			if(mc.getDepartment() != null && !"".equals(mc.getDepartment())){
//				hql.append(" and m.departmentId ='"+mc.getDepartment()+"' ");
//			}
//		
//		}else if(mc.getBatchNumber() != null &&!"".equals(mc.getBatchNumber())){
//			hql = new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
//			if(mc.getBatchNumber() != null && !"".equals(mc.getBatchNumber())){
//				hql.append(" and t.batchNumber ='"+mc.getBatchNumber()+"' ");
//			}
//		}else if(mc.getReturnTime() != null &&!"".equals(mc.getReturnTime())){
//			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
//			if(mc.getReturnTime() != null && !"".equals(mc.getReturnTime())){
//				hql.append(" and t.returnTime ='"+mc.getReturnTime()+"' ");
//			}
//		}else{
//			hql =new StringBuffer( "from PurchaseReturnBill t where t.reviewStatus=0 ");
//		}
		
		List<EntryTicket> list = null;
		Session session = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
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
	public int getTotalCount(EntryTicket et) {
		StringBuffer hql = new StringBuffer("");
		hql =new StringBuffer("select count(*) from EntryTicket t");
		
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			 list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(list);
	}
	@Override
	public EntryTicket findById(String id) {
		Session session = null;
		EntryTicket  chn = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			chn = (EntryTicket) session.get(EntryTicket.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		
		return chn;
	}

}
