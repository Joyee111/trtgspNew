package com.sinosoft.drugState.mackNo.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.mackNo.dao.MakeNoDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.systemConfig.MakingNo;

@Repository("MakeNoDao")
public class MakeNoDaoImpl extends GenericDaoHibernate<MakingNo, Long> implements MakeNoDao{

	public MakeNoDaoImpl() {
		super(MakingNo.class);
	}
	public void update(MakingNo mc){
		this.getHibernateTemplate().saveOrUpdate(mc);
	}
	public MakingNo save(MakingNo mc){
		MakingNo mcs  = this.getHibernateTemplate().merge(mc);
		return mcs;
	}
	@Override
	public String mackNo(String desc) {
		MakingNo mc = findMN(desc);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String number = format.format(date);
		String d ="";
		if(mc.getNo()!=null && !"".equals(mc.getNo()) && number.equals(mc.getNo().substring(0, 8))){
			String a = mc.getNo().substring(8,mc.getNo().length());
			Integer b = Integer.parseInt(a)+1;
			String c = b.toString();
			if(c.length()==1){
				d="000"+c;
			}else if(c.length()==2){
				d="00"+c;
			}else if(c.length()==3){
				d="0"+c;
			}else if(c.length()==4){
				d=c;
			}
		}else{
			mc.setName(desc);
			d="0001";
		}
		String no =number+d;
		mc.setNo(no);
		update(mc);
		return no;
	}
	
	//用于购进退出的编号，形式为T16+7位数字，从0000001开始
	public String makeNo(String desc) {
		MakingNo mc = findMN(desc);
		String d ="";
		if(mc.getNo()!=null && !"".equals(mc.getNo())){
			String a = mc.getNo();
			Integer b = Integer.parseInt(a)+1;
			String c = b.toString();
			d = c;
		}else{
			mc.setName(desc);
			d="160000001";
		}
		mc.setNo(d);
		update(mc);
		return d;
	}
	public MakingNo findMN(String name) {
//		String hql = " from MakingNo where name='"+name+"'";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		MakingNo mc = new MakingNo();
//		if(query.list()!=null && query.list().size()>0){
//			mc= (MakingNo) query.list().get(0);
//		}
//		try {
//			session.flush();
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String hql = " from MakingNo where name='"+name+"'";
		Session session = null;
		List<MakingNo> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			//if(session!=null)
				session.close();
		}
		
		return (list!=null && list.size()>0)?list.get(0):null;
	}
	
	public MakingNo findMNById(Long MakingNoId){
		MakingNo mn = null;
		Session session =  null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			mn = (MakingNo) session.get(MakingNo.class, MakingNoId);
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			//if(session!=null)
				session.close();
		}
		
		return mn;
		
	}
	@Override
	public String findNo(String purchasenoteact) {
		//String hql = " from MakingNo where name='"+purchasenoteact+"'";
		DetachedCriteria daCriteria = DetachedCriteria.forClass(MakingNo.class);
		if(purchasenoteact!=null && !"".equals(purchasenoteact)){
			daCriteria.add(Restrictions.eq("name", purchasenoteact));
		}
		Session session = null;
		List<MakingNo> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = daCriteria.getExecutableCriteria(session);
			list = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			//if(session!=null)
				session.close();
		}
		return (list!=null && list.size()>0)?list.get(0).getNo():"";
		
	}
	@Override
	public List<MakingNo> getBillType(Map<String, Object> queryParams) {
		String hql=" from MakingNo where name='"+queryParams.get("sample")+"' or name='"+queryParams.get("rework")+"' ";
		Session session = null;
		List<MakingNo> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			//if(session!=null)
				session.close();
		}
		return list;
	}
	
	
}
