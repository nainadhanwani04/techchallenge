	package util;

	import java.sql.Connection;
	import java.sql.SQLException;
	import javax.servlet.ServletContext;
	import javax.servlet.ServletContextEvent;
	import javax.servlet.ServletContextListener;

	import util.DBConnectionManager;

	public class AppContextListener implements ServletContextListener {
	    public void contextInitialized(ServletContextEvent servletContextEvent) {
	        ServletContext ctx = servletContextEvent.getServletContext();

	        //initialize DB Connection
	        String dbURL = ctx.getInitParameter("dbURL");
	        String user = ctx.getInitParameter("dbUser");
	        String pwd = ctx.getInitParameter("dbPassword");

	        try {
	            DBConnectionManager connectionManager = new DBConnectionManager(dbURL, user, pwd);
	            ctx.setAttribute("DBConnection", connectionManager.getConnection());
	            System.out.println("DB Connection initialized successfully.");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void contextDestroyed(ServletContextEvent servletContextEvent) {
	        Connection con = (Connection) servletContextEvent.getServletContext().getAttribute("DBConnection");
	        try {
	            con.close();
	            System.out.println("Connection closed");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	}

