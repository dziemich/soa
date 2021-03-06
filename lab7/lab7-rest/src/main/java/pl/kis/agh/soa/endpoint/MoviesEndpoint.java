package pl.kis.agh.soa.endpoint;

import io.swagger.annotations.Api;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pl.kis.agh.soa.controller.MovieController;
import pl.kis.agh.soa.entities.Movie;
import pl.kis.agh.soa.entities.User;

@Api(value = "Movies")
@Path("/movies")
public class MoviesEndpoint {

  @Inject
  private MovieController movieController;
  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Movie> getAll() {
    return movieController.fetchAllMovies();
  }

  @GET
  @Path("/all/{title}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response addOne(@PathParam("title") String title) {
    Movie movie = movieController.fetchMovie(title);
    return Response.ok(movie).build();
  }
}
