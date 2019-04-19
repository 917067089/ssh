package main.com.imooc.service;

import main.com.imooc.entity.Employee;
import main.com.imooc.entity.PageBean;

/**
 * 员工管理的业务层的接口
 */
public interface EmployeeService {
    public Employee login(Employee employee);
    //分页查询
    PageBean<Employee> findByPage(Integer currPage);
    //保存方法
    void save(Employee employee);
    //根据员工id查询员工信息
    Employee findById(Integer eid);
    //update方法
    void update(Employee employee);
    //删除员工的方法
    void delete(Employee employee);
}
