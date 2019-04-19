package main.com.imooc.action;

import main.com.imooc.filter.SyncFilter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoginServlet.class);
    public LoginServlet() {
        super();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        logger.info(username);
        String password = request.getParameter("password");

        if("admin".equals(username)&& "admin".equals("password")){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/fail.jsp");
        }
    }
}
