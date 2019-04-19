package main.com.imooc.dao;

import main.com.imooc.entity.Employee;

import java.util.List;

/**
 * 员工管理数据层接口
 */
public interface EmployeeDao {
    public Employee findByUsernameAndPassword(Employee employee);
    //查询总记录数
    int findCount();
    //分页查询
    List<Employee> findByPage(int begin, int pageSize);
    //保存方法
    void save(Employee employee);
    //根据员工id查询员工信息
    Employee findById(Integer eid);
    //update方法
    void update(Employee employee);
    //删除员工的方法
    void delete(Employee employee);
}
