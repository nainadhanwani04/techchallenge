package util;
   
    import java.net.URL;

import oauth.signpost.basic.DefaultOAuthConsumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;


import beans.ResponseBean;
import oauth.signpost.OAuthConsumer;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import oauth.signpost.exception.OAuthCommunicationException;
	import oauth.signpost.exception.OAuthExpectationFailedException;
	import oauth.signpost.exception.OAuthMessageSignerException;

	public class Utility {
	
		public static String getJasonResponse(String eventUrl)throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
			String output="";
			String jason="";
		  try {
			System.out.println(eventUrl);
			OAuthConsumer consumer = new DefaultOAuthConsumer("testproductnaina-151855", "SQvGLKJAj2syslob");
			URL url = new URL(eventUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			consumer.sign(conn);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.connect();
			//conn.setRequestMethod("GET");
			

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
         StringBuffer buffer = new StringBuffer();
		
			System.out.println("Output from Server .... \n");
			while ((output=br.readLine()) != null) {
				System.out.println( "Jason String "+output.toString());	
				buffer.append(output);
			}
			// conn.disconnect();
			 jason = buffer.toString();
			 System.out.println("jason printed");
		  } catch (IOException e) {

			e.printStackTrace();

		  }
		  return jason;	
		}
		
		public static ResponseBean getBean(String jsonString){
			ObjectMapper mapper =new ObjectMapper();
			ResponseBean response = null;
			try {
				response = mapper.readValue(jsonString, ResponseBean.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello response"+response);
			return response;
		}

	}

