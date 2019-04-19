package main.com.imooc.service.Impl;

import main.com.imooc.dao.EmployeeDao;
import main.com.imooc.entity.Department;
import main.com.imooc.entity.Employee;
import main.com.imooc.entity.PageBean;
import main.com.imooc.service.EmployeeService;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 员工管理的业务层的实现类
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    //注入Dao层
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * 实现登录的方法
     * @param employee
     * @return
     */
    @Override
    public Employee login(Employee employee) {
        Employee employeeTemp = employeeDao.findByUsernameAndPassword(employee);
        return employeeTemp;
    }

    @Override
    public PageBean<Employee> findByPage(Integer currPage) {
        PageBean<Employee> pageBean = new PageBean<Employee>();
        pageBean.setCurrPage(currPage); //当前页数
        int pageSize=3;
        pageBean.setPageSize(pageSize);//每页显示的记录数
        int totalCount = employeeDao.findCount(); //总记录数
        pageBean.setTotalCount(totalCount);
        Double  totalPage = Math.ceil(Double.valueOf(totalCount)/pageSize);
        pageBean.setTotalPage(totalPage.intValue());//总页数
        //每页显示的数据
        int  begin = (currPage-1)*pageSize;
        List<Employee> employees = employeeDao.findByPage(begin,pageSize);
        pageBean.setList(employees);
        return  pageBean;
    }

    /**
     * 保存方法
     * @param employee
     */
    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    /**
     * 根据员工id查询员工信息
     * @param eid
     * @return
     */
    @Override
    public Employee findById(Integer eid) {
        Employee  employee = employeeDao.findById(eid);
        return employee;
    }

    /**
     * update方法
     * @param employee
     */
    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    /**
     * //删除员工的方法
     * @param employee
     */
    @Override
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }
}


