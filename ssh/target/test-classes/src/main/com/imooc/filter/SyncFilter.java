package main.com.imooc.filter;



import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter(filterName = "SyncFilter",value ={"/index.jsp"},dispatcherTypes = {DispatcherType.ASYNC,DispatcherType.REQUEST})
public class SyncFilter implements Filter {
    Logger logger = Logger.getLogger(SyncFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("start .. SyncFilter");
        logger.info("start  lo4j .. SyncFilter");
        chain.doFilter(request,response);
        System.out.println("end .. SyncFilter");
    }

    @Override
    public void destroy() {

    }
}
