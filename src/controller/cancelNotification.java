package controller;

import java.io.IOException;
import java.io.PrintWriter;
import util.ResponseCode;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import services.CancelSubscriptionServices;
import services.CancelSubscriptionServicesImp;
import util.AccountAlreadyExists;
import util.AccountDoesNotExist;
import util.ResponseCode;

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
		
		response.setContentType("application/json");
		PrintWriter writer = response.getWriter();
		try{
		ResponseCode responseCode = cancelSubscriptionServices.cancelSubscription(eventUrl); 
		ObjectMapper mapper = new ObjectMapper();
        String jason = mapper.writeValueAsString(responseCode);
        writer.print(jason);
    
	} 
    
    catch (AccountDoesNotExist e) {
    	e.printStackTrace();
	}
    
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
