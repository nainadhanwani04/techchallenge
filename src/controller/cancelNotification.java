package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import services.CancelSubscriptionServices;
import services.CancelSubscriptionServicesImp;
import services.CreateNotificationServices;

/**
 * Servlet implementation class cancelNotification
 */
@WebServlet("/cancelNotification")
public class cancelNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String eventUrl = (String) request.getParameter("eventUrl");	
		
	    CancelSubscriptionServicesImp cancelSubscriptionServices = new CancelSubscriptionServicesImp();
	    cancelSubscriptionServices.cancelSubscription(eventUrl);
		
		
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
