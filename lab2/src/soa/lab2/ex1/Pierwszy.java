package soa.lab2.ex1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Pierwszy", urlPatterns = {"/pierwszy", "/abc"})
public class Pierwszy extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("post tez dziala lalala");
    out.close();
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    response.setCharacterEncoding("utf-8");
    PrintWriter out = response.getWriter();
    String name = request.getParameter("imie");
    int age = Integer.parseInt(request.getParameter("wiek"));
    out.println("<html>");
    out.println("<head><title>Pierwszy Servlet</title></head>");
    out.println("<body>");
    out.println("<p>Witaj, " + name + ", masz " + age + " lat</p>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
