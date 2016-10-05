package jaxrs;

import poscase.dal.HardCodedData;
import poscase.Product;
import poscase.dal.DataAccessLayer;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;

/**
 * Created by maart on 22-9-2016.
 */
@Path("/products")
public class JaxrsProduct {

    DataAccessLayer myData = HardCodedData.getMyData();

    @Context
    UriInfo uriInfo;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Product> getAllProducts(){
        return myData.getProducts();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Product getSingleProduct(@PathParam("id") String id){
        return myData.getProductById(Integer.parseInt(id));
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addProduct(Product product){
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Integer.toString(product.getProdid()));
        if (myData.addProduct(product)){
            return Response.created(uriBuilder.build()).build();
        }
        else{
            return Response.status(400).build();
        }
    }
}
