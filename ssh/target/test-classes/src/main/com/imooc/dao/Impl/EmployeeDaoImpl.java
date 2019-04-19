package main.com.imooc.dao.Impl;

import main.com.imooc.dao.EmployeeDao;
import main.com.imooc.entity.Employee;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * 员工管理数据层实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
    /**
     * 在DAO中根据用户名和密码来查询用户的方法
     * @param employee
     * @return
     */
    @Override
    public Employee findByUsernameAndPassword(Employee employee) {
        String hql1  ="from Employee where username = ? and password = ?";
        StringBuffer sb = new StringBuffer();
        sb.append("from Employee where username = ? and password = ?");
        String hql = sb.toString();
        List<Employee> employees = this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
        if(employees.size()>0){
            return employees.get(0);
        }
        return null;
    }

    /**
     * 查询总记录数
     * @return
     */
    @Override
    public int findCount() {
        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from Employee");
        String hql = sb.toString();
        List<Long> longs = this.getHibernateTemplate().find(hql);
        if(longs!= null && longs.size()>0){
            return longs.get(0).intValue();
        }
        return 0;
    }

    /**
     * 分页查询
     * @param begin
     * @param pageSize
     * @return
     */
    @Override
    public List<Employee> findByPage(int begin, int pageSize) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Employee.class);
        List<Employee> employees = this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
        if(employees!=null && employees.size()>0){
            return employees;
        }
        return null;
    }

    /**
     * 保存方法
     * @param employee
     */
    @Override
    public void save(Employee employee) {
        this.getHibernateTemplate().save(employee);
    }

    /**
     * //根据员工id查询员工信息
     * @param eid
     */
    @Override
    public Employee findById(Integer eid) {
        /*StringBuffer sb = new StringBuffer();
        sb.append("select * from  Employee");
        String hql = sb.toString();
        List<Employee> employees = this.getHibernateTemplate().find(hql,eid);
        if(employees!= null && employees.size()>0){
            return employees.get(0);
        }
        return null;*/
        return this.getHibernateTemplate().get(Employee.class,eid);
    }

    /**
     * update 方法
     * @param employee
     */
    @Override
    public void update(Employee employee) {
        this.getHibernateTemplate().update(employee);
    }

    /**
     * //删除员工的方法
     * @param employee
     */
    @Override
    public void delete(Employee employee) {
        this.getHibernateTemplate().delete(employee);
    }
}
