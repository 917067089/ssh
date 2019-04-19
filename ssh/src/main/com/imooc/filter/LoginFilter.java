package main.com.imooc.filter;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    Logger logger = Logger.getLogger(LoginFilter.class);
    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        //通过过滤器中设置编码格式
        //方法一
//        httpServletRequest.setCharacterEncoding("utf-8");
        //方法二 当不配置的时候就给他赋值一个默认值
        String charset = config.getInitParameter("charset");
        if(charset==null){
            charset="utf-8";
        }
        httpServletRequest.setCharacterEncoding(charset);

        logger.info("请求地址："+httpServletRequest.getRequestURL());
        logger.info("过滤初始化路径："+config.getInitParameter("noLoginPaths"));
        logger.info("session中username："+session.getAttribute("username"));
        //方法一  web.xml里面的所有要过滤的路径都配一遍
        //方法二 这里配多个不需要过滤的路径
//        if(httpServletRequest.getRequestURI().indexOf("index.jsp")!=-1){
//            chain.doFilter(request,response);
//            return;
//        }
        //方法三 和方法二比较相似：这里判断就多个不拦截
        String noLoginPaths = config.getInitParameter("noLoginPaths");
        String[] strings = noLoginPaths.split(";");
        for (int i=0;i<strings.length;i++){
            //如果为null 或为空 继续
            if(strings[i] == null || "".equals(strings[i]))continue;
            logger.info("过滤器里面的不过滤的路径："+strings[i] );
            if(httpServletRequest.getRequestURI().indexOf(strings[i])!=-1
                    || httpServletRequest.getRequestURI().indexOf(".js")!=-1
                    || httpServletRequest.getRequestURI().indexOf(".css")!=-1
                    || httpServletRequest.getRequestURI().indexOf(".gif")!=-1
                    || httpServletRequest.getRequestURI().indexOf(".jpg")!=-1){
                chain.doFilter(request,response);
                return;
            }
        }
        if(session.getAttribute("username")!=null){
            chain.doFilter(request,response);
        }else {
            httpServletResponse.sendRedirect("index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
