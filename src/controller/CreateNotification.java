package controller;
import util.ResponseCode;
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
import services.CreateSubscriptionServicesImp;
import util.AccountAlreadyExists;

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
	 	
		
		CreateSubscriptionServicesImp createServices = new CreateSubscriptionServicesImp();
		response.setContentType("application/json");
		
		
		PrintWriter writer = response.getWriter();
        try {
			ResponseCode responseCode = createServices.CreateNotification(eventUrl) ;
			System.out.println(responseCode.getSuccess());
			System.out.println(responseCode.getAccountIdentifier());
			System.out.println(responseCode.getMessage());
			System.out.println(responseCode.getErrorCode());
			ObjectMapper mapper = new ObjectMapper();
	        String jason = mapper.writeValueAsString(responseCode);
	        writer.print(jason);
	    
		} 
        
        catch (AccountAlreadyExists e) {
			// TODO Auto-generated catch block
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
