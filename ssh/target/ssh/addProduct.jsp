<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
</head>
<body>
<h1>保存商品的页面</h1>
<s:form action="product_save" method="post" namespace="/" theme="simple">
    <table border="1" width="400">
        <tr>
            <td>商品名称</td>
            <td><s:textfield name="pname"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><s:textfield name="price"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="添加"/></td>
        </tr>
    </table>
</s:form>
<h1>日期格式页面</h1>
<div>
    <!-- 你可以给通过配置minDate(最小日期),maxDate(最大日期)为静态日期值,来限定日期的范围
        示例4-1-1 限制日期的范围是 2006-09-10到2008-12-20
     -->
    <input id="d411"  type="text" onclick="WdatePicker({skin:'whyGreen',minDate:'2006-09-10',maxDate:'2008-12-20'})"/>
    <!-- 示例4-1-2 限制日期的范围是 2008-3-8 11:30:00 到 2008-3-10 20:59:30 -->
    <input type="text" class="Wdate" id="d412" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'2008-03-08 11:30:00',maxDate:'2008-03-10 20:59:30'})" value="2008-03-09 11:00:00"/>
    <!-- 示例4-1-3 限制日期的范围是 2008年2月 到 2008年10月-->
    <input type="text" class="Wdate" id="d413" onclick="WdatePicker({dateFmt:'yyyy年M月',minDate:'2008-2',maxDate:'2008-10'})"/>
    <!-- 示例4-1-4 限制日期的范围是 8:00:00 到 11:30:00 -->
    <input type="text" class="Wdate" id="d414" onclick="WdatePicker({dateFmt:'H:mm:ss',minDate:'8:00:00',maxDate:'11:30:00'})"/>
    <!-- 动态限制
注意:日期格式必须与 realDateFmt 和 realTimeFmt 一致而不是与 dateFmt 一致
你可以通过系统给出的动态变量,如%y(当前年),%M(当前月)等来限度日期范围,你还可以通过{}进行表达式运算,如:{%d+1}:表示明天
%y	当前年
%M	当前月
%d	当前日
%ld	本月最后一天
%H	当前时
%m	当前分
%s	当前秒
{}	运算表达式,如:{%d+1}:表示明天
#F{}	{}之间是函数可写自定义JS代码

-->
    <!-- 示例4-2-1 只能选择今天以前的日期(包括今天) -->
    <input id="d421" class="Wdate" type="text" onclick="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"/>
    <!-- 示例4-2-2 使用了运算表达式 只能选择今天以后的日期(不包括今天) -->
    <input id="d422" class="Wdate" type="text" onclick="WdatePicker({minDate:'%y-%M-{%d+1}'})"/>
    <!-- 示例4-2-3 只能选择本月的日期1号至本月最后一天-->
    <input id="d423" class="Wdate" type="text" onclick="WdatePicker({minDate:'%y-%M-01',maxDate:'%y-%M-%ld'})"/>

    <!-- 示例4-2-4 只能选择今天7:00:00至明天21:00:00的日期-->
    <input id="d424" class="Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-M-d H:mm:ss',minDate:'%y-%M-%d 7:00:00',maxDate:'%y-%M-{%d+1} 21:00:00'})"/>

    <!-- 示例4-2-5 使用了运算表达式 只能选择 20小时前 至 30小时后 的日期 -->
    <input id="d425" class="Wdate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d {%H-20}:%m:%s',maxDate:'%y-%M-%d {%H+30}:%m:%s'})"/>

</div>
</body>
</html>
