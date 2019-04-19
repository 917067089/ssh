<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>错误页面</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style/reset.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style1.css" />
</head>
<body>
	<div class="error-404">
<div class="error-404-content">
    <h1 class="font-weight-normal">对不起，您访问的页面没有找到！</h1>
<!--    <button class="btn btn-primary" onclick="javascript:window.top.location.href='<%=request.getContextPath() %>/main'">返回首页</button>&nbsp;&nbsp;<button class="btn btn-info" onclick="javascript:window.history.go(-1);">上一页</button>-->
</div>
</div>
</body>
</html>
