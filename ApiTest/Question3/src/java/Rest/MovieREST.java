/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Controller.MovieStoreController;
//import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("movies")
//@RequestScoped
@SessionScoped
public class MovieREST {

    
    @GET
    @Produces("application/json")
    public Response getAll() {
        MovieStoreController controller = new MovieStoreController();
        return Response.ok(controller.getAllMoviesJson()).build();
    }
      
}
