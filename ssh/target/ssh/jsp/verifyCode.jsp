<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"  pageEncoding="GBK" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
        function refresh() {
            //IE存在缓存,需要new Date()实现更换路径的作用
            document.getElementById("image").src="${pageContext.request.contextPath}/createImageAction.action?+ Math.random()"+new Date();
        }
    </script>
    <title>验证码</title>
</head>
<body>
   <%-- <div>
        验证码：<input type="text"  name="checkcode"/>
        <img alt="验证码" src="<%=request.getContextPath()%>/ImageServlet_verifyCode.action" namespace="/servlet"/>
        <a href="javascript：reloadCode();">看不清</a></br>
    </div>--%>
    <div>
        <s:textfield name="checkCode" maxlength="4" label="验证码"/>
        验证码：<img id="image" border="0"  onclick="refresh()"  src="${pageContext.request.contextPath}/createImageAction.action" title="看不清，换一张">
    </div>
</body>
</html>
