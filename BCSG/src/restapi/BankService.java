
package restapi;
 
/**
 * @author Crunchify.com
 */
 
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import utility.Customer;
import utility.ReadFromCSVFile;

@Path("/bankservice")
public class BankService {
	
	@Path("/get")
    @GET
	@Produces("application/json")
	public Response getProductInJSON() {
 
		ReadFromCSVFile readFromCSVFile = new ReadFromCSVFile();
		List<Customer> list = readFromCSVFile.getInput();
		
		JSONObject jo = getJsonFromMyFormObject(list);
		return Response.status(201).entity(jo.toString()).build();
	}
	
	 public static JSONObject getJsonFromMyFormObject(List<Customer> customerList)
	  {
	    JSONObject responseDetailsJson = new JSONObject();
	    StringBuilder sb = new StringBuilder();
	    
	    for (Customer customer :  customerList)
	    {
	     sb.append(customer.toString());
	     System.out.println(sb.toString());
	    }
	    responseDetailsJson.put("Customers", sb.toString());
	    return responseDetailsJson;
	  }
}

