package listener;




import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


import domain.User;



/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
@WebListener
public class MyContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	List<User> users = new ArrayList<User>() {
    		
    		{
    			add(new User("nikola", "123", "nikola", "beocanin"));
    			add(new User("admin", "admin", "admin", "admin"));
    			add(new User("test1", "test1", "test1", "test1"));
    		}
    	};
    	arg0.getServletContext().setAttribute("users", users);
    	arg0.getServletContext().setAttribute("loggedUsers", new ArrayList<User>());
    }
	
}
