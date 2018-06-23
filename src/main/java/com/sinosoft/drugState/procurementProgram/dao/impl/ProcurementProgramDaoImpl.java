package com.sinosoft.drugState.procurementProgram.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.procurementProgram.dao.ProcurementProgramDao;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlan;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanItem;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;
@Repository("ProcurementProgramDao")
public class ProcurementProgramDaoImpl extends GenericDaoHibernate<PurchasePlan, Long> implements ProcurementProgramDao{

	public ProcurementProgramDaoImpl() {
		super(PurchasePlan.class);
	}

	@Override
	public List<PurchasePlanItem> getPage(PurchasePlan rurIt, String types,int i, int pagesize) {
		StringBuffer hql=new StringBuffer("");
		if(rurIt!=null){
			hql.append( "select p from PurchasePlanItem p,PurchasePlan q where q.id=p.purchasePlanOrder ");
			if(rurIt.getYear()!=null && !"".equals(rurIt.getYear())){
				hql.append(" and q.year='"+rurIt.getYear()+"'");
			}
			if(rurIt.getSeason()!=null && !"".equals(rurIt.getSeason())){
				hql.append(" and q.season='"+rurIt.getSeason()+"'");
			}
			if(rurIt.getPlanNo()!=null && !"".equals(rurIt.getPlanNo())){
				hql.append(" and q.planNo='"+rurIt.getPlanNo()+"'");
			}
			if(rurIt.getQualifiedSupplierId()!=null && !"".equals(rurIt.getQualifiedSupplierId())){
				hql.append(" and q.qualifiedSupplierId="+rurIt.getQualifiedSupplierId());
			}
			if(rurIt.getDepartmentId()!=null && !"".equals(rurIt.getDepartmentId())){
				hql.append(" and q.departmentId='"+rurIt.getDepartmentId()+"' ");
			}
		}else{
			hql.append(" from PurchasePlanItem p where 1=1");
		}
		if(types!=null && !"".equals(types)){
			hql.append(" and p.planType= '"+types+"'");
		}
		hql.append(" order by p.id DESC ");
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		List<PurchasePlanItem> res = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<PurchasePlanItem> res = null;
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
	public int getTotalCount(PurchasePlan rurIt,String types) {
		StringBuffer hql=new StringBuffer("");
		if(rurIt!=null){
			hql.append( "select count(p) from PurchasePlanItem p,PurchasePlan q where q.id=p.purchasePlanOrder ");
			if(rurIt.getYear()!=null && !"".equals(rurIt.getYear())){
				hql.append(" and q.year='"+rurIt.getYear()+"'");
			}
			if(rurIt.getSeason()!=null && !"".equals(rurIt.getSeason())){
				hql.append(" and q.season='"+rurIt.getSeason()+"'");
			}
			if(rurIt.getPlanNo()!=null && !"".equals(rurIt.getPlanNo())){
				hql.append(" and q.planNo='"+rurIt.getPlanNo()+"'");
			}
			if(rurIt.getQualifiedSupplierId()!=null && !"".equals(rurIt.getQualifiedSupplierId())){
				hql.append(" and q.qualifiedSupplierId="+rurIt.getQualifiedSupplierId());
			}
			if(rurIt.getDepartmentId()!=null && !"".equals(rurIt.getDepartmentId())){
				hql.append(" and q.departmentId='"+rurIt.getDepartmentId()+"' ");
			}
		}else{
			hql.append(" select count(*) from PurchasePlanItem p where 1=1");
		}
		if(types!=null && !"".equals(types)){
			hql.append(" and p.planType= '"+types+"'");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		String res = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		String res = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			 res = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		Integer a = Integer.parseInt(res);
		return a;
	}

	@Override
	public PurchasePlan savepl(PurchasePlan pl) {
		PurchasePlan pls =this.getHibernateTemplate().merge(pl);
		return pls;
	}

	@Override
	public PurchasePlan find(String departmentId,String season, String year, Long parseLong){
		//String hql="from PurchasePlan p where p.season='"+season+"' and p.year='" +year+"' and p.qualifiedSupplierId="+parseLong ;
		StringBuffer hqlBuffer = new StringBuffer("from PurchasePlan p where 1=1 ");
		if(departmentId!=null && !"".equals(departmentId)){
			hqlBuffer.append(" and p.departmentId =:departmentId ");
		}
		if(season!=null && !"".equals(season)){
			hqlBuffer.append(" and p.season =:season ");
		}
		if(year!=null && !"".equals(year)){
			hqlBuffer.append(" and p.year =:year ");
		}
		if(parseLong!=null){
			hqlBuffer.append(" and p.qualifiedSupplierId =:qualifiedSupplierId ");
		}
		Session session =  null;
		List<PurchasePlan> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(departmentId!=null && !"".equals(departmentId)){
				query.setParameter("departmentId", departmentId);
			}
			if(season!=null && !"".equals(season)){
				query.setParameter("season", season);
			}
			if(year!=null && !"".equals(year)){
				query.setParameter("year", year);
			}
			if(parseLong!=null){
				query.setParameter("qualifiedSupplierId", parseLong);
			}
			list =query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return (list!=null && list.size()>0)?list.get(0):null;
	}

	@Override
	public PurchasePlanStore findps(String departmentId, String season, String year, Long parseLong) {
	//	String hql="from PurchasePlanStore p where p.season='"+season+"' and p.year='" +year+"' and p.qualityMidicineId="+parseLong ;
		StringBuffer hqlBuffer = new StringBuffer("from PurchasePlanStore p where 1=1");
		if(departmentId!=null && !"".equals(departmentId)){
			hqlBuffer.append(" and p.departmentId =:departmentId ");
		}
		if(season!=null && !"".equals(season)){
			hqlBuffer.append(" and p.season =:season ");
		}
		if(year!=null && !"".equals(year)){
			hqlBuffer.append(" and p.year =:year ");
		}
		if(parseLong!=null ){
			hqlBuffer.append(" and p.qualityMidicineId =:qualityMidicineId ");
		}
		Session session = null;
		List<PurchasePlanStore> list =null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(departmentId!=null && !"".equals(departmentId)){
				query.setParameter("departmentId", departmentId);
			}
			if(season!=null && !"".equals(season)){
				query.setParameter("season", season);
			}
			if(year!=null && !"".equals(year)){
				query.setParameter("year", year);
			}
			if(parseLong!=null ){
				query.setParameter("qualityMidicineId", parseLong);
			}
			list= query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session !=null )
				session.close();
		}
		return (list!=null && list.size()>0)?list.get(0):null;
	}

