<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    µÇÂ¼³É¹¦£¬»¶Ó­£º${username}
</body>
</html>
