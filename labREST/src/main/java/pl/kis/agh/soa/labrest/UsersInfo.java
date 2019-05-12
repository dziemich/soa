package pl.kis.agh.soa.labrest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pl.kis.agh.soa.labrest.controller.UserController;
import pl.kis.agh.soa.labrest.entities.User;

@Path("/users")
public class UsersInfo {

  @Inject
  private UserController userController;

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> getUsers() {
    return userController.fetchAllUsers();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUser(@PathParam("id") Long id) {
    User user = userController.fetchOneUser(id);
    return Response.status(201).entity(user).build();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteUser(@PathParam("id") Long id){
    userController.deleteUser(id);
    return Response.status(200).build();
  }
}
