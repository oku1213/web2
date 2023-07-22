package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CounterListener implements ServletContextListener {

    public CounterListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	Integer count = 0;
    	context.setAttribute("count", count);
    	System.out.println("contextListenerスタート");
    }
}