package main.com.imooc.dao.Impl;

import main.com.imooc.dao.DepartmentDao;
import main.com.imooc.entity.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * 部门管理数据层实现类
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    //统计总记录数
    @Override
    public int findCount() {
        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from Department");
        String hql = sb.toString();
        List<Long> longs =  this.getHibernateTemplate().find(hql);
        this.getHibernateTemplate().find(hql);
        if(longs!=null && longs.size()>0){
            return longs.get(0).intValue();
        }
        return 0;
    }

    //分页查询页数
    @Override
    public List<Department> findByPage(Integer begin,Integer pageSize) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Department.class);
        List<Department> departments =  this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
        if(departments!=null && departments.size()>0){
            return departments;
        }
        return  null;
    }

    @Override
    public List<Department> findAll() {
        StringBuffer sb = new StringBuffer();
        sb.append("from Department");
        String hql = sb.toString();
        List<Department> departments =  this.getHibernateTemplate().find(hql);
        if(departments!=null && departments.size()>0){
            return departments;
        }
        return null;
    }

    /**
     * 保存方法
     * @param department
     */
    @Override
    public void save(Department department) {
        this.getHibernateTemplate().save(department);
    }

    /**
     * 根据部门id查询部门方法
     * @param did
     * @return
     */
    @Override
    public Department findById(int did) {
       /* StringBuffer sb = new StringBuffer();
        sb.append("from Department where did=?");
        String hql = sb.toString();
        List<Department> departments =  this.getHibernateTemplate().find(hql,did);
        if(departments!=null && departments.size()>0){
            return departments.get(0);
        }
        return null;*/
       return this.getHibernateTemplate().get(Department.class,did);
    }

    /**
     * 更新方法
     * @param department
     */
    @Override
    public void update(Department department) {
        this.getHibernateTemplate().update(department);
    }

    /**
     * 删除方法
     * @param department
     */
    @Override
    public void delete(Department department) {
        this.getHibernateTemplate().delete(department);
    }
}
