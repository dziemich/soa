package soa.lab2.ex3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginHandler", urlPatterns = {"/ex3/login"})
public class LoginHandler extends HttpServlet {

  public static class UserData {

    String login;
    String pass;
    String firstName;
    String lastName;

    public UserData(String login, String pass, String firstName, String lastName) {
      this.login = login;
      this.pass = pass;
      this.firstName = firstName;
      this.lastName = lastName;
    }
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    String login = request.getParameter("login");
    String pass = request.getParameter("pass");
    PrintWriter out = response.getWriter();
    if (login.equals("")){
      displayLoginPageOnError(out, "missing login");
      out.close();
      return;
    }

    if(pass.equals("")){
      displayLoginPageOnError(out, "missing pass");
      out.close();
      return;
    }

    boolean userExists = Stream.of(
        new UserData("f1", "f2", "Franek", "Kimono"),
        new UserData("k1", "k2", "King Bruce Lee", "Karate Mistrz"),
        new UserData("n1", "n2", "Nie rycz mala nie rycz", "Ja znam te wasze numery")
    )
        .anyMatch(u -> u.login.equals(login) && u.pass.equals(pass));

    if (userExists){
      response.sendRedirect("/app/ex3/guestbook");
      out.close();
    } else {
      displayLoginPageOnError(out, "invalid login data");
      out.close();
    }
  }

  public void displayLoginPageOnError(PrintWriter out, String errorMessage) {
    out.println("<!DOCTYPE html>\n"
        + "<html lang=\"en\">\n"
        + "<head>\n"
        + "  <meta charset=\"UTF-8\">\n"
        + "  <title>Title</title>\n"
        + "</head>\n"
        + "<body>\n"
        + "<p>" + errorMessage + "</p>"
        + "<form action=\"login\" method=\"get\">\n"
        + "  Login: <input type=\"text\" name=\"login\"/>\n"
        + "  Pass: <input type=\"text\" name=\"pass\"/>\n"
        + "  <input type=\"submit\" value=\"Wyslij\"/>\n"
        + "</form>\n"
        + "</body>\n"
        + "</html>\n");
  }
}
