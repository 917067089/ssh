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
            //IE���ڻ���,��Ҫnew Date()ʵ�ָ���·��������
            document.getElementById("image").src="${pageContext.request.contextPath}/createImageAction.action?+ Math.random()"+new Date();
        }
    </script>
    <title>��֤��</title>
</head>
<body>
   <%-- <div>
        ��֤�룺<input type="text"  name="checkcode"/>
        <img alt="��֤��" src="<%=request.getContextPath()%>/ImageServlet_verifyCode.action" namespace="/servlet"/>
        <a href="javascript��reloadCode();">������</a></br>
    </div>--%>
    <div>
        <s:textfield name="checkCode" maxlength="4" label="��֤��"/>
        ��֤�룺<img id="image" border="0"  onclick="refresh()"  src="${pageContext.request.contextPath}/createImageAction.action" title="�����壬��һ��">
    </div>
</body>
</html>
