<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
    <style type="text/css">
    </style>
</head>
<body bgcolor="#0099FF">
<div class="div1">
    <%
        session.invalidate(); %>
    <jsp:forward page="${pageContext.request.contextPath}/index.jsp"></jsp:forward>
</div>
</body>
</html>
