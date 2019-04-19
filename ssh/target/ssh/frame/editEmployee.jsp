<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
</head>
<body>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size:24px; color:#666"> 员工编辑</td>
    </tr>
    <tr>
        <td align="right">
            <a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
            <a href="javascript:history.go(-1)">退回</a>
        </td>
    </tr>
</table>
<br/>

<s:form id="saveForm" action="employee_update" method="POST" namespace="/" theme="simple">
    <s:hidden name="eid" value="%{model.eid}"/>
    <table border='0' cellpadding="0" cellspacing="10">
        <tr>
            <td>姓名：</td>
            <td><s:textfield name="ename" type="text" value="%{model.ename}"/></td>
            <td>性别：</td>
            <td><s:radio name="sex" list="{'男','女'}" value="%{model.sex}"/></td>
        </tr>
        <tr>
            <td width="10%">出生日期：</td>
            <td width="20%"><input type="date" name="birthday" value="<s:date name="%{model.birthday}" format="yyyy-MM-dd"/>"/></td>
            <td width="10%">入职时间：</td>
            <td width="60%"><input type="date" name="joinDate" value="<s:date name="%{model.joinDate}" format="yyyy-MM-dd"/>"/></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><s:textfield name="username" type="text" value="%{model.username}"/></td>
            <td width="10%">密码：</td>
            <td width="60%"><s:password name="password" value="%{model.password}" showPassword="true"/></td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <s:select name="department.did" list="departmentList" value="%{model.department.did}" listKey="did" listValue="dname" headerKey="dname" headerValue="-----请--选--择----">
                </s:select>
            </td>
            <td width="10%">编号：</td>
            <td width="60%"><s:textfield name="eno" type="text" value="%{model.eno}"/></td>
        </tr>
    </table>
</s:form>

</body>
</html>