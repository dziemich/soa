package pl.kis.agh.soa.endpoint;

import io.swagger.annotations.Api;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pl.kis.agh.soa.controller.UserController;
import pl.kis.agh.soa.entities.User;

@Api(value = "Users")
@Path("/users")
public class UsersEndpoint {

  @Inject
  private UserController userController;

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> gerAll() {
    return userController.fetchAllUsers();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response addOne(@PathParam("id") Long id) {
    User user = userController.fetchOneUser(id);
    return Response.ok(user).build();
  }

  @POST
  @Path("/post")
  public Response addOne(User user){
    userController.addOne(user);
    return Response.ok().build();
  }

  @PUT
  @Path("/put/{id}")
  public Response updateOne(@PathParam("id") Long id, User user){
    userController.updateOne(id, user);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteUser(@PathParam("id") Long id){
    userController.deleteOne(id);
    return Response.ok().build();
  }
}
