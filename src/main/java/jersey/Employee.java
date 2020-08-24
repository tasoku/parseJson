package jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Employee {

	
	public static void main(String[] args)  {
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("https://api.mockaroo.com/api/ccaecc90?count=1000&key=33378a00");
		 
		String response = target.request(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE).get(String.class);
	
		

	try {
		FileOutputStream fout = new FileOutputStream("output.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(response);
	}
	catch (IOException e){
		e.printStackTrace();
	}
	

	
	
}
}


