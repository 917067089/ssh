package main.com.imooc.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门的实体
 */
public class Department {
    private Integer did;
    /**
     * 部门名陈
     */
    private String dname;
    /**
     * 部门的描述
     */
    private String ddesc;

    /**
     * 员工的集合
     */
    private Set<Employee> employees = new HashSet<Employee>();

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Integer getDid() {
        return did;
    }

    public String getDname() {
        return dname;
    }

    public String getDdesc() {
        return ddesc;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setDdesc(String ddesc) {
        this.ddesc = ddesc;
    }
}
