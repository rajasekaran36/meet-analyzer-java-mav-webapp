package servlets.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import io.github.rajasekarans.meettool.service.MeetAnalyzerService;

@WebListener
public class PrimaryListner implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
