package com.ts;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ts.dao.CustomerDAO;
import com.ts.dto.Customer;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void register(Customer customer) {
		System.out.println("Data Recieved in user Register : " + customer);
		CustomerDAO customerDao = new CustomerDAO();
		customerDao.register(customer);
	
	}
    @Path("getCustomerByUserPass/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerByUserPass(@PathParam("loginId") String loginId,@PathParam("password") String password) {
		System.out.println("Recieved path params: "+loginId+" "+password); 
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.getCustomerByUserPass(loginId, password);
		return customer;
	}
}
