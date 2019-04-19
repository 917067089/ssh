package main.com.imooc.service.Impl;

import main.com.imooc.dao.DepartmentDao;
import main.com.imooc.entity.Department;
import main.com.imooc.entity.PageBean;
import main.com.imooc.service.DepartmentService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 部门管理业务层实现类
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public PageBean<Department> findByPage(Integer currPage) {
        PageBean<Department> pageBean = new PageBean<Department>();
        //封装当前的页数
        pageBean.setCurrPage(currPage);
        //封装每页显示的记录数
        int pageSize =3;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数 =总记录数除以每页显示多少条，然后向上取整
        double tc = totalCount;
        Double totalPage = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(totalPage.intValue());
        //封装每页显示的数据 从上页的数据的结束到这个页
        int begin = (currPage-1)*pageSize;
        List<Department> list =  departmentDao.findByPage(begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    /**
     * 查询所有部门的方法
     * @return
     */
    @Override
    public List<Department> findAll() {
        List<Department> departments = departmentDao.findAll();
        return departments;
    }

    /**
     * 保存方法
     * @param department
     */
    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    /**
     * 根据部门id查询部门方法
     * @param did
     * @return
     */
    @Override
    public Department findById(int did) {
        Department department = departmentDao.findById(did);
        return department;
    }

    /**
     * 更新方法
     * @param department
     */
    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    /**
     * 删除方法
     * @param department
     */
    @Override
    public void delete(Department department) {
        departmentDao.delete(department);
    }
}
