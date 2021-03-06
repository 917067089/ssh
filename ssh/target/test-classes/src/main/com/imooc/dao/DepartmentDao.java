package main.com.imooc.dao;

import main.com.imooc.entity.Department;
import main.com.imooc.entity.PageBean;

import java.util.List;

/**
 * 部门管理数据层接口
 */
public interface DepartmentDao {
    //统计总共多少条
    int findCount();
    //分页查询页数
    List<Department> findByPage(Integer begin,Integer pageSize);
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
