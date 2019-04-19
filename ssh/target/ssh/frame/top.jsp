<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
    <style type="text/css">
        .div1{ margin-top:50px; margin-left:600px; font-size:14px; color:white}
        .span{
            float:right
        }
    </style>
    <script language="javascript">
        function exit(){
            document.getElementById("exit").src="${pageContext.request.contextPath}/employee_exit.action";
        }
    </script>
</head>

<body bgcolor="#0099FF">
<div class="div1">
    欢迎您：<s:property value="#session.employeeTemp.ename"/>
    <%--<span class="span"><a id="exit" href="${pageContext.request.contextPath}/employee_exit.action" >[退出]</a></span>--%>
    <span class="span"><a href="${pageContext.request.contextPath}/jsp/exit.jsp" target="_top" >[退出]</a></span>
</div>
</body>
</html>
