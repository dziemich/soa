package soa.lab2.ex2.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AgeHandler", urlPatterns = {"/ex2/askage"})
public class AgeHandler extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    String age = request.getParameter("age");
    if (age != null) {
      int i = Integer.parseInt(age);
      if (i >= 18) {
        response.sendRedirect("/app/ex2/beerform.html");
      }
    }
    PrintWriter out = response.getWriter();
    out.println("you cant drink beer buddy");
    out.close();
  }
}
