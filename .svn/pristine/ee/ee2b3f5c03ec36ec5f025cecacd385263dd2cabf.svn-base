package com.sinosoft.drugState.returnRecords.dao.impl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.returnRecords.dao.ReturnRecordsDao;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNote;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteVO;

@Repository("ReturnRecordsDao")
public class ReturnRecordsDaoImpl extends GenericDaoHibernate<ReturnReceivingNote, Long> implements ReturnRecordsDao{

	public ReturnRecordsDaoImpl() {
		super(ReturnReceivingNote.class);
	}
	@Override
	public List<ReturnReceivingNote> getPage(ReturnReceivingNote re, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(re!=null){
			if(re.getCheckConclusion()==null || "".equals(re.getCheckConclusion())){
				hql=new StringBuffer("from ReturnReceivingNote t  where 1=1" );
				if(re.getDeliveryDate()!=null && !"".equals(re.getDeliveryDate())){
					hql.append(" and t.deliveryDate like '%"+re.getDeliveryDate()+"%'");
				}
			}else{
				hql=new StringBuffer("select t from ReturnReceivingNote t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId " );
				hql.append(" and q.customerName like '%"+re.getCheckConclusion()+"%' ");
				if(re.getDeliveryDate()!=null && !"".equals(re.getDeliveryDate())){
					hql.append(" and t.deliveryDate like '%"+re.getDeliveryDate()+"%'");
				}
			}
		}else{
			hql=new StringBuffer("from ReturnReceivingNote t  where 1=1" );
		}
		hql.append(" order by t.id DESC ");
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		List<ReturnReceivingNote> res = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<ReturnReceivingNote> res = null;
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
	public int getTotalCount(ReturnReceivingNote re) {
		StringBuffer hql = new StringBuffer();
		if(re!=null){
			if(re.getCheckConclusion()==null || "".equals(re.getCheckConclusion())){
				hql=new StringBuffer("select count(*) from ReturnReceivingNote t where 1=1" );
				if(re.getDeliveryDate()!=null && !"".equals(re.getDeliveryDate())){
					hql.append(" and t.deliveryDate like '%"+re.getDeliveryDate()+"%'");
				}
			}else{
				hql=new StringBuffer("select count(*) from ReturnReceivingNote t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId " );
				hql.append(" and q.customerName like '%"+re.getCheckConclusion()+"%' ");
				if(re.getDeliveryDate()!=null && !"".equals(re.getDeliveryDate())){
					hql.append(" and t.deliveryDate like '%"+re.getDeliveryDate()+"%'");
				}
			}
		}else{
			hql=new StringBuffer("select count(*) from ReturnReceivingNote t where 1=1" );
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
	public ReturnReceivingNote findById(String id) {
		/*String hql=" from ReturnReceivingNote t where t.id="+Long.parseLong(id);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		ReturnReceivingNote re =(ReturnReceivingNote) query.list().get(0);
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		ReturnReceivingNote re = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			re = (ReturnReceivingNote)session.get(ReturnReceivingNote.class, Long.parseLong(id)); 
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return re;
	}
	@Override
	public List<ReturnReceivingNoteItem> findYp(Long id) {
		/*String hql = "select t from ReturnReceivingNoteItem t where receivingNoteId ="+id;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<ReturnReceivingNoteItem> list= query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select t from ReturnReceivingNoteItem t where receivingNoteId ="+id;
		Session session = null;
		List<ReturnReceivingNoteItem> list= null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list= query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	@Override
	public ReturnReceivingNote saveReceivingNote(ReturnReceivingNote re) {
		ReturnReceivingNote res=getHibernateTemplate().merge(re);
		return res;
	}
	@Override
	public void del(String id) {
		ReturnReceivingNote re=findById(id);
		getHibernateTemplate().delete(re);
	}
	@Override
	public List<?> findAllId(String s) {
			String hql = "select t.id from ReturnReceivingNoteItem t where receivingNoteId ="+s;
			/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			List<?> list= query.list();
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			Session session = null;
			List<?> list= null;
			try{
				session =this.getHibernateTemplate().getSessionFactory().openSession();
				Query query = session.createQuery(hql);
				list= query.list();
			}catch (RuntimeException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw e;
			}finally{
				if(session!=null)
					session.close();
			}
			return list;
	}
	@Override
	public List<OutboundCheckBill> findItemById(String saleNumber) {
		String hql = " from OutboundCheckBill t where t.salesNumber ="+Long.parseLong(saleNumber);
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<OutboundCheckBill> list= query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<OutboundCheckBill> list= null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			 list= query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	@Override
	public List<OutboundCheckItem> findOutItem(Long id) {
		String hql = " from OutboundCheckItem t where t.outboundCheckBillId ="+id;
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<OutboundCheckItem> list= query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<OutboundCheckItem> list= null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			 list= query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	@Override
	public List<OutboundCheckBill> findOutboundCheckBill(String salesItemId) {
		Session session = null;
		List<OutboundCheckBill> list = null;
		String hql = "select a  from OutboundCheckBill a where a.salesNumber =:salesItemId";  
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("salesItemId", salesItemId);
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
	public int countReturnReceivingNoteByCondiction(String date,
			String customerName, String status,String xiaoshoudanhao,String tuihuodanhao,String isfood) {
		Session session = null;
		StringBuffer hql = new StringBuffer("select count(*) from ReturnReceivingNote a,ReturnReceivingNoteItem b,QualifiedPurchaseUnits c,QualityMidicine d where 1=1 ");
		hql.append(" and b.receivingNoteId = a.id and a.qualifiedPurchaseUnitsId=c.id and b.qualifiedMedicineId = d.id ");
		if(date!=null && !"".equals(date)){
			hql.append(" and a.deliveryDate =:date ");
		}
		if(customerName!=null && !"".equals(customerName)){
			hql.append(" and c.customerName like :customerName ");
		}
		if(xiaoshoudanhao != null && !"".equals(xiaoshoudanhao)){
			hql.append(" and a.saleNo like :saleNo ");
		}
		if(tuihuodanhao != null && !"".equals(tuihuodanhao)){
			hql.append(" and a.returnNumber like :retunNum ");
		}
		if(status != null && !"".equals(status.trim())){
			hql.append(" and d.commonname like :commonname ");
		}
		if(isfood != null && !"".equals(isfood.trim())){
			hql.append(" and d.isfood like :isfood ");
		}
		hql.append(" and len(b.batchProduction) > 7 ");
		String count = "0";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			if(date!=null && !"".equals(date)){
				query.setParameter("date", date);
			}
			if(customerName!=null && !"".equals(customerName)){
				query.setParameter("customerName", "%"+customerName+"%");
			}
			if(status != null && !"".equals(status.trim())){
				query.setParameter("commonname", "%"+status+"%");
			}
			if(xiaoshoudanhao != null && !"".equals(xiaoshoudanhao)){
				query.setParameter("saleNo", "%"+xiaoshoudanhao+"%");
			}
			if(tuihuodanhao != null && !"".equals(tuihuodanhao)){
				query.setParameter("retunNum", "%"+tuihuodanhao+"%");
			}
			if(isfood != null && !"".equals(isfood)){
				query.setParameter("isfood", isfood);
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
	public List<ReturnReceivingNoteVO> findReturnReceivingNoteByCondiction(
			String date, String customerName, String status, String xiaoshoudanhao,String tuihuodanhao,String isfood,int first,
			int pagesize) {
		Session session = null;
		List<ReturnReceivingNoteVO> list = null;
		StringBuffer hql = new StringBuffer("select new com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteVO(a,b,c,d) from ReturnReceivingNote a,ReturnReceivingNoteItem b,QualifiedPurchaseUnits c,QualityMidicine d where 1=1 ");
		hql.append(" and b.receivingNoteId = a.id and a.qualifiedPurchaseUnitsId=c.id and b.qualifiedMedicineId = d.id ");
		if(date!=null && !"".equals(date)){
			hql.append(" and a.deliveryDate =:date ");
		}
		if(customerName!=null && !"".equals(customerName)){
			hql.append(" and c.customerName like :customerName ");
		}
		if(xiaoshoudanhao != null && !"".equals(xiaoshoudanhao)){
			hql.append(" and a.saleNo like :saleNo ");
		}
		if(tuihuodanhao != null && !"".equals(tuihuodanhao)){
			hql.append(" and a.returnNumber like :retunNum ");
		}
		if(status != null && !"".equals(status.trim())){
			hql.append(" and d.commonname like :commonname ");
		}
		if(isfood != null && !"".equals(isfood.trim())){
			hql.append(" and d.isfood like :isfood ");
		}
		hql.append(" and len(b.batchProduction) > 7 ");
		hql.append(" order by  a.id DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			if(date!=null && !"".equals(date)){
				query.setParameter("date", date);
			}
			if(customerName!=null && !"".equals(customerName)){
				query.setParameter("customerName", "%"+customerName+"%");
			}
			if(status != null && !"".equals(status.trim())){
				query.setParameter("commonname", "%"+status+"%");
			}
			if(xiaoshoudanhao != null && !"".equals(xiaoshoudanhao)){
				query.setParameter("saleNo", "%"+xiaoshoudanhao+"%");
			}
			if(tuihuodanhao != null && !"".equals(tuihuodanhao)){
				query.setParameter("retunNum", "%"+tuihuodanhao+"%");
			}
			if(isfood != null && !"".equals(isfood)){
				query.setParameter("isfood", isfood);
			}
			query.setFirstResult(first);
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
	public Integer getSumQuantity(String saleNumber,String batchNo,String qualifiedMedicineId) {
		StringBuffer hql = new StringBuffer();
		hql.append("select SUM(rni.quantity) from ReturnReceivingNoteItem rni,ReturnReceivingNote rn where rni.receivingNoteId = rn.id");
		hql.append(" and rn.saleNo = '"+saleNumber+"' " );
		hql.append(" and rni.batchProduction = '"+batchNo+"' " );
		hql.append(" and rni.qualifiedMedicineId = "+qualifiedMedicineId+" " );
		
		Session session = null;
		Integer num = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			
			num = query.list().size() > 0 ? //3
					  (query.list().get(0)!=null ? //2
							(!query.list().get(0).toString().trim().equals("") ? Integer.parseInt(query.list().get(0).toString().trim()) : null ) //1
					  : null )
				  : null;
			
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return num;
	}

}
