package com.ts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.ts.dao.AgentDAO;
import com.ts.dao.CustomerDAO;
import com.ts.dao.ProductDAO;
import com.ts.dto.Agent;
import com.ts.dto.Customer;
import com.ts.dto.Product;

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
    @Path("registerProduct")
   	@POST
   	@Consumes(MediaType.MULTIPART_FORM_DATA)
   	public void registerProduct(@FormDataParam("productName") String productName, @FormDataParam("price") Double price ,
   			@FormDataParam("description") String description,@FormDataParam("Image") InputStream fileInputStream,
   			@FormDataParam("Image") FormDataContentDisposition formDataContentDisposition,
   			@FormDataParam("Category") String category ,@FormDataParam("Quantity") int quantity) throws IOException {
    		int read=0;
    		byte[] bytes=new byte[1024];
    		String path=this.getClass().getClassLoader().getResource("").getPath();
    		String pathArr[]=path.split("/WEB-INF/classes/");
    		FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/",formDataContentDisposition.getFileName()));
    		while((read=fileInputStream.read(bytes)) != -1) {
    			out.write(bytes,0,read);
    		}
    		out.flush();
    		out.close();
    		
    		Product product = new Product();
    		product.setProName(productName);
    		product.setPrice(price);
    		product.setDescription(description);
    		product.setProImage(formDataContentDisposition.getFileName());
    		product.setCatName(category);
    		product.setQuantity(quantity);
    		ProductDAO productDao = new ProductDAO();
    		productDao.addProduct(product);
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
    @Path("getAgentByUserPass/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Agent getAgentByUserPass(@PathParam("loginId") String loginId,@PathParam("password") String password) {
		System.out.println("Recieved path params: "+loginId+" "+password); 
		
		AgentDAO agentDAO = new AgentDAO();
		Agent agent = agentDAO.getAgentByUserPass(loginId, password);
		return agent;
	}
}
