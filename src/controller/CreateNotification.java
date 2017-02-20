package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import services.CreateNotificationServices;

/**
 * Servlet implementation class create
 */
@WebServlet(name = "createNotification", urlPatterns = { "/create/Notification" })
public class CreateNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String eventUrl = (String) request.getParameter("eventUrl");
	 	
		
		CreateNotificationServices createNotificationServices = new CreateNotificationServices();
		
	 	createNotificationServices.CreateNotification(eventUrl);
		
		
		response.setContentType("application/json");
		
		
		PrintWriter writer = response.getWriter();
        TestUser user1 = new TestUser("testIDentifier","true");
        ObjectMapper mapper = new ObjectMapper();
        String jason = mapper.writeValueAsString(user1);
        writer.print(jason);
    
        
        
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
