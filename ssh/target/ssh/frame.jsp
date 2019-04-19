<frameset rows="80,*">
    <frame name="top" src="${pageContext.request.contextPath}/frame/top.jsp">
    <frameset cols="150,*" id="main">

        <frame src="${pageContext.request.contextPath}/frame/left.jsp">
        <frame name="right" src="${pageContext.request.contextPath}/frame/right.jsp">
    </frameset>
</frameset>