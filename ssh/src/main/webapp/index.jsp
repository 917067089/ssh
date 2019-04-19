<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>��½</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/main.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ie6Fixpng.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/employee/employee.js">

    </script>
    <script type="text/javascript">
        function refresh() {
            //IE���ڻ���,��Ҫnew Date()ʵ�ָ���·��������
            var time = new Date();
           // document.getElementById("image").src="${pageContext.request.contextPath}/createImage_verifyCode.action?d="+time;
            document.getElementById("image").src="${pageContext.request.contextPath}/createImage_verifyCode?+ Math.random()"+new Date();
        }
    </script>

</head>

<body>
<div class="headerBar">
    <div class="logoBar login_logo">
        <div class="comWidth">
            <div class="logo fl">
                <a href="#"><img src="${pageContext.request.contextPath}/images/logo.jpg" alt="Ľ����"></a>
            </div>
            <h3 class="welcome_title">��ӭ��½</h3>
        </div>
    </div>
</div>
<s:form action="employee_login" method="post" namespace="/">
    <div class="loginBox">
        <h3>
            <s:actionerror/>
            <s:fielderror cssStyle="color:red"></s:fielderror>
        </h3>
        <div class="login_cont">
            <ul class="login">
                <li class="l_tit" style="margin-left: 10px;margin-bottom: 10px">�û���</li>
                <li class="mb_10"><input type="text" id="username" name="username" class="login_input user_icon" autofocus placeholder="�������û���"></li>
                <li class="l_tit">����</li>
                <li class="mb_10"><input type="password"  name="password" class="login_input user_icon" autofocus placeholder="����������"></li>
                <li>
                    ��֤�룺<input type="text" maxlength="4" name="checkCode" size="10"/>&nbsp;&nbsp;
                    <img alt="��֤��" id="image" src="${pageContext.request.contextPath}/createImage_verifyCode"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:refresh();">������</a></br>
                </li>
                <li><input type="submit" value="" class="login_btn"></li>
            </ul>
            <div class="login_partners">
                <p class="l_tit">ʹ�ú������˺ŵ�½��վ</p>
                <ul class="login_list clearfix">
                    <li><a href="#">QQ</a></li>
                    <li><span>|</span></li>
                    <li><a href="#">����</a></li>
                    <li><span>|</span></li>
                    <li><a href="#">����΢��</a></li>
                    <li><span>|</span></li>
                    <li><a href="#">��Ѷ΢��</a></li>
                </ul>
            </div>
        </div>
    </div>
</s:form>

<div class="hr_25"></div>
<div class="footer">
    <p><a href="#">Ľ�μ��</a><i>|</i><a href="#">Ľ�ι���</a><i>|</i> <a href="#">������ʿ</a><i>|</i><a href="#">��ϵ����</a><i>|</i>�ͷ����ߣ�400-675-1234
    </p>
    <p>Copyright &copy; 2006 - 2014 Ľ�ΰ�Ȩ����&nbsp;&nbsp;&nbsp;��ICP��09037834��&nbsp;&nbsp;&nbsp;��ICP֤B1034-8373��&nbsp;&nbsp;&nbsp;ĳ�й�����XX�־ֱ�����ţ�123456789123</p>
    <p class="web"><a href="#"><img src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a><a
            href="#"><img src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a><a href="#"><img
            src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a><a href="#"><img
            src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a></p>
</div>
</body>
</html>
