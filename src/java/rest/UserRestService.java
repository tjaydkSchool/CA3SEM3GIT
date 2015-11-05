package rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.User;
import facade.UserFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;


@Path("user")
public class UserRestService {
    Gson gson;
    UserFacade facade;

    @Context
    private UriInfo context;


    public UserRestService() {
        gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
        
//        CHANGE PU ON DEPLOYMENT
        facade = new UserFacade();
    }

    /**
     * Get users company list on login
     * 
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{username}")
    @Produces("application/json")
    public String getUserCompanyList(@PathParam("username") String username) {
        return gson.toJson(facade.getUser(username));
    }

    /**
     * Create new user with username and password, then return response with success of failure and credentials
     * @param content username and password
     * @return an HTTP response with credentials.
     */
    @POST
    @Consumes("application/json")
    public void createUser(String userData) {
        facade.createUser(gson.fromJson(userData, User.class));
    }
}