	@Override
	public String findAllNo(String year, String season, String whone) {
		StringBuffer sql = new StringBuffer(" select t.plan_no from t_purchase_plan_order t where 1=1 ");
		sql.append(" and t.year= '"+year+"'");
		//sql.append(" and t.season= '"+season+"'");
		if(whone!=null && whone.equals("1")){
			sql.append(" and t.plan_no like'%A%' ");
		}else if(whone.equals("2")){
			sql.append(" and t.plan_no like'%B%' ");
		}else if(whone.equals("3")){
			sql.append(" and t.plan_no like'%B%' ");
		}
		sql.append(" order by t.id desc ");
		Session session = null;
		String a = "";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
			if(sqlQuery.list()!=null && sqlQuery.list().size()>0){
				a=sqlQuery.list().get(0).toString();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session !=null )
				session.close();
		}
		return a;
	}

	@Override
	public List<PurchasePlanItem> getAllPurchasePlanIten(PurchasePlan plan,
			String types) {
		StringBuffer hql=new StringBuffer("");
		if(plan.getQualifiedSupplierId()!=null || plan.getSeason()!=null || plan.getYear()!=null || plan.getPlanNo()!=null){
			hql.append( "select p from PurchasePlanItem p,PurchasePlan q where q.id=p.purchasePlanOrder ");
			if(plan.getYear()!=null && !"".equals(plan.getYear())){
				hql.append(" and q.year='"+plan.getYear()+"'");
			}
			if(plan.getSeason()!=null && !"".equals(plan.getSeason())){
				hql.append(" and q.season='"+plan.getSeason()+"'");
			}
			if(plan.getPlanNo()!=null && !"".equals(plan.getPlanNo())){
				hql.append(" and q.planNo='"+plan.getPlanNo()+"'");
			}
			if(plan.getQualifiedSupplierId()!=null && !"".equals(plan.getQualifiedSupplierId())){
				hql.append(" and q.qualifiedSupplierId="+plan.getQualifiedSupplierId());
			}
		}else{
			hql.append(" from PurchasePlanItem p where 1=1");
		}
		if(types!=null && !"".equals(types)){
			hql.append(" and p.planType= '"+types+"'");
		}
		Session session = null;
		List<PurchasePlanItem> purchasePlanItems = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			purchasePlanItems = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return purchasePlanItems;
	}
	
}
