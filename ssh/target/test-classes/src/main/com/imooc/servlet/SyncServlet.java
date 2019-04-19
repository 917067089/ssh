package main.com.imooc.servlet;


import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class SyncServlet extends HttpServlet {
    public SyncServlet(){
        super();
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response){
        System.out.println("Servlet业务执行开始时间"+new Date());
        AsyncContext context = request.startAsync();
        new Thread(new Executer(context)).start();//异步的线程
        System.out.println("Servlet业务完成开始时间"+new Date());
    }
    public class Executer implements Runnable{
        private AsyncContext context;
        public Executer(AsyncContext context){
            this.context=context;
        }
        @Override
        public void run() {
            //执行相关负责业务
            try {
//                context.getRequest();
//                context.getResponse();
                Thread.sleep(1000*10);
                System.out.println("业务执行完成时间"+new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
