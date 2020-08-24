package jersey;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.server.JSONP;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee {

	
	public static void main(String[] args) throws IOException
	{
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("https://api.mockaroo.com/api/ccaecc90?count=1000&key=33378a00");
		 
		String response = target.request(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE).get(String.class);
	
		

	    	
	JSONObject obj= new JSONObject();
	JSONArray jsonArray = new JSONArray(response);
	//simply put obj into jsonArray
	jsonArray.put(obj);
	File file = new File("C:/output.json");
	ObjectMapper om = new ObjectMapper();
	om.writeValue(file, response);
	
    try {  
    	FileWriter file = new FileWriter("C:/output.json");
    	file.write(response);
    	file.close();
        // Writing to a file   
    //    mapper.writeValue(new File("c:\\country.json"), obj );

    } catch (IOException e) {  
        e.printStackTrace();  
    }    	
	
	
}
}


