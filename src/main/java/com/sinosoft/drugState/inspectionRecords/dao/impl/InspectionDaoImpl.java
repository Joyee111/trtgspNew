package com.sinosoft.drugState.inspectionRecords.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.inspectionRecords.dao.InspectionDao;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrder;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNote;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNoteItem;
import com.sinosoft.drugState.inspectionRecords.model.ReveivingNoteVO;
import com.sinosoft.drugState.inspectionRecords.model.TicketSamples;
import com.sinosoft.drugState.price.MedicinePrice;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
@Repository("InspectionDao")
public class InspectionDaoImpl extends GenericDaoHibernate<ReceivingNote, Long> implements InspectionDao {



	public InspectionDaoImpl() {
		super(ReceivingNote.class);
	}

	@Override
	public List<ReveivingNoteVO> getPage(String date,String customerName, String checkResult, String isfood,int pageSize,int resultSize) {
		Session session = null;
		List<ReveivingNoteVO> recNotes = null;
		StringBuffer hqlBuffer = new StringBuffer("select new com.sinosoft.drugState.inspectionRecords.model.ReveivingNoteVO(rn,ri,qm) from ");
		hqlBuffer.append("ReceivingNote rn , ReceivingNoteItem ri ,QualityMidicine qm  where rn.id = ri.receivingNoteId and ri.qualifiedMedicineId = qm.id ");
		try{
			if(date!=null && !"".equals(date)){
				hqlBuffer.append(" and rn.receivedDate = :receivedDate ");
			}
			if(customerName!=null && !"".equals(customerName)){
				hqlBuffer.append(" and ri.batchProduction like :batchProduction ");
			}
			if(checkResult != null && !"".equals(checkResult)){
				hqlBuffer.append(" and rn.checkConclusion = :checkConclusion ");
			}
			if(isfood != null && !"".equals(isfood)){
				hqlBuffer.append(" and qm.isfood = :isfood ");
			}
			hqlBuffer.append(" order by rn.id DESC");
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(date!=null && !"".equals(date)){
				query.setParameter("receivedDate", date);
			}
			if(customerName!=null && !"".equals(customerName)){
				query.setParameter("batchProduction", "%"+customerName+"%");
			}
			if(checkResult != null && !"".equals(checkResult)){
				query.setParameter("checkConclusion", checkResult);
			}
			if(isfood != null && !"".equals(isfood)){
				query.setParameter("isfood", isfood);
			}
			query.setFirstResult(pageSize);
			query.setMaxResults(resultSize);
			recNotes = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return recNotes;
	}

	@Override
	public int getTotalCount(String date,String customerName, String checkConclusion,String isfood) {
		Session session = null;
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from ReceivingNote rn,ReceivingNoteItem ri,QualityMidicine qm where rn.id = ri.receivingNoteId " );
		hqlBuffer.append(" and ri.qualifiedMedicineId = qm.id ");
		
		if(date!=null && !"".equals(date)){
			hqlBuffer.append(" and rn.receivedDate = :receivedDate ");
		}
		if(customerName!=null && !"".equals(customerName)){
			hqlBuffer.append(" and ri.batchProduction like :batchProduction ");
		}
		if(checkConclusion != null && !"".equals(checkConclusion)){
			hqlBuffer.append(" and rn.checkConclusion = :checkConclusion ");
		}
		if(isfood != null && !"".equals(isfood)){
			hqlBuffer.append(" and qm.isfood = :isfood ");
		}
		int count = 0;
		try{
		session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hqlBuffer.toString());
		if(date!=null && !"".equals(date)){
			query.setParameter("receivedDate", date);
		}
		if(customerName!=null && !"".equals(customerName)){
			query.setParameter("batchProduction", "%"+customerName+"%");
		}
		if(checkConclusion != null && !"".equals(checkConclusion)){
			query.setParameter("checkConclusion", checkConclusion);
		}
		if(isfood != null && !"".equals(isfood)){
			query.setParameter("isfood", isfood);
		}
		count = Integer.parseInt(query.list().get(0).toString());
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			session.close();
		}
		return count;
	}

	@Override
	public ReceivingNote findById(String ids) {
		Session session = null;
		ReceivingNote  receivingNote = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			receivingNote = (ReceivingNote)session.get(ReceivingNote.class, Long.parseLong(ids.trim()));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return receivingNote;
	}

	@Override
	public ReceivingNote saveOrUpdata(ReceivingNote re) {
		return (ReceivingNote) this.getHibernateTemplate().save(re);
	}

	@Override
	public ReceivingNote saveReceivingNote(ReceivingNote re) {
		ReceivingNote rec=	getHibernateTemplate().merge(re);
		return rec;
	}

