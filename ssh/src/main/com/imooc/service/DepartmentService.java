package main.com.imooc.service;

import main.com.imooc.entity.Department;
import main.com.imooc.entity.PageBean;

import java.util.List;

/**
 * 部门管理的业务层的接口
 */
public interface DepartmentService {
    //查询页数
    PageBean<Department>findByPage(Integer currPage);
    //查询所有部门的方法
    List<Department> findAll();
    //保存方法
    void save(Department department);
    //根据部门id查询部门方法
    Department findById(int did);
    //更新方法
    void update(Department department);
    //删除方法
    void delete(Department department);
}
