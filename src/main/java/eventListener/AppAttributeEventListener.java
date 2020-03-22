package eventListener;

import helper.FileReaderHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: AppAttributeEventListener.java, v 0.1 2020-03-22  10.40 Ahmad Isyfalana Amin Exp $
 */
@WebListener
public class AppAttributeEventListener implements ServletContextListener, ServletContextAttributeListener {

    private static final Logger LOGGER = Logger.getLogger( AppAttributeEventListener.class.getName() );

    public static final String COUNTER = "COUNTER";

    int counter = 0;

    private String filePath = "src/main/resources/html/event/counter.txt";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("ServletContextEvent.contextInitialized()");
        LOGGER.info("Get counter file");


        try{
            counter = Integer.parseInt(FileReaderHelper.getContentWithoutNewLine("event/counter.txt"));

            ServletContext context = servletContextEvent.getServletContext();
            context.setAttribute(COUNTER, counter);

        } catch (IOException e){
            LOGGER.warning(e.getMessage());
        }

        LOGGER.info("App is up");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("ServletContextEvent.contextDestroyed()");
        LOGGER.info("App is down");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        LOGGER.info("ServletContextEvent.attributeAdded()");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        LOGGER.info("ServletContextEvent.attributeRemoved()");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        LOGGER.info("ServletContextEvent.attributeReplaced()");
        LOGGER.info("Page Counter change");

        writeCounter(servletContextAttributeEvent);
    }

    synchronized void writeCounter(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        counter = (int) servletContext.getAttribute(COUNTER);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(Integer.toString(counter));
            writer.close();
            LOGGER.info("Writing");
        }
        catch (Exception e) {
            LOGGER.info(e.toString());
        }
    }
}