	@Override
	public void del(String ids) {
		ReceivingNote re=findById(ids);
		getHibernateTemplate().delete(re);
	}

	@Override
	public Map<String, String> qmMap() {
		Map<String, String> map = new HashMap<String, String>();
//		String hql =" select q from QualityMidicine q where q.useflag=0";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		String value = "";
//		if(query.list().size()>0){
//			List<QualityMidicine> listMq=query.list();
//			for(int i=0 ;i<listMq.size();i++){
//				QualityMidicine qm=listMq.get(i);
//				if(qm!=null){
//					map.put(String.valueOf(qm.getId()),qm.getCommonname());
//				}
//			}
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return map;
	}

	@Override
	public QualityMidicine findYpById(String quamap) {
//		Long a = Long.parseLong(quamap.trim());
//		String hql = "from QualityMidicine t where t.id ="+a;
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		QualityMidicine qu = (QualityMidicine) query.list().get(0);
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		QualityMidicine qu = null;
		try{ 
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			qu = (QualityMidicine)session.get(QualityMidicine.class, Long.parseLong(quamap));
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return qu;
	}

	@Override
	public void saveReceivingNoteItem(ReceivingNoteItem receivingNoteItem) {
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		session.saveOrUpdate(receivingNoteItem);
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			session.update(receivingNoteItem);
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
	}

	@Override
	public List<ReceivingNoteItem> findYp(Long id) {
//		String hql = "select t from ReceivingNoteItem t where receivingNoteId ="+id;
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		List<ReceivingNoteItem> list= query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String hql = "select t from ReceivingNoteItem t where receivingNoteId ="+id;
		Session session = null;
		List<ReceivingNoteItem> list = null;
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
	public List<?> findAllId(String id) {
//		Long a = Long.parseLong(id);
//		String sql = " select t.id from t_receiving_note_item t where t.receiving_note_id= "+a;
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		SQLQuery sqlQuery = session.createSQLQuery(sql);
//		List<?> list = sqlQuery.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Long a = Long.parseLong(id);
		String sql = " select t.id from t_receiving_note_item t where t.receiving_note_id=:id ";
		Session session = null;
		List<?> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setParameter("id", a);
			list = sqlQuery.list();
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
	public Map<String, String> gonghuoMap() {
		Map<String, String> map = new HashMap<String, String>();
//		String hql =" select q from QualifiedSuppliers q ";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		String value = "";
//		if(query.list().size()>0){
//			List<QualifiedSuppliers> listMq=query.list();
//			for(int i=0 ;i<listMq.size();i++){
//				QualifiedSuppliers qm=listMq.get(i);
//				if(qm!=null){
//					map.put(String.valueOf(qm.getId()), qm.getCustomerName());
//				}
//			}
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return map;
	}

	@Override
	public Map<String, String> gouhuoMap() {
		Map<String, String> map = new HashMap<String, String>();
//		String hql =" select q from QualifiedPurchaseUnits q ";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		String value = "";
//		if(query.list().size()>0){
//			List<QualifiedPurchaseUnits> listMq=query.list();
//			for(int i=0 ;i<listMq.size();i++){
//				QualifiedPurchaseUnits qm=listMq.get(i);
//				if(qm!=null){
//					map.put(String.valueOf(qm.getId()), qm.getCustomerName());
//				}
//			}
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return map;
	}

	@Override
	public QualityMidicine findHGYP(Long qualifiedMedicineId) {
		QualityMidicine qm = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			qm = (QualityMidicine)session.get(QualityMidicine.class, qualifiedMedicineId);
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return qm;
	}

	@Override
	public PurchaseOrder findCGDById(String caigoudan) {
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		PurchaseOrder re = new PurchaseOrder();
//		if(caigoudan!=null && !"".equals(caigoudan)){
//			String sql = "from PurchaseOrder t where t.number= '"+caigoudan+"'";
//			Query sqlQuery = session.createQuery(sql);
//			if(sqlQuery.list().size()>0){
//				re= (PurchaseOrder) sqlQuery.list().get(0);
//			}
//		}else{
//			re=null;
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		PurchaseOrder re = null;
		try{
			if(caigoudan!=null&& !"".equals(caigoudan)){
				String sql = "from PurchaseOrder t where t.number=:caigoudan";
				session = getHibernateTemplate().getSessionFactory().openSession();
				Query sqlQuery = session.createQuery(sql);
				sqlQuery.setParameter("caigoudan", caigoudan);
				if(sqlQuery.list()!=null && sqlQuery.list().size()>0){
					re = (PurchaseOrder)sqlQuery.list().get(0);
				}
			}
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
	public ReceivingNote findByNumber(String shouhuodan) {
//		ReceivingNote re = new ReceivingNote();
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		if(shouhuodan!=null && !"".equals(shouhuodan)){
//			String sql = "from ReceivingNote t where t.number='"+shouhuodan+"'";
//			Query sqlQuery = session.createQuery(sql);
//			if(sqlQuery.list().size()>0){
//				re= (ReceivingNote) sqlQuery.list().get(0);
//			}
//		}else{
//			re=null;
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		ReceivingNote re = null;
		Session session = null;
		try{
			if(shouhuodan!=null && !"".equals(shouhuodan)){
				session = this.getHibernateTemplate().getSessionFactory().openSession();
				String sql = "from ReceivingNote t where t.number='"+shouhuodan+"'";
				Query sqlQuery = session.createQuery(sql);
				if(sqlQuery.list()!=null && sqlQuery.list().size()>0){
					re = (ReceivingNote)sqlQuery.list().get(0);
				}
			}
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
	public QualifiedSuppliers findGYSById(Long qualifiedSupplierId) {
		QualifiedSuppliers re = null;
		Session session =  null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			re = (QualifiedSuppliers) session.get(QualifiedSuppliers.class, qualifiedSupplierId);
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		
		return re;
	}

	@Override
	public QualifiedPurchaseUnits findGHSById(Long qualifiedPurchaseUnitId) {
//		QualifiedPurchaseUnits re = new QualifiedPurchaseUnits();
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		if(qualifiedPurchaseUnitId!=null && !"".equals(qualifiedPurchaseUnitId)){
//			String sql = "from QualifiedPurchaseUnits t where t.id= "+qualifiedPurchaseUnitId;
//			Query sqlQuery = session.createQuery(sql);
//			if(sqlQuery.list().size()>0){
//				re= (QualifiedPurchaseUnits) sqlQuery.list().get(0);
//			}
//		}else{
//			re=null;
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		QualifiedPurchaseUnits re = null;
		Session session = null;
		try{ 
			if(qualifiedPurchaseUnitId!=null && !"".equals(qualifiedPurchaseUnitId)){
				session = this.getHibernateTemplate().getSessionFactory().openSession();
				re = (QualifiedPurchaseUnits) session.get(QualifiedPurchaseUnits.class, qualifiedPurchaseUnitId);
			}
		
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
	public List<PurchaseOrder> findcgdJson() {
//		String hql =" from PurchaseOrder q where 1=1 ";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		List<PurchaseOrder> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		List<PurchaseOrder> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(PurchaseOrder.class);
			criteria.addOrder(Order.desc("id"));
			list = criteria.list();
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
	public Map<String, String> qmMaps() {
		Map<String, String> map = new HashMap<String, String>();
//		String hql =" select q from QualityMidicine q where q.useflag=1";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		String value = "";
//		if(query.list().size()>0){
//			List<QualityMidicine> listMq=query.list();
//			for(int i=0 ;i<listMq.size();i++){
//				QualityMidicine qm=listMq.get(i);
//				if(qm!=null){
//					map.put(String.valueOf(qm.getId()),qm.getTradename());
//				}
//			}
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return map;
	}

	@Override
	public List<ReceivingNote> findshdJson() {
//		String hql =" from ReceivingNote q where 1=1 ";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		List<ReceivingNote> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		List<ReceivingNote> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(ReceivingNote.class);
			criteria.addOrder(Order.desc("id"));
			list = criteria.list();
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
	public List<QualityMidicine> findypJsonqy() {
		// TODO: handle exception
		String hql =" select q  from QualityMidicine q join q.dosageforms d  where q.useflag=0 order by q.medicinalNo asc ";
		Session session = null;
		List<QualityMidicine> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
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
	public List<QualityMidicine> findypJsonty() {
//		String hql =" from QualityMidicine q where q.useflag=1 order by q.medicinalNo asc ";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		List<QualityMidicine> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String hql =" from QualityMidicine q where q.useflag=1 order by q.medicinalNo asc ";
		Session session = null;
		List<QualityMidicine> list = null;
		try{ 
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
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
	public List<QualifiedPurchaseUnits> findList(String hql) {
		
		List<QualifiedPurchaseUnits> list =null;
		
		Session  session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list(); 
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			 session.close();
		}
		return list;
	}

	@Override
	public DrugMaintenance findDrByNumber(String batchProduction) {
//		String hql=" from DrugMaintenance q where q.batchnumber='"+batchProduction+"'";
//		Session session=getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		DrugMaintenance qu = null;
//		if(query.list()!=null&&query.list().size()>0){
//			qu = (DrugMaintenance) query.list().get(0);
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String hql=" from DrugMaintenance q where q.batchnumber=:batchProduction";
		Session session= null;
		DrugMaintenance qu = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("batchProduction", batchProduction);
			if(query.list()!=null && query.list().size()>0){
				qu = (DrugMaintenance)query.list().get(0);
			}
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return qu;
	}

	@Override
	public List<PurchaseOrderItem> findcgdITJson() {
//		String hql =" from PurchaseOrderItem q where 1=1 and q.id not in (select r.purchaseNumber from ReceivingNote r ) ";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		List<PurchaseOrderItem> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String hql =" select q  from PurchaseOrder p, PurchaseOrderItem q, QualityMidicine m where 1=1 and  q.purchaseOrderId = p.id and q.qualifiedMedicineId = m.id" +
				" and p.status = '2' and q.id not in (select r.purchaseNumber from ReceivingNote r ) " +
				" and m.medicinalNo not in( select medicNo from  QualifiedMedcJH ) and p.useFlag = '0'" +
				" and len(q.batchProduction) > 7 "; 
		Session session = null;
		List<PurchaseOrderItem> list = null;
		try{ 
			
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
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
	public List<ReceivingNoteItem> findshdItemJson() {
//			String hql =" select q from ReceivingNote rn, ReceivingNoteItem q where 1=1 and rn.id=q.receivingNoteId and rn.checkConclusion='1' and rn.id not in  (select cn.receivingNumber from CheckAcceptNote cn  ) ";
//			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//			Query query = session.createQuery(hql);
//			List<ReceivingNoteItem> list = query.list();
//			try {
//				session.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		String hql =" select q from ReceivingNote rn, ReceivingNoteItem q where 1=1 and rn.id=q.receivingNoteId " +
				" and rn.checkConclusion='1' and rn.id not in  (select cn.receivingNumber from CheckAcceptNote cn  ) " +
				" and len(q.batchProduction) > 7 ";
		Session session = null;
		List<ReceivingNoteItem> list = null;
		try{ 
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
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
	public List<ReceivingNoteItem> findYpItemBy(String id) {
//		String hql =" from ReceivingNoteItem q where q.batchProduction='"+id+"'";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		List<ReceivingNoteItem> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	//	String hql =" from ReceivingNoteItem q where q.batchProduction=:id";
		String hql = "select a from ReceivingNoteItem a where a.receivingNoteId =:receivingNoteId ";
		List<ReceivingNoteItem> itemList  = null;
		Session session = null;
	//	List<ReceivingNoteItem> list = null;
	//	ReceivingNoteItem item = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("receivingNoteId", Long.parseLong(id));
			itemList = query.list();
			//item = (ReceivingNoteItem)session.get(ReceivingNoteItem.class, Long.parseLong(id));
			//itemList.add(item);
			//list = query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return itemList;
	}

	@Override
	public MedicinePrice getMedicinePriceByNumber(String medicNo) {
		List<MedicinePrice> medcPriceList = null;
		Session session = null;
		try{
			String sql = "select t.medc_no,t.trade_price,t.tax_price, t.pack_rate  from  t_medc_price t where t.medc_no=:medcNo";
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(sql);
			query.addScalar("medc_no",Hibernate.STRING);
			query.addScalar("trade_price", Hibernate.BIG_DECIMAL);
			query.addScalar("tax_price",Hibernate.BIG_DECIMAL);
			query.addScalar("pack_rate",Hibernate.STRING);
			query.setParameter("medcNo", medicNo);
			
			query.setResultTransformer(Transformers.aliasToBean(MedicinePrice.class));
			medcPriceList = query.list();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session !=null)
				session.close();
		}
		return (medcPriceList!=null && medcPriceList.size()>0)?medcPriceList.get(0):null;
	}

	@Override
	public List<QualityMidicine> findMedicJsonByDepaetId(String departId) {
		//String hql =" from QualityMidicine q where q.useflag=1 order by q.medicinalNo asc ";
		StringBuffer hqlBuffer = new StringBuffer(" select q from QualityMidicine q join q.dosageforms d  where q.useflag=0 ");
		if(departId!=null && !"".equals(departId)){
			hqlBuffer.append(" and q.departmentId like :departmentId");
		}
		
		hqlBuffer.append(" order by q.medicinalNo asc ");
		
		Session  session = null;
		List<QualityMidicine> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(departId!=null && !"".equals(departId)){
				query.setParameter("departmentId", "%"+departId+"%");
			}
			
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public TicketSamples getTicketSamplesByName(String ticketSamplesName) {
		List<TicketSamples> list = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(TicketSamples.class);
			criteria.add(Restrictions.eq("ticketSamplesName", ticketSamplesName));
			list = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null ){
				session.close();
			}
		}
		return (list != null && list.size()>0)?list.get(0):null;
	}

	@Override
	public void saveOrUpdateTicketSamples(TicketSamples ticketSamples) {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			session.saveOrUpdate(ticketSamples);
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null ){
				session.close();
			}
		}
		
		
	}
	
	
	
	
	
	@Override
	public List<ReveivingNoteVO> getPageIsNotJh(String date,String customerName, String checkResult, String isfood,int pageSize,int resultSize) {
		Session session = null;
		List<ReveivingNoteVO> recNotes = null;
		StringBuffer hqlBuffer = new StringBuffer("select new com.sinosoft.drugState.inspectionRecords.model.ReveivingNoteVO(rn,ri,qm) from ");
		hqlBuffer.append("ReceivingNote rn , ReceivingNoteItem ri ,QualityMidicine qm  where rn.id = ri.receivingNoteId and ri.qualifiedMedicineId = qm.id ");
		try{
			if(date!=null && !"".equals(date)){
				hqlBuffer.append(" and rn.receivedDate = :receivedDate ");
			}
			if(customerName!=null && !"".equals(customerName)){
				hqlBuffer.append(" and ri.batchProduction like :batchProduction ");
			}
			if(checkResult != null && !"".equals(checkResult)){
				hqlBuffer.append(" and rn.checkConclusion = :checkConclusion ");
			}
			if(isfood != null && !"".equals(isfood)){
				hqlBuffer.append(" and qm.isfood = :isfood ");
			}
			hqlBuffer.append(" and ri.qualifiedMedicineId not in (select tqm.id from QualifiedMedcJH jh, QualityMidicine tqm where jh.medicNo = tqm.medicinalNo) ");
			hqlBuffer.append(" and ri.quantity > 0 ");//屏蔽小于0的收货数据
			hqlBuffer.append(" and len(ri.batchProduction) > 7 ");
			hqlBuffer.append(" order by rn.id DESC");
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(date!=null && !"".equals(date)){
				query.setParameter("receivedDate", date);
			}
			if(customerName!=null && !"".equals(customerName)){
				query.setParameter("batchProduction", "%"+customerName+"%");
			}
			if(checkResult != null && !"".equals(checkResult)){
				query.setParameter("checkConclusion", checkResult);
			}
			if(isfood != null && !"".equals(isfood)){
				query.setParameter("isfood", isfood);
			}
			query.setFirstResult(pageSize);
			query.setMaxResults(resultSize);
			recNotes = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return recNotes;
	}
	
	
	
	
	@Override
	public int getTotalCountIsNotJh(String date,String customerName, String checkConclusion,String isfood) {
		Session session = null;
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from ReceivingNote rn,ReceivingNoteItem ri,QualityMidicine qm where rn.id = ri.receivingNoteId " );
		hqlBuffer.append(" and ri.qualifiedMedicineId = qm.id ");
		
		if(date!=null && !"".equals(date)){
			hqlBuffer.append(" and rn.receivedDate = :receivedDate ");
		}
		if(customerName!=null && !"".equals(customerName)){
			hqlBuffer.append(" and ri.batchProduction like :batchProduction ");
		}
		if(checkConclusion != null && !"".equals(checkConclusion)){
			hqlBuffer.append(" and rn.checkConclusion = :checkConclusion ");
		}
		if(isfood != null && !"".equals(isfood)){
			hqlBuffer.append(" and qm.isfood = :isfood ");
		}
		hqlBuffer.append(" and ri.qualifiedMedicineId not in (select tqm.id from QualifiedMedcJH jh, QualityMidicine tqm where jh.medicNo = tqm.medicinalNo) ");
		hqlBuffer.append(" and ri.quantity > 0 ");
		hqlBuffer.append(" and len(ri.batchProduction) > 7 ");
		int count = 0;
		try{
		session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hqlBuffer.toString());
		if(date!=null && !"".equals(date)){
			query.setParameter("receivedDate", date);
		}
		if(customerName!=null && !"".equals(customerName)){
			query.setParameter("batchProduction", "%"+customerName+"%");
		}
		if(checkConclusion != null && !"".equals(checkConclusion)){
			query.setParameter("checkConclusion", checkConclusion);
		}
		if(isfood != null && !"".equals(isfood)){
			query.setParameter("isfood", isfood);
		}
		count = Integer.parseInt(query.list().get(0).toString());
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			session.close();
		}
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
