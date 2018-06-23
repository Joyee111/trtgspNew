package com.sinosoft.drugState.outcheck.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.outcheck.dao.OutCheckDao;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBillVO;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfo;
import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfoVO;
import com.sinosoft.drugState.outcheck.model.TrtssSalesItemsInfo;
import com.sinosoft.util.StringUtil;

@Repository("OutCheckDao")
public class OutCheckDaoImpl extends GenericDaoHibernate<OutboundCheckBill, Long> implements OutCheckDao{

	public OutCheckDaoImpl() {
		super(OutboundCheckBill.class);
	}
	
	@Override
	public List<OutboundCheckBill> getPage(OutboundCheckBill mc, int i, int pagesize) {
		/*String hql = "from OutboundCheckBill t where t.reviewStatus=0";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<OutboundCheckBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "from OutboundCheckBill t where t.reviewStatus=0";
		Session session = null;
		List<OutboundCheckBill> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
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
	public int getTotalCount() {
		/*String hql = "select count(*) from OutboundCheckBill t where t.reviewStatus=0";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select count(*) from OutboundCheckBill t where t.reviewStatus=0";
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(list);
	}
	@Override
	public OutboundCheckBill save(OutboundCheckBill mc){
		OutboundCheckBill mcs =getHibernateTemplate().merge(mc);
		return mcs;
		
	}

	@Override
	public OutboundCheckBill findById(String id) {
		Session session = null;
		OutboundCheckBill outboundCheckBill =null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			outboundCheckBill = (OutboundCheckBill)session.get(OutboundCheckBill.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return outboundCheckBill;
	}

	@Override
	public void update(OutboundCheckBill mc) {
		this.getHibernateTemplate().saveOrUpdate(mc);
	}

	@Override
	public List<OutboundCheckBill> getPagedsh(OutboundCheckBill mc, int i,
			int pagesize) {
		/*String hql = "from OutboundCheckBill t where t.reviewStatus=1";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<OutboundCheckBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "from OutboundCheckBill t where t.reviewStatus=1";
		Session session = null;
		List<OutboundCheckBill> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
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
	public int getTotalCountdsh() {
		/*String hql = "select count(*) from OutboundCheckBill t where t.reviewStatus=1";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select count(*) from OutboundCheckBill t where t.reviewStatus=1";
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
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
	public List<OutboundCheckItem> find(String id) {
		/*String hql = "from OutboundCheckItem t where t.outboundCheckBillId="+Long.parseLong(id);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<OutboundCheckItem> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "from OutboundCheckItem t where t.outboundCheckBillId="+Long.parseLong(id);
		Session session = null; 
		List<OutboundCheckItem> list = null;
		try{
			session =  this.getHibernateTemplate().getSessionFactory().openSession();
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
	public List<OutboundCheckBill> getPageysh(OutboundCheckBill mc, int i,int pagesize) {
		/*String hql = "from OutboundCheckBill t where t.reviewStatus=2";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<OutboundCheckBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "from OutboundCheckBill t where t.reviewStatus=2";
		Session session = null;
		List<OutboundCheckBill> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
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
	public int getTotalCountysh() {
		/*String hql = "select count(*) from OutboundCheckBill t where t.reviewStatus=2";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select count(*) from OutboundCheckBill t where t.reviewStatus=2";
		Session session = null;
		String list = "0";
		try{ 
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
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
	public List<OutboundCheckBill> getPageybh(OutboundCheckBill mc, int i,
			int pagesize) {
		/*String hql = "from OutboundCheckBill t where t.reviewStatus=3";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<OutboundCheckBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "from OutboundCheckBill t where t.reviewStatus=3";
		Session session = null;
		List<OutboundCheckBill> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
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
	public int getTotalCountybh() {
		/*String hql = "select count(*) from OutboundCheckBill t where t.reviewStatus=3";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select count(*) from OutboundCheckBill t where t.reviewStatus=3";
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
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
	public void audit(String id) {
		String sql = " update t_check_accept_note t set t.review_status=2 where id="+Long.parseLong(id);
		Connection conn=this.getHibernateTemplate().getSessionFactory().openSession().connection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(null != conn)
				conn.close();
			if(null != stm)
				stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OutboundCheckItem> findYp(Long id) {
		/*String hql = "select t from OutboundCheckItem t where outboundCheckBillId ="+id;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<OutboundCheckItem> list= query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select t from OutboundCheckItem t where outboundCheckBillId =:id";
		Session session = null;
		List<OutboundCheckItem> list = null;
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
	public List<?> findAllId(Long id) {
		/*String hql = "select t.id from OutboundCheckItem t where outboundCheckBillId ="+id;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<?> list= query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select t.id from OutboundCheckItem t where outboundCheckBillId =:id";
		Session session = null;
		List<?> list = null;  
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
	public List<OutboundCheckItem> find(Long id, int i, int pagesize) {
		/*String hql = "from OutboundCheckItem t where t.outboundCheckBillId="+id;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<OutboundCheckItem> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "from OutboundCheckItem t where t.outboundCheckBillId=:id";
		Session session = null;
		List<OutboundCheckItem> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
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
	public int findCount(Long id) {
		/*String hql = "select count(*) from OutboundCheckItem t where t.outboundCheckBillId="+id;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select count(*) from OutboundCheckItem t where t.outboundCheckBillId=:id";
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
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
	public void del(String id) {
		OutboundCheckBill ch = findById(id);
		getHibernateTemplate().delete(ch);
	}

	@Override
	public List<TrtssSalesFormInfo> findxsJson() {
		/*String hql = " from TrtssSalesFormInfo t where 1=1 and t.id not in(select o.salesNumber from OutboundCheckBill o)";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<TrtssSalesFormInfo> list= query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = " from TrtssSalesFormInfo t where 1=1 and t.id not in(select o.salesNumber from OutboundCheckBill o)";
		Session session = null;
		List<TrtssSalesFormInfo> list = null;
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
	public List<TrtssSalesItemsInfo> findxsItem(String id) {
//	现在根据销售细单号查询 之前是根据销售总单号查询	String hql = " from TrtssSalesItemsInfo t where t.salesItemNo="+id;
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		List<TrtssSalesItemsInfo> list= query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
		Session session = null;
		//String[] strs = id.split("_");
		String department = id.substring(0,1);
		String salesItemNo = id.substring(1);
		List<TrtssSalesItemsInfo> list = null;
		try{
			session  = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(TrtssSalesItemsInfo.class);
			if(department.equalsIgnoreCase("Y")){
				criteria.add(Restrictions.eq("departmentId", "1001"));
			}else if(department.equalsIgnoreCase("X")){
				criteria.add(Restrictions.eq("departmentId", "2001"));
			}else if(department.equalsIgnoreCase("S")){
				criteria.add(Restrictions.eq("departmentId", "3001"));
			}
			criteria.add(Restrictions.eq("salesItemNo", salesItemNo));
			list = criteria.list();
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
	public TrtssSalesFormInfo findxsBy(String salesNumber) {
		/*String hql = " from TrtssSalesFormInfo t where t.sqlesFormNo='"+salesNumber+"'";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		TrtssSalesFormInfo tf = new TrtssSalesFormInfo();
		if(query.list()!=null && query.list().size()>0){
			tf=(TrtssSalesFormInfo) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = " from TrtssSalesFormInfo t where t.sqlesFormNo=:salesNumber";
		Session session = null;
		List<TrtssSalesFormInfo> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("salesNumber", salesNumber);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return (list!=null && list.size()>0)?list.get(0):null;
	}

	@Override
	public TrtssSalesFormInfo findTFById(String id) {
		/*String hql = " from TrtssSalesFormInfo t where t.id="+Long.parseLong(id);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		TrtssSalesFormInfo tf = new TrtssSalesFormInfo();
		if(query.list()!=null && query.list().size()>0){
			tf=(TrtssSalesFormInfo) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		TrtssSalesFormInfo tf = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			tf = (TrtssSalesFormInfo)session.get(TrtssSalesFormInfo.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return tf;
	}

	@Override
	public TrtssSalesFormInfo findxsById(String salesNumber) {
		//String hql = " from TrtssSalesFormInfo t where t.id="+Long.parseLong(salesNumber);
		Session session =  null;
		TrtssSalesFormInfo trtssSalesFormInfo = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			trtssSalesFormInfo = (TrtssSalesFormInfo)session.get(TrtssSalesFormInfo.class, Long.parseLong(salesNumber));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return trtssSalesFormInfo;	
	}

	@Override
	public List<TrtssSalesFormInfo> findSaleNo(String contractNumber,
			String saleNumber, int i, int pagesize) {
		StringBuffer sql = new StringBuffer(
				" select t.id,t.sales_form_no,t.create_date,t.contract_no from trtss_sales_form_info t where t.id not in ( select c.sales_number from t_outbound_check_bill c ) ");
		if (contractNumber != null && !"".equals(contractNumber)) {
			sql.append(" and t.contract_no like :contractNumber ");
		}
		if (saleNumber != null && !"".equals(saleNumber)) {
			sql.append(" and t.sales_form_no like :saleNumber");
		}
		Session session = null;
		List<?> list = null;
		try {
			session = this.getHibernateTemplate().getSessionFactory()
					.openSession();
			SQLQuery query = session.createSQLQuery(sql.toString());
			if (contractNumber != null && !"".equals(contractNumber)) {
				query.setParameter("contractNumber", "%" + contractNumber+ "%");
			}
			if (saleNumber != null && !"".equals(saleNumber)) {
				query.setParameter("saleNumber", "%" + saleNumber + "%");
			}

			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			list = query.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		List<TrtssSalesFormInfo> lists = new ArrayList<TrtssSalesFormInfo>();
		if (list != null) {
			if (list.size() > 0) {
				for (int j = 0; j < list.size(); j++) {
					Object[] obj = (Object[]) list.get(j);
					TrtssSalesFormInfo t = new TrtssSalesFormInfo();
					if (obj[0] != null) {
						t.setId(Long.parseLong(obj[0].toString()));
					}
					if (obj[1] != null) {
						t.setSqlesFormNo(obj[1].toString());
					}
					if (obj[2] != null) {
						t.setSaleTime(obj[2].toString());
					}
					if (obj[3] != null) {
						t.setContractNo(obj[3].toString());
					}
					lists.add(t);
				}
			}
		}
		return lists;
	}

	@Override
	public int getTotalCountSaleNodlr(String contractNumber,String saleNumber) {
		StringBuffer hql = new StringBuffer("select count(t.id) from trtss_sales_form_info t where t.id not in ( select c.sales_number from t_outbound_check_bill c ) ");
		if(contractNumber!=null && !"".equals(contractNumber)){
			hql.append(" and t.contract_no like :contractNumber ");
		}
		if(saleNumber!=null && !"".equals(saleNumber)){
			hql.append(" and t.sales_form_no like :saleNumber");
		}
		Session session = null;
		String list = "0";
		try{
		session = 	this.getHibernateTemplate().getSessionFactory().openSession();
		SQLQuery query = session.createSQLQuery(hql.toString());
		if(contractNumber!=null && !"".equals(contractNumber)){
				query.setParameter("contractNumber", "%"+contractNumber+"%");
		}
		if(saleNumber!=null && !"".equals(saleNumber)){
			query.setParameter("saleNumber", "%"+saleNumber+"%");
		}
		 list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return Integer.parseInt(list);
	}

	@Override
	public List<String[]> findSaleDetailNO(String requestName) {
		Session  session = null;
		List<String[]> list =null;
		StringBuffer hql = new StringBuffer("select t.real_sales_item_no,t.department_id from  trtss_sales_items_info  t  where 1=1 and t.medc_no not in (SELECT medc_no FROM t_medc_jh )");
		if(requestName != null && !"".equals(requestName.trim()) ){
			if(requestName.trim().length()<3){
				return list;
			}
			/*String subStr = requestName.substring(0,1);
			if(!StringUtil.validateDepartment(subStr)){
				return list;
			}else if(requestName.trim().length()==1 && StringUtil.validateDepartment(subStr)){
				if(requestName.equalsIgnoreCase("y")){
					hql.append(" and t.department_id = '1001' ");
				}else if(requestName.equalsIgnoreCase("x")){
					hql.append(" and t.department_id = '2001' ");
				}else if(requestName.equalsIgnoreCase("s")){
					hql.append(" and t.department_id = '3001' ");
				}
			}else if(requestName.trim().length()>1 && StringUtil.validateDepartment(subStr) ){
				String end = requestName.trim().substring(1);
				if(subStr.equalsIgnoreCase("y")){
					hql.append(" and t.department_id = '1001' ");
				}else if(subStr.equalsIgnoreCase("x")){
					hql.append(" and t.department_id = '2001' ");
				}else if(subStr.equalsIgnoreCase("s")){
					hql.append(" and t.department_id = '3001' ");
				}
				hql.append(" and t.sales_item_no like'%"+end+"%' ");
			}*/
			hql.append(" and t.real_sales_item_no like'%"+requestName+"%' ");
			hql.append("  group by t.real_sales_item_no,t.department_id ");
			hql.append("having  not exists (select b.id from t_outbound_check_bill b  where t.real_sales_item_no = b.sales_number )");
			hql.append(" order by t.department_id  ");
			try{
				session = getHibernateTemplate().getSessionFactory().openSession();
				Query query = session.createSQLQuery (hql.toString());
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
		
		/*try{
			
//			StringBuffer hql = new StringBuffer("select t.salesItemNo,t.departmentId from TrtssSalesItemsInfo t where 1=1 and t.salesItemNo not in(select o.salesNumber from OutboundCheckBill o) ");
			//StringBuffer hql = new StringBuffer("select t.salesItemNo,t.departmentId from TrtssSalesItemsInfo t  ");
			StringBuffer hql = new StringBuffer("select t.sales_item_no,t.department_id from  trtss_sales_items_info  t  where 1=1");
			
			if(requestName!=null && requestName.length()==1){
				if(StringUtil.validateEngsh(requestName)&& StringUtil.validateDepartment(requestName)){
					if(requestName.equalsIgnoreCase("y")){
						hql.append(" and t.department_id = '1001' ");
					}else if(requestName.equalsIgnoreCase("x")){
						hql.append(" and t.department_id = '2001' ");
					}else if(requestName.equalsIgnoreCase("s")){
						hql.append(" and t.department_id = '3001' ");
					}
				}
			}else if(requestName.length()>1){
				String head = requestName.substring(0,1);
				String end  = requestName.substring(1);
				if(StringUtil.validateEngsh(head)){
					if(StringUtil.validateDepartment(head)){
						if(head.equalsIgnoreCase("y")){
							hql.append(" and t.department_id = '1001' ");
						}else if(head.equalsIgnoreCase("x")){
							hql.append(" and t.department_id = '2001' ");
						}else if(head.equalsIgnoreCase("s")){
							hql.append(" and t.department_id = '3001' ");
						}
					}else{
						hql.append(" and t.sales_item_no like'%"+end+"%' ");
					}
				}
				if(StringUtil.validateInteger(end)){
					hql.append(" and t.sales_item_no like'%"+end+"%' ");
				}
			}
			hql.append("  group by t.sales_item_no,t.department_id ");
			hql.append("having  not exists (select b.id from t_outbound_check_bill b  where t.sales_item_no = SUBSTRING(b.sales_number,2,LEN(b.sales_number)) and SUBSTRING(b.sales_number,1,1)=case when t.department_id='1001' then 'Y' when t.department_id='2001' then 'X' when t.department_id='3001' then 'S' end)");
			hql.append(" order by t.department_id  ");
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery (hql.toString());
			query.setFirstResult(0);
			query.setMaxResults(200);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}*/
		return list;
	}

	@Override
	public List<?> findRetturnRecordSaleDetailNO(String requestName) {
		Session session = null;
		List<?> list = null;
		StringBuffer hql = new StringBuffer("select t.real_sales_item_no  from trtss_sales_items_info t  where 1=1 ");
		if(requestName != null && !"".equals(requestName.trim()) ){
			if(requestName.trim().length() < 3){
				return list;
			}
			/*String subStr = requestName.substring(0,1);
			if(!StringUtil.validateDepartment(subStr)){
				return list;
			}else if(requestName.trim().length()==1 && StringUtil.validateDepartment(subStr)){
				if(requestName.equalsIgnoreCase("y")){
					hql.append(" and t.department_id = '1001' ");
				}else if(requestName.equalsIgnoreCase("x")){
					hql.append(" and t.department_id = '2001' ");
				}else if(requestName.equalsIgnoreCase("s")){
					hql.append(" and t.department_id = '3001' ");
				}
			}else if(requestName.trim().length()>1 && StringUtil.validateDepartment(subStr) ){
				String end = requestName.trim().substring(1);
				if(subStr.equalsIgnoreCase("y")){
					hql.append(" and t.department_id = '1001' ");
				}else if(subStr.equalsIgnoreCase("x")){
					hql.append(" and t.department_id = '2001' ");
				}else if(subStr.equalsIgnoreCase("s")){
					hql.append(" and t.department_id = '3001' ");
				}
				hql.append(" and t.sales_item_no like'%"+end+"%' ");
			}*/
			
			hql.append("and t.real_sales_item_no like '%"+requestName+"%' ");
			hql.append(" and LEN(t.batch_no) > 7 ");
			hql.append(" group by  t.real_sales_item_no  ");
			//hql.append("having not exists (select b.id from t_return_receiving_note b where  t.real_sales_item_no = b.sale_no )");
			//hql.append("order by t.department_id ");
			try{
				session = getHibernateTemplate().getSessionFactory().openSession();
				Query query = session.createSQLQuery (hql.toString());
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
		/*try{
			//StringBuffer hql = new StringBuffer("select t.salesItemNo,t.departmentId from TrtssSalesItemsInfo t where t.salesItemNo not in (select n.saleNo as long from ReturnReceivingNote n)");
			StringBuffer hql = new StringBuffer("select t.sales_item_no ,t.department_id from trtss_sales_items_info t  where 1=1 ");
			if(requestName!=null && requestName.length()==1){
				if(StringUtil.validateEngsh(requestName)&& StringUtil.validateDepartment(requestName)){
					if(requestName.equalsIgnoreCase("y")){
						hql.append(" and t.department_id = '1001' ");
					}else if(requestName.equalsIgnoreCase("x")){
						hql.append(" and t.department_id = '2001' ");
					}else if(requestName.equalsIgnoreCase("s")){
						hql.append(" and t.department_id = '3001' ");
					}
				}
			}else if(requestName.length()>1){
				String head = requestName.substring(0,1);
				String end  = requestName.substring(1);
				if(StringUtil.validateEngsh(head)){
					if(StringUtil.validateDepartment(head)){
						if(head.equalsIgnoreCase("y")){
							hql.append(" and t.department_id = '1001' ");
						}else if(head.equalsIgnoreCase("x")){
							hql.append(" and t.department_id = '2001' ");
						}else if(head.equalsIgnoreCase("s")){
							hql.append(" and t.department_id = '3001' ");
						}
						hql.append(" and t.sales_item_no like'%"+end+"%' ");
					}else{
						hql.append(" and t.sales_item_no like'%"+end+"%' ");
					}
				}else if(StringUtil.validateInteger(head)){
					hql.append(" and t.sales_item_no like'%"+end+"%' ");
				}
			}
			hql.append(" group by  t.sales_item_no,t.department_id ");
			hql.append("having not exists (select b.id from t_return_receiving_note b where  t.sales_item_no = SUBSTRING(b.sale_no,2,LEN(b.sale_no)) and SUBSTRING(b.sale_no,1,1)=case when t.department_id='1001' then 'Y' when t.department_id='2001' then 'X' when t.department_id='3001' then 'S' end )");
			hql.append("order by t.department_id ");
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query  query = session.createSQLQuery(hql.toString());
			query.setFirstResult(0);
			query.setMaxResults(200);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}*/
		return list;
	}

	@Override
	public TrtssSalesFormInfo findSalesFromInfoBySalesItemId(String id) {
		Session session = null;
		List<TrtssSalesFormInfo> salesFormInfos = null;
		String department = id.substring(0,1);
		String salesItemNo = id.substring(1);
		String hql = "select a from TrtssSalesFormInfo a ,TrtssSalesItemsInfo b where a.sqlesFormNo = b.salesFormNo and a.departmentId = b.departmentId and b.salesItemNo=:salesItemId and b.departmentId=:departmentId";  
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("salesItemId", salesItemNo);
			if(department.equalsIgnoreCase("Y")){
				query.setParameter("departmentId", "1001");
			}else if(department.equalsIgnoreCase("X")){
				query.setParameter("departmentId", "2001");
			}else if(department.equalsIgnoreCase("S")){
				query.setParameter("departmentId", "3001");
			}
			salesFormInfos = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return (salesFormInfos!=null && salesFormInfos.size()>0)?salesFormInfos.get(0):null;
	}

	@Override
	public int countOutboundCheckBillByStatus(String status) {
		Session session = null;
		StringBuffer hql = new StringBuffer("select count(*) from OutboundCheckBill a,OutboundCheckItem b" );
		hql.append(" where b.outboundCheckBillId = a.id and a.reviewStatus =:status ");
		String count = "0";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setParameter("status", Long.parseLong(status));
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
	public List<OutboundCheckBillVO> findOutboundCheckBillByStatus(
			String statuas,int first ,int pagesize) {
		Session session = null;
		List<OutboundCheckBillVO> list = null;
		StringBuffer hql = new StringBuffer("select new com.sinosoft.drugState.outcheck.model.OutboundCheckBillVO(a,b) from OutboundCheckBill a,OutboundCheckItem b" );
		hql.append(" where b.outboundCheckBillId = a.id and a.reviewStatus =:status ");
		hql.append(" order by a.salesFromNumber DESC,a.salesNumber DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setParameter("status", Long.parseLong(statuas));
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
	public List<TrtssSalesFormInfoVO> findSalesFromInfoVO(String salesNumber,
			String contractNumber, int first, int pagesize) {
		Session session = null;
		List<TrtssSalesFormInfoVO> list = null;

		StringBuffer hql = new StringBuffer(" select  z.contractNo,z.salesFromNumber,z.salesItemNumber,z.commonName,z.salesDate,z.departmentId  from ");
		hql.append("(select a.contract_no as contractNo , a.sales_form_no as salesFromNumber,");
		hql.append("case when b.department_id='1001' then 'Y'+b.sales_item_no when b.department_id ='2001' then 'X'+b.sales_item_no when b.department_id='3001' then 'S'+b.sales_item_no end as salesItemNumber,");
		hql.append("c.common_name as commonName ,SUBSTRING( CONVERT(varchar(50),a.create_date,20),1,10) as salesDate ,b.department_id as departmentId from ");
		hql.append(" trtss_sales_form_info a,trtss_sales_items_info b,t_qualified_medicine c ");
		hql.append(" WHERE b.sales_form_no = a.sales_form_no AND b.department_id = a.department_id AND b.qualified_medicine_id = c.id) z ");
		hql.append(" where z.salesItemNumber not in(select sales_number from t_outbound_check_bill)	");
		if(salesNumber!=null && !"".equals(salesNumber) ){
			hql.append(" and  z.salesItemNumber like :salesNumber ");
		}
		if(contractNumber!=null && !"".equals(contractNumber)){
			hql.append(" and z.contractNo like :contractNumber ");
		}
		hql.append("GROUP BY z.contractNo,z.salesFromNumber,z.salesItemNumber,z.commonName,z.salesDate,z.departmentId ");
		
	
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(hql.toString());
			
			if (salesNumber != null && !"".equals(salesNumber)) {
				query.setParameter("salesNumber", "%" + salesNumber + "%");
			}
			if (contractNumber != null && !"".equals(contractNumber)) {
				query.setParameter("contractNumber", "%" + contractNumber+ "%");
			}
			query.addScalar("contractNo", Hibernate.STRING);
			query.addScalar("salesFromNumber", Hibernate.STRING);
			query.addScalar("salesItemNumber", Hibernate.STRING);
			query.addScalar("commonName", Hibernate.STRING);
			query.addScalar("salesDate", Hibernate.STRING);
			query.addScalar("departmentId", Hibernate.STRING);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			query.setResultTransformer(Transformers.aliasToBean(TrtssSalesFormInfoVO.class));
			list = query.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	@Override
	public int countSalesFromInfoVO(String salesNumber, String contractNumber) {
		Session session = null;
		List<TrtssSalesFormInfoVO> list = null;
		StringBuffer hql = new StringBuffer(" select  z.contractNo,z.salesFromNumber,z.salesItemNumber,z.commonName,z.salesDate,z.departmentId  from ");
		hql.append("(select a.contract_no as contractNo , a.sales_form_no as salesFromNumber,");
		hql.append("case when b.department_id='1001' then 'Y'+b.sales_item_no when b.department_id ='2001' then 'X'+b.sales_item_no when b.department_id='3001' then 'S'+b.sales_item_no end as salesItemNumber,");
		hql.append("c.common_name as commonName ,SUBSTRING( CONVERT(varchar(50),a.create_date,20),1,10) as salesDate ,b.department_id as departmentId from ");
		hql.append(" trtss_sales_form_info a,trtss_sales_items_info b,t_qualified_medicine c ");
		hql.append(" WHERE b.sales_form_no = a.sales_form_no AND b.department_id = a.department_id AND b.qualified_medicine_id = c.id) z ");
		hql.append(" where z.salesItemNumber not in(select sales_number from t_outbound_check_bill)	");
		if(salesNumber!=null && !"".equals(salesNumber) ){
			hql.append(" and  z.salesItemNumber like :salesNumber ");
		}
		if(contractNumber!=null && !"".equals(contractNumber)){
			hql.append(" and z.contractNo like :contractNumber ");
		}
		hql.append("GROUP BY z.contractNo,z.salesFromNumber,z.salesItemNumber,z.commonName,z.salesDate,z.departmentId ");
		
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(hql.toString());
			
			if (salesNumber != null && !"".equals(salesNumber)) {
				query.setParameter("salesNumber", "%" + salesNumber + "%");
			}
			if (contractNumber != null && !"".equals(contractNumber)) {
				query.setParameter("contractNumber", "%" + contractNumber+ "%");
			}
			query.addScalar("contractNo", Hibernate.STRING);
			query.addScalar("salesFromNumber", Hibernate.STRING);
			query.addScalar("salesItemNumber", Hibernate.STRING);
			query.addScalar("commonName", Hibernate.STRING);
			query.addScalar("salesDate", Hibernate.STRING);
			query.addScalar("departmentId", Hibernate.STRING);
			query.setResultTransformer(Transformers.aliasToBean(TrtssSalesFormInfoVO.class));
			list = query.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return list.size();
	}
}
