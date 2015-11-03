/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Company;
import facade.CompanyFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Asnorrason
 */
@Path("company")
public class CompanyRestService {

    Gson gson;
    CompanyFacade cf;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CompanyRestService
     */
    public CompanyRestService() {
        gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
        cf = new CompanyFacade();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String createCompany(String company) {
        Company c = gson.fromJson(company, Company.class);
        cf.CreateCompany(c);
        return company;
    }

    @GET
    @Path("getbycvr/{cvr}")
    @Produces("application/json")
    public String getCompanyByCvr(@PathParam("cvr") String cvr) {
        return gson.toJson(cf.getCompanyByCvr(cvr));
    }

    @DELETE
    @Path("{cvr}")
    @Consumes("application/json")
    public String deleteCompany(@PathParam("cvr") String company) {
        Company c = gson.fromJson(company, Company.class);
        cf.deleteCompany(c);
        return company;
    }
}
