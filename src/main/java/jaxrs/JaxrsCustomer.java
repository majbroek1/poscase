package jaxrs;

import poscase.dal.HardCodedData;
import poscase.Customer;
import poscase.dal.DataAccessLayer;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by maart on 21-9-2016.
 */
@Path("/customers")
public class JaxrsCustomer {

    DataAccessLayer mdata = HardCodedData.getMyData();


    @Context
    UriInfo uriInfo;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Customer> getAllCustomers(){
        return mdata.getCustomers();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Customer getSingleCustomer(@PathParam("id") String id) throws SQLException {
        return mdata.getCustomerById(Integer.parseInt(id));
    }


    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addCustomer(Customer customer){
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Integer.toString(customer.getCustomerCode()));
        if (mdata.addCustomer(customer)){
            return Response.created(uriBuilder.build()).build();
        }
        else{
            return Response.status(400).build();
        }
    }

}
