package main.com.imooc.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import main.com.imooc.entity.Department;
import main.com.imooc.entity.PageBean;
import main.com.imooc.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 部门管理Action类
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
    private static final Logger log = LoggerFactory.getLogger(DepartmentAction.class);
    //模型驱动使用对象
    private Department department = new Department();

    @Override
    public Department getModel() {
        return department;
    }
    //注入部门管理
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //查询页数，默认当前是第一页
    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    /**
     * 部门查询的方法
     * @return
     */
    public String findAll(){
        PageBean<Department> pageBean = departmentService.findByPage(currPage);
        //将pageBean村早值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        log.info("总共查询到数据"+pageBean.getTotalCount());
        return "findAll";
    }
    //跳转到添加部门的页面的方法
    public String saveUI(){
        return "saveUI";
    }
    /**
     * 添加部门的方法
     */
    public String save(){
        departmentService.save(department);
        return "saveSuccess";
    }

    /**
     * 编辑部门的执行方法
     * @return
     */
    public String edit(){
        department = departmentService.findById(department.getDid());
        return "editSuccess";
    }

    /**
     * 更新部门方法
     * @return
     */
    public String update(){
        departmentService.update(department);
        return "updateSuccess";
    }
    /**
     * 删除部门方法
     */
    public String delete(){
        department = departmentService.findById(department.getDid());
        departmentService.delete(department);
        return "deleteSuccess";
    }

}
