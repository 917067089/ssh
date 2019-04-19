package main.com.imooc.entity;

import java.util.Date;

/**
 * 员工的实体
 */
public class Employee {
    private Integer eid;
    /**
     * 姓名
     */
    private String ename;
    /**
     * 姓别
     */
    private String sex;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 入职日期
     */
    private Date joinDate;
    /**
     * 所属编号
     */
    private String eno;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 所属部门
     */
    private Department department;

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setEno(String eno) {
        this.eno = eno;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getEno() {
        return eno;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Department getDepartment() {
        return department;
    }
}
