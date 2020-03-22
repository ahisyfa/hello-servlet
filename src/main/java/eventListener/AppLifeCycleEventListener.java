package eventListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: AppLifeCycleEvent.java, v 0.1 2020-03-22  10.15 Ahmad Isyfalana Amin Exp $
 */
@WebListener
public class AppLifeCycleEventListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger( AppLifeCycleEventListener.class.getName() );

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("AppLifeCycleEvent.contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.warning("AppLifeCycleEvent.contextDestroyed()");
    }
}