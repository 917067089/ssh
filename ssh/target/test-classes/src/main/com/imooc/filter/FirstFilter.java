package main.com.imooc.filter;

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter {
    /**
     * 过滤器初始化方法，web容器创建过滤器实例后将调用这个方法。这个方法可以读取web.xml文件中过滤器的参数
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 这个方法完成实际的过滤操作，当用户请求与过滤器关联的 url时，web容器将先调用过滤器doFilter()。
     * FilterChain的参数可以调用chain.doFilter 将请求传给下一个过滤器（目标资源）或者利用转发、重定向将请求转发到其他资源
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
    }

    /**
     * web容器在销毁过滤器实例前调用该方法，在这个方法中可以释放过滤器占用的资源。
     */
    @Override
    public void destroy() {

    }
}
