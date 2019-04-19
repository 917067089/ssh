package main.com.imooc.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import main.com.imooc.entity.Department;
import main.com.imooc.entity.Employee;
import main.com.imooc.entity.PageBean;
import main.com.imooc.service.DepartmentService;
import main.com.imooc.service.EmployeeService;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

/**
 * 员工管理Action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
    Logger logger = Logger.getLogger(EmployeeAction.class);
    //模型驱动使用的对象
    private Employee employee = new Employee();

    @Override
    public Employee getModel() {
        return employee;
    }

    //注入set方法
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //或者使用注解方式替代set方法
//    @Autowired
//    private EmployeeService employeeService;
//    @Autowired
//    @Qualifier("employeeService")
//    private EmployeeService employeeService;
    //注入部门Service类
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
//    @Autowired
//    private DepartmentService departmentService;

    private String checkCode;

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    /**
     * 执行登录的方法
     */
    public String login() {
        System.out.println("用户名：" + employee.getUsername());
        Employee employeeTemp = employeeService.login(employee);
        //        //登录失败
        if (employeeTemp == null) {
            this.addActionError("用户名或密码错误！");
            return INPUT;
        } else {
            //登录成功 将登录信息存到Session中
            ActionContext.getContext().getSession().put("employeeTemp", employeeTemp);
            ActionContext.getContext().getSession().put("username", employeeTemp.getUsername());
//            ActionContext.getContext().getValueStack().push(employeeTemp);
            return SUCCESS;
        }

    }
    /**
     * 退出
     */
    public String exit() throws IOException, ServletException {
        ActionContext ac = ActionContext.getContext();
        HttpServletRequest request=(HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
//        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
//        HttpServletResponse response=(HttpServletResponse) ac.get(ServletActionContext.HTTP_REQUEST);
        HttpSession session = request.getSession();
        //清空Session方法1
        session.removeAttribute("username");
        //清空Session方法2
        session.invalidate();
        //清空Session方法3
//        initSession(request);
        //页面路径跳转-重定向
//        response.sendRedirect("index.jsp");
        //转发,转发是在服务器端转发的，客户端是不知道的
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
        return "exit";
    }
    private void initSession(HttpServletRequest request){
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }
    }
    /**
     * 校验
     */
    @Override
    public void validate() {
        ActionContext ac = ActionContext.getContext();
        HttpServletRequest request=(HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
        logger.info("请求路径登录时:"+request.getRequestURI());
        if("/employee_login.action".indexOf(request.getRequestURI())!=-1){
            if (employee.getUsername() == null || employee.getUsername().trim().equals("")) {
                this.addFieldError("usererror", "用户名不能为空");
                return;
            }
            if (employee.getPassword() == null || employee.getPassword().trim().equals("")) {
                this.addFieldError("passerror", "密码不能为空");
                return;
            }
            if (checkCode == null || checkCode.trim().equals("")) {
                this.addFieldError("checkerror", "验证码不能为空");
                return;
            }
            HttpSession session = ServletActionContext.getRequest().getSession();
            String checkCode2 = (String) session.getAttribute("checkCode");
            if (!checkCode.equals(checkCode2)) {
                addFieldError(checkCode, "输入的验证码不正确,请重新输入");
                return;
            }
        }
    }

    private Integer currPage = 1;//当前页面

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    /**
     * 执行查询方法
     *
     * @return
     */
    public String findAll() {
        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    /**
     * 跳转添加员工页面的方法
     *
     * @return
     */
    public String saveUI() {
        List<Department> departmentList = departmentService.findAll();
        //放到值栈中，集合给它set,对象push
        ActionContext.getContext().getValueStack().set("departmentList", departmentList);
        return "saveUI";
    }

    /**
     * 保存方法
     *
     * @return
     */
    public String save() {
        employeeService.save(employee);
        return "saveSuccess";
    }

    /**
     * 编辑员工的方法
     *
     * @return
     */
    public String edit() {
        //根据员工id查询员工信息
        employee = employeeService.findById(employee.getEid());
        List<Department> departmentList = departmentService.findAll();
        //放到值栈中，集合给它set,对象push
        ActionContext.getContext().getValueStack().set("departmentList", departmentList);
        return "editSuccess";
    }

    /**
     * update方法
     *
     * @return
     */
    public String update() {
        employeeService.update(employee);
        return "updateSuccess";
    }

    /**
     * 删除员工的方法
     *
     * @return
     */
    public String delete() {
        employee = employeeService.findById(employee.getEid());
        employeeService.delete(employee);
        return "deleteSuccess";
    }
}
