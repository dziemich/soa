package soa.lab2.ex3;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GuestBookHandler", urlPatterns = {"/ex3/guestbook"})
public class GuestBookHandler extends HttpServlet {

  public static class Post {

    String name;
    String mail;
    String opinion;

    public Post(String name, String mail, String opinion) {
      this.name = name;
      this.mail = mail;
      this.opinion = opinion;
    }
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    String reqName = request.getParameter("name");
    String reqMail = request.getParameter("mail");
    String reqOpinion = request.getParameter("opinion");
    PrintWriter out = response.getWriter();

    ServletContext servletContext = getServletContext();

    Object posts = servletContext.getAttribute("posts");
    ArrayList<Post> postList = null;
    if (posts == null) {
      postList = new ArrayList<>();
    } else {
      postList = (ArrayList<Post>) posts;
    }
    postList.add(new Post(reqName, reqMail, reqOpinion));
    if (!postList.isEmpty()) printGuestBook(out, postList);
    servletContext.setAttribute("posts", postList);
    out.close();
  }

  private void printGuestBook(PrintWriter out, List<Post> posts) {
    out.println("<!DOCTYPE html>\n"
        + "<html lang=\"en\">\n"
        + "<head>\n"
        + "  <meta charset=\"UTF-8\">\n"
        + "  <title>Title</title>\n"
        + "</head>\n"
        + "<body>\n"
        + "<form action=\"guestbook\" method=\"get\">\n"
        + "  Name: <input type=\"text\" name=\"name\"/>\n"
        + "  Mail: <input type=\"text\" name=\"mail\"/>\n"
        + "  Opinion: <input type=\"text\" name=\"opinion\"/>\n"
        + "  <input type=\"submit\" value=\"Wyslij\"/>\n"
        + "</form>\n"
        + "</body>\n"
        + "</html>\n");
    posts.forEach(post -> {
      out.println("name:" + post.name + "<br/> mail: " + post.mail + "<br/> opinion:" + post.opinion + "<br/>");
      System.out.println(post.mail +  post.name + post.opinion);
    });
  }
}
