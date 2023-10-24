package rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class MyServlet {
    @Path("/hello")
    @GET
    public String getHello() {
        return "hello";
    }

    @Path("/human/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Human getHuman(@PathParam(value = "name") String someValue) {
        return new Human(someValue, "tes");
    }
    @Path("/human-query/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Human getHumanQuery(@QueryParam(value = "name") String name , @QueryParam(value = "family") String family) {
        return new Human(name, family);
    }
    @Path("/human")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Human getHumanPost(Human h) {
        return new Human(h.getName(), h.getFamily());
    }



}